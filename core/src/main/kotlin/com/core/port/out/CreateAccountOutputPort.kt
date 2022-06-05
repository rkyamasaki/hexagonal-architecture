package com.core.port.out

import com.core.domain.Account

interface CreateAccountOutputPort {
    
    fun createAccount(account: Account)
    
}