package lv.id.jc.numbers.property

import spock.lang.Specification

class PropertyTest extends Specification {
    def "expects that #value is a natural number"() {
        expect:
        Property.isNaturalNumber(value)

        where:
        value << ["1", "+1", "01", "001", "+001", "2", "320", "+00023003210900"]
    }
}
