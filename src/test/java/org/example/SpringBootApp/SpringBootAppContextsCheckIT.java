package org.example.SpringBootApp;

import org.example.SpringBootApp.controller.rest.EmployeeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpringBootAppContextsCheckIT {

	@Autowired
	private EmployeeController employeeController;


	@Test
	void contextLoads() {
		assertThat(employeeController).isNotNull();
	}

}
