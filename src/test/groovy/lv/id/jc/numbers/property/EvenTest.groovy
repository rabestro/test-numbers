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
        number << [2, 4, 14, 40, 10, 18652, 453066, 4000]
    }

    def 'expects that #number is not an even number'() {
        expect:
        !property.test(number as long)

        where:
        number << [1, 3, 7, 11, 19, 5221, 145, 31]
    }
}
