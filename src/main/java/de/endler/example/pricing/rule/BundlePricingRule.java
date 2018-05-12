package de.endler.example.pricing.rule;

import java.math.BigDecimal;

import static de.endler.example.tools.NumberTools.SCALE;
import static de.endler.example.tools.NumberTools.decimal;

/**
 * Price calculation for bundle priced items
 *
 * <h2>example</h2>
 * <p>1 item costs 10$, 3 items cost 25$. At checkout, 5 items cost $45.</p>
 *
 * @author Andreas Endler
 * @see PricingRule
 */
public final class BundlePricingRule implements PricingRule {

    private final BigDecimal unitPrice;
    private final BigDecimal bundlePrice;
    private final int itemsPerBundle;

    /**
     * Create the rule based on the given prices
     *
     * @param unitPrice      price per item
     * @param bundlePrice    price per bundle
     * @param itemsPerBundle items per bundle
     */
    public BundlePricingRule(BigDecimal unitPrice, BigDecimal bundlePrice, int itemsPerBundle) {
        this.unitPrice = unitPrice;
        this.bundlePrice = bundlePrice;
        this.itemsPerBundle = itemsPerBundle;
    }

    @Override
    public BigDecimal calculate(int itemcount) {
        if (itemcount >= itemsPerBundle) {
            final BigDecimal[] division = decimal(itemcount).divideAndRemainder(decimal(itemsPerBundle));
            final BigDecimal bundles = division[0];
            final BigDecimal singleItems = division[1];
            return bundles.multiply(bundlePrice).add(singleItems.multiply(unitPrice)).setScale(SCALE, BigDecimal.ROUND_HALF_UP);
        }
        return unitPrice.multiply(decimal(itemcount)).setScale(SCALE, BigDecimal.ROUND_HALF_UP);

    }
}
