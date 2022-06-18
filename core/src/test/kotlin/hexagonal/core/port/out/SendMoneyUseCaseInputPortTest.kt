package hexagonal.core.port.out

import hexagonal.core.domain.Account
import hexagonal.core.domain.Money
import hexagonal.core.port.`in`.SendMoneyCommand
import hexagonal.core.port.`in`.SendMoneyUseCaseInputPort
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.mockito.kotlin.any
import java.math.BigInteger

class SendMoneyUseCaseInputPortTest {
    
    val loadAccountOutputPort: LoadAccountOutputPort = Mockito.mock(LoadAccountOutputPort::class.java)
    val updateAccountOutputPort: UpdateAccountOutputPort = Mockito.mock(UpdateAccountOutputPort::class.java)
    var sendMoneyUseCaseInputPort: SendMoneyUseCaseInputPort
    
    init {
        given(updateAccountOutputPort.updateAccount(any()))
                .willReturn(true)

        sendMoneyUseCaseInputPort = SendMoneyUseCaseInputPort(updateAccountOutputPort, loadAccountOutputPort)
    }
    
    @Test
    fun shouldSendMoneyIfSourceAccountHasSuficientMoney() {
        val sourceAccount = createAccountWith100OfBalance()
        val sourceAccointId = sourceAccount.id
        given(loadAccountOutputPort.loadAccount(Mockito.eq(sourceAccointId)))
                .willReturn(sourceAccount)

        val targetAccount = createAccountWith800fBalance()
        val targetAccountId = targetAccount.id
        given(loadAccountOutputPort.loadAccount(Mockito.eq(targetAccountId)))
                .willReturn(targetAccount)
        
        
        val moneyToSend: Money = Money(BigInteger.valueOf(999)) 
        val sendMoneyCommand: SendMoneyCommand = SendMoneyCommand(
                sourceAccountId = sourceAccointId,
                targetAccountId = targetAccountId,
                money = moneyToSend
        )
        
        Assertions.assertTrue(sendMoneyUseCaseInputPort.sendMoney(sendMoneyCommand))
        Assertions.assertEquals(BigInteger.valueOf(1), sourceAccount.getAccountBalance())
        Assertions.assertEquals(BigInteger.valueOf(1799), targetAccount.getAccountBalance())
    }

    @Test
    fun shouldSendMoneyIfSourceAccountHasBalanceEqualtMoneyToTransfer() {
        val sourceAccount = createAccountWith100OfBalance()
        val sourceAccointId = sourceAccount.id
        given(loadAccountOutputPort.loadAccount(Mockito.eq(sourceAccointId)))
                .willReturn(sourceAccount)

        val targetAccount = createAccountWith800fBalance()
        val targetAccountId = targetAccount.id
        given(loadAccountOutputPort.loadAccount(Mockito.eq(targetAccountId)))
                .willReturn(targetAccount)


        val moneyToSend: Money = Money(BigInteger.valueOf(1000))
        val sendMoneyCommand: SendMoneyCommand = SendMoneyCommand(
                sourceAccountId = sourceAccointId,
                targetAccountId = targetAccountId,
                money = moneyToSend
        )

        Assertions.assertTrue(sendMoneyUseCaseInputPort.sendMoney(sendMoneyCommand))
        Assertions.assertEquals(BigInteger.valueOf(0), sourceAccount.getAccountBalance())
        Assertions.assertEquals(BigInteger.valueOf(1800), targetAccount.getAccountBalance())
    }

    @Test
    fun shouldNotSendMoneyIfSourceAccountDoNotHaveSuficientMoney() {
        val sourceAccount = createAccountWith100OfBalance()
        val sourceAccointId = sourceAccount.id
        given(loadAccountOutputPort.loadAccount(Mockito.eq(sourceAccointId)))
                .willReturn(sourceAccount)

        val targetAccount = createAccountWith800fBalance()
        val targetAccountId = targetAccount.id
        given(loadAccountOutputPort.loadAccount(Mockito.eq(targetAccountId)))
                .willReturn(targetAccount)


        val moneyToSend: Money = Money(BigInteger.valueOf(1001))
        val sendMoneyCommand: SendMoneyCommand = SendMoneyCommand(
                sourceAccountId = sourceAccointId,
                targetAccountId = targetAccountId,
                money = moneyToSend
        )

        Assertions.assertFalse(sendMoneyUseCaseInputPort.sendMoney(sendMoneyCommand))
        Assertions.assertEquals(BigInteger.valueOf(1000), sourceAccount.getAccountBalance())
        Assertions.assertEquals(BigInteger.valueOf(800), targetAccount.getAccountBalance())
    }

    private fun createAccountWith100OfBalance() =
            Account(id = 100L,
                    ownerName = "Jose Teste",
                    ownerDocument = "0618795913",
                    balance = Money(BigInteger.valueOf(1000))
            )

    private fun createAccountWith800fBalance() =
            Account(id = 101L,
                    ownerName = "Jose Teste",
                    ownerDocument = "0618795913",
                    balance = Money(BigInteger.valueOf(800))
            )
    
}