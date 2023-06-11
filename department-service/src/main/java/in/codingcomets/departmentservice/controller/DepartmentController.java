package in.codingcomets.departmentservice.controller;

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

import in.codingcomets.departmentservice.client.EmployeeClient;
import in.codingcomets.departmentservice.model.Department;
import in.codingcomets.departmentservice.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	@Autowired
	private DepartmentRepository repository;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	@GetMapping("/{id}")
	public Department findDepartment(@PathVariable Long id) {
		LOGGER.info("Get department using id = {}", id);
		return repository.findById(id);
	}
	
	@GetMapping
	public List<Department> getDepartments() {
		LOGGER.info("Find all departments!!");
		return repository.findAll();
	}
	
	@PostMapping
	public Department add(@RequestBody Department dept) {
		repository.add(dept);
		return dept;
	}
	
	@GetMapping("/with-employees")
	public List<Department> findAllWithEmployees(){
		List<Department> departments = repository.findAll();
		
		departments.forEach(department->department.setEmployees(employeeClient.findByDepartment(department.getId())));
		departments.forEach(System.out::println);
		return departments;
	}

	
	
}
 