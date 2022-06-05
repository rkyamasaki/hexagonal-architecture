package com.core.port.out

import com.core.domain.Account

interface UpdateAccountOutputPort{
    
    fun updateAccount(account: Account): Boolean
    
}