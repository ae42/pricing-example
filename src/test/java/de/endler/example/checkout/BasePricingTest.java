package de.endler.example.checkout;

import de.endler.example.pricing.provider.PricingRuleProvider;
import de.endler.example.tools.NumberTools;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

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
        assertThat(checkout.total()).isEqualTo(BigDecimal.ZERO);

        checkout.scan("A");
        assertThat(checkout.total()).isEqualTo(NumberTools.decimal(50));

        checkout.scan("B");
        assertThat(checkout.total()).isEqualTo(NumberTools.decimal(80));

        checkout.scan("A");
        assertThat(checkout.total()).isEqualTo(NumberTools.decimal(130));

        checkout.scan("A");
        assertThat(checkout.total()).isEqualTo(NumberTools.decimal(160));

        checkout.scan("B");
        assertThat(checkout.total()).isEqualTo(NumberTools.decimal(175));
    }

    @Test
    public void test_totals() throws Exception {
        assertThat(price("")).isEqualTo(BigDecimal.ZERO);
        assertThat(price("A")).isEqualTo(NumberTools.decimal(50));
        assertThat(price("AB")).isEqualTo(NumberTools.decimal(80));
        assertThat(price("CDBA")).isEqualTo(NumberTools.decimal(115));

        assertThat(price("AA")).isEqualTo(NumberTools.decimal(100));
        assertThat(price("AAA")).isEqualTo(NumberTools.decimal(130));
        assertThat(price("AAAA")).isEqualTo(NumberTools.decimal(180));
        assertThat(price("AAAAA")).isEqualTo(NumberTools.decimal(230));
        assertThat(price("AAAAAA")).isEqualTo(NumberTools.decimal(260));

        assertThat(price("AAAB")).isEqualTo(NumberTools.decimal(160));
        assertThat(price("AAABB")).isEqualTo(NumberTools.decimal(175));
        assertThat(price("AAABBD")).isEqualTo(NumberTools.decimal(190));
        assertThat(price("DABABA")).isEqualTo(NumberTools.decimal(190));
    }

    private BigDecimal price(String items) throws Exception {
        final Checkout checkout = new Checkout(getRules());
        Arrays.stream(items.split("")).forEach(checkout::scan);
        return checkout.total();
    }
}
