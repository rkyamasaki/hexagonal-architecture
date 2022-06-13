package io.adapter.persistence

import com.core.domain.Account
import com.core.domain.Money
import java.math.BigInteger

class AccountMapper {
    
    companion object {
        fun mapToEntity(account: Account): AccountEntity {
            return AccountEntity(
                    id = account.id,
                    ownerDocument = account.ownerDocument,
                    ownerName = account.ownerName,
                    balance = account.getAccountBalance().toLong()
            )
        }
        
        fun mapToDomainObject(accountEntity: AccountEntity): Account {
            return Account(
                    id = accountEntity.id,
                    ownerName = accountEntity.ownerName,
                    ownerDocument = accountEntity.ownerDocument,
                    balance = Money(BigInteger.valueOf( accountEntity.balance))
            )
        }
    }
}