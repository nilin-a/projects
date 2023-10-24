package com.diploma.server.repository;

import com.diploma.server.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
    UserSession findSessionByToken(String token);
}
