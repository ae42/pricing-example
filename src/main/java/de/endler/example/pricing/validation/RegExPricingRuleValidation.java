package de.endler.example.pricing.validation;

import java.util.regex.Pattern;

/**
 * Validates a rule definition using a regular expression
 *
 * @author Andreas Endler
 */
public final class RegExPricingRuleValidation {

    private final String ruleDefinition;
    private final Pattern rulePattern;

    /**
     * Validates a rule definition using a regular expression
     *
     * @param ruleDefinition rule to check
     * @param pattern        rule will be evaluated against this regex pattern
     */
    public RegExPricingRuleValidation(String ruleDefinition, Pattern pattern) {
        this.ruleDefinition = ruleDefinition;
        this.rulePattern = pattern;
    }

    /**
     * @return true, if the rule definition matches the pattern
     */
    public boolean isValid() {
        return rulePattern.matcher(ruleDefinition).matches();
    }

    /**
     * @return Errortext, if validation failed
     */
    public String getValidationError() {
        return String.format("Rule definition <%s> is not valid. "
                + "It should be in a format <%s>", ruleDefinition, rulePattern.toString());
    }

}
