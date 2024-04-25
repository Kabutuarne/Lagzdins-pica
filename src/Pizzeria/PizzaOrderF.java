package Pizzeria;

public class PizzaOrderF extends PizzaOrderS { // pilns order ar adresi
		/**
	 * 
	 */
	private static final long serialVersionUID = 2271856762748497292L;
	String addrLine1, addrLine2;
	public PizzaOrderF(Pizza pizza, String addrLine1, String addrLine2, String name, String surname, String phone,int amount, String orderID, boolean coupon, Double price) {
		
		super(pizza, name, surname, phone, amount, orderID, coupon, price);
		this.addrLine1=addrLine1;
		this.addrLine2=addrLine2;
	}
	//setteri
	public void setAddrLine1(String addrLine1N) {
		addrLine1=addrLine1N;
	}
	public void setAddrLine2(String addrLine2N) {
		addrLine2=addrLine2N;
	}
	//getteri
	public String getAddrLine1() {
		return addrLine1;
	}
	public String getAddrLine2() {
		return addrLine2;
	}
}
