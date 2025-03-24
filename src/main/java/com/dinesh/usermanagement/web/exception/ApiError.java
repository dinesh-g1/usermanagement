package com.dinesh.usermanagement.web.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private Integer status;
    private String message;
    private String developerMessage;
}
