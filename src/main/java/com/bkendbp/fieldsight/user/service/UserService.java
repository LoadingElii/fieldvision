package com.bkendbp.fieldsight.user.service;

import com.bkendbp.fieldsight.exception.EmailAlreadyExistException;
import com.bkendbp.fieldsight.exception.ResourceNotFoundException;
import com.bkendbp.fieldsight.mapper.UserMapper;
import com.bkendbp.fieldsight.user.model.User;
import com.bkendbp.fieldsight.user.model.UserDto;
import com.bkendbp.fieldsight.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDto> getAllUsers() {
        if(userRepository.findAll().isEmpty()) {
            throw new ResourceNotFoundException("No users exist.");
        }
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserDto)
                .toList();
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " does not exist."));
        return userMapper.toUserDto(user);
    }

    public UserDto createUser(UserDto user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistException("User already exist with email: " + user.getEmail() +".");
        }
        User newUser = userMapper.toUser(user);
        System.out.println("Here is the" + user.getPassword());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(newUser);

        return userMapper.toUserDto(newUser);
    }

    public UserDto updateUserById(Long id, UserDto user) {
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " does not exist."));
        if(user.getPassword() != null) {

           userToUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());

        return userMapper.toUserDto(userRepository.save(userToUpdate));
    }

    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        if(userRepository.existsById(id)) {
            return "User not deleted";
        }

        return "Successfully deleted user";
    }
}
