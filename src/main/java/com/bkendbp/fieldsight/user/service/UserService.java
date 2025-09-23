package com.bkendbp.fieldsight.user.service;

import com.bkendbp.fieldsight.user.model.User;
import com.bkendbp.fieldsight.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public String createUser(User user) {
        userRepository.save(user);
        return "Success";
    }

    public void updateUserById(Long id, User user) {
        Optional<User> userToUpdate = userRepository.findById(id);

    }

    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "User deleted";
    }
}
