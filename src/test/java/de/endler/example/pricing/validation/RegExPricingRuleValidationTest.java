package de.endler.example.pricing.validation;

import org.junit.Test;

import static de.endler.example.pricing.provider.PropertyPricingRuleProvider.RULE_PATTERN;
import static org.assertj.core.api.Assertions.assertThat;

public class RegExPricingRuleValidationTest {

    @Test
    public void testIsValid() {
        assertThat(new RegExPricingRuleValidation("30", RULE_PATTERN).isValid()).isTrue();
        assertThat(new RegExPricingRuleValidation("30,50,3", RULE_PATTERN).isValid()).isTrue();
        assertThat(new RegExPricingRuleValidation("30,", RULE_PATTERN).isValid()).isFalse();
        assertThat(new RegExPricingRuleValidation("30,50,", RULE_PATTERN).isValid()).isFalse();
        assertThat(new RegExPricingRuleValidation("30,a,1", RULE_PATTERN).isValid()).isFalse();
        assertThat(new RegExPricingRuleValidation("30,,1", RULE_PATTERN).isValid()).isFalse();
        assertThat(new RegExPricingRuleValidation("30,,a", RULE_PATTERN).isValid()).isFalse();
    }

    @Test
    public void testGetValidationError() {
        assertThat(new RegExPricingRuleValidation("30,", RULE_PATTERN).getValidationError()).isEqualTo(
                "Rule definition <30,> is not valid. It should be in a format <" + RULE_PATTERN.toString() + ">");
    }
}
