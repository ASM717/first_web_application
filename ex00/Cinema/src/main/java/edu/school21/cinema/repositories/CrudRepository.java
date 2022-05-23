package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    T findById(Long id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
    void delete(Long id);
}
