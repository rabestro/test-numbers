package lv.id.jc.numbers.domain

import lv.id.jc.numbers.property.Even
import spock.lang.Specification
import spock.lang.Subject

class NaturalNumberTest extends Specification {
    @Subject
    NaturalNumber number

    PropertyService propertyService = Mock()

    void setup() {
        number = new NaturalNumber("1", propertyService)
    }

    def "Test"() {
        given:
        propertyService.get("even") >> new Even()

        when:
        def result = number.test("even")

        then:
        !result
    }
}
