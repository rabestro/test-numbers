package lv.id.jc.numbers.domain

import spock.lang.Specification

class QueryParameterTest extends Specification {

    def "when #queryParameter then opposite is #opposite and property is #property"() {
        given:
        def underTest = new QueryParameter(queryParameter)

        expect:
        underTest.opposite == opposite
        underTest.propertyName == property

        where:
        queryParameter || property | opposite
        "buzz"         || "buzz"   | false
        "-buzz"        || "buzz"   | true
        "even"         || "even"   | false
        "odd"          || "odd"    | false
        "-even"        || "even"   | true
        "-odd"         || "odd"    | true
        ""             || ""       | false
    }

}
