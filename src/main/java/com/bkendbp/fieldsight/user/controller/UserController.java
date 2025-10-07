package com.bkendbp.fieldsight.user.controller;

import com.bkendbp.fieldsight.user.model.User;
import com.bkendbp.fieldsight.user.model.UserDto;
import com.bkendbp.fieldsight.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.valueOf(200));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.valueOf(201));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable("id") Long id, @RequestBody UserDto user) {
        return new ResponseEntity<>(userService.updateUserById(id, user), HttpStatus.valueOf(200));

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.deleteUserById(id), HttpStatus.valueOf(200));

    }


}
