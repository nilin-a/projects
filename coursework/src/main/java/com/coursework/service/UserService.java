package com.coursework.service;

import com.coursework.dto.UserPojo;
import com.coursework.entity.Session;
import com.coursework.entity.User;
import com.coursework.repository.SessionRepository;
import com.coursework.repository.UserRepository;
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
    private SessionRepository sessionRepository;

    public String registration(UserPojo userPojo) throws Exception {
        if (userRepository.existsByLogin(userPojo.getLogin())) {
            throw new Exception();
        }
        User user = UserPojo.toEntity(userPojo);
        user.setPassword(passwordEncode(userPojo.getPassword()));
        userRepository.save(user);
        return login(userPojo);
    }

    public String login(UserPojo userPojo) throws Exception {
        User user = userRepository.findUserByLoginAndPassword(userPojo.getLogin(), passwordEncode(userPojo.getPassword()));
        if (user == null) {
            throw new Exception();
        }
        String token = generateToken(user);
        Session session = new Session(token, user);
        sessionRepository.save(session);
        return token;
    }

    public void logout(String token) throws Exception {
        Session session = sessionRepository.findSessionByToken(token);
        System.out.println(session.getId());
        if (session != null) {
            sessionRepository.delete(session);
        }
        else {
            throw new Exception();
        }
    }

    public UserPojo updateUser(UserPojo newUser, String token) throws Exception {
        User user = validateUser(token);
        user.setName(newUser.getName());
        user.setLogin(newUser.getLogin());
        user.setPassword(passwordEncode(newUser.getPassword()));
        userRepository.save(user);

        return UserPojo.fromEntity(user);
    }


    public User validateUser(String token) throws Exception {
        Session session = sessionRepository.findSessionByToken(token);
        if (session != null) {
            return session.getUser();
        }
        else {
            throw new Exception();
        }
    }

    public UserPojo getUser(String token) throws Exception {
        User user = validateUser(token);
        return UserPojo.fromEntity(user);
    }

    public String generateToken(User user) throws NoSuchAlgorithmException {
        return generateSHA256(user.getLogin() + user.getName() + LocalDateTime.now().toString());
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
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
