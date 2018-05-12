package de.endler.example.pricing.provider;


import de.endler.example.pricing.rule.PricingRule;

/**
 * Provides the price calculation for a particular item
 *
 * @author Andreas Endler
 */
public interface PricingRuleProvider {

    /**
     * Provides the price calculation for a particular item
     *
     * @param itemId id of the item for which the price calculation is to be determined
     * @return price calculation as {@link PricingRule}
     */
    PricingRule get(String itemId);
}
