package edu.school21.cinema.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@ToString
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    Long id;
    String firstName;
    String lastName;
    String phoneNumber;
    String email;
    String password;

    public User(long id, String firstname, String lastname, String email, String phone, String password) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.phoneNumber = phone;
        this.password = password;
    }

    public User(String firstname, String lastname, String email, String phone, String password) {
        this.id = null;
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.phoneNumber = phone;
        this.password = password;
    }
}
