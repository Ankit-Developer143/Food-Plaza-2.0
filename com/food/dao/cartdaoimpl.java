package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.pojo.Cart;
import com.food.utility.DBConnection;

public class cartdaoimpl implements cartdao {
	Connection con=DBConnection.getConnection();
	PreparedStatement ps=null;
	String sql;
	int Result;
	ResultSet rs=null;

	@Override
	public boolean AddToCart(Cart c) {
		try {
			sql="insert into cart(foodid,customeremail,quantity)values(?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1, c.getFoodID());
			ps.setString(2, c.getCustomerEmail());
			ps.setInt(3, c.getQuantity());
			Result=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(Result>0) {
			return true;
		}else {
		
		
		return false;
	}
	}

	@Override
	public boolean UpdateCart(Cart c) {
		try {
			sql="update cart set foodid=?,customeremail=?,quantity=? where cartid=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, c.getFoodID());
			ps.setString(2, c.getCustomerEmail());
			ps.setInt(3, c.getQuantity());
			ps.setInt(4, c.getCartid());
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
	public boolean DeleteFromCartByCartID(int CartID) {
		try {
			sql="delete from cart where cartid=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, CartID);
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
	public boolean DeleteByCustomerEmail(String CustomerEmail) {
		try {
			sql="delete from cart where customeremail=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, CustomerEmail);
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
	public List<Cart> showAllDetails() {
		List<Cart>list2 =new ArrayList<>();
		try {
			sql="select c.cartid,f.foodid,f.foodname,f.foodcategory,f.foodprice, c.customeremail,c.quantity from food f inner join cart c on f.foodid = c.foodid";
					 
			ps=con.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Cart c=new Cart();
				c.setCartid(rs.getInt(1));
				c.setFoodID(rs.getInt(2));
				c.setFoodName(rs.getString(3));
				c.setFoodCategory(rs.getString(4));
				c.setFoodPrice(rs.getDouble(5));
				c.setCustomerEmail(rs.getString(6));
				c.setQuantity(rs.getInt(7));
				list2.add(c);
				
			}
			return list2;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Cart searchfromCartbyCartid(int cartid) {
		try {
			sql="select c.cartid,f.foodid,f.foodname,f.foodcategory,f.foodprice, c.customeremail,c.quantity from food f inner join cart c on f.foodid = c.foodid where cartid =?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, cartid);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Cart c = new Cart();
	                c.setCartid(rs.getInt(1));
	                c.setFoodID(rs.getInt(2));
	                c.setFoodName(rs.getString(3));
	                c.setFoodCategory(rs.getString(4));
	                c.setFoodPrice(rs.getDouble(5));
	                c.setCustomerEmail(rs.getString(6));
	                c.setQuantity(rs.getInt(7));
	                return c;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Cart Searchbycartid(int cartid) {
		Cart c3=new Cart();
		try {
			sql="select * from cart where cartid=?";
			
			ps=con.prepareStatement(sql);
			ps.setInt(1, cartid);
			rs=ps.executeQuery();
			while(rs.next()) {
				c3=new Cart();
			 c3.setCartid(rs.getInt(1));
			 c3.setFoodID(rs.getInt(2));
			 c3.setCustomerEmail(rs.getString(3));
			 c3.setQuantity(rs.getInt(4));
			 
			}
			return c3;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

}
