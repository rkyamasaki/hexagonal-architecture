package hexagonal.core.port.`in`

import hexagonal.core.port.out.LoadAccountOutputPort
import hexagonal.core.port.out.UpdateAccountOutputPort

class SendMoneyUseCaseInputPort(
        val updateAccountOutputPort: UpdateAccountOutputPort,
        val loadAccountOutputPort: LoadAccountOutputPort
)
{
    
    fun sendMoney(sendMoneyCommand: SendMoneyCommand): Boolean {
        val sourceAccount = loadAccountOutputPort.loadAccount(sendMoneyCommand.sourceAccountId)
        val targetAccount = loadAccountOutputPort.loadAccount(sendMoneyCommand.targetAccountId)
        val moneyToTransfer = sendMoneyCommand.money

        if (!sourceAccount.witdhdraw(money = moneyToTransfer)) {
            return false
        }

        targetAccount.deposit(money = moneyToTransfer)
        updateAccountOutputPort.updateAccount(sourceAccount)
        updateAccountOutputPort.updateAccount(targetAccount)
        return true
    } 
    
}