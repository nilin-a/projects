package com.diploma.server.repository;

import com.diploma.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLogin(String login);

    User findUserByLoginAndPassword(String login, String passwordEncode);

    User findUserByLogin(String login);
}
