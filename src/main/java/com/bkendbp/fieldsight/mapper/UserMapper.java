package com.bkendbp.fieldsight.mapper;

import com.bkendbp.fieldsight.user.model.User;
import com.bkendbp.fieldsight.user.model.UserDto;
import com.bkendbp.fieldsight.auth.config.PasswordConfig;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        if(user == null) {
            return null;
        }
        UserDto UserDto = new UserDto();
        UserDto.setId(user.getId());
        UserDto.setUsername(user.getUsername());
        UserDto.setEmail(user.getEmail());

        return UserDto;

    }
    public static User toUser(UserDto userDto) {

        if(userDto == null) {
            return null;
        }
        User User = new User();
        User.setUsername(userDto.getUsername());
        User.setEmail(userDto.getEmail());
        User.setPassword(PasswordConfig.passwordEncoder(userDto.getPassword()).toString());
        return User;

    }
}
