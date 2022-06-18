package hexagonal.input.rest

import hexagonal.input.data.AccountResponse
import hexagonal.input.data.CreateAccountRequest
import hexagonal.input.data.SendMoneyRequest
import hexagonal.input.service.AccountService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/account")
class AccountController(
        val accountService: AccountService
) {
    
    @PostMapping
    fun createAccount(@RequestBody createAccountRequest: CreateAccountRequest) {
        accountService.createAccount(createAccountRequest)
    }
    
    @GetMapping("{id}")
    fun getAccount(@PathVariable id: Long): AccountResponse {
        return accountService.findAccount(id)
    }
    
    @PostMapping("/balance")
    fun sendMoney(@RequestBody sendMoneyRequest: SendMoneyRequest) {
        accountService.sendMoney(sendMoneyRequest)
    }
    
}