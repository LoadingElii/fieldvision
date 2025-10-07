package com.bkendbp.fieldsight.mapper;

import com.bkendbp.fieldsight.user.model.User;
import com.bkendbp.fieldsight.user.model.UserDto;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        if(user == null) {
            return null;
        }
        UserDto UserDtoFromUser = new UserDto();
        UserDtoFromUser.setId(user.getId());
        UserDtoFromUser.setUsername(user.getUsername());
        UserDtoFromUser.setEmail(user.getEmail());

        return UserDtoFromUser;

    }
    public static User toUser(UserDto userDto) {
        if(userDto == null) {
            return null;
        }
        User UserFromUserDto = new User();
        UserFromUserDto.setUsername(userDto.getUsername());
        UserFromUserDto.setEmail(userDto.getEmail());
        UserFromUserDto.setPassword(userDto.getPassword());

        return UserFromUserDto;

    }
}
