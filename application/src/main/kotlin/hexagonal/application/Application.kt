package hexagonal.application

import com.core.domain.Account
import com.core.domain.Money
import io.adapter.persistence.AccountEntity
import io.adapter.persistence.AccountMapper
import io.adapter.persistence.AccountRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import java.math.BigInteger
import java.util.*


@SpringBootApplication
@Configuration
@ComponentScan(basePackages = arrayOf("io.adapter.persistence"))
@EnableJpaRepositories(basePackages = arrayOf("io.adapter.persistence"))
@EntityScan(basePackages = arrayOf("io.adapter.persistence"))
open class Application(
        val accountRepository: AccountRepository
)
    : ApplicationRunner {

    private var applicationContext: ApplicationContext? = null
    
    override fun run(args: ApplicationArguments?) {
        val account: Account = Account(
                id=1,
                ownerDocument = "0616789",
                ownerName = "Josimar teste",
                balance = Money(BigInteger.valueOf(15))
        )
        print("------------------------------------------------")
        accountRepository.save(AccountMapper.mapToEntity(account))
        val accountEntity: Optional<AccountEntity> = accountRepository.findById(1L)
        print(accountEntity.get())
        print("---------------------------------------------------")
    }

}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}