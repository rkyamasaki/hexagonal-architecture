package hexagonal.core.port.out

import hexagonal.core.domain.Account

interface CreateAccountOutputPort {
    
    fun createAccount(account: Account): Boolean
    
}