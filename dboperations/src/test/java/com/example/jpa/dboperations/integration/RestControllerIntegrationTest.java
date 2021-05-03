package com.example.jpa.dboperations.integration;

import com.example.jpa.dboperations.DboperationsApplicationTests;
import com.example.jpa.dboperations.data.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;


public class RestControllerIntegrationTest extends DboperationsApplicationTests {

    //value from properties file
    @LocalServerPort
    private int port;

    // test client for REST
    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testIntegrationGetAllOperations() throws Exception{

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/v1/getall"),
                HttpMethod.GET, entity, String.class);

        Assertions.assertNotNull(response.getBody());
        Assertions.assertTrue(response.getBody().contains("Joe Root"));
    }

    @Test
    public void testIntegrationPutOperations() {
        int id = 1;
        Employee employee = restTemplate.getForObject(createURLWithPort("/api/v1/get/"+id), Employee.class);
        employee.setFullName("Joe Root");
        employee.setRole("Captain");

        restTemplate.put(createURLWithPort("/api/v1/put/"+id), employee);

        Employee updatedEmployee = restTemplate.getForObject(createURLWithPort("/api/v1/get/"+id), Employee.class);

        Assertions.assertNotNull(updatedEmployee);
        Assertions.assertEquals(updatedEmployee.getId(), 1);
        Assertions.assertEquals(updatedEmployee.getFullName(), "Joe Root");
        Assertions.assertEquals(updatedEmployee.getRole(), "Captain");
    }


    private String createURLWithPort (String uri){

        return "http://localhost:" + port + uri;

    }
}

