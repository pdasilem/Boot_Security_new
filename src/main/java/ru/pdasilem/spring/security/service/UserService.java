package ru.pdasilem.spring.security.service;


import ru.pdasilem.spring.security.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> getAllUsers();
    UserModel getUserById(long id);
    void save(UserModel userModel);
    void deleteUserById(long id);
    void updateUser(UserModel newUser, long id);
    UserModel getUserByLogin(String login);

}
