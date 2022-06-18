package hexagonal.input.data

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateAccountRequest (

        @JsonProperty("id")
        val id: Long,

        @JsonProperty("owner_name")
        val ownerName: String,

        @JsonProperty("owner_document")
        val ownerDocument: String,

        @JsonProperty("balance")
        var balance: Long
)