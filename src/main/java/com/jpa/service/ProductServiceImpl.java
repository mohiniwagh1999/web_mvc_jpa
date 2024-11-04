package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entity.Product;
import com.jpa.repo.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
	private ProductRepo repo;
	
	@Override
	public boolean saveProduct(Product p) {
		// TODO Auto-generated method stub
		
		Product save = repo.save(p);
		
		return save.getPid()!=null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
