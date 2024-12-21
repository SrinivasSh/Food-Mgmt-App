package com.SpringBoot.app.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.app.Entity.FoodEntity;
import com.SpringBoot.app.Service.FoodService;

@RestController
public class FoodController {
	
	@Autowired
	FoodService service;
	
	//Create one food item
	@PostMapping("/food/create")
	public ResponseEntity<FoodEntity> createFoodItem(@RequestBody FoodEntity foodData) {
		
		FoodEntity receivedFoodOutput=service.createAndSaveFood(foodData);
		return new ResponseEntity<FoodEntity>(receivedFoodOutput,HttpStatus.CREATED);
	}
	
	//Create multiple food items
	@PostMapping("/food/many/create")
	public ResponseEntity<List<FoodEntity>> createMultipleFood(@RequestBody List<FoodEntity> foodData) {
		List<FoodEntity> receivedMultipleFoodOutput=service.createAndSaveMultipleFood(foodData);
		return new ResponseEntity<List<FoodEntity>>(receivedMultipleFoodOutput, HttpStatus.CREATED);
	}
	
	//Delete particular Food item
	@DeleteMapping("/food/particlarFood/{orderId}")
	public ResponseEntity<String> deleleParticularFood(@PathVariable int orderId) {
		String receivedDeletedOutut=service.removeParticularFood(orderId);
		return new ResponseEntity<String>(receivedDeletedOutut,HttpStatus.OK);
	}


	//Delete particular Food item
	@DeleteMapping("/food/allFood")
	public ResponseEntity<String> deleleAllFood() {
		String receivedAllDeletedOutut=service.removeAllFood();
		return new ResponseEntity<String>(receivedAllDeletedOutut,HttpStatus.OK);
	}
	
	//Count the numbers of food items
	@GetMapping("/food/count")
	public long  countFoodItems() {
		long receivedCount=service.count();
		return receivedCount;
	}
	
	@GetMapping("/food/get/{orderId}")
	public ResponseEntity<FoodEntity>  getFoodById(@PathVariable int orderId) {
		FoodEntity receivedFoodById=service.readById(orderId);
		return new ResponseEntity<FoodEntity>(receivedFoodById,HttpStatus.OK);
	}
	
	@GetMapping("/food/getByName/{orderName}")
	public ResponseEntity<FoodEntity>  getFoodByName(@PathVariable String orderName) {
		FoodEntity receivedFoodByName=service.readByName(orderName);
		return new ResponseEntity<FoodEntity>(receivedFoodByName,HttpStatus.OK);
	}
	
	@GetMapping("/food/getByCost/{orderCost}")
	public ResponseEntity<FoodEntity>  getFoodByCost(@PathVariable int orderCost) {
		FoodEntity receivedFoodByCost=service.readByCost(orderCost);
		return new ResponseEntity<FoodEntity>(receivedFoodByCost,HttpStatus.OK);
	}
	
	@GetMapping("/food/getNameLike/{name}")
	public ResponseEntity<List<FoodEntity>>  getFoodNameLike(@PathVariable String name) {
		List<FoodEntity> receivedFoodLike=service.readByNameLike(name);
		return new ResponseEntity<List<FoodEntity>>(receivedFoodLike,HttpStatus.OK);
	}
	
	//GET THE FOOD ITEMS IN ASCENDING ORDER
	@GetMapping("/food/getFoodAsc")
	public ResponseEntity<List<FoodEntity>>  getFoodNamesAsc() {
		List<FoodEntity> receivedFoodAsc=service.readByNameAsc();
		return new ResponseEntity<List<FoodEntity>>(receivedFoodAsc,HttpStatus.OK);
	}
	
	//GET THE FOOD ITEMS IN Descending ORDER
	@GetMapping("/food/getFoodDesc")
	public ResponseEntity<List<FoodEntity>>  getFoodNamesDesc() {
		List<FoodEntity> receivedFoodAsc=service.readByNameDesc();
		return new ResponseEntity<List<FoodEntity>>(receivedFoodAsc,HttpStatus.OK);
		}
		
	//GET THE FOOD ITEMS IN Descending ORDER
	@GetMapping("/food/getFoodCostAsc")
	public ResponseEntity<List<FoodEntity>>  getFoodCostAsc() {
		List<FoodEntity> receivedFoodCostAsc=service.readByFoodCostAsc();
		return new ResponseEntity<List<FoodEntity>>(receivedFoodCostAsc,HttpStatus.OK);
	}
	
	
	//GET THE FOOD ITEMS IN Descending ORDER
	@GetMapping("/food/getFoodCostDesc")
	public ResponseEntity<List<FoodEntity>>  getFoodCostDesc() {
		List<FoodEntity> receivedFoodCostDesc=service.readByFoodCostDesc();
		return new ResponseEntity<List<FoodEntity>>(receivedFoodCostDesc,HttpStatus.OK);
	}
}
