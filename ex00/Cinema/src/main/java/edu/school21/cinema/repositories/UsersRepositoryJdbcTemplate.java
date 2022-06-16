package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepositoryJdbcTemplate implements UsersRepository {

    private final JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    private final RowMapper<User> userRowMapper = (resultSet, rowNum) -> {
        User user = new User(
                resultSet.getLong("id"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getString("email"),
                resultSet.getString("phoneNumber"),
                resultSet.getString("password")
        );
        return user;
    };

    @Override
    public Optional<User> findById(Long id) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * FROM schema.users WHERE id = ?", userRowMapper, id);
            return Optional.ofNullable(user);
        } catch (DataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM schema.users", userRowMapper);
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("INSERT INTO schema.users (firstName, lastName, email, phoneNumber, password) VALUES (?, ?, ?, ?, ?)",
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getPassword());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE schema.users SET firstName = ?, lastName = ?, email = ?, phoneNumber = ?, password = ? WHERE id = ?",
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getPassword(),
                entity.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM schema.users WHERE id = ?", id);
    }

    @Override
    public Optional<User> findByPhoneNumber(String phoneNumber) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * FROM schema.users WHERE phoneNumber = ?", userRowMapper, phoneNumber);
            return Optional.ofNullable(user);
        } catch (DataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * FROM schema.users WHERE email = ?", userRowMapper, email);
            return Optional.ofNullable(user);
        } catch (DataAccessException e) {
            return Optional.empty();
        }
    }
}
