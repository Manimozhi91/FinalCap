package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.entity.Food;
import com.repository.FoodRepository;
@Service
public class FoodService {
	@Autowired
	FoodRepository foodRespository;
	public List<Food> viewAllFoodDetails() {
		return foodRespository.findAll();
	}

	public Food findFoodInfo(int fid) {
		Optional<Food> op =foodRespository.findById(fid);
		if(op.isPresent()) {
			Food fooditem = op.get();
			return fooditem;
		}else {
			return null;
		}
	}

	public String addFood(Food food) {
		Optional<Food> fd = foodRespository.findById(food.getFid());
		if(fd.isPresent()) {
			return "Food Item details already exists!";
		}else {
			foodRespository.save(food);
			return "Food item details added successfully!";
		}	
	}

	public String updateFood(Food food) {
		Optional<Food> fd = foodRespository.findById(food.getFid());
		if(fd.isPresent()) {
			Food fchange = fd.get();
			fchange.setFid(food.getFid());
			fchange.setFoodname(food.getFoodname());
			fchange.setDescription(food.getDescription());
			fchange.setImage(food.getImage());
			fchange.setPrice(food.getPrice());
			foodRespository.saveAndFlush(fchange);
			return "Food item details updated successfuly!";
			
		}else {
			return "Food item details not found!";
		}
	}

	public String deleteFood(int fid) {
		Optional<Food> food = foodRespository.findById(fid);
		if(food.isPresent()) {
			foodRespository.deleteById(fid);
			return "Food item details deleted successfully!";
			
		}else {
			return "Food item details not found!";
		}
	}
	



}
