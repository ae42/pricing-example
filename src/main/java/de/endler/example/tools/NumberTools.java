package de.endler.example.tools;

import java.math.BigDecimal;

/**
 * Tools for working with BigDecimal
 *
 * @author Andreas Endler
 */
public final class NumberTools {

    /**
     * default scale is 2
     */
    public static final int SCALE = 2;

    /**
     * converts the given Integer to a BigDecimal using the {@link #SCALE}
     */
    public static BigDecimal decimal(int number) {
        return BigDecimal.valueOf(number).setScale(SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * converts the given String to a BigDecimal using the {@link #SCALE}
     */
    public static BigDecimal decimal(String number) {
        return new BigDecimal(number).setScale(SCALE, BigDecimal.ROUND_HALF_UP);
    }

}
