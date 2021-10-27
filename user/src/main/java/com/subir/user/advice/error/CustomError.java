package com.subir.user.advice.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CustomError {
    private int errorCode;
    private List<String> errorMessages;
    private LocalDateTime localDateTime;

    public CustomError(HttpStatus httpStatus, List<String> errorMessages) {
        this.errorCode = httpStatus.value();
        this.errorMessages = errorMessages;
        this.localDateTime = LocalDateTime.now();
    }
}
