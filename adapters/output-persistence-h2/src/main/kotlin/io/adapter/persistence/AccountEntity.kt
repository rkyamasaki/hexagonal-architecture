package io.adapter.persistence

import javax.persistence.*

@Entity
@Table(name = "account")
class AccountEntity (
    @Id
    @GeneratedValue
    val id:Long,

    @Column(name = "owner_name")
    val ownerName: String,
    
    @Column(name = "owner_document")
    val ownerDocument: String,
    
    @Column
    val balance: Long
)