package com.bkendbp.fieldsight.mapper;

import com.bkendbp.fieldsight.user.model.User;
import com.bkendbp.fieldsight.user.model.UserDto;
import org.springframework.stereotype.Component;

@Component
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
    public User toUser(UserDto userDto) {

        if(userDto == null) {
            return null;
        }
        User User = new User();
        User.setUsername(userDto.getUsername());
        User.setEmail(userDto.getEmail());
        return User;

    }
}
