package hexagonal.input.data

import com.fasterxml.jackson.annotation.JsonProperty
import hexagonal.core.domain.Money

class SendMoneyRequest(
        
        @JsonProperty("source_account_id")
        val sourceAccountId: Long,

        @JsonProperty("target_account_id")
        val targetAccountId: Long,
        
        @JsonProperty("value")
        val value: Long
)