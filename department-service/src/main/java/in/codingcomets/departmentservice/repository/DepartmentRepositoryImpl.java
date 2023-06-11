package in.codingcomets.departmentservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import in.codingcomets.departmentservice.model.Department;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository{

	private List<Department> departments=new ArrayList<>();
	/*
	private List<Department> departments1 = List.of(
			new Department(1L, "IT", null),
			new Department(2L, "HR", null));
	*/

	public Department findById(Long id) {
		return departments.stream().filter(dept->dept.getId()==id).findFirst().orElseThrow();
	}
	
	public List<Department> findAll(){
		return departments;
	}
	
	public Department add(Department dept) {
		departments.add(dept);
		return dept;
	}
}
