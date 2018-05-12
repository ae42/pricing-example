package de.endler.example.checkout;

import de.endler.example.pricing.provider.FixedPricingRuleProvider;
import de.endler.example.pricing.provider.PricingRuleProvider;

public class PricingTest extends BasePricingTest {

    @Override
    protected PricingRuleProvider getRules() {
        return FixedPricingRuleProvider.create();
    }
}
