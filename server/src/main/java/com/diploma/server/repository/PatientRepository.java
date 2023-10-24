package com.diploma.server.repository;

import com.diploma.server.entity.Patient;
import com.diploma.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findPatientByUser(User user);

    Patient findPatientById(long id);

    Patient findPatientByMedicalCardId(long id);
}


