package lv.id.jc.numbers

import lv.id.jc.numbers.domain.PropertyService
import spock.lang.Specification

import java.util.stream.Stream

class PropertyServiceTest extends Specification {
    def "Constructor"() {
        given:
        Set properties = Mock()
        properties.stream() >> Stream.empty()

        when:
        def service = new PropertyService(properties)

        then:
        service.keySet() == Collections.emptySet()
    }
}
