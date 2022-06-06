package edu.school21.cinema.models;

import lombok.Data;

//@Getter
//@Setter
//@ToString
@Data
public class User {
//    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;

    public User(String firstName, String lastName, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
