package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UsersRepositoryJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {
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

}
