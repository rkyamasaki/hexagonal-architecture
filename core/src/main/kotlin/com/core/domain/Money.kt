package com.core.domain

import java.math.BigInteger

class Money(
        val amount: BigInteger
) {
    infix fun isLessThan(money: Money): Boolean {
        return amount.compareTo(money.amount) < 0
    }

    infix fun sum(money: Money): Money {
        return Money(this.amount.add(money.amount))
    }

    infix fun subtract(money: Money): Money {
        return Money(this.amount.subtract(money.amount))
    }
    
}