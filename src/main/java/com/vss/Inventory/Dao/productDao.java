package com.vss.Inventory.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vss.Inventory.model.Product;

public interface productDao extends JpaRepository<Product, Integer> {

	Product findByproductName(String productName);

	

}
