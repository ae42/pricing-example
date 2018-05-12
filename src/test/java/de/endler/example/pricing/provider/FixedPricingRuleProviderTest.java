package de.endler.example.pricing.provider;

import de.endler.example.pricing.rule.BundlePricingRule;
import de.endler.example.pricing.rule.SinglePricingRule;
import de.endler.example.pricing.rule.ZeroPricingRule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FixedPricingRuleProviderTest {

    @Test
    public void testGet() {
        FixedPricingRuleProvider fixedPricingRuleProvider = FixedPricingRuleProvider.create();
        assertThat(fixedPricingRuleProvider.get("A")).isInstanceOf(BundlePricingRule.class);
        assertThat(fixedPricingRuleProvider.get("B")).isInstanceOf(BundlePricingRule.class);
        assertThat(fixedPricingRuleProvider.get("C")).isInstanceOf(SinglePricingRule.class);
        assertThat(fixedPricingRuleProvider.get("D")).isInstanceOf(SinglePricingRule.class);
        assertThat(fixedPricingRuleProvider.get("")).isInstanceOf(ZeroPricingRule.class);
    }

}
