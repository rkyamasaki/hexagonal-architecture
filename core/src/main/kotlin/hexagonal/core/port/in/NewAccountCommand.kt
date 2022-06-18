package hexagonal.core.port.`in`

import hexagonal.core.domain.Money

data class NewAccountCommand (
        val id: Long,
        val ownerName: String,
        val ownerDocument: String,
        var balance: Long
)