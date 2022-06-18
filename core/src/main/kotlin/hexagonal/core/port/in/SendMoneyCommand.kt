package hexagonal.core.port.`in`

import hexagonal.core.domain.Money

data class SendMoneyCommand(
        val sourceAccountId: Long,
        val targetAccountId: Long,
        val money: Money
)