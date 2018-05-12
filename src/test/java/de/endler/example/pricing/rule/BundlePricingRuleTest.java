package de.endler.example.pricing.rule;

import de.endler.example.tools.NumberTools;
import org.junit.Test;

import static de.endler.example.tools.NumberTools.decimal;
import static org.assertj.core.api.Assertions.assertThat;

public class BundlePricingRuleTest {

    private final BundlePricingRule bundlePricingRule = new BundlePricingRule(NumberTools.decimal(10), NumberTools.decimal(15), 2);

    @Test
    public void testCalculate() {
        assertThat(bundlePricingRule.calculate(0)).isEqualTo(decimal(0));
        assertThat(bundlePricingRule.calculate(1)).isEqualTo(decimal(10));
        assertThat(bundlePricingRule.calculate(2)).isEqualTo(decimal(15));
        assertThat(bundlePricingRule.calculate(3)).isEqualTo(decimal(25));
        assertThat(bundlePricingRule.calculate(4)).isEqualTo(decimal(30));
        assertThat(bundlePricingRule.calculate(5)).isEqualTo(decimal(40));
    }
}
