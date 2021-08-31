package lv.id.jc.numbers.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestedNumber implements Predicate<QueryParameter> {
    private final Number number;
    private final PropertyService propertyService;
    private final Map<String, Boolean> properties;
    private final Function<String, Boolean> tester;

    public TestedNumber(Number number, PropertyService propertyService) {
        this.number = number;
        this.propertyService = propertyService;
        properties = new HashMap<>();
        tester = propertyService.getTester(number);
    }

    public Map<String, Boolean> getProperties() {
        return propertyService.keySet().stream()
                .collect(Collectors.toUnmodifiableMap(Function.identity(), this::test));
    }

    public boolean test(final String propertyName) {
        return properties.computeIfAbsent(propertyName, tester);
    }

    @Override
    public boolean test(final QueryParameter queryParameter) {
        return queryParameter.isOpposite() != test(queryParameter.getPropertyName());
    }

    public boolean test(final Set<QueryParameter> query) {
        return query.stream().allMatch(this);
    }

}
