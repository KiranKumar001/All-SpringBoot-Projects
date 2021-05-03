package com.rest.example.restAPI.data;

import lombok.*;

/*
@Data - lombok annotation for auto generation of getter(), setter(), toString() methods.
@Builder - Lombok classes for class builders
@NoArgsConstructor - lombok annotation for auto generation of no args constructor
@AllArgsConstructor lombok annotation for auto generation of All arg constructor
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int id;

    private String fullName;

    private String role;


}
