package Pizzeria;

public class Pizza {
		private String dough, sauce, topping;
		private Double diameter;
		private int amount;
		private boolean coupon;
		
		public Pizza(String dough, String sauce, String topping, Double diameter, int amount, boolean coupon) {
			this.dough = dough;
			this.sauce = sauce;
			this.topping = topping;
			this.diameter = diameter;
			this.amount = amount;
			this.coupon = coupon;
	}
		//setter
		public void setDough(String newD) {
			dough=newD;
		}
		public void setSauce(String newS) {
			sauce=newS;
		}
		public void setTopping(String newT) {
			topping=newT;
		}
		public void setDiameter(Double newD) {
			diameter=newD;
		}
		public void setAmount(int newA) {
			amount=newA;
		}
		public void setCoupon(boolean newC) {
			coupon=newC;
		}
		
		//getter
		public String getDough() {
			return dough;
		}
		public String getSauce() {
			return sauce;
		}
		public String getTopping() {
			return topping;
		}
		public Double getDiamater() {
			return diameter;
		}
		public int getAmount() {
			return amount;
		}
		public boolean isCoupon() {
			return coupon;
		}
		
}
