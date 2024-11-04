package com.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
