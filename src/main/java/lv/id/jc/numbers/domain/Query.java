package lv.id.jc.numbers.domain;

import java.util.Set;
import java.util.function.Predicate;

public class Query implements Predicate<Number> {
    private final Set<Parameter> query;

    public Query(Set<Parameter> query) {
        this.query = query;
    }

    @Override
    public boolean test(Number number) {
        return false;
    }

    public static class Parameter {
        private final boolean isOpposite;
        private final String propertyName;

        Parameter(String parameter) {
            isOpposite = parameter.length() > 0 && parameter.charAt(0) == '-';
            propertyName = isOpposite ? parameter.substring(1) : parameter;
        }

        public boolean isOpposite() {
            return isOpposite;
        }

        public String getPropertyName() {
            return propertyName;
        }
    }


}
