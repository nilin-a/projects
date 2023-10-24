package com.diploma.server.service;
import com.diploma.server.dto.MedicalCardPojo;
import com.diploma.server.dto.MonitoredParameterPojo;
import com.diploma.server.dto.QuestionnairePojo;
import com.diploma.server.entity.*;
import com.diploma.server.repository.PatientResponseRepository;
import com.diploma.server.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class QuestionnaireService {
    @Autowired
    private QuestionnaireRepository questionnaireRepository;
    @Autowired
    private MedicService medicService;
    @Autowired
    private MonitoredParameterService monitoredParameterService;
    @Autowired
    private MedicalCardService medicalCardService;
    @Autowired
    private PatientResponseRepository patientResponseRepository;

    public QuestionnairePojo createQuestionnaire(QuestionnairePojo questionnairePojo, String token) throws Exception {
        Medic medic = medicService.getMedic(token);
        Questionnaire questionnaire = new Questionnaire();
        List<MonitoredParameter> allMonitoredParameters = monitoredParameterService.findAllEntity();
        List<MonitoredParameter> myMonitoredParameters = new ArrayList<>();
        for (MonitoredParameterPojo parameterPojo : questionnairePojo.getParameterList()) {
            MonitoredParameter param = allMonitoredParameters.stream().filter(p -> p.getId() == parameterPojo.getId()).findAny().orElseThrow();
            myMonitoredParameters.add(param);
        }
        questionnaire.setMedic(medic);
        questionnaire.setMedicalCard(medicalCardService.getMedicalCardById(questionnairePojo.getMedicalCard().getId()));
        questionnaire.setStatus(Questionnaire.Status.SENT_TO_PATIENT);
        questionnaire.setParameterList(myMonitoredParameters);
        //questionnaire.setDate(java.sql.Date.valueOf(LocalDate.now()));
        questionnaire.setDate(questionnairePojo.getDate());
        questionnaire.setFilledPatientData(Collections.emptyList());
        questionnaireRepository.save(questionnaire);
        return QuestionnairePojo.fromEntity(questionnaire);
    }

    public QuestionnairePojo answeredByPatientQuestionnaire(QuestionnairePojo questionnairePojo, String token) throws Exception {
        MedicalCard medicalCard = medicalCardService.getMedicalCardByToken(token);
       // Questionnaire questionnaire = questionnaireRepository.findQuestionnaireByIdAndMedicalCard(questionnairePojo.getId(), medicalCard);
        Questionnaire questionnaire = questionnaireRepository.findQuestionnaireByIdAndMedicalCardOrderByDateAsc(questionnairePojo.getId(), medicalCard);
        questionnaire.setOptional(questionnairePojo.getOptional());
        questionnaire.setStatus(Questionnaire.Status.SENT_TO_MEDIC);
        List<PatientResponse> finalMap = new ArrayList<>();
        questionnairePojo.getFilledPatientData().forEach((k, v) -> {
            finalMap.add(new PatientResponse(k, questionnaire, questionnaire.getParameterList().stream().filter(p -> p.getId() == v.getId()).findAny().orElseThrow()));
        });
        List<PatientResponse> map = patientResponseRepository.saveAllAndFlush(finalMap);
        questionnaire.setFilledPatientData(map);
        questionnaireRepository.save(questionnaire);
        return QuestionnairePojo.fromEntity(questionnaire);
    }

    public QuestionnairePojo answeredByMedicQuestionnaire(QuestionnairePojo questionnairePojo, String token) throws Exception {
        Medic medic = medicService.getMedic(token);
        Questionnaire questionnaire = questionnaireRepository.findQuestionnaireByIdAndMedicOrderByDateAsc(questionnairePojo.getId(), medic);
        questionnaire.setMedicsRespond(questionnairePojo.getMedicsRespond());
        questionnaire.setResult(questionnairePojo.getResult());
        questionnaire.setStatus(questionnairePojo.getStatus());
        questionnaireRepository.save(questionnaire);
        return QuestionnairePojo.fromEntity(questionnaire);
    }

    public List<QuestionnairePojo> findAllQuestionnaireByMedic(String token) throws Exception {
        Medic medic = medicService.getMedic(token);
        List<Questionnaire> questionnaires = questionnaireRepository.findAllByMedic(medic);
        List<QuestionnairePojo> questionnairePojos = new ArrayList<>();
        for (Questionnaire questionnaire : questionnaires) {
            questionnairePojos.add(QuestionnairePojo.fromEntity(questionnaire));
        }
        return questionnairePojos;
    }

    public List<QuestionnairePojo> findAllQuestionnaireByPatient(String token) throws Exception {
        MedicalCard medicalCard = medicalCardService.getMedicalCardByToken(token);
        List<Questionnaire> questionnaires = questionnaireRepository.findAllByMedicalCard(medicalCard);
        List<QuestionnairePojo> questionnairePojos = new ArrayList<>();
        for (Questionnaire questionnaire : questionnaires) {
            questionnairePojos.add(QuestionnairePojo.fromEntity(questionnaire));
        }
        return questionnairePojos;
    }

    public List<QuestionnairePojo> findAllQuestionnaireForCurve(String token) throws Exception {
        MedicalCard medicalCard = medicalCardService.getMedicalCardByToken(token);
        List<Questionnaire> questionnaires = questionnaireRepository.findAllByMedicalCardAndStatusOrderByDateAsc(medicalCard, Questionnaire.Status.ANSWERED);
        List<QuestionnairePojo> questionnairePojos = new ArrayList<>();
        for (Questionnaire questionnaire : questionnaires) {
            questionnairePojos.add(QuestionnairePojo.fromEntity(questionnaire));
        }
        return questionnairePojos;
    }

    public List<Questionnaire> findAllQuestionnaireByPatientId(long id) throws Exception {
        MedicalCard medicalCard = MedicalCardPojo.toEntity(medicalCardService.getMedicalCardByPatientId(id));
        return questionnaireRepository.findAllByMedicalCard(medicalCard);
    }

    public QuestionnairePojo updateQuestionnaire(QuestionnairePojo questionnairePojo) {
        Questionnaire questionnaire = questionnaireRepository.findById(questionnairePojo.getId()).orElseThrow();
        questionnaire.setStatus(questionnairePojo.getStatus());
        questionnaireRepository.save(questionnaire);
        return QuestionnairePojo.fromEntity(questionnaire);
    }

    public void deleteQuestionnaire(long id) {
        Questionnaire questionnaire = questionnaireRepository.findById(id).orElseThrow();
        /*
        if (questionnaire.getStatus() != Questionnaire.Status.SENT_TO_PATIENT) {
            patientResponseRepository.deleteAllByQuestionnaire(questionnaire);
        }

         */
        questionnaireRepository.delete(questionnaire);
    }
}
