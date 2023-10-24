package com.diploma.server.repository;

import com.diploma.server.entity.MonitoredParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoredParameterRepository extends JpaRepository<MonitoredParameter, Long> {
}
