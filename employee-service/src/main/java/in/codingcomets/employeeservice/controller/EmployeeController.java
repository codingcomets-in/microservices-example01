package in.codingcomets.employeeservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codingcomets.employeeservice.model.Employee;
import in.codingcomets.employeeservice.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		LOGGER.info("Find by employee id {}",id);
		return repository.findById(id);
	}
	
	@GetMapping("/all")
	public List<Employee> findAll(){
		LOGGER.info("Find all employees");
		return repository.findAll();
	}
	
	@GetMapping("/dept/{deptId}")
	public List<Employee> findByDepartment(@PathVariable Long deptId){
		LOGGER.info("Find by department id {}",deptId);
		return repository.findByDepartment(deptId);
	}
	
	@PostMapping
	public Employee add(@RequestBody Employee employee) {
		LOGGER.info("Add empployee with name {}",employee.name());
		return repository.add(employee);
	}
}
