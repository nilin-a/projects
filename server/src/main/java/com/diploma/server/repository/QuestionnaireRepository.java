package com.diploma.server.repository;
import com.diploma.server.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
  //  Questionnaire findQuestionnaireByIdAndMedicalCard(long id, MedicalCard medicalCard);

  //  Questionnaire findQuestionnaireByIdAndMedic(long id, Medic medic);

    List<Questionnaire> findAllByMedic(Medic medic);

    List<Questionnaire> findAllByMedicalCard(MedicalCard medicalCard);

   // List<Questionnaire> findAllByParameterListContaining(MonitoredParameter monitoredParameter);
    void deleteAllByFilledPatientData(PatientResponse patientResponse);

    Questionnaire findQuestionnaireByIdAndMedicalCardOrderByDateAsc(long id, MedicalCard medicalCard);

    Questionnaire findQuestionnaireByIdAndMedicOrderByDateAsc(long id, Medic medic);

    // List<Questionnaire> findAllByMedicOrderByDateAsc(Medic medic);

  //  List<Questionnaire> findAllByMedicalCardOrderByDateAsc(MedicalCard medicalCard);

    List<Questionnaire> findAllByMedicalCardAndStatusOrderByDateAsc(MedicalCard medicalCard, Questionnaire.Status s);
}
