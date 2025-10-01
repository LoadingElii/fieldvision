package com.bkendbp.fieldsight.user.service;

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
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toUserDto)
                .toList();
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return UserMapper.toUserDto(user);
    }

    public UserDto createUser(User user) {
        User newUser = userRepository.save(user);

        return UserMapper.toUserDto(newUser);
    }

    public UserDto updateUserById(Long id, UserDto user) {
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        User savedUpdatedUser = userRepository.save(userToUpdate);

        return UserMapper.toUserDto(savedUpdatedUser);
    }

    public String deleteUserById(Long id) {
        userRepository.deleteById(id);
        return "User deleted";
    }
}
