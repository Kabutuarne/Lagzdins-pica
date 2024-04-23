package Pizzeria;

import java.io.Serializable;

public class Pizza implements Serializable {
		/**
	 * 
	 */
		private static final long serialVersionUID = -4275725730997264355L;
		private String crust, sauce;
		private String topping[];
		private int diameter;
		
		public Pizza(String crust, String sauce, String[] topping, int diameter) {
			this.crust = crust;
			this.sauce = sauce;
			this.topping = topping;
			this.diameter = diameter;
	}
		//setter
		public void setCrust(String newD) {
			crust=newD;
		}
		public void setSauce(String newS) {
			sauce=newS;
		}
		public void setTopping(String[] newT) {
			topping=newT;
		}
		public void setDiameter(int newD) {
			diameter=newD;
		}
		
		
		//getter
		public String getCrust() {
			return crust;
		}
		public String getSauce() {
			return sauce;
		}
		public String[] getTopping() {
			return topping;
		}
		public int getDiameter() {
			return diameter;
		}


		
}
