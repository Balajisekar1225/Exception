package com.myapp.employee;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;
	public String addEmployee(Employee e) throws AgeException {
		try {
			if(e.getAge()<18) {
		
			throw new AgeException("Age below 18");
		}else {
			return empDao.addEmployee(e);
		}
	}
		catch (AgeException ae) {
			return "Invalid age";
		}
	}
		//return empDao.addEmployee(e);
	
	public Employee getEmployee( int id) {
		return empDao.getEmployee(id);
	}
	public String postEmployee(Employee a) {
		return empDao.postEmployee(a);
	}
	public List<Employee> getEmployee(){
		return empDao.getEmployee();
	}
	public String getDelete(int id) {
		return empDao.getDelete(id);
	}
	public String getUpdate(Employee e) {
		return empDao.getUpdate(e);
	}
	public String getDeleteAll() {
		return empDao.getDeleteAll();

	}
	public List<Employee> getname(String name) throws NameNotFoundException{
		List<Employee>allemp = empDao.getEmployee();
		List<Employee>emp= allemp.stream().filter(x->x.getName().equalsIgnoreCase(name)).toList();
		if(emp.isEmpty()) {
			throw new NameNotFoundException("Name not found");
		}else {
			return emp;
		}
	}
	public List<Employee> getage(int age) throws AgeNotFoundException  {
		List<Employee>allemp = empDao.getEmployee();
		List<Employee>emp1= allemp.stream().filter(x->x.getAge()==age).collect(Collectors.toList());
		if(emp1.isEmpty()) {
			throw new AgeNotFoundException("Age Not Found");
		}else {
			return emp1;
		}
	}
	public List<Employee> getsalary() {
	List<Employee>allemp = empDao.getEmployee();
	return allemp.stream().map(x->{
	if (x.getAge()>20 && x.getAge()<30) {
		x.setSalary(x.getSalary()+5000);
	}
	if(x.getAge()>30&& x.getAge()<40) {
		x.setSalary(x.getSalary()+6000);
	}
	if(x.getAge()>40 && x.getAge()<50) {
		x.setSalary(x.getSalary()+7000);
	}
	return x;}).toList();
	
	}
	public List<Employee> getGen(String gender) {
		List<Employee>allemp = empDao.getEmployee();
		return allemp.stream().filter(x->x.getGender().equalsIgnoreCase(gender)).toList();
	}
	public List<Employee> getEmployeeBySalary(int salary) {
		return empDao.getEmployeeBySalary(salary);
	}
	public List<Employee> getEmployeeByName(String name) {
		return empDao.getEmployeeByName(name);
	}
    public List<Employee> getMaxEmp() {
    	return  empDao.getMaxEmp();
    }
	
		
}
