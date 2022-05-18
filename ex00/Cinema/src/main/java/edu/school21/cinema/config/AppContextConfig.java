package edu.school21.cinema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
@ComponentScan("edu.school21.cinema")
public class AppContextConfig {
    @Bean
    public static DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("gastellsky");
        dataSource.setPassword("qwerty");

        return dataSource;
    }

    @Bean
    public static JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

//    @Bean
//    public MyListener myListenerConfig() {
//        return new MyListener(jdbcTemplate());
//    }

}
