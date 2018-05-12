package de.endler.example.pricing.rule;

import de.endler.example.tools.NumberTools;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class SinglePricingRuleTest {

    private final static BigDecimal PRICE = NumberTools.decimal(10);
    private final static int MAX_QUANTITY = 20;

    private final SinglePricingRule singlePricingRule = new SinglePricingRule(PRICE);

    @Test
    public void testCalculate() {
        for (int quantity = 0; quantity <= MAX_QUANTITY; quantity++) {
            assertThat(singlePricingRule.calculate(quantity)).isEqualByComparingTo(PRICE.multiply(NumberTools.decimal(quantity)));
        }
    }

}
