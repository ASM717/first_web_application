package edu.school21.cinema.services;

import edu.school21.cinema.exceptions.ErrorException;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UsersRepositoryJdbcTemplate;
import org.apache.maven.shared.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UsersService {
    @Autowired
    private UsersRepositoryJdbcTemplate userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(String firstName, String lastName, String phoneNumber, String password) {
        User user = new User(firstName, lastName, phoneNumber, password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(passwordEncoder.encode(password));
    }

    public User login(String phoneNumber, String password) throws ErrorException {
        Optional<User> optionalUser = Optional.ofNullable(userRepo.findByPhoneNumber(phoneNumber));
        if (!optionalUser.isPresent()) {
            return null;
        }
        User user = optionalUser.get();
        if(passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    private static void validate(String phoneNumber, String password) throws ErrorException {

    }

}
