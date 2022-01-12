package org.example.employeems.integrationtest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.example.employeems.common.EmployeeTestConstants;
import org.example.employeems.controller.dto.EmployeeVO;
import org.example.employeems.domain.Employee;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.employeems.common.EmployeeTestConstants.FWD_SLASH;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeRestAPIIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    JSONObject employeeCreatedJson ;

    @BeforeEach
    public void setup() throws JSONException, JsonProcessingException {
         employeeCreatedJson = new JSONObject(createEmployeeRecord().getBody().toString());
    }

    @Test
    public void testAddEmployeeRest() throws Exception {
        ResponseEntity response = createEmployeeRecord();
        Assertions.assertThat(response).isNotNull();
        assertThat(response.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
    }

    private ResponseEntity createEmployeeRecord() throws JSONException, JsonProcessingException {
        JSONObject requestBody = new JSONObject("{\r\n    \"address\": \"Gatgarh\",\r\n    \"department\": {\r\n        \"name\": \"Gatgarh\"\r\n    },\r\n    \"fname\": \"authen\",\r\n    \"lname\": \"authorized\",\r\n    \"phones\": [\r\n        {\r\n            \"number\": \"456779\"\r\n        }\r\n    ],\r\n    \"salary\": 101\r\n}");
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeVO employeeVO = objectMapper.readValue(requestBody.toString(),EmployeeVO.class);
        HttpEntity<EmployeeVO> request = new HttpEntity<>(employeeVO);
        ResponseEntity response =  restTemplate.postForEntity(EmployeeTestConstants.HTTP_LOCALHOST + port
                        + EmployeeTestConstants.EMPLOYEE_ENDPOINT, request, Object.class);
        return response;
    }

    @Test
    public void testGetEmployeeByIdRest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employeeCreatedObj = objectMapper.readValue(employeeCreatedJson.toString(),Employee.class);
        ResponseEntity response =  restTemplate.getForEntity(EmployeeTestConstants.HTTP_LOCALHOST + port
                + EmployeeTestConstants.EMPLOYEE_ENDPOINT + FWD_SLASH + employeeCreatedObj.getId(),  Object.class);
        Assertions.assertThat(response).isNotNull();
        assertThat(response.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void testGetAllEmployeeRest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employeeCreatedObj = objectMapper.readValue(employeeCreatedJson.toString(),Employee.class);
        ResponseEntity response =  restTemplate.getForEntity(EmployeeTestConstants.HTTP_LOCALHOST + port
                + EmployeeTestConstants.EMPLOYEE_ENDPOINT,  Object.class);
        Assertions.assertThat(response).isNotNull();
        assertThat(response.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    public void testGetEmployeePhonesRest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employeeCreatedObj = objectMapper.readValue(employeeCreatedJson.toString(),Employee.class);
        ResponseEntity response =  restTemplate.getForEntity(EmployeeTestConstants.HTTP_LOCALHOST + port
                + EmployeeTestConstants.EMPLOYEE_ENDPOINT + FWD_SLASH + "phones",  Object.class);
        Assertions.assertThat(response).isNotNull();
        assertThat(response.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
    }
}
