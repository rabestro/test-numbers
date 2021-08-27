package lv.id.jc.numbers.property

import spock.lang.Specification
import spock.lang.Subject

class DuckTest extends Specification {
    @Subject
    Property property = new Duck()

    def 'expects that small #number is a duck number'() {
        expect:
        property.test(number as byte)
        property.test(number as short)
        property.test(number as int)

        where:
        number << [10, 20, 30, 40, 50, 101, 120, 109]
    }

    def 'expects that #number is a duck number'() {
        expect:
        property.test(number as long)

        where:
        number << [10, 205, 3080, 40, 17031, 903527, 453066, 4045]
    }

    def "expects that #number is not a duck number"() {
        expect:
        !property.test(number as long)

        where:
        number << [1, 2, 13, 42, 423, 123, 63523, 2342, 653]
    }

    def "expects that BigInteger #number is a duck number"() {
        expect:
        property.test(number as BigInteger)

        where:
        number << [100_012_300, 205843554268902234, 30883518475434758230]
    }

    def "expects that BigInteger #number is not a duck number"() {
        expect:
        !property.test(number as BigInteger)

        where:
        number << [435736951615987526, 2584355426892234, 388351847543475823]
    }
}
