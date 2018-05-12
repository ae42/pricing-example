package de.endler.example.pricing.provider;

import de.endler.example.pricing.rule.PricingRule;
import de.endler.example.pricing.rule.BundlePricingRule;
import de.endler.example.pricing.rule.SinglePricingRule;
import de.endler.example.pricing.rule.ZeroPricingRule;
import de.endler.example.pricing.validation.RegExPricingRuleValidation;
import de.endler.example.tools.NumberTools;

import java.util.Properties;
import java.util.regex.Pattern;

/**
 * Rule provider based on Java Properties in the format
 *
 * <p>item=price,bundleprice,itemsPerBundle</p>
 *
 * @author Andreas Endler
 * @see PricingRuleProvider
 */
public final class PropertyPricingRuleProvider implements PricingRuleProvider {

    /**
     * describes a rule in \\d+(,\\d+,\\d+){0,1} format
     */
    public final static Pattern RULE_PATTERN = Pattern.compile("\\d+(,\\d+,\\d+)?");

    private final Properties properties;

    private PropertyPricingRuleProvider(Properties properties) {
        this.properties = properties;
    }

    public static PropertyPricingRuleProvider create(Properties properties) {
        return new PropertyPricingRuleProvider(properties);
    }

    @Override
    public PricingRule get(String itemId) {
        String ruleDefinition = properties.getProperty(itemId);

        if (ruleDefinition == null) {
            return new ZeroPricingRule();
        }

        RegExPricingRuleValidation validation = new RegExPricingRuleValidation(ruleDefinition, RULE_PATTERN);
        if (!validation.isValid()) {
            throw new IllegalStateException(validation.getValidationError());
        }

        return createPricingRule(ruleDefinition);
    }

    /**
     * Creates a {@link SinglePricingRule} or {@link BundlePricingRule} based on the given rule definition
     *
     * @param ruleDefinition pricing rule in a format {@link #RULE_PATTERN}
     * @return {@link PricingRule}
     */
    private PricingRule createPricingRule(String ruleDefinition) {

        String[] values = ruleDefinition.split(",");

        if (values.length > 1) {
            return new BundlePricingRule(NumberTools.decimal(values[0]), NumberTools.decimal(values[1]), Integer.valueOf(values[2]));
        } else {
            return new SinglePricingRule(NumberTools.decimal(values[0]));
        }
    }
}
