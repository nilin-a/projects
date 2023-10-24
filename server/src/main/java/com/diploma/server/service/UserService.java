package com.diploma.server.service;

import com.diploma.server.dto.RegistrationMedicPojo;
import com.diploma.server.dto.RegistrationPatientPojo;
import com.diploma.server.dto.UserPojo;
import com.diploma.server.entity.*;
import com.diploma.server.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private MedicRepository medicRepository;
    @Autowired
    private UserSessionRepository userSessionRepository;
    @Autowired
    private MedicalCardRepository medicalCardRepository;

    public String registrationPatient(RegistrationPatientPojo registrationPatientPojo) throws Exception {
        if (userRepository.existsByLogin(registrationPatientPojo.getUserPojo().getLogin())) {
            throw new Exception();
        }
        User user = UserPojo.toEntity(registrationPatientPojo.getUserPojo());
        if (user.getRole() != User.Role.PATIENT) {
            throw new Exception();
        }
        user.setPassword(passwordEncode(registrationPatientPojo.getUserPojo().getPassword()));
        user = userRepository.saveAndFlush(user);
        Patient patient = new Patient();
        patient.setUser(user);
        patient.setName(registrationPatientPojo.getPatientPojo().getName());
        patient.setBirthDate(registrationPatientPojo.getPatientPojo().getBirthDate());
        patient.setSex(registrationPatientPojo.getPatientPojo().getSex());
        MedicalCard medicalCard = new MedicalCard(); //!!!
        medicalCard.setWeight(0);
        medicalCard.setHeight(0);
        medicalCard.setBloodType(MedicalCard.BloodType.O);
        medicalCard.setRhFactor(MedicalCard.RhFactor.RhPositive);
        medicalCard.setChronicDisease("");
        medicalCard.setAllergy("");
        medicalCard = medicalCardRepository.saveAndFlush(medicalCard);
        patient.setMedicalCard(medicalCard);
        patientRepository.save(patient);
        return login(registrationPatientPojo.getUserPojo());
    }

    public String registrationMedic(RegistrationMedicPojo registrationMedicPojo) throws Exception {
        if (userRepository.existsByLogin(registrationMedicPojo.getUserPojo().getLogin())) {
            throw new Exception();
        }
        User user = UserPojo.toEntity(registrationMedicPojo.getUserPojo());
        if (user.getRole() != User.Role.MEDIC) {
            throw new Exception();
        }
        user.setPassword(passwordEncode(registrationMedicPojo.getUserPojo().getPassword()));
        user = userRepository.saveAndFlush(user);
        Medic medic = new Medic();
        medic.setUser(user);
        medic.setName(registrationMedicPojo.getMedicPojo().getName());
        medic.setSpecialty(registrationMedicPojo.getMedicPojo().getSpecialty());
        medic.setEducation(registrationMedicPojo.getMedicPojo().getEducation());
        medic.setWorkPlace(registrationMedicPojo.getMedicPojo().getWorkPlace());
        medicRepository.save(medic);
        return login(registrationMedicPojo.getUserPojo());
    }

    public String login(UserPojo userPojo) throws Exception {
        User user = userRepository.findUserByLoginAndPassword(userPojo.getLogin(), passwordEncode(userPojo.getPassword()));
        if (user == null) {
            throw new Exception();
        }
        String token = generateToken(user);
        UserSession session = new UserSession(token, user);
        userSessionRepository.save(session);
        return token;
    }

    public void logout(String token) throws Exception {
        UserSession userSession = userSessionRepository.findSessionByToken(token);
        if (userSession != null) {
            userSessionRepository.delete(userSession);
        } else {
            throw new Exception();
        }
    }

    public UserPojo updateUser(UserPojo newUser, String token) throws Exception {
        User user = validateUser(token);
        if(newUser.getLogin() != null && !newUser.getLogin().trim().isEmpty()) {
            user.setLogin(newUser.getLogin());
        }
        if(newUser.getPassword() != null && !newUser.getPassword().trim().isEmpty()) {
            user.setPassword(passwordEncode(newUser.getPassword()));
        }
        userRepository.save(user);
        return UserPojo.fromEntity(user);
    }

    public UserPojo getUser(String token) throws Exception {
        User user = validateUser(token);
        return UserPojo.fromEntity(user);
    }

    public User validateUser(String token) throws Exception {
        UserSession userSession = userSessionRepository.findSessionByToken(token);
        if (userSession != null) {
            return userSession.getUser();
        } else {
            throw new Exception();
        }
    }

    public String generateToken(User user) throws NoSuchAlgorithmException {
        return generateSHA256(user.getLogin() + LocalDateTime.now().toString());
    }

    public String passwordEncode(String password) throws NoSuchAlgorithmException {
        return generateSHA256(password + "SALT");
    }

    public static String generateSHA256(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return bytesToHex(digest.digest(text.getBytes(StandardCharsets.UTF_8)));
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
