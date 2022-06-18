package hexagonal.input.service

import hexagonal.core.domain.Money
import hexagonal.core.port.`in`.NewAccountCommand
import hexagonal.core.port.`in`.NewAccountUseCaseInputPort
import hexagonal.core.port.`in`.SendMoneyCommand
import hexagonal.core.port.`in`.SendMoneyUseCaseInputPort
import hexagonal.input.data.AccountResponse
import hexagonal.input.data.CreateAccountRequest
import hexagonal.input.data.SendMoneyRequest
import hexagonal.output.persistence.CreateAccountPersistenceAdapter
import hexagonal.output.persistence.LoadAccountPersistenceAdapter
import hexagonal.output.persistence.UpdateAccountPersistenceAdapter
import org.springframework.stereotype.Service
import java.math.BigInteger

@Service
class AccountService(
        val createAccountPersistenceAdapter: CreateAccountPersistenceAdapter,
        val loadAccountPersistenceAdapter: LoadAccountPersistenceAdapter,
        val updateAccountPersistenceAdapter: UpdateAccountPersistenceAdapter
) {
    
    fun createAccount(createAccountRequest: CreateAccountRequest) {
        val newAccountCommand: NewAccountCommand = NewAccountCommand(
                id = createAccountRequest.id,
                ownerDocument = createAccountRequest.ownerDocument,
                ownerName = createAccountRequest.ownerName,
                balance = createAccountRequest.balance
        )
        
        val newAccountUseCaseInputPort: NewAccountUseCaseInputPort = NewAccountUseCaseInputPort(createAccountPersistenceAdapter)
        newAccountUseCaseInputPort.createNewAccount(newAccountCommand)
    }
    
    fun findAccount(accountId: Long): AccountResponse {
        val account = loadAccountPersistenceAdapter.loadAccount(accountId)
        
        return AccountResponse(
                id = account.id,
                ownerName = account.ownerName,
                ownerDocument = account.ownerDocument,
                balance = account.getAccountBalance().toLong()
        )
    }
    
    fun sendMoney(sendMoneyRequest: SendMoneyRequest) {
        val money = Money(BigInteger.valueOf(sendMoneyRequest.value))
        val sendMoneyCommand = SendMoneyCommand(
                sourceAccountId = sendMoneyRequest.sourceAccountId,
                targetAccountId = sendMoneyRequest.targetAccountId,
                money = money
        )
        
        val sendMoneyUseCaseInputPort = SendMoneyUseCaseInputPort(updateAccountPersistenceAdapter, loadAccountPersistenceAdapter)
        sendMoneyUseCaseInputPort.sendMoney(sendMoneyCommand)
    }
    
}