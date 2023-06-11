package in.codingcomets.departmentservice.client;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import in.codingcomets.departmentservice.model.Employee;

@HttpExchange
public interface EmployeeClient {

	@GetExchange("/employee/dept/{deptId}")
	public List<Employee> findByDepartment(@PathVariable Long deptId);
}
