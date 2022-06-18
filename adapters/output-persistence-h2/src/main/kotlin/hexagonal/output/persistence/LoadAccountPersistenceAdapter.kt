package hexagonal.output.persistence

import hexagonal.core.domain.Account
import hexagonal.core.port.out.CreateAccountOutputPort
import hexagonal.core.port.out.LoadAccountOutputPort
import hexagonal.core.port.out.UpdateAccountOutputPort
import org.springframework.stereotype.Component

@Component
class LoadAccountPersistenceAdapter(
        val accountRepository: AccountRepository
) : LoadAccountOutputPort {
  
    override fun loadAccount(accountId: Long): Account {
        return AccountMapper.mapToDomainObject(accountRepository.findById(accountId).get())
    }

}