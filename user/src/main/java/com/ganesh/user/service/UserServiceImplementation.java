package com.ganesh.user.service;

import com.ganesh.user.repo.UserRepo;
import com.ganesh.user.userEntity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepo repo;

    public String addUser(User user) {

        repo.save(user);
        return "saved okay";
    }

   public User createUser(User user){
        User userSaved = repo.save(user);
        log.info("\nUser Created : "+user.toString());
        return userSaved;
   }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public String deleteUser(int id) {
        Optional<User> user = repo.findById(id);
        if (user.isPresent()) {
            repo.deleteById(id);
            return "delete successfully";
        } else {
            return "ID not Present";
        }
    }

    public String updateUser(final int id, final User user) {
        Optional<User> byId = repo.findById(id);
        if (byId.isPresent()) {
            User user1 = byId.get();
            user1.setName(user.getName());
            user1.setDesignation(user.getDesignation());
            repo.save(user1);
            return "Update Successfully";
        } else {
            return "ID not Available";
        }
    }

    public User getUserById( int id) {
        Optional<User> user = repo.findById(id);
        return repo.findById(id).get();
    }
}