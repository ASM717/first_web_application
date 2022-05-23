package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;

public interface UsersRepository extends CrudRepository<User>{
    User findByPhoneNumber(String phoneNumber);
}
