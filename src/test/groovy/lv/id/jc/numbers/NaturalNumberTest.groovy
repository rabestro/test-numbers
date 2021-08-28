package lv.id.jc.numbers

import spock.lang.Specification

class NaturalNumberTest extends Specification {
    def "expects that #value is a natural number"() {
        expect:
        NaturalNumber.isNaturalNumber(value)

        where:
        value << ["1", "+1", "01", "001", "+001", "2", "320", "+00023003210900"]
    }
}
