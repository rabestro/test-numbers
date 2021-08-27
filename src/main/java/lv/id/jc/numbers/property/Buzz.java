package lv.id.jc.numbers.property;

import java.math.BigInteger;

import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;

public final class Buzz implements Property {
    private static final BigInteger SEVEN = BigInteger.valueOf(7);

    @Override
    public boolean test(final BigInteger number) {
        return number.mod(SEVEN).equals(ZERO) || number.mod(TEN).equals(SEVEN);
    }

    @Override
    public boolean test(long number) {
        return number % 7 == 0 || number % 10 == 7;
    }
}