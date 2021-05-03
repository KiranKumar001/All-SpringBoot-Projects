package com.rest.example.restAPI.controller;

import com.rest.example.restAPI.RestApiApplicationTests;
import com.rest.example.restAPI.data.Employee;
import com.rest.example.restAPI.data.Employees;
import com.rest.example.restAPI.service.EmployeeService;

import org.hamcrest.Matchers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

public class RestAPIControllerTest extends RestApiApplicationTests {

    private MockMvc mockMvc;

    // Specifies to create a replica of EmployeeService object
    @Mock
    private EmployeeService employeeService;

    // Specifies to inject the replica employeeService into RestAPIController
    @InjectMocks
    private RestAPIController restAPIController;

    //Runs this setup() method before each test
    @BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(restAPIController)
                .build();
    }

    //Specifies its a Junit5 test
    @Test
    public void testGetAllOperation() throws Exception {

        Employee emp1 = Employee.
                builder().
                id(1).
                fullName("Joe Root").
                role("Captain").
                build();

        List<Employee> employeesList = Arrays.asList(emp1);

        Mockito.when(employeeService.getAllEmployeeDetails()).thenReturn(Employees.builder().employees(employeesList).build());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getall")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.employees[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.employees[0].fullName", Matchers.is("Joe Root")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.employees[0].role", Matchers.is("Captain")));

    }

    @Test
    public void testPostOperation() throws Exception {

        String json = "{\n" +
                "    \"id\": 1,\n" +
                "    \"fullName\": \"Joe Root\",\n" +
                "    \"role\": \"Captain\"\n" +
                "}";

        Employee emp1 = Employee.
                builder().
                id(1).
                fullName("Joe Root").
                role("Captain").
                build();

        List<Employee> employeesList = Arrays.asList(emp1);

        Mockito.when(employeeService.createEmployee(1, "Joe Root", "Captain")).thenReturn(emp1);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.fullName", Matchers.is("Joe Root")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.role", Matchers.is("Captain")));

    }

}
