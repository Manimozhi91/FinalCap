package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Food;
@Repository
public interface FoodRepository  extends JpaRepository<Food, Integer>{

}
