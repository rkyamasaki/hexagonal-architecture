package hexagonal.core.domain

import java.math.BigInteger

class Account(
        val id: Long,
        val ownerName: String,
        val ownerDocument: String,
        private var balance: Money
        
) {
    
    fun witdhdraw(money: Money): Boolean {
        if (balance isLessThan  money) {
            return false
        }
        balance = this.balance subtract money
        return true
    }
    
    fun deposit(money: Money) {
        balance = this.balance sum money
    }
    
    fun getAccountBalance(): BigInteger = balance.amount
    
}