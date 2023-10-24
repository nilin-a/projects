package com.coursework.repository;

import com.coursework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByNameContainingIgnoreCase(String name);

    boolean existsByLogin(String login);

    User findUserByLoginAndPassword(String login, String password);
}
