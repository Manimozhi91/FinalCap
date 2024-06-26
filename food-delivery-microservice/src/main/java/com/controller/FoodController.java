package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.ws.rs.core.MediaType;

import com.entity.Food;
import com.service.FoodService;

@RestController
@RequestMapping("food")
@CrossOrigin
public class FoodController {
	@Autowired
	FoodService foodService;
	@GetMapping(value="viewmenu")
	public List<Food> viewAllFoodItems(){
		return foodService.viewAllFoodDetails();
	}
	
	@GetMapping(value="findfoodInfo/{fid}")
	public Food findFoodItemById(@PathVariable("fid") int fid) {
		return foodService.findFoodInfo(fid);
	}

	@PostMapping(value="addfood",consumes= MediaType.APPLICATION_JSON)
	public String addFoodItem(@RequestBody Food food) {
		return foodService.addFood(food);
	}
	
	@PatchMapping(value="updatefood",consumes= MediaType.APPLICATION_JSON)
	public String updateFoodItem(@RequestBody Food food) {
		return foodService.updateFood(food);
	}
	
	@DeleteMapping(value="deletefood/{fid}")
	public String deleteFoodItem(@PathVariable int fid) {
		return foodService.deleteFood(fid);
	}
}
