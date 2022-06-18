package hexagonal.output.persistence

import hexagonal.core.domain.Account
import hexagonal.core.port.out.CreateAccountOutputPort
import hexagonal.core.port.out.LoadAccountOutputPort
import hexagonal.core.port.out.UpdateAccountOutputPort
import org.springframework.stereotype.Component

@Component
class AccountPersistenceAdapter(
        val accountRepository: AccountRepository
) : CreateAccountOutputPort, LoadAccountOutputPort, UpdateAccountOutputPort {
    
    
    override fun createAccount(account: Account): Boolean {
        val accountEntity: AccountEntity = AccountMapper.mapToEntity(account)
        accountRepository.save(accountEntity)
        return true
    }

    override fun loadAccount(accountId: Long): Account {
        return AccountMapper.mapToDomainObject(accountRepository.findById(accountId).get())
    }

    override fun updateAccount(account: Account): Boolean {
        accountRepository.save(AccountMapper.mapToEntity(account))
        return true
    }
}