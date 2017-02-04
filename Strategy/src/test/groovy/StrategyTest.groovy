import net.wdo.domain.Adult
import net.wdo.domain.Child
import net.wdo.domain.InfantInLap
import net.wdo.domain.InfantInSeat
import net.wdo.domain.Traveler
import net.wdo.pattern.DiscountSelector
import spock.lang.Specification

class StrategyTest extends Specification {

    def "Should Apply Discounts Strategically"() {
        given:
        double amount = 100.1
        expect:
        calculatedDiscount == DiscountSelector.calculateDiscount(traveler, amount)

        where:
        traveler                     | calculatedDiscount
        new Adult().withAge(65)      | new Double(40.04)
        new Adult().withAge(30)      | new Double(0)
        new Child()                  | new Double(50.05)
        new InfantInSeat()           | new Double(70.07)
        new InfantInLap().withAge(2) | new Double(70.07)
        new InfantInLap().withAge(1) | new Double(80.08)
    }
}
