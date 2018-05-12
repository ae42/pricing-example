package de.endler.example.pricing.provider;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.fail;

public class PropertyPricingRuleProviderTest {

    @Test
    public void invalidRule() throws Exception {
        Properties pricingProperties = new Properties();
        pricingProperties.load(getClass().getResourceAsStream("invalidpricing.properties"));
        PropertyPricingRuleProvider rules = PropertyPricingRuleProvider.create(pricingProperties);
        expectException(() -> rules.get("A"));
        expectException(() -> rules.get("B"));
        expectException(() -> rules.get("C"));
        expectException(() -> rules.get("D"));
    }

    private void expectException(Runnable runnable) {
        try {
            runnable.run();
            fail("rule definition is not valid but no IllegalStateException was thrown");
        } catch (IllegalStateException ignored) {
        }
    }
}
