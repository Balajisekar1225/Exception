package com.myapp.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empSer;
	@PostMapping(value="/add")
	public String addEmployee(@RequestBody Employee e) throws AgeException {
		return empSer.addEmployee(e);
		
	}
	@GetMapping(value="/getvalue/{id}")
	public Employee getEmployee(@PathVariable int id)  {
	return empSer.getEmployee(id);
	}
	@PostMapping(value="/postEmployee")
	public String postEmployee(@RequestBody Employee a)	{
		return empSer.postEmployee(a);
		
	}
	@GetMapping(value="/getList")
	public List<Employee> getEmployee() {
		return empSer.getEmployee();
	}
	@DeleteMapping(value="/delete/{id}") 
	public String getDelete(@PathVariable int id) {
		return empSer.getDelete(id);
		
	}
	@PutMapping(value="/update")
	public String getUpdate(@RequestBody Employee e) {
		return empSer.getUpdate(e);
	}
	@DeleteMapping(value="/deleteAll") 
	public String getDeleteAll() {
		return empSer.getDeleteAll();
	}
	@GetMapping(value="/getName/{name}")
	public List<Employee> getname (@PathVariable String name)throws NameNotFoundException {
		return empSer.getname(name);
	}
	@GetMapping(value="/getage/{age}")
	public List<Employee> getage (@PathVariable int age) throws AgeNotFoundException {
		return empSer.getage(age);
	}
	@PutMapping(value="/getsalaryIncrease") 
	public List<Employee> getsalary() {
		return empSer.getsalary();
	}
	@GetMapping(value="/getG/{gender}")
	public List<Employee> getGen(@PathVariable String gender) {
		return empSer.getGen(gender);
	}
	@GetMapping(value="/getsalary/{salary}")
	public List<Employee> getEmployeeBySalary(@PathVariable int salary) {
		
		return empSer.getEmployeeBySalary(salary);
	}
	@GetMapping(value="/getName1/{name}") 
	public List<Employee> getEmployeeByName(@PathVariable String name) {
		return empSer.getEmployeeByName(name);
	}
	@GetMapping(value="/getMax")
	public List<Employee> getMaxEmp() {
		return empSer.getMaxEmp();
	}
	RestTemplate rest = new RestTemplate();
	@GetMapping(value="/findList") 
	public List<Car>findList() {
		String url = "http://localhost:8081/cars/getdetails";
		ResponseEntity<List<Car>> arr = rest.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<Car>>() {});
		List<Car> val = arr.getBody();	
		return val;
	}
	RestTemplate rest1 = new RestTemplate();
	@GetMapping(value="/findId/{id}") 
	public Car findId(@PathVariable int id) {
		String url = "http://localhost:8081/cars/getvalue/";
		ResponseEntity<Car> arr1 = rest.exchange(url+id, HttpMethod.GET,null,Car.class);
		Car val = arr1.getBody();	
		return val;
	}
	
	
	

}
