package hexagonal.core.port.`in`

import hexagonal.core.domain.Account
import hexagonal.core.domain.Money
import hexagonal.core.port.out.CreateAccountOutputPort
import java.math.BigInteger

class NewAccountUseCaseInputPort(
        val createAccountOutputPort: CreateAccountOutputPort
) {
    
    fun createNewAccount(newAccountCommand: NewAccountCommand): Boolean {
        val account: Account = Account(
                id = newAccountCommand.id,
                ownerName = newAccountCommand.ownerName,
                ownerDocument = newAccountCommand.ownerDocument,
                balance = Money(BigInteger.valueOf(newAccountCommand.balance))
        )
        
        return createAccountOutputPort.createAccount(account)
    }
    
}