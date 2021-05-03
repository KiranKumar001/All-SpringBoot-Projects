package com.rest.example.restAPI.service;

import com.rest.example.restAPI.data.Employee;
import com.rest.example.restAPI.data.Employees;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
@Service - indicates service component, i.e its a component with buisness logic
 */
@Service
public class EmployeeService {

    public Employees dataSetup() {

        Employee emp1 = Employee.
                builder().
                id(1).
                fullName("Joe Root").
                role("Captain").
                build();

        Employee emp2 = Employee.
                builder().
                id(2).
                fullName("Alester Cook").
                role("Batsman").
                build();

        Employee emp3 = Employee.
                builder().
                id(3).
                fullName("James Anderson").
                role("Bowler").
                build();

        List<Employee> employeesList = Arrays.asList(emp1, emp2, emp3);

        return Employees.builder().employees(employeesList).build();

    }


    public Employees getAllEmployeeDetails() {

        return dataSetup();

    }

    public Employee getEmployee(int id) {

        Employees employees = dataSetup();

        for (Employee employee: employees.getEmployees()) {

            if (employee.getId() == id)

                return employee;
        }

        return null;

    }

    public Employee createEmployee(int id, String fullName, String role) {

        Employee empNew = Employee.builder().id(id).fullName(fullName).role(role).build();

        System.out.println("emp new is: "+empNew);


        Employees.builder().employees(Arrays.asList(empNew)).build();

        return empNew;

    }

    public Employee updateEmployee(int id, String fullName) {

        Employees employees = dataSetup();

        for (Employee employee: employees.getEmployees()) {

            if (employee.getId() == id) {

                employee.setFullName(fullName);

                System.out.println("emp new is: "+employee);

                return employee;

            }

        }

        return null;

    }

    public Employees deleteEmployee(int id) {

        Employees employees = dataSetup();

        List<Employee> empList = new ArrayList<>();

        for (Employee employee : employees.getEmployees()) {

            if (employee.getId() != id) {

                Employee emp = Employee.
                        builder().id(employee.getId()).
                        fullName(employee.getFullName()).
                        role(employee.getRole()).
                        build();

                empList.add(emp);

            }

        }

        return Employees.builder().employees(empList).build();

    }

}
