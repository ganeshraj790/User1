package com.ganesh.user.service;


import com.ganesh.user.userEntity.User;

import java.util.List;

public interface UserService {
    public String addUser(User user);

    User createUser(User user);

    public List<User> getAllUsers();

    public String deleteUser(int id);



    public User getUserById(int id);

    String updateUser(int id, User user);
}
