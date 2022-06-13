package io.adapter.persistence

import com.core.domain.Account
import com.core.port.out.CreateAccountOutputPort
import com.core.port.out.LoadAccountOutputPort
import com.core.port.out.UpdateAccountOutputPort
import org.springframework.stereotype.Component

@Component
class AccountPersistenceAdapter(
        val accountRepository: AccountRepository
) : CreateAccountOutputPort, LoadAccountOutputPort, UpdateAccountOutputPort  {
    
    
    override fun createAccount(account: Account) {
        val accountEntity: AccountEntity = AccountMapper.mapToEntity(account)
        accountRepository.save(accountEntity)
    }

    override fun loadAccount(accountId: Long): Account {
        return AccountMapper.mapToDomainObject(accountRepository.findById(accountId).get())
    }

    override fun updateAccount(account: Account): Boolean {
        accountRepository.save(AccountMapper.mapToEntity(account))
        return true
    }
}