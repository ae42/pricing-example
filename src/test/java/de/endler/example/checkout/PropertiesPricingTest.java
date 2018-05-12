package de.endler.example.checkout;

import de.endler.example.pricing.provider.PricingRuleProvider;
import de.endler.example.pricing.provider.PropertyPricingRuleProvider;

import java.util.Properties;

public class PropertiesPricingTest extends BasePricingTest {

    @Override
    protected PricingRuleProvider getRules() throws Exception {
        Properties pricingProperties = new Properties();
        pricingProperties.load(getClass().getResourceAsStream("pricing.properties"));
        return PropertyPricingRuleProvider.create(pricingProperties);
    }
}
