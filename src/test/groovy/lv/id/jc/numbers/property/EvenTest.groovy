package lv.id.jc.numbers.property

import spock.lang.Specification
import spock.lang.Subject

class EvenTest extends Specification {
    @Subject
    Property property = new Even()

    def 'expects that #number is an even number'() {
        expect:
        property.test(number as long)

        where:
        number << [2, 4, 8, 10, 12, 18, 22, 36]
    }

    def 'expects that #number is not an even number'() {
        expect:
        !property.test(number as long)

        where:
        number << [1, 3, 7, 11, 19, 21, 31, 49]
    }
}
