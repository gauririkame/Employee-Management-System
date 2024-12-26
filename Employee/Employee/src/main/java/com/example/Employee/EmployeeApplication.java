package com.example.Employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
		System.out.println("hey this your new project ");
		System.err.println("hello");//print in red color 
		//.loger -info,error,warning
		//thread id,process id ,source id 
	}

}
