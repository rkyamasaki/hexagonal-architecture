package hexagonal.output.persistence

import javax.persistence.*

@Entity
@Table(name = "account")
data class AccountEntity (
    @Id
    @GeneratedValue
    val id:Long = 0L,

    @Column(name = "owner_name")
    val ownerName: String = "",
    
    @Column(name = "owner_document")
    val ownerDocument: String = "",
    
    @Column
    val balance: Long = 0L
)