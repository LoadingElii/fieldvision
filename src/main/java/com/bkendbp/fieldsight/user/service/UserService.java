package com.bkendbp.fieldsight.user.service;

import com.bkendbp.fieldsight.exception.EmailAlreadyExistException;
import com.bkendbp.fieldsight.exception.ResourceNotFoundException;
import com.bkendbp.fieldsight.mapper.UserMapper;
import com.bkendbp.fieldsight.user.model.User;
import com.bkendbp.fieldsight.user.model.UserDto;
import com.bkendbp.fieldsight.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private Long id;
    private UserDto user;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        if(userRepository.findAll().isEmpty()) {
            throw new ResourceNotFoundException("No users exist.");
        }
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toUserDto)
                .toList();
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " does not exist."));
        return UserMapper.toUserDto(user);
    }

    public UserDto createUser(UserDto user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistException("User already exist with email: " + user.getEmail() +".");
        }

        User newUser = userRepository.save(UserMapper.toUser(user));

        return UserMapper.toUserDto(newUser);
    }

    public UserDto updateUserById(Long id, UserDto user) {
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " does not exist."));
        if(user.getPassword() != null) {
           userToUpdate.setPassword(user.getPassword());
        }
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());

        return UserMapper.toUserDto(userRepository.save(userToUpdate));
    }

    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        if(userRepository.existsById(id)) {
            return "User not deleted";
        }

        return "Successfully deleted user";
    }
}
