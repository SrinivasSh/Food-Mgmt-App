package com.SpringBoot.app.Service;

import java.util.List;
import java.util.Optional;

import com.SpringBoot.app.Entity.FoodEntity;

public interface IFood {
	
	public FoodEntity createAndSaveFood(FoodEntity data);
	public List<FoodEntity> createAndSaveMultipleFood(List<FoodEntity> data);
	public String removeParticularFood(int data);
	public String removeAllFood();
	public long count();
	public FoodEntity readById(int data);
	public FoodEntity readByName(String Name);
	public FoodEntity readByCost(int Cost);
	
	public List<FoodEntity> readByNameLike(String Name);  //finds the food which starts or ends with specific character
	public List<FoodEntity> readByNameAsc();///sorting of food item in ascending order
	public List<FoodEntity> readByNameDesc();///sorting of food item by name in ascending order
	public List<FoodEntity> readByFoodCostAsc();///sorting of food item by cost in ascending order
	public List<FoodEntity> readByFoodCostDesc();///sorting of food item by cost in descending order



}
