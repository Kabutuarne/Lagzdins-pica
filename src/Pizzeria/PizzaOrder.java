package Pizzeria;

import java.io.Serializable;

public class PizzaOrder implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String addrLine1, addrLine2, name, surname, phone;
	Pizza pizza;
	int orderID;
	boolean coupon;
	
	public PizzaOrder(Pizza pizza, String addrLine1, String addrLine2, String name, String surname, String phone, int orderID, boolean coupon) {
		this.addrLine1=addrLine1;
		this.addrLine2=addrLine2;
		this.name=name;
		this.surname=surname;
		this.phone=phone;
		this.orderID=orderID;
		this.coupon=coupon;
		this.pizza=pizza;
	}
	//setter
	public void setPizza(Pizza pizzaN) {
		pizza=pizzaN;
	}
	public void setAddrLine1(String addrLine1N) {
		addrLine1=addrLine1N;
	}
	public void setAddrLine2(String addrLine2N) {
		addrLine2=addrLine2N;
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
	public void setID(int orderIDN) {
		orderID=orderIDN;
	}
	public void setCoupon(boolean couponN) {
		coupon=couponN;
	}
	//getter
	public Pizza getPizza() {
		return pizza;
	}
	public String getAddrLine1() {
		return addrLine1;
	}
	public String getAddrLine2() {
		return addrLine2;
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
	public int getOrderID() {
		return orderID;
	}
}
