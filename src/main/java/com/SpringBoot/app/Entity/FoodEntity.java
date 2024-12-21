package com.SpringBoot.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Foods")
public class FoodEntity {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	private String foodName;
	private int foodCost;
	
	
	public FoodEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodEntity(int orderId, String foodName, int foodCost) {
		super();
		this.orderId = orderId;
		this.foodName = foodName;
		this.foodCost = foodCost;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodCost() {
		return foodCost;
	}
	public void setFoodCost(int foodCost) {
		this.foodCost = foodCost;
	}
	@Override
	public String toString() {
		return "FoodEntity [orderId=" + orderId + ", foodName=" + foodName + ", foodCost=" + foodCost + "]";
	}
	
	

}
