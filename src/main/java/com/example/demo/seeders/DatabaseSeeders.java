package com.example.demo.seeders;

import com.example.demo.dao.Userdao;
import com.example.demo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class DatabaseSeeders {
    private Logger logger = Logger.getLogger(String.valueOf(DatabaseSeeders.class));
    private JdbcTemplate jdbcTemplate;
    private Userdao userdao;
    @Autowired
    public DatabaseSeeders(Userdao userdao,JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
        this.userdao=userdao;
    }
    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedUsersTable();
    }

    private void seedUsersTable() {

        String sql = "SELECT user_name, password FROM users U WHERE U.user_name = \"admin@admin.com\" OR " +
                "U.password = \"12345678\" LIMIT 1";

        List<Users> u = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if(u == null || u.size() <= 0) {
            Users user = new Users();
            user.setFirstName("Mr.");
            user.setLastName("Admin");
            user.setUserName("admin@admin.com");
            user.setPassword("123456789");
            userdao.save(user);
            logger.info("Users Seeded");
        } else {
            logger.info("Users Seeding Not Required");
        }
    }


}
