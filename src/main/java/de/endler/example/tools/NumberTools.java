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
    private static final int SCALE = 2;

    /**
     * converts the given Integer to a BigDecimal using the {@link #SCALE}
     */
    public static BigDecimal decimal(int number) {
        return scale(BigDecimal.valueOf(number));
    }

    /**
     * converts the given String to a BigDecimal using the {@link #SCALE}
     */
    public static BigDecimal decimal(String number) {
        return scale(new BigDecimal(number));
    }

    /**
     * sets the default scale as defined in {@link #SCALE}
     */
    public static BigDecimal scale(BigDecimal bigDecimal) {
        return bigDecimal.setScale(SCALE, BigDecimal.ROUND_HALF_UP);
    }

}
