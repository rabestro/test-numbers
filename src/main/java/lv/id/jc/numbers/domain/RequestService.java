package lv.id.jc.numbers.domain;

import java.util.Set;

public class RequestService {
    private final PropertyService propertyService;
    private final Set<Set<String>> mutuallyExclusive;

    public RequestService(PropertyService propertyService, Set<Set<String>> mutuallyExclusive) {
        this.propertyService = propertyService;
        this.mutuallyExclusive = mutuallyExclusive;
    }

    enum RequestType {
        EXIT, HELP, WRONG_FIRST, WRONG_SECOND, WRONG_PROPERTY, MUTUALLY, CARD, LIST
    }
}
