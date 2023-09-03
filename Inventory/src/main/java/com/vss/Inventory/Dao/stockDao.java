package com.vss.Inventory.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vss.Inventory.model.proStock;

public interface stockDao extends JpaRepository<proStock, Integer> {

}
