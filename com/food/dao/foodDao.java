package com.food.dao;

import java.util.List;

import com.food.pojo.Food;

public interface foodDao {
	boolean addfood(Food f);
boolean Updatefood(Food f);
boolean deleteFood(int FoodID);
List<Food>ShowAllFood();
Food showFoodByID (int Id);
List<Food> ShowFoodByName(String FoodName);
}
