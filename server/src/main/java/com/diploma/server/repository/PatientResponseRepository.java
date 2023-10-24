package com.diploma.server.repository;

import com.diploma.server.entity.MonitoredParameter;
import com.diploma.server.entity.PatientResponse;
import com.diploma.server.entity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientResponseRepository  extends JpaRepository<PatientResponse, Long> {
    List<PatientResponse> findAllByParameter(MonitoredParameter object);
    void deleteAllByQuestionnaire(Questionnaire questionnaire);
}
