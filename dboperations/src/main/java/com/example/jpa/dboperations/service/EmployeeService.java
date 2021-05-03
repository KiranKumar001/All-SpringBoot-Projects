package com.example.jpa.dboperations.service;

import com.example.jpa.dboperations.Exception.ResourceNotFoundException;
import com.example.jpa.dboperations.Repository.EmployeeRepository;
import com.example.jpa.dboperations.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeeDetails() {

        return this.employeeRepository.findAll();
    }

    public ResponseEntity<Employee> getEmployee(int id) throws ResourceNotFoundException{

        Employee employee =  this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id ::" + id));
        return ResponseEntity.ok().body(employee);

    }

    public Employee createEmployee(Employee employee) {

        return this.employeeRepository.save(employee);
    }

    public ResponseEntity<Employee> updateEmployee(int id, Employee employee) throws ResourceNotFoundException{

        Employee emp=  this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id ::" + id));
        emp.setId(employee.getId());
        emp.setFullName(employee.getFullName());
        emp.setRole(employee.getRole());

        return ResponseEntity.ok().body(this.employeeRepository.save(emp));

    }

    public ResponseEntity<Employee> deleteEmployee(int id) throws ResourceNotFoundException {

        Employee employee =  this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id ::" + id));
        this.employeeRepository.delete(employee);
        return ResponseEntity.ok().body(employee);

    }

}
