package com.food.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.food.dao.cartdao;
import com.food.dao.cartdaoimpl;
import com.food.pojo.Cart;

public class carttest {
	public static void main(String[] args) {
		
		char FinalChoice;
		int MyChoice;
		int FoodID;
		String CustomerEmail;
		int Quantity;
		boolean flag;
		int cartid;
		
		Cart c=new Cart();
		cartdao cd=new cartdaoimpl();
		
		List<Cart> list1=new ArrayList<Cart>();
		Scanner sc=new Scanner(System.in);
		
		do {
		System.out.println("******Welcome To Food Plaza******");
		System.out.println("1.Add cart");
		System.out.println("2.Update cart");
		System.out.println("3.Delete cart By Id");
		System.out.println("4.Delete cart by CustomerEmail ");
		System.out.println("5.Show All Items In Cart");
		System.out.println("6.Search Cart Item By Cart Id");
		
		System.out.println("Select Your Choice...");
		MyChoice=sc.nextInt();
		
		switch(MyChoice) {
		
		case 1:
			System.out.println("add cart Values..");
			
			System.out.println("Enter Food Id");
			FoodID=sc.nextInt();
			System.out.println("Enter Customer Email");
			CustomerEmail=sc.next();
			System.out.println("Enter Quantity");
			Quantity=sc.nextInt();
			
			c=new Cart(FoodID,CustomerEmail,Quantity);
		
			flag=cd.AddToCart(c);
			if (flag) {
				System.out.println("Added succefully..");
			}
			else {
				System.out.println("Added Not Succefully..");
			}
			break;
		case 2:
			System.out.println("Update cart values..");
			System.out.println("Enter cart id");
			cartid=sc.nextInt();
			
			System.out.println("Enter Food Id");
			FoodID=sc.nextInt();
			
			System.out.println("Enter Customer Email");
			CustomerEmail=sc.next();
			
			
			System.out.println("Enter Quantity");
			Quantity=sc.nextInt();
			
			c=new Cart(cartid,FoodID,CustomerEmail,Quantity);
			flag=cd.UpdateCart(c);
			
			if(flag) {
				System.out.println("Succefully...");
			}
			else {
				System.out.println("Not Succefully..");
			}
			break;
		case 3:
			System.out.println("Delete cart by cart id");
			System.out.println("Enter Cart id");
			cartid=sc.nextInt();
			
			c.setCartid(cartid);
			flag=cd.DeleteFromCartByCartID(cartid);
			
			if(flag) {
				System.out.println("Succefully Deleted.");
			}
			else {
				System.out.println("Not deleted..");
			}
			break;
		case 4:
			System.out.println("Deleted by CustomerEmail");
			System.out.println("Enter Customer Email");
			CustomerEmail=sc.next();
			
			c.setCustomerEmail(CustomerEmail);
			flag=cd.DeleteByCustomerEmail(CustomerEmail);
			if(flag) {
				System.out.println("Deleted Succefully..");
				
			}
			else {
				System.out.println("Not Deleted");
			}
			break;
			
		case 5:
			System.out.println("Show All Items");
			
			List<Cart> list2=cd.showAllDetails();
			if(!list2.isEmpty()) {
				for(Cart c2:list2) {
					System.out.println(c2);
				}
			}else {
				System.out.println("cart Is Empty");
			}
			
			
		case 6:
			System.out.println("Search By Cart Id");
			System.out.println("Enter Cart ID");
			cartid=sc.nextInt();
			
			c.setCartid(cartid);
			Cart c2=cd.searchfromCartbyCartid(cartid);
			if(c2!=null) {
				System.out.println(c2);
			}
			else {
				System.out.println("Not Find");
			}
			break;
		case 7:
			System.out.println("Enter Cart Id");
			cartid=sc.nextInt();
			
			c.setCartid(cartid);
			Cart c3=cd.Searchbycartid(cartid);
			if(c3!=null) {
				System.out.println(c3);
			}
			else {
				System.out.println("Empty");
			}
					
		
		
		}
		
	System.out.println("Do You Want to Continue..if Yess Press'y'or 'Y'");	
		FinalChoice=sc.next().charAt(0);
	}while(FinalChoice=='y'||FinalChoice=='Y');
	}

}
