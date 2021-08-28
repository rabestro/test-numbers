package lv.id.jc.numbers.domain;

import java.math.BigInteger;
import java.util.regex.Pattern;

public class NaturalNumber extends BigInteger {
    private static final Pattern NATURAL_NUMBER = Pattern.compile("[+]?(?!0+$)\\d*\\d");

    public NaturalNumber(String val) {
        super(val);
    }

    static boolean isNaturalNumber(final String value) {
        return NATURAL_NUMBER.matcher(value).matches();
    }
}
