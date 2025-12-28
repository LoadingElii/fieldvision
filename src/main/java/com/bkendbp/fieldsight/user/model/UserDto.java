package com.bkendbp.fieldsight.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    @NotBlank(message = "Please provide an username.")
    private String username;
    @Email(message = "Please provide an proper email.")
    private String email;
    @Size(message = "Password must contain at least 6 characters.")
    private String password;
}
