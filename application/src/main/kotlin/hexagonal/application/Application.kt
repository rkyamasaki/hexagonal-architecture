package hexagonal.application

import hexagonal.core.domain.Account
import hexagonal.core.domain.Money
import hexagonal.output.persistence.AccountEntity
import hexagonal.output.persistence.AccountMapper
import hexagonal.output.persistence.AccountRepository
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
@ComponentScan(basePackages = arrayOf("hexagonal.output.persistence", "hexagonal.input.*"))
@EnableJpaRepositories(basePackages = arrayOf("hexagonal.output.persistence"))
@EntityScan(basePackages = arrayOf("hexagonal.output.persistence"))
open class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}