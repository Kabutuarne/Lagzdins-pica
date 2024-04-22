package Pizzeria;

public class PizzaOrder {
	
	String addrLine1, addrLine2, name, surname, phone;
	int orderID;
	boolean coupon;
	
	public PizzaOrder(String addrLine1, String addrLine2, String name, String surname, String phone, int orderID, boolean coupon) {
		this.addrLine1=addrLine1;
		this.addrLine2=addrLine2;
		this.name=name;
		this.surname=surname;
		this.phone=phone;
		this.orderID=orderID;
		this.coupon=coupon;
	}
	//setter
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
