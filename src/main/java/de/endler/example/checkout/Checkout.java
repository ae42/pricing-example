package de.endler.example.checkout;

import de.endler.example.pricing.provider.PricingRuleProvider;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

/**
 * Scans items and calculates the total price
 *
 * @author Andreas Endler
 */
public class Checkout {

    private final PricingRuleProvider pricingRuleProvider;
    private final Map<String, Integer> items = new HashMap<>();

    public Checkout(PricingRuleProvider princingRuleResolver) {
        this.pricingRuleProvider = princingRuleResolver;
    }

    /**
     * Adds an item with the given id to the basket
     *
     * @param itemId unique id of the item to add
     */
    public void scan(String itemId) {
        final int itemsCount = Optional.ofNullable(items.get(itemId)).orElse(0) + 1;
        items.put(itemId, itemsCount);
    }

    /**
     * Calculates the total price of all items in the basket
     *
     * @return total price as BigDecimal
     */
    public BigDecimal total() {
        return items.entrySet().stream().map(this::calculate).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    private BigDecimal calculate(Entry<String, Integer> itemBundleEntry) {
        final String itemId = itemBundleEntry.getKey();
        final int itemsCount = itemBundleEntry.getValue();
        return pricingRuleProvider.get(itemId).calculate(itemsCount);
    }

}
