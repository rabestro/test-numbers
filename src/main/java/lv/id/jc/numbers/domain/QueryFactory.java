package lv.id.jc.numbers.domain;

import java.util.Set;

public class QueryFactory {
    private final PropertyService propertyService;
    private final Set<Set<String>> mutuallyExclusive;

    public QueryFactory(PropertyService propertyService, Set<Set<String>> mutuallyExclusive) {
        this.propertyService = propertyService;
        this.mutuallyExclusive = mutuallyExclusive;
    }
}
