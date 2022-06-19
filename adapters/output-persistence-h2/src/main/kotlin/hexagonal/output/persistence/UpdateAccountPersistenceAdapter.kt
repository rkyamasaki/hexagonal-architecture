package hexagonal.output.persistence

import hexagonal.core.domain.Account
import hexagonal.core.port.out.CreateAccountOutputPort
import hexagonal.core.port.out.LoadAccountOutputPort
import hexagonal.core.port.out.UpdateAccountOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateAccountPersistenceAdapter(
        val accountRepository: AccountRepository
) : UpdateAccountOutputPort {

    override fun updateAccount(account: Account): Boolean {
        accountRepository.update(AccountMapper.mapToEntity(account))
        return true
    }
}