package com.myapp.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;
	public String addEmployee(Employee e) {
		empRepo.save(e);
		return "Successfully Added"+e.toString();
	}
	public Employee getEmployee(int id) {
		
		return empRepo.findById(id).get();
	}
	public String postEmployee(Employee a) {
		empRepo.save(a);
		return "Successfully Added";
	}
	public List<Employee> getEmployee(){
		return empRepo.findAll();
	}
	public String getDelete(int id) {
		 empRepo.deleteById(id);
		 return "Deleted Successfully";
		
		}
	public String getUpdate(Employee e) {
		empRepo.save(e);
		return "Successfully";
	}
	public String getDeleteAll() {
		empRepo.deleteAll();
		return "DeleteAll Successfully";
	}
	public List<Employee> getEmployeeBySalary(int salary) {
		return empRepo.getEmployeeBySalary(salary);
	}
	public List<Employee> getEmployeeByName(String name) {
		return empRepo.getEmployeeByName(name);
	}
	public List<Employee> getMaxEmp() {
		return empRepo.getMaxEmp();
	}

}
