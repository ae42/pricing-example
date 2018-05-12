package de.endler.example.pricing.rule;

import de.endler.example.tools.NumberTools;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ZeroPricingRuleTest {

    private final static int MAX_QUANTITY = 20;
    private final ZeroPricingRule zeroPricingRule = new ZeroPricingRule();

    @Test
    public void testCalculate() {
        for (int quantity = 0; quantity <= MAX_QUANTITY; quantity++) {
            assertThat(zeroPricingRule.calculate(quantity)).isEqualTo(NumberTools.scale(BigDecimal.ZERO));
        }
    }
}
