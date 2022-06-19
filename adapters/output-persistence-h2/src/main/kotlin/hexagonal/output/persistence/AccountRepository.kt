package hexagonal.output.persistence

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.util.*


@Component
open class AccountRepository  {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate
    
    fun save(accountEntity: AccountEntity) {
        jdbcTemplate.update("insert into account (id, owner_name, owner_document, balance) values(?,?,?,?)",
        accountEntity.id, accountEntity.ownerName, accountEntity.ownerDocument, accountEntity.balance)
    }

    fun update(accountEntity: AccountEntity) {
        jdbcTemplate.update("update account " +
                "                    set owner_name = ?, owner_document = ?, balance = ? " +
                "                  where id = ?",
                accountEntity.ownerName, accountEntity.ownerDocument, accountEntity.balance, accountEntity.id)
    }
    
    fun findById(id: Long): AccountEntity {
        var rowMapper: RowMapper<AccountEntity> = RowMapper<AccountEntity> { resultSet: ResultSet, _ ->
            AccountEntity(resultSet.getLong("id"), 
                    resultSet.getString("owner_name"), 
                    resultSet.getString("owner_document"),
                    resultSet.getLong("balance"))
        }
        val result = jdbcTemplate.query("select * from account where id = ${id}",
                rowMapper)
        
        return result.get(0)
    }
    
}