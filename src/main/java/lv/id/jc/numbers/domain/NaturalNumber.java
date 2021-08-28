package lv.id.jc.numbers.domain;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class NaturalNumber extends BigInteger {
    private static final Pattern NATURAL_NUMBER = Pattern.compile("[+]?(?!0+$)\\d*\\d");
    private final PropertyService propertyService;
    private final Map<String, Boolean> properties;

    public NaturalNumber(String val, PropertyService propertyService) {
        super(val);
        properties = new HashMap<>();
        this.propertyService = propertyService;
    }

    static boolean isNaturalNumber(final String value) {
        return NATURAL_NUMBER.matcher(value).matches();
    }

    public boolean test(final String propertyName) {
        return properties.computeIfAbsent(propertyName, key -> propertyService.get(key).test(this));
    }
}
