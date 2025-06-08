package com.lostfound.service;

import com.lostfound.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {


    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);


    User registerUser(User user);


    Optional<User> findByEmail(String email);
}
