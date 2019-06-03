package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Items  implements Serializable{
  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer itemId;
  private String itemName;
  private Double itemPrice;
  private Integer itemQty;
  public Items() {}
  public Items(Integer itemId, String itemName, Double itemPrice, Integer itemQty) {
	super();
	this.itemId = itemId;
	this.itemName = itemName;
	this.itemPrice = itemPrice;
	this.itemQty = itemQty;
}
public Integer getItemId() {
	return itemId;
}
public void setItemId(Integer itemId) {
	this.itemId = itemId;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public Double getItemPrice() {
	return itemPrice;
}
public void setItemPrice(Double itemPrice) {
	this.itemPrice = itemPrice;
}
public Integer getItemQty() {
	return itemQty;
}
public void setItemQty(Integer itemQty) {
	this.itemQty = itemQty;
}
  
}
