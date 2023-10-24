package com.diploma.server.dto;

import com.diploma.server.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPojo {
    private long id;
    private String login;
    private String password;
    private User.Role role;

    public static UserPojo fromEntity(User entity) {
        UserPojo pojo = new UserPojo();
        pojo.setId(entity.getId());
        pojo.setLogin(entity.getLogin());
        pojo.setPassword(entity.getPassword());
        pojo.setRole(entity.getRole());
        return pojo;
    }

    public static User toEntity(UserPojo pojo) {
        User entity = new User();
        entity.setId(pojo.getId());
        entity.setLogin(pojo.getLogin());
        entity.setPassword(pojo.getPassword());
        entity.setRole(pojo.getRole());
        return entity;
    }
}
