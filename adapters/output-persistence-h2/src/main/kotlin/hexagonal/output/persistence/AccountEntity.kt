package hexagonal.output.persistence

data class AccountEntity (
    val id:Long = 0L,
    
    val ownerName: String = "",
    
    val ownerDocument: String = "",
    
    val balance: Long = 0L
)