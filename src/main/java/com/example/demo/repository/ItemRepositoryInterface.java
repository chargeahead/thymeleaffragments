package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Items;

@Repository
public interface ItemRepositoryInterface extends CrudRepository<Items,Integer>{
	
	public List<Items> findByItemName(String itemName);
	public List<Items> findByItemNameAndItemPrice(String itemName, Double itemPrice);
	public List<Items> findByItemPriceOrderByItemName(Double itemPrice);

}
