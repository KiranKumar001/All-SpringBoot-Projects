package com.rest.example.restAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Responds with resource not found http code when used
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    //GlobalExceptionHandler picks it and formats
    public ResourceNotFoundException(String message){
        super(message);
    }
}
