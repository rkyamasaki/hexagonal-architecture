package com.core.port.`in`

import com.core.port.out.LoadAccountOutputPort
import com.core.port.out.UpdateAccountOutputPort

class SendMoneyUseCaseInputPort(
        val updateAccountOutputPort: UpdateAccountOutputPort,
        val loadAccountOutputPort: LoadAccountOutputPort
)
{
    
    fun sendMoney(sendMoneyCommand: SendMoneyCommand): Boolean {
        val sourceAccount = loadAccountOutputPort.loadAccount(sendMoneyCommand.sourceAccountId)
        val targetAccount = loadAccountOutputPort.loadAccount(sendMoneyCommand.targeAccountId)
        val moneyToTransfer = sendMoneyCommand.money

        if (!sourceAccount.witdhdraw(money = moneyToTransfer)) {
            return false
        }

        targetAccount.deposit(money = moneyToTransfer)
        return true
    } 
    
}