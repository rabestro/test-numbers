package lv.id.jc.numbers

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
