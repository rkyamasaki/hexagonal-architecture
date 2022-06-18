package hexagonal.output.persistence

import hexagonal.core.domain.Account
import hexagonal.core.port.out.CreateAccountOutputPort
import hexagonal.core.port.out.LoadAccountOutputPort
import hexagonal.core.port.out.UpdateAccountOutputPort
import org.springframework.stereotype.Component

@Component
class CreateAccountPersistenceAdapter(
        val accountRepository: AccountRepository
) : CreateAccountOutputPort {
    
    
    override fun createAccount(account: Account): Boolean {
        val accountEntity: AccountEntity = AccountMapper.mapToEntity(account)
        accountRepository.save(accountEntity)
        return true
    }
    
}