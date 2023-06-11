package in.codingcomets.employeeservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import in.codingcomets.employeeservice.model.Employee;

@Repository
public class EmployeeRepository {
	
	private List<Employee> employees = new ArrayList<>();
	
	private List<Employee> employees1 = List.of(new Employee(1L, 1L, "Guddu Lahane", 45, "Technical Architect"),
			new Employee(2L, 1L, "Kranti Lahane", 42, "Technical Consultant"),
			new Employee(3L, 2L, "Ishita Lahane", 12, "CEO"));
	
	
	public EmployeeRepository() {
		// TODO Auto-generated constructor stub
		employees.addAll(employees1);
	}
	public Employee add(Employee employee) {
		employees.add(employee);
		return employee;
	}
	
	public Employee findById(Long id) {
		return employees.stream().filter(e->e.id().equals(id)).findFirst().orElseThrow();
	}
	
	public List<Employee> findByDepartment(Long departmentId) {
		return employees.stream().filter(e->e.departmentId().equals(departmentId)).toList();
	}
	
	public List<Employee> findAll(){
		return employees;
	}
}
