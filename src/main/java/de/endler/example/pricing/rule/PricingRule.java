package de.endler.example.pricing.rule;

import de.endler.example.checkout.Checkout;

import java.math.BigDecimal;

/**
 * Describes a price calculation for use in {@link Checkout}
 *
 * @author Andreas Endler
 */
public interface PricingRule {

    /**
     * Calculates the price for the quantity of the specified items
     *
     * @param quantity items count
     * @return the resulting price as {@link BigDecimal}
     */
    BigDecimal calculate(int quantity);

}
