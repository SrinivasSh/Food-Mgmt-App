package com.SpringBoot.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.app.Entity.FoodEntity;
import com.SpringBoot.app.Repository.FoodRepository;

@Service
public class FoodService implements IFood {
	
	@Autowired
	private FoodRepository repository;

	@Override
	public FoodEntity createAndSaveFood(FoodEntity receivedFoodData) {
		
		FoodEntity createFood=repository.save(receivedFoodData);
		return createFood;
		
	}

	@Override
	public List<FoodEntity> createAndSaveMultipleFood(List<FoodEntity> receivedMultipleFoodData) {
	  List<FoodEntity> createMultipleFood=repository.saveAll(receivedMultipleFoodData);
	 return createMultipleFood;
	}

	@Override
	public String removeParticularFood(int data) {
		repository.deleteById(data);
		return "Particualar data is deleted succssfully";
	}

	@Override
	public String removeAllFood() {
	  repository.deleteAll();
		return "All Food Data is deleted Successfully";
	}

	@Override
	public long count() {
		long noOfFoodItems=repository.count();
		return noOfFoodItems;
		
	}

	@Override
	public FoodEntity readById(int receivedOrderId) {
	FoodEntity readParticualrFood=repository.findById(receivedOrderId).get();
	return readParticualrFood;
		
	}

	@Override
	public FoodEntity readByName(String receivedFoodName) {
		FoodEntity readParticularFoodByName=repository.findByfoodName(receivedFoodName);
		return readParticularFoodByName;
	}

	@Override
	public FoodEntity readByCost(int receivedFoodCost) {
		FoodEntity readParticularFoodByCost=repository.findByfoodCost(receivedFoodCost);
		return readParticularFoodByCost;
	}
	//Get particualr food item by a specific character
	//-->"%" is used to get the name of the food item
	@Override
	public List<FoodEntity> readByNameLike(String Name) {
		List<FoodEntity> readParticularFoodNameLike=repository.findByfoodNameLike(Name+"%");
		return readParticularFoodNameLike;
	}
	
	///GET THE FOOD NAME IN ASCENDING ORDER
	@Override
	public List<FoodEntity> readByNameAsc() {
	List<FoodEntity> readFoodInAsc=repository.findByOrderByFoodNameAsc();
		return readFoodInAsc;
	}

	@Override
	public List<FoodEntity> readByNameDesc() {
		List<FoodEntity> readFoodInDsc=repository.findByOrderByFoodNameDesc();
		return readFoodInDsc;
	}

	@Override
	public List<FoodEntity> readByFoodCostAsc() {
		List<FoodEntity> readFoodCostInAsc=repository.findByOrderByFoodCostAsc();
		return readFoodCostInAsc;
	}

	@Override
	public List<FoodEntity> readByFoodCostDesc() {
		List<FoodEntity> readFoodCostInDesc=repository.findByOrderByFoodCostDesc();
		return readFoodCostInDesc;
	}
	
	

}
