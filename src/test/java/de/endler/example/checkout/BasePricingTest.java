package de.endler.example.checkout;

import de.endler.example.pricing.provider.PricingRuleProvider;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static de.endler.example.tools.NumberTools.decimal;
import static de.endler.example.tools.NumberTools.scale;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Base test class with default test cases for testing different PricingRuleProviders
 *
 * @author Andreas Endler
 */
public abstract class BasePricingTest {

    protected abstract PricingRuleProvider getRules() throws Exception;

    @Test
    public void test_incremental() throws Exception {
        final Checkout checkout = new Checkout(getRules());
        assertThat(checkout.total()).isEqualTo(scale(BigDecimal.ZERO));

        checkout.scan("A");
        assertThat(checkout.total()).isEqualTo(decimal(50));

        checkout.scan("B");
        assertThat(checkout.total()).isEqualTo(decimal(80));

        checkout.scan("A");
        assertThat(checkout.total()).isEqualTo(decimal(130));

        checkout.scan("A");
        assertThat(checkout.total()).isEqualTo(decimal(160));

        checkout.scan("B");
        assertThat(checkout.total()).isEqualTo(decimal(175));
    }

    @Test
    public void test_totals() throws Exception {
        assertThat(price("")).isEqualTo(scale(BigDecimal.ZERO));
        assertThat(price("A")).isEqualTo(decimal(50));
        assertThat(price("AB")).isEqualTo(decimal(80));
        assertThat(price("CDBA")).isEqualTo(decimal(115));

        assertThat(price("AA")).isEqualTo(decimal(100));
        assertThat(price("AAA")).isEqualTo(decimal(130));
        assertThat(price("AAAA")).isEqualTo(decimal(180));
        assertThat(price("AAAAA")).isEqualTo(decimal(230));
        assertThat(price("AAAAAA")).isEqualTo(decimal(260));

        assertThat(price("AAAB")).isEqualTo(decimal(160));
        assertThat(price("AAABB")).isEqualTo(decimal(175));
        assertThat(price("AAABBD")).isEqualTo(decimal(190));
        assertThat(price("DABABA")).isEqualTo(decimal(190));
    }

    private BigDecimal price(String items) throws Exception {
        final Checkout checkout = new Checkout(getRules());
        Arrays.stream(items.split("")).forEach(checkout::scan);
        return checkout.total();
    }
}
