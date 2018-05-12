package de.endler.example.pricing.provider;

import de.endler.example.pricing.rule.PricingRule;
import de.endler.example.pricing.rule.BundlePricingRule;
import de.endler.example.pricing.rule.SinglePricingRule;
import de.endler.example.pricing.rule.ZeroPricingRule;
import de.endler.example.tools.NumberTools;

/**
 * Rule provider with fixed prices
 * <p>
 * <b>item: price, bundleprice, itemsPerBundle</b><br/>
 * A: 50,130,3<br/>
 * B: 30, 45,3<br/>
 * C: 20<br/>
 * B: 15<br/>
 * </p>
 *
 * @author Andreas Endler
 * @see PricingRuleProvider
 */
public final class FixedPricingRuleProvider implements PricingRuleProvider {

    private FixedPricingRuleProvider() {
    }

    public static FixedPricingRuleProvider create() {
        return new FixedPricingRuleProvider();
    }

    @Override
    public PricingRule get(String itemId) {
        switch (itemId) {
            case "A":
                return new BundlePricingRule(NumberTools.decimal(50), NumberTools.decimal(130), 3);
            case "B":
                return new BundlePricingRule(NumberTools.decimal(30), NumberTools.decimal(45), 2);
            case "C":
                return new SinglePricingRule(NumberTools.decimal(20));
            case "D":
                return new SinglePricingRule(NumberTools.decimal(15));
            default:
                return new ZeroPricingRule();
        }
    }
}
