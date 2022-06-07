package edu.school21.cinema.services;

import edu.school21.cinema.exceptions.ErrorException;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UsersRepositoryJdbcTemplate;
//import org.apache.maven.shared.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UsersService {
    @Autowired
    private UsersRepositoryJdbcTemplate userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createUser(String firstName, String lastName, String phoneNumber, String password) {
        Optional<User> optionalUser = Optional.ofNullable(userRepo.findByPhoneNumber(phoneNumber));
        if (optionalUser.isPresent()) {
            return false;
        }
        userRepo.save(new User(firstName, lastName, phoneNumber, passwordEncoder.encode(password)));
        return true;

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
