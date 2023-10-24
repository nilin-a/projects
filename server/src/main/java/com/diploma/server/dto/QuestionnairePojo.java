package com.diploma.server.dto;
import com.diploma.server.entity.MonitoredParameter;
import com.diploma.server.entity.PatientResponse;
import com.diploma.server.entity.Questionnaire;
import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
public class QuestionnairePojo {
    private long id;
    private MedicalCardPojo medicalCard;
    private MedicPojo medic;
    private Date date;
    private List<MonitoredParameterPojo> parameterList;
    private String optional;
    private int result;
    private Questionnaire.Status status;
    private String medicsRespond;
    private Map<String, MonitoredParameterPojo> filledPatientData;

    public static QuestionnairePojo fromEntity(Questionnaire entity) {
        QuestionnairePojo pojo = new QuestionnairePojo();
        pojo.setId(entity.getId());
        pojo.setMedicalCard(MedicalCardPojo.fromEntity(entity.getMedicalCard()));
        pojo.setMedic(MedicPojo.fromEntity(entity.getMedic()));
        pojo.setDate(entity.getDate());
        List<MonitoredParameterPojo> parameterPojoList = new ArrayList<>();
        for (MonitoredParameter monitoredParameter: entity.getParameterList()) {
            parameterPojoList.add(MonitoredParameterPojo.fromEntity(monitoredParameter));
        }
        pojo.setParameterList(parameterPojoList);
        pojo.setOptional(entity.getOptional());
        pojo.setResult(entity.getResult());
        pojo.setStatus(entity.getStatus());
        pojo.setMedicsRespond(entity.getMedicsRespond());
        Map<String, MonitoredParameterPojo> map = new HashMap<>();
        for (PatientResponse pr : entity.getFilledPatientData())
        {
            map.put(pr.getResponse(),MonitoredParameterPojo.fromEntity(pr.getParameter()));
        }
        pojo.setFilledPatientData(map);
        return pojo;
    }
}
