## Pricing example

### Introduction

This little projects corresponds to a task of [codekata](http://codekata.com/kata/kata09-back-to-the-checkout/).

It's a possible implementation based on two core ideas: 

An interface for calculating the price

```java
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
```

An interface for determining the price calculation for a particular item
```java
/**
 * Provides the price calculation for a particular item
 *
 * @author Andreas Endler
 */
public interface PricingRuleProvider {

    /**
     * Provides the price calculation for a particular item
     *
     * @param itemId id of the item for which the price calculation is to be determined
     * @return price calculation as {@link PricingRule}
     */
    PricingRule get(String itemId);

}
```

### Project usage

This project is based on the build tool [Gradle](https://gradle.org). You can import this project easily as Gradle-project into your favorite IDE. 

It makes use of the Gradle-plugin [Test-Logger](https://plugins.gradle.org/plugin/com.adarshr.test-logger) to beautify the logs on the console while running tests.

Running the tests on console or shell is made by
```
C:\> gradlew.bat test
```
```
$ ./gradlew test
```


