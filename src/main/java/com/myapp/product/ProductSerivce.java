package com.myapp.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSerivce {
	@Autowired
	Productdao prodao;
	public String addProduct(Product p) {
		return prodao.addProduct(p);
	}
	public String addList(List<Product>p) {
		return prodao.addList(p);
	}
	public Product getid (int id) {
		return prodao.getid(id);
	}
	public String getUpdate(Product p) {
		return prodao.getUpdate(p);
	}
	public String delete (int id) {
		return prodao.delete(id);
	}
	public List<Product> getProductList() {
		return prodao.getProductList();
	}
}
