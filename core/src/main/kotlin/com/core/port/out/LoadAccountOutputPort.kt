package com.core.port.out

import com.core.domain.Account

interface LoadAccountOutputPort {
    
    fun loadAccount(accountId: Long): Account
    
}