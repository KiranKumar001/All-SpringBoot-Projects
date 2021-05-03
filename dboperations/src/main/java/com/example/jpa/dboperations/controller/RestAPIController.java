package com.example.jpa.dboperations.controller;


import com.example.jpa.dboperations.Exception.ResourceNotFoundException;
import com.example.jpa.dboperations.data.Employee;
import com.example.jpa.dboperations.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@Slf4j - lombok annotation for sl4j logging
@RestController - Specifies its a rest controller class
@RequestMapping("/api/v1") - maps the request to the url: http://host:port/api/v1
 */
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class RestAPIController {

    // Wires the employeeService dependency to EmployeeService bean/object.
    @Autowired
    EmployeeService employeeService;

    //Specifies its a GET operation
    @GetMapping("/getall")
    public List<Employee> getAllOperation() {

        log.debug("get all employee details");
        return employeeService.getAllEmployeeDetails();

    }

    // Specifies its a GET operation with a parameter which is mapped as a parameter with @PathVariable(value = "id") int id
    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getOperation(@PathVariable(value = "id") int id) throws ResourceNotFoundException {

        log.debug("get an employee detail");
        return employeeService.getEmployee(id);

    }

    //Specifies its a POST operation with content-type application/json and accepts json as body
    @PostMapping(path = "/post", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee postOperation(@RequestBody Employee emp) {

        log.debug("create an employee");
        return employeeService.createEmployee(emp);

    }

    //Specifies its a PUT operation with content-type application/json and accepts json as body
    @PutMapping(path = "/put/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> putOperation(@PathVariable(value = "id") int id, @RequestBody Employee emp) throws ResourceNotFoundException {

        log.debug("update an employee");
        return employeeService.updateEmployee(id, emp);

    }

    // Specifies its a DELETE operation with a parameter which is mapped as a parameter with @PathVariable(value = "id") int id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteOperation(@PathVariable(value = "id") int id) throws ResourceNotFoundException {

        log.debug("delete an employee");
        return employeeService.deleteEmployee(id);

    }

}

