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
}
