package hexagonal.input.service

import hexagonal.core.port.`in`.NewAccountCommand
import hexagonal.core.port.`in`.NewAccountUseCaseInputPort
import hexagonal.input.data.AccountResponse
import hexagonal.input.data.CreateAccountRequest
import hexagonal.output.persistence.AccountPersistenceAdapter
import org.springframework.stereotype.Service

@Service
class AccountService(
        val accountPersistenceAdapter: AccountPersistenceAdapter
) {
    
    fun createAccount(createAccountRequest: CreateAccountRequest) {
        val newAccountCommand: NewAccountCommand = NewAccountCommand(
                id = createAccountRequest.id,
                ownerDocument = createAccountRequest.ownerDocument,
                ownerName = createAccountRequest.ownerName,
                balance = createAccountRequest.balance
        )
        
        val newAccountUseCaseInputPort: NewAccountUseCaseInputPort = NewAccountUseCaseInputPort(accountPersistenceAdapter)
        newAccountUseCaseInputPort.createNewAccount(newAccountCommand)
    }
    
    fun findAccount(accountId: Long): AccountResponse {
        val account = accountPersistenceAdapter.loadAccount(accountId)
        
        return AccountResponse(
                id = account.id,
                ownerName = account.ownerName,
                ownerDocument = account.ownerDocument,
                balance = account.getAccountBalance().toLong()
        )
    }
    
}