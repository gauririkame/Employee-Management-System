/*package com.example.Employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;




@RestController
@Slf4j
public class EmployeeController {
	@Autowired

	EmployeeRepository employeeRepository;
	@GetMapping("/test")
	public String testMethod() {
		return "This is test method!";
	}
	@PostMapping("/insert")
	public String insertData(@RequestBody EmployeeEntity  employeeEntity ) {
		employeeRepository.save(employeeEntity);
		return "data save successfully";
		
	}
	@GetMapping("/get")
	public List<EmployeeEntity>getData(){
		log.info("logger is used ");
		log.error("no error");
		employeeRepository.findAll();
		return employeeRepository.findAll();
		
	}
	
	@GetMapping("get/{id}")
	public Optional<EmployeeEntity>getData1(@PathVariable Long id)
	{
	employeeRepository.findById(id);
	return employeeRepository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void DeleteData(@PathVariable Long id) {
		employeeRepository.deleteById(id);
	}
	    
	
	@PutMapping("/update/{id}")
	public EmployeeEntity updateData(@RequestBody EmployeeEntity employeeEntity ) {
		employeeRepository.save(employeeEntity);
		System.out.println("update sucessfully");
		return employeeEntity;
		
	
		
	}
}
*/



package com.example.Employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller // Change from RestController to Controller
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    // Endpoint to show the employee management page
    @GetMapping("/")
    public String showEmployeePage(Model model) {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees); // Add employee list to model
        return "index"; // Return the name of the HTML file (index.html)
    }

    // Test method to verify the server is running
    @GetMapping("/test")
    public String testMethod() {
        return "This is a test method!";
    }

    // Insert employee data via form submission
    @PostMapping("/insert")
    public String insertData(@RequestParam String name, @RequestParam double salary, @RequestParam String department) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(name);
        employeeEntity.setSalary(salary);
        employeeEntity.setDepartment(department);
        
        employeeRepository.save(employeeEntity);
        return "redirect:/"; // Redirect back to the employee list page
    }

    // Retrieve all employee data
    @GetMapping("/get")
    public List<EmployeeEntity> getData() {
        log.info("logger is used");
        log.error("no error");
        return employeeRepository.findAll(); // Return the list of employees
    }

    // Retrieve employee data by ID
    @GetMapping("/get/{id}")
    public Optional<EmployeeEntity> getDataById(@PathVariable Long id) {
        return employeeRepository.findById(id);
    }

    // Delete employee data by ID
    @DeleteMapping("/delete/{id}")
    public void deleteData(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

    // Update employee data
    @PutMapping("/update/{id}")
    public EmployeeEntity updateData(@RequestBody EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
        System.out.println("Update successfully");
        return employeeEntity;
    }
}
