package com.food.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.food.dao.foodDao;
import com.food.dao.foodDaoImpl;
import com.food.pojo.Food;



public class foodtest {
	public static void main(String[] args) {
		
	
	Scanner scan = new Scanner(System.in);
    //Food objects
    int FoodID;
    String FoodName;
    String FoodCategory;
    double FoodPrice;
    int InitialChoice=0;
    boolean flag;
    char FinalChoice;
    int showChoice;
   
    
    
    Food foodobj = new Food();
    
    foodDao fooddaoobj=new foodDaoImpl();
    
    List<Food> foodlist=new ArrayList<Food>();
   
    
    do {
    	 System.out.println("*****Welcome to Food Plaza*****");
         System.out.println("1. Add Food");
         System.out.println("2. Update Food");
         System.out.println("3.Delete Food By Id");
         System.out.println("4.Show All Food");
         System.out.println("5.Show Food By ID");
         System.out.println("Enter Your Choice");
         showChoice=scan.nextInt();
         
         switch(showChoice) {
         case 1:
        	 System.out.println("Enter Food Name");
        	 FoodName=scan.next();
        	 
        	 System.out.println("Enter Food Category");
        	 FoodCategory=scan.next();
        	 
        	 System.out.println("Enter Food Price");
        	 FoodPrice=scan.nextDouble();
        	 
        	 foodobj=new Food(FoodName,FoodCategory,FoodPrice);
        	 flag=fooddaoobj.addfood(foodobj);
        	
        	 
        	 if(flag) {
        		 System.out.println("Added Succfully..");
        	 }
        	 else {
        		 System.out.println("Food Not Added Succefully...");
        	 }
        	 
         case 2:
        	 System.out.println("Enter Food Id to update..");
        	 FoodID=scan.nextInt();
        	 System.out.println("Enter Food Name");
        	 FoodName=scan.next();
        	 
        	 System.out.println("Enter Food Category");
        	 FoodCategory=scan.next();
        	 System.out.println("Enter Food Price");
        	 FoodPrice=scan.nextDouble();
        	 
        	 foodobj=new Food(FoodID,FoodName,FoodCategory,FoodPrice);
        	flag=fooddaoobj.Updatefood(foodobj);
        	 
        	 if(flag) {
        		 System.out.println("Update Succefully...");
        	 }
        	 else {
        		 System.out.println("Not Update Succefully...");
        	 }
        	 break;
        	
        	 
         case 3:
        	 System.out.println("****Delete The Food*********");
        	 
        	 System.out.println("Enter Food Id Which You Want To Delete");
        	 FoodID=scan.nextInt();
        	 
        	 foodobj.setFoodID(FoodID);
        	 flag=fooddaoobj.deleteFood(FoodID);
        	 
        	 if(flag) {
        		 System.out.println("Delete Succefully");
        	 }
        	 else {
        		 System.out.println("Not deleted....");
        	 }
        	 break;
        	 
         case 4:
        	 System.out.println("******Show Food*******");
        	 
        	foodlist=fooddaoobj.ShowAllFood();
        	if(foodlist !=null) {
        		for(Food f1:foodlist) {
        			System.out.println(f1);
        			
        		}
        		System.out.println("succefully...");
        	}
        	else {
        		System.out.println("Not Succefully");
        	}
        	break;
         case 5:
        	 System.out.println("Enter Food ID");
        	 FoodID=scan.nextInt();
        	 
        	 foodobj.setFoodID(FoodID);
        	Food foodobj2=fooddaoobj.showFoodByID(FoodID);
        	 if(foodobj2 !=null) {
                     System.out.println(foodobj2);		 
        	 }
        	 else {
        		 System.out.println("Not present");
        	 }
        	 break;
         case 6:
        	 System.out.println("Enter Food Name");
        	 FoodName=scan.next();
        	 foodobj.setFoodName(FoodName);
        	List<Food> Foodlist2=fooddaoobj.ShowAllFood(); //here flag 
        	
        	if(Foodlist2 !=null) {
        		for(Food f2:Foodlist2) {
        			 System.out.println(f2);
        			
        		}
               		 
   	 }
   	 else {
   		 System.out.println("Not present");
   	 }
        	break;
        	 
        	 
        	 
        	 
        			 
        			 
        	 
         }
         
         
     System.out.print("If you want to continue Enter 'y' or 'Y' to continue: ");
    FinalChoice = scan.next().charAt(0);
}while(FinalChoice =='y'||FinalChoice=='Y');
    
    
	}
}