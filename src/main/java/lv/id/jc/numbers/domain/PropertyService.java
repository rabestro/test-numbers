package lv.id.jc.numbers.domain;

import lv.id.jc.numbers.property.Property;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;

public class PropertyService {
    private final Map<String, Property> properties;

    public PropertyService(Set<Property> properties) {
        this.properties = properties.stream().collect(toUnmodifiableMap(Property::name, identity()));
    }

    public Set<String> keySet() {
        return properties.keySet();
    }

    public Property get(String name) {
        return properties.get(name);
    }

    Function<String, Boolean> getTester(Number number) {
        return key -> properties.get(key).test(number);
    }

    Predicate<String> getNumberTester(Number number) {
        return key -> properties.get(key).test(number);
    }

    Predicate<String> getBigTester(Number number) {
        return new Predicate<>() {
            private final Map<String, Boolean> cache = new HashMap<>();

            @Override
            public boolean test(String property) {
                return cache.computeIfAbsent(property, key -> properties.get(key).test(number));
            }
        };
    }
}
