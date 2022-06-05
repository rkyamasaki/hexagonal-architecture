package com.core.port.`in`

import com.core.domain.Money

data class SendMoneyCommand(
        val sourceAccountId: Long,
        val targetAccountId: Long,
        val money: Money
)