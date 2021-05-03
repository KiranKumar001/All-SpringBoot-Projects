package com.example.jpa.dboperations.unit;

import com.example.jpa.dboperations.DboperationsApplicationTests;
import com.example.jpa.dboperations.controller.RestAPIController;
import com.example.jpa.dboperations.data.Employee;
import com.example.jpa.dboperations.service.EmployeeService;
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

public class RestAPIControllerTest extends DboperationsApplicationTests {

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

        Mockito.when(employeeService.getAllEmployeeDetails()).thenReturn(employeesList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getall")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].fullName", Matchers.is("Joe Root")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].role", Matchers.is("Captain")));

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

        Mockito.when(employeeService.createEmployee(emp1)).thenReturn(emp1);

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

