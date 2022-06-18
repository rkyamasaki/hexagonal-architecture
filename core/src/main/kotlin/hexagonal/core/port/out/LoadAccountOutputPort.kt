package hexagonal.core.port.out

import hexagonal.core.domain.Account

interface LoadAccountOutputPort {
    
    fun loadAccount(accountId: Long): Account
    
}