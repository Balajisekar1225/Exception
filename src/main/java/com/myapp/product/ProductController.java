package com.myapp.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/product")
public class ProductController {
	@Autowired
	ProductSerivce proser;
	@PostMapping(value="/add")
	public String addProduct(@RequestBody Product p) {
		return proser.addProduct(p);
	}
	@PostMapping (value="/addList") 
	public String addList(@RequestBody List<Product>p) {
		return proser.addList(p);
	}
	@GetMapping(value="findId/{id}") 
	public Product getid (@PathVariable int id) {
		return proser.getid(id);
	}
	@PutMapping(value="/Update")
	public String getUpdate(@RequestBody Product p) {
		return proser.getUpdate(p);
	}
	@DeleteMapping(value="/delete/{id}")
	public String delete (@PathVariable int id) {
		return proser.delete(id);
	}
	@GetMapping (value ="/getList")
	public List<Product> getProductList() {
		return proser.getProductList();
	}
	

}
