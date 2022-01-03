package org.example.SpringBootApp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.example.SpringBootApp.controller.dto.EmployeeVO;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeRestAPIIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    //ignore as not able to mock security server yet
    @Ignore
    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        JSONObject requestBody = new JSONObject("{\r\n    \"address\": \"Gatgarh\",\r\n    \"department\": {\r\n        \"name\": \"Gatgarh\"\r\n    },\r\n    \"fname\": \"authen\",\r\n    \"lname\": \"authorized\",\r\n    \"phones\": [\r\n        {\r\n            \"number\": \"456779\"\r\n        }\r\n    ],\r\n    \"salary\": 101\r\n}");
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeVO employeeVO = objectMapper.readValue(requestBody.toString(),EmployeeVO.class);
        HttpEntity<EmployeeVO> request = new HttpEntity<>(employeeVO);
        ResponseEntity response =  restTemplate.postForEntity(EmployeeTestConstants.HTTP_LOCALHOST + port
                        + EmployeeTestConstants.EMPLOYEE_ENDPOINT, request, ResponseEntity.class);
        Assertions.assertThat(response).isNotNull();
    }
}
