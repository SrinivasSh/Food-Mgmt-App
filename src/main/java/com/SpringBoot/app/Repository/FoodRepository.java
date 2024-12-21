package com.SpringBoot.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.app.Entity.FoodEntity;

public interface FoodRepository extends JpaRepository<FoodEntity, Integer> {
	
	
	//Custom query Methods
	public FoodEntity findByfoodName(String name);
	public FoodEntity findByfoodCost(int cost);
	public List<FoodEntity> findByfoodNameLike(String name);//find the foodName by specific character
	public List<FoodEntity> findByOrderByFoodNameAsc();///sorting of food items by name in ascending order
	public List<FoodEntity> findByOrderByFoodNameDesc();///sorting of food items by name in Descending order
	public List<FoodEntity> findByOrderByFoodCostAsc();///sorting of food items By cost in Ascending order
	public List<FoodEntity> findByOrderByFoodCostDesc();///sorting of food items By cost in Descending order
	}

