package de.endler.example.pricing.rule;

import de.endler.example.tools.NumberTools;

import java.math.BigDecimal;

/**
 * Empty price calculation which returns always zero
 *
 * @author Andreas Endler
 * @see PricingRule
 */
public final class ZeroPricingRule implements PricingRule {

    @Override
    public BigDecimal calculate(int itemcount) {
        return NumberTools.scale(BigDecimal.ZERO);

    }
}
