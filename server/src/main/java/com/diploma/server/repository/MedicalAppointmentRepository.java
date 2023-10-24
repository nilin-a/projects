package com.diploma.server.repository;

import com.diploma.server.entity.Medic;
import com.diploma.server.entity.MedicalAppointment;
import com.diploma.server.entity.MedicalCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long> {
    List<MedicalAppointment> findAllByMedic(Medic medic);

    List<MedicalAppointment> findAllByMedicalCardAndMedic(MedicalCard medicalCard, Medic medic);
    List<MedicalAppointment> findAllByMedicalCard(MedicalCard medicalCard);
}
