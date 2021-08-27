package lv.id.jc.numbers.property

import spock.lang.Specification

class BuzzTest extends Specification {

    def "expects that #number is a buzz number "() {
        given:
        def property = new Buzz()

        expect:
        property.test(number as long)

        where:
        number << [7, 14, 17, 21, 27, 28, 35, 37, 42]
    }

    def "expects that #number is not a buzz number "() {
        given:
        def property = new Buzz()

        expect:
        !property.test(number as int)

        where:
        number << [1, 2, 4, 6, 8, 71, 16, 72, 638_045]
    }

    def "expects that BigInteger #number is a buzz number "() {
        given:
        def property = new Buzz()

        expect:
        property.test(number as BigInteger)

        where:
        number << ["777", "1437388952612632237", "17", "21", "27", "28", "35", "37", "42"]
    }

}
