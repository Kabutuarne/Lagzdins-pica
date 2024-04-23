package Pizzeria;

public class StuffedCrustPizza extends Pizza {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7670300346991566332L;
	private String filling;
	
	public StuffedCrustPizza(String crust, String sauce, String[] topping, int diameter, String filling) {
		super(crust, sauce, topping, diameter);
		this.filling = filling;
	}
	public String getFilling() {
		return filling;
	}
	public void setFilling(String nFill) {
		filling=nFill;
	}
	

}
