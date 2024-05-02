package Pizzeria;

import java.awt.EventQueue;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CheckWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCheck;
	private DecimalFormat df = new DecimalFormat("0.00");
	private DecimalFormat dfInt = new DecimalFormat("0");
	public CheckWindow frameCheck;

	/**
	 * Launch the application.
	 */
	public static void checkWindow(PizzaOrderS order){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					CheckWindow frameCheck = new CheckWindow();
					frameCheck.setLocationRelativeTo(null);
					frameCheck.setLocation(frameCheck.getX()+420,frameCheck.getY());
					frameCheck.setUndecorated(true);
					frameCheck.setBackground(new Color(0, 0, 0, 0));
					frameCheck.checkLabel(order);
					frameCheck.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckWindow() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 333, 481);
		contentPane = new JPanel();
		contentPane.setVisible(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setOpaque(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCheck = new JLabel("New label");
		lblCheck.setVerticalAlignment(SwingConstants.TOP);
		lblCheck.setForeground(new Color(87, 44, 0));
		lblCheck.setFont(new Font("Arial", Font.BOLD, 14));
		lblCheck.setBounds(30, 69, 266, 305);
		contentPane.add(lblCheck);
		
		JLabel backgroundLbl = new JLabel("");
		backgroundLbl.setIcon(new ImageIcon(CheckWindow.class.getResource("/Resources/checkBackground.png")));
		backgroundLbl.setBounds(new Rectangle(-17, -22, 308, 440));
		backgroundLbl.setBounds(10, 0, 308, 440);
		contentPane.add(backgroundLbl);
	}
	
	public void checkLabel(PizzaOrderS order) {
		String stuffedCrust="";
		String toppins="";
		String coupon="";
		String shipping="";
		Double crustPrice,saucePrice,pizzaPrice, pizzaPP;
		boolean stuffed=false;
		if(order.getPizza().getDiameter()==33) {
			pizzaPrice=9.0;
		}else if(order.getPizza().getDiameter()==27) {
			pizzaPrice=7.0;
		}else {
			pizzaPrice=5.0;
		}
		pizzaPP=pizzaPrice;
		String[] toppings=order.getPizza().getTopping();
		for (int i=0; i<toppings.length;i++) {
			toppins+="<br>"+toppings[i]+" = 0.20 Eur ";
			pizzaPrice+=0.2;
		}
		if(order.getPizza().getClass()==StuffedCrustPizza.class) {
			stuffedCrust="<br>   -Filling: "+order.getPizza().getFilling();
		}
		if(order.isCoupon()) {
			coupon="<br> 10% off (shipping not covered)";
		}
		if(order.getClass()==PizzaOrderF.class) {
			shipping="<br> Shipping: 2.20 Eur";
		}
		if(order.getPizza().getCrust().equals("Thick")) {
			crustPrice=0.45;
		}else if(order.getPizza().getCrust().equals("Thin")) {
			crustPrice=0.30;
		}else {
			stuffed=true;
			crustPrice=0.60;
		}
		String crust = "<br>"+order.getPizza().getCrust()+" crust: "+df.format(crustPrice)+" Eur\r\n";
		
		if(stuffed) {
			crust+="  - Filling "+order.getPizza().getFilling();
		}
		
		if(order.getPizza().getSauce().equals("Tomato")) {
			saucePrice=0.20;
		}else if(order.getPizza().getSauce().equals("Pesto")) {
			saucePrice=0.20;
		}else {
			saucePrice=0.30;
		}
		String sauce="<br>"+order.getPizza().getSauce()+" sauce: "+df.format(saucePrice)+" Eur\r\n";
		pizzaPrice+=crustPrice;
		pizzaPrice+=saucePrice;
		lblCheck.setText(
				"<html>"
				+ "<br> Date: "+ order.getDate()
				+ "<br> Recipient: "+order.getName()+" "+order.getSurname()
				+ "<br> ---------------------------------"
				+ "<br>Pizza size: "+order.getPizza().getDiameter()+" cm "+df.format(pizzaPP)
				+ toppins
				+ "<br> Sauce: "+order.getPizza().getSauce()+" "+df.format(saucePrice)+" Eur"
				+ "<br> Crust: "+order.getPizza().getCrust()+" "+df.format(crustPrice)+" Eur"
				+ stuffedCrust

				+ "<br> ---------------------------------"
				+ "<br> Pizza price: "+df.format(pizzaPrice)+" Eur  "+dfInt.format(order.getAmount())+"x = "+df.format(pizzaPrice*order.getAmount())+" Eur"
				+ coupon
				+ shipping
				+ "<br> ---------------------------------"
				+ "<br> Total = "+df.format(order.getPrice())+" Eur"
				+ "<br> ---------------------------------"
				+ "<br> Order ID - "+order.getOrderID()
				+ "</html>");

	}
}
