package edu.school21.cinema.services;

import edu.school21.cinema.exceptions.ErrorException;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UsersRepositoryJdbcTemplate;
import org.apache.maven.shared.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class UsersService {
    @Autowired
    private UsersRepositoryJdbcTemplate userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(String firstName, String lastName, String phoneNumber, String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(passwordEncoder.encode(password));
    }

    public User login(String phoneNumber, String password) throws ErrorException {
        validate(phoneNumber, password);

        User user = userRepo.findByPhoneNumber(phoneNumber);
        return user != null && passwordEncoder.matches(password, user.getPassword()) ? user : null;
    }

    private static void validate(String email, String password) throws ErrorException {
        Map<String, String> errors = new HashMap<>();

        if (StringUtils.isEmpty(email)) {
            errors.put("email", "Not defined");
        }

        if (StringUtils.isEmpty(password)) {
            errors.put("password", "Not defined");
        }

//        if (!errors.isEmpty()) {
//            throw new ErrorException(errors);
//        }
    }

}
