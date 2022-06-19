package hexagonal.output.persistence

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class DatabaseGenerator:ApplicationRunner {
    
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate
    
    override fun run(args: ApplicationArguments?) {
        jdbcTemplate.execute("create table account(id int, owner_name varchar, owner_document varchar, balance int)")
    }


}