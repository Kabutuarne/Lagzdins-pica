package Pizzeria;

import java.io.Serializable;

public class PizzaOrderS implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name, surname, phone, orderID, date;
	Pizza pizza;
	int amount;
	boolean coupon;
	Double price;
	
	public PizzaOrderS(Pizza pizza, String name, String surname, String phone,int amount, String orderID, boolean coupon, Double price, String date) {
		this.name=name;
		this.surname=surname;
		this.phone=phone;
		this.orderID=orderID;
		this.coupon=coupon;
		this.pizza=pizza;
		this.amount=amount;
		this.price=price;
		this.date = date;
	}
	//setter
	public void setPrice(Double priceN) {
		price=priceN;
	}
	public void setPizza(Pizza pizzaN) {
		pizza=pizzaN;
	}
	public void setName(String nameN) {
		name=nameN;
	}
	public void setSurname(String surnameN) {
		surname=surnameN;
	}
	public void setPhone(String phoneN) {
		phone=phoneN;
	}
	public void setID(String orderIDN) {
		orderID=orderIDN;
	}
	public void setCoupon(boolean couponN) {
		coupon=couponN;
	}
	public void setAmount(int amountN) {
		amount=amountN;
	}
	//getter
	public Pizza getPizza() {
		return pizza;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getPhone() {
		return phone;
	}
	public boolean isCoupon() {
		return coupon;
	}
	public String getOrderID() {
		return orderID;
	}
	public int getAmount() {
		return amount;
	}
	public Double getPrice() {
		return price;
	}
	public String getDate() {
		return date;
	}
	
}
