package com.coursework.dto;

import com.coursework.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPojo {
    private long id;
    private User.Role role;
    private String name;
    private String login;
    private String password;

    public static UserPojo fromEntity(User user) {
        UserPojo userPojo = new UserPojo();
        userPojo.setId(user.getId());
        userPojo.setRole(user.getRole());
        userPojo.setName(user.getName());
        userPojo.setLogin(user.getLogin());
        userPojo.setPassword(user.getPassword());
        return userPojo;
    }

    public static User toEntity(UserPojo userPojo) {
        User user = new User();
        user.setId(userPojo.getId());
        user.setRole(userPojo.getRole());
        user.setName(userPojo.getName());
        user.setLogin(userPojo.getLogin());
        user.setPassword(userPojo.getPassword());
        return user;
    }
}
