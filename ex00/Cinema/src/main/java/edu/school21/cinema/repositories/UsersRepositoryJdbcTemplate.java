package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsersRepositoryJdbcTemplate implements UsersRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("INSERT INTO schema.users (first_name, last_name, email, password) VALUES (?, ?, ?, ?)",
                entity.getFirstName(), entity.getLastName(), entity.getPhoneNumber(), entity.getPassword());
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User findByPhoneNumber(String phoneNumber) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM schema.users WHERE phone_number = ?",
                    new UserMapper(), phoneNumber);
        } catch (Exception e) {
            return null;
        }
    }

    private static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            User user = new User();
//            user.setId(rs.getLong("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setPhoneNumber(resultSet.getString("phone_number"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }
    }

}
