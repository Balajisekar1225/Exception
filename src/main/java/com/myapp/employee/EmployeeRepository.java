package com.myapp.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	@Query(value = "select * from employee_details where salary>=?",nativeQuery = true)
	public List<Employee> getEmployeeBySalary(int salary);
	
	@Query(value = "select * from employee_details where name like %?",nativeQuery = true)
	public List<Employee> getEmployeeByName(String name);
	@Query(value = "select * from employee_details where salary = (select max(salary)from employee_details)",nativeQuery = true)
	public List<Employee> getMaxEmp();
	
}
