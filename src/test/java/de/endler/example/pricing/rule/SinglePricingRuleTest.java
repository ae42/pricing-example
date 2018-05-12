package de.endler.example.pricing.rule;

import org.junit.Test;

import java.math.BigDecimal;

import static de.endler.example.tools.NumberTools.decimal;
import static de.endler.example.tools.NumberTools.scale;
import static org.assertj.core.api.Assertions.assertThat;

public class SinglePricingRuleTest {

    private final static BigDecimal PRICE = decimal(10);
    private final static int MAX_QUANTITY = 20;

    private final SinglePricingRule singlePricingRule = new SinglePricingRule(PRICE);

    @Test
    public void testCalculate() {
        for (int quantity = 0; quantity <= MAX_QUANTITY; quantity++) {
            assertThat(singlePricingRule.calculate(quantity)).isEqualTo(scale(PRICE.multiply(decimal(quantity))));
        }
    }

}
