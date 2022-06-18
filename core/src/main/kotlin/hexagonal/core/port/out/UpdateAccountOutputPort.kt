package hexagonal.core.port.out

import hexagonal.core.domain.Account

interface UpdateAccountOutputPort{
    
    fun updateAccount(account: Account): Boolean
    
}