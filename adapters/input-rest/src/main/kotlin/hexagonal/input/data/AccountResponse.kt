package hexagonal.input.data

import com.fasterxml.jackson.annotation.JsonProperty

class AccountResponse(
        val id: Long,

        @JsonProperty("owner_name")
        val ownerName: String,

        @JsonProperty("owner_document")
        val ownerDocument: String,

        var balance: Long
)