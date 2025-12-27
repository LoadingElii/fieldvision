package com.bkendbp.fieldsight.mapper;

import com.bkendbp.fieldsight.user.model.User;
import com.bkendbp.fieldsight.user.model.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {

    public UserDto toUserDto(User user) {
        if(user == null) {
            return null;
        }
        UserDto UserDto = new UserDto();
        UserDto.setId(user.getId());
        UserDto.setUsername(user.getUsername());
        UserDto.setEmail(user.getEmail());

        return UserDto;

    }
    public User toUser(UserDto userDto, PasswordEncoder passwordEncoder) {

        if(userDto == null) {
            return null;
        }
        User User = new User();
        User.setUsername(userDto.getUsername());
        User.setEmail(userDto.getEmail());
        User.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return User;

    }
}
