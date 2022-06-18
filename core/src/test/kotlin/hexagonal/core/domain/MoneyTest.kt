package hexagonal.core.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import java.math.BigInteger

class MoneyTest {
    
    @Test
    fun shouldReturnTrueWhenMoneyHasLessAmount() {
        val money: Money = Money(BigInteger.valueOf(1000))
        val targeMoney: Money = Money(BigInteger.valueOf(999))
        
        Assertions.assertTrue(targeMoney.isLessThan(money))
    }

    @Test
    fun shouldReturnTrueWhenMoneyHasEqualAmount() {
        val money: Money = Money(BigInteger.valueOf(1000))
        val targeMoney: Money = Money(BigInteger.valueOf(1000))

        Assertions.assertFalse(targeMoney.isLessThan(money))
    }

    @Test
    fun shouldReturnFalseWhenMoneyHasMoreAmount() {
        val money: Money = Money(BigInteger.valueOf(999))
        val targeMoney: Money = Money(BigInteger.valueOf(1000))

        Assertions.assertFalse(targeMoney.isLessThan(money))
    }
    
}