package com.food.pojo;

public class Cart {
	private int cartid;

    private int FoodID;
    private String FoodName;
    private String FoodCategory;
    private double FoodPrice;
    private String CustomerEmail;
    private int Quantity;
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", FoodID=" + FoodID + ", FoodName=" + FoodName + ", FoodCategory="
				+ FoodCategory + ", FoodPrice=" + FoodPrice + ", CustomerEmail=" + CustomerEmail + ", Quantity="
				+ Quantity + "]";
	}
	public Cart() {
		super();
	}
	public Cart(int foodID, String customerEmail, int quantity) {
		super();
		FoodID = foodID;
		CustomerEmail = customerEmail;
		Quantity = quantity;
	}
	public Cart(int cartid, int foodID, String customerEmail, int quantity) {
		super();
		this.cartid = cartid;
		FoodID = foodID;
		CustomerEmail = customerEmail;
		Quantity = quantity;
	}
	public Cart(int cartid, int foodID, String foodName, String foodCategory, double foodPrice, String customerEmail,
			int quantity) {
		super();
		this.cartid = cartid;
		FoodID = foodID;
		FoodName = foodName;
		FoodCategory = foodCategory;
		FoodPrice = foodPrice;
		CustomerEmail = customerEmail;
		Quantity = quantity;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getFoodID() {
		return FoodID;
	}
	public void setFoodID(int foodID) {
		FoodID = foodID;
	}
	public String getFoodName() {
		return FoodName;
	}
	public void setFoodName(String foodName) {
		FoodName = foodName;
	}
	public String getFoodCategory() {
		return FoodCategory;
	}
	public void setFoodCategory(String foodCategory) {
		FoodCategory = foodCategory;
	}
	public double getFoodPrice() {
		return FoodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		FoodPrice = foodPrice;
	}
	public String getCustomerEmail() {
		return CustomerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		CustomerEmail = customerEmail;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

}
