package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.pojo.Food;
import com.food.utility.DBConnection;

public class foodDaoImpl implements foodDao {
	Connection con=DBConnection.getConnection();
	 PreparedStatement ps = null;
	 String sql;
	 int Result;
	 ResultSet rs=null;
	 Food foodobj=null;
	@Override
	public boolean addfood(Food f) {
		
		try {
			sql="insert into food(foodname,foodcategory,foodprice) values(?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, f.getFoodName());
			ps.setString(2, f.getFoodCategory());
			ps.setDouble(3, f.getFoodPrice());
			Result=ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 if(Result>0){
	            return true;
	        }else{
	            return false;
	        }
		
		
		
		 
	}
	public boolean Updatefood(Food f) {
		
		try {
			sql="update food set foodname=?, foodcategory=?, foodprice=? where foodid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, f.getFoodName());
			ps.setString(2, f.getFoodCategory());
			ps.setDouble(3, f.getFoodPrice());
			ps.setInt(4, f.getFoodID());
			Result=ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(Result>0) {
			return true;
		}
		else {
		
		
		
		return false;
		
	}
	}
	@Override
	public boolean deleteFood(int FoodID) {
		
		try {
			sql="delete from food where foodid=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, FoodID);
			Result=ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(Result>0) {
			return true;
		}
		return false;
	}
	@Override
	public List<Food> ShowAllFood() {
		List<Food> foodlist2=new ArrayList<Food>();
		
		try {
			sql="Select * from food";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Food foodobj=new Food();
				foodobj.setFoodID(rs.getInt(1));
				foodobj.setFoodName(rs.getString(2));
				foodobj.setFoodCategory(rs.getString(3));
				foodobj.setFoodPrice(rs.getDouble(4));
				foodlist2.add(foodobj);
				
			}
			return foodlist2;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public Food showFoodByID(int Id) {
		try {
			sql="select * from where foodid=?";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
foodobj.setFoodID(rs.getInt(1));
foodobj.setFoodName(rs.getString(2));
foodobj.setFoodCategory(rs.getString(3));
foodobj.setFoodPrice(rs.getDouble(4));


			}
			return foodobj;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Food> ShowFoodByName(String FoodName) {
		List<Food> Foodlist2=new ArrayList<>();
		try {
			sql="Select * from Food where foodname=?";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Food foodobj=new Food();
				foodobj.setFoodID(rs.getInt(1));
				foodobj.setFoodName(rs.getString(2));
				foodobj.setFoodCategory(rs.getString(3));
				foodobj.setFoodPrice(rs.getDouble(4));
				Foodlist2.add(foodobj);
			}
			
			return Foodlist2;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return null;
	}
}
	
	


