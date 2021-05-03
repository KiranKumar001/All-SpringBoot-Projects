package com.rest.example.restAPI.integration;

import com.rest.example.restAPI.RestApiApplicationTests;
import com.rest.example.restAPI.data.Employee;
import com.rest.example.restAPI.data.Employees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;


public class RestControllerIntegrationTest extends RestApiApplicationTests {

    //value from properties file
    @LocalServerPort
    private int port;

    // test client for REST
    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testIntegrationGetAllOperations() throws Exception{

        HttpEntity<Employees> entity = new HttpEntity<>(null, headers);

        ResponseEntity<Employees> response = restTemplate.exchange(
                createURLWithPort("/api/v1/getall"),
                HttpMethod.GET, entity, Employees.class);

        Assertions.assertTrue(response.getStatusCode().equals(HttpStatus.OK));

        Assertions.assertTrue(response.getBody().getEmployees().size()==3);

        Assertions.assertEquals(response.getBody().getEmployees().get(0).getId(), 1);
        Assertions.assertEquals(response.getBody().getEmployees().get(1).getId(), 2);
        Assertions.assertEquals(response.getBody().getEmployees().get(2).getId(), 3);

        Assertions.assertEquals(response.getBody().getEmployees().get(0).getFullName(), "Joe Root");
        Assertions.assertEquals(response.getBody().getEmployees().get(1).getFullName(), "Alester Cook");
        Assertions.assertEquals(response.getBody().getEmployees().get(2).getFullName(), "James Anderson");

        Assertions.assertEquals(response.getBody().getEmployees().get(0).getRole(), "Captain");
        Assertions.assertEquals(response.getBody().getEmployees().get(1).getRole(), "Batsman");
        Assertions.assertEquals(response.getBody().getEmployees().get(2).getRole(), "Bowler");

    }

    @Test
    public void testIntegrationPostOperations() throws Exception {


        HttpEntity<Employee> entity = new HttpEntity<>(Employee.builder().id(1).fullName("Joe Root").role("Captain").build(), headers);

        ResponseEntity<Employee> response = restTemplate.exchange(
                createURLWithPort("/api/v1/post"),
                HttpMethod.POST, entity, Employee.class);

        Assertions.assertTrue(response.getStatusCode().equals(HttpStatus.OK));

        Assertions.assertTrue(response.getBody().getId()==1);
        Assertions.assertTrue(response.getBody().getFullName().equals("Joe Root"));
        Assertions.assertTrue(response.getBody().getRole().equals("Captain"));

    }

    private String createURLWithPort(String uri) {

        return "http://localhost:" + port + uri;

    }
}
