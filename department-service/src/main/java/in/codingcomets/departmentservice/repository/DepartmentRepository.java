package in.codingcomets.departmentservice.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import in.codingcomets.departmentservice.model.Department;


public interface DepartmentRepository {
	
	public Department findById(Long id) ;
	public List<Department> findAll() ;
	public Department add(Department dept);
	
}
