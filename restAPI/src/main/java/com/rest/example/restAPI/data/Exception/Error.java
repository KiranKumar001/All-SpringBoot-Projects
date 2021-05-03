package com.rest.example.restAPI.data.Exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
@Data - lombok annotation for auto generation of getter(), setter(), toString() methods.
@Builder - Lombok classes for class builders
@NoArgsConstructor - lombok annotation for auto generation of no args constructor
@AllArgsConstructor lombok annotation for auto generation of All arg constructor
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Error {

    private Date timestamp;
    private String message;

}
