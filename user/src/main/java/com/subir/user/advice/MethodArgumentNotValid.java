package com.subir.user.advice;

import com.subir.user.advice.error.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MethodArgumentNotValid {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<CustomError> handleMethodArgumentError(MethodArgumentNotValidException ex, WebRequest webRequest) {
        List<String> errorList = new ArrayList<>();
        ex.getFieldErrors().forEach((fieldError) -> errorList.add(fieldError.getObjectName()+"."+fieldError.getField()+" : " +fieldError.getDefaultMessage() +" : rejected value [" +fieldError.getRejectedValue() +"]" ));
        ex.getGlobalErrors().forEach((fieldError) -> errorList.add(fieldError.getObjectName()+" : " +fieldError.getDefaultMessage() ));
        CustomError customError = new CustomError(HttpStatus.BAD_REQUEST, errorList);
        return new ResponseEntity<>(customError,HttpStatus.BAD_REQUEST);
    }
}
