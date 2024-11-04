package com.jpa.service;

import java.util.List;

import com.jpa.entity.Product;

public interface ProductService {
	public boolean saveProduct(Product p);
	public List<Product> getAllProducts();

}
