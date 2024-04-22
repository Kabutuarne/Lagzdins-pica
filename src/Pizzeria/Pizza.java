package Pizzeria;

import java.io.Serializable;

public class Pizza implements Serializable {
		/**
	 * 
	 */
		private static final long serialVersionUID = -4275725730997264355L;
		private String dough, sauce, topping;
		private Double diameter;
		private int amount;
		
		public Pizza(String dough, String sauce, String topping, Double diameter, int amount) {
			this.dough = dough;
			this.sauce = sauce;
			this.topping = topping;
			this.diameter = diameter;
			this.amount = amount;
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
		public Double getDiameter() {
			return diameter;
		}
		public int getAmount() {
			return amount;
		}

		
}
