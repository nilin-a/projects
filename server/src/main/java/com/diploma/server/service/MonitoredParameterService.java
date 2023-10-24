package com.diploma.server.service;

import com.diploma.server.dto.MonitoredParameterPojo;
import com.diploma.server.entity.MonitoredParameter;
import com.diploma.server.entity.PatientResponse;
import com.diploma.server.entity.Questionnaire;
import com.diploma.server.repository.MonitoredParameterRepository;
import com.diploma.server.repository.PatientResponseRepository;
import com.diploma.server.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonitoredParameterService {
    @Autowired
    private MonitoredParameterRepository monitoredParameterRepository;
    @Autowired
    private QuestionnaireRepository questionnaireRepository;
    @Autowired
    private PatientResponseRepository responseRepository;

    public MonitoredParameterPojo createMP(MonitoredParameterPojo pojo) {
        MonitoredParameter object = MonitoredParameterPojo.toEntity(pojo);
        monitoredParameterRepository.save(object);
        return MonitoredParameterPojo.fromEntity(object);
    }

    public List<MonitoredParameter> findAllEntity() {
        List<MonitoredParameter> objects = monitoredParameterRepository.findAll();
        return objects;
    }

    public List<MonitoredParameterPojo> findAllPojo() {
        List<MonitoredParameter> objects = monitoredParameterRepository.findAll();
        List<MonitoredParameterPojo> result = new ArrayList<>();
        for (MonitoredParameter object : objects) {
            result.add(MonitoredParameterPojo.fromEntity(object));
        }
        return result;
    }

    public MonitoredParameterPojo updateMonitoredParameter(MonitoredParameterPojo monitoredParameterPojo) {
        MonitoredParameter monitoredParameter = monitoredParameterRepository.findById(monitoredParameterPojo.getId()).orElseThrow();
        if (monitoredParameterPojo.getName() != null && !monitoredParameterPojo.getName().trim().isEmpty()) {
            monitoredParameter.setName(monitoredParameterPojo.getName());
        }
        if (monitoredParameterPojo.getDescription() != null && !monitoredParameterPojo.getDescription().trim().isEmpty())
        {
            monitoredParameter.setDescription(monitoredParameterPojo.getDescription());
        }
        monitoredParameterRepository.save(monitoredParameter);
        return MonitoredParameterPojo.fromEntity(monitoredParameter);
    }

    public void delete(long objectId) {
        MonitoredParameter object = monitoredParameterRepository.findById(objectId).orElseThrow();
        List<PatientResponse> responses = responseRepository.findAllByParameter(object);
      //  List<Questionnaire> questionnaires = questionnaireRepository.findAllByParameterListContaining(object);
        for (PatientResponse response: responses) {
            questionnaireRepository.deleteAllByFilledPatientData(response);
        }
        responseRepository.deleteAll(responses);
      //  questionnaireRepository.deleteAll(questionnaires);
        monitoredParameterRepository.delete(object);
    }


}
