package com.vss.Inventory.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vss.Inventory.model.Order;

public interface orderDao extends JpaRepository<Order,Integer> {

}
