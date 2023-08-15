package com.myapp.product;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class Productdao {
	@Autowired
	ProductRepository proRepo;
	public String addProduct(Product p) {
		proRepo.save(p);
		return "Successfully added";
		}
	public String addList(List<Product>p) {
		proRepo.saveAll(p);
		return "List Added Successfully";
		}
	public Product getid (int id) {
		return proRepo.findById(id).get();
	}
	public String getUpdate(Product p) {
		proRepo.save(p);
		return "Update Successfully";
	}
	public String delete (int id) {
		proRepo.deleteById(id);
		return "delete Successfully";
	}
	public List<Product> getProductList() {
		return proRepo.findAll();
	}

}
