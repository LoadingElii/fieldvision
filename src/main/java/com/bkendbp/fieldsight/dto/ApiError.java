package com.bkendbp.fieldsight.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
    private int status;
    private String message;

}
