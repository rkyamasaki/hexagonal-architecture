package com.core.port.out

import com.core.domain.Account
import com.core.domain.Money
import java.math.BigInteger

class SendMoneyUseCaseInputPortTest {

    
    

    private fun createAccountWith100OfBalance() =
            Account(id = 100,
                    ownerName = "Jose Teste",
                    ownerDocument = "0618795913",
                    balance = Money(BigInteger.valueOf(1000))
            )

    private fun createAccountWith800fBalance() =
            Account(id = 100,
                    ownerName = "Jose Teste",
                    ownerDocument = "0618795913",
                    balance = Money(BigInteger.valueOf(800))
            )
    
}