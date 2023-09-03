package com.vss.Inventory.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vss.Inventory.model.Orderer;

public interface ordererDao extends JpaRepository<Orderer,Integer>{

}
