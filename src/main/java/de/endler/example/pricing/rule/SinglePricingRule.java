package de.endler.example.pricing.rule;

import java.math.BigDecimal;

import static de.endler.example.tools.NumberTools.scale;

/**
 * Single price calculation based on a unit price
 *
 * @author Andreas Endler
 * @see PricingRule
 */
public final class SinglePricingRule implements PricingRule {

    private final BigDecimal unitprice;

    /**
     * creates the rule based on the specified price
     *
     * @param unitprice price per item
     */
    public SinglePricingRule(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    @Override
    public BigDecimal calculate(int itemcount) {
        return scale(unitprice.multiply(BigDecimal.valueOf(itemcount)));

    }
}
