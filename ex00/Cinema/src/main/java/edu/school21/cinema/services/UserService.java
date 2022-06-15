package edu.school21.cinema.services;

import edu.school21.cinema.exceptions.ErrorException;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UsersRepository;
import edu.school21.cinema.repositories.UsersRepositoryJdbcTemplate;
//import org.apache.maven.shared.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserService {
    private final UsersRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UsersRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public boolean saveUser(String firstname, String lastname, String email, String phone, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            return false;
        }
        userRepository.save(new User(firstname, lastname, email, phone, passwordEncoder.encode(password)));
        return true;
    }

    public User authorizeUser(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            return null;
        }
        User user = optionalUser.get();
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }
}
