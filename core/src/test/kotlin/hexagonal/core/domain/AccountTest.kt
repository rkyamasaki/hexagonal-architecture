package hexagonal.core.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigInteger

class AccountTest {
    
    @Test
    fun shouldWithdrawMoneyIfHasEnoughtBalance() {
        val account1000Balance = createAccountWith100OfBalance()
        
        val money = Money(BigInteger.valueOf(1000))
        Assertions.assertTrue(account1000Balance.witdhdraw(money))
        Assertions.assertEquals(BigInteger.ZERO, account1000Balance.getAccountBalance())
    }

    @Test
    fun shoulNotdWithdrawMoneyIfDontHaveEnoughtBalance() {
        val account1000Balance = createAccountWith100OfBalance()

        val money = Money(BigInteger.valueOf(1001))
        Assertions.assertFalse(account1000Balance.witdhdraw(money))
        Assertions.assertEquals(BigInteger.valueOf(1000), account1000Balance.getAccountBalance())
    }
    
    @Test
    fun shouldDepositMoney() {
        val account1000Balance = createAccountWith100OfBalance()
        val money = Money(BigInteger.valueOf(150))
        
        account1000Balance.deposit(money)
        Assertions.assertEquals(BigInteger.valueOf(1150), account1000Balance.getAccountBalance())
        
    }
    
    private fun createAccountWith100OfBalance() = 
            Account(id = 100,
                    ownerName = "Jose Teste",
                    ownerDocument = "0618795913",
                    balance = Money(BigInteger.valueOf(1000))
            )
}