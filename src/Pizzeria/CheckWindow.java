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
		
		String[] toppings=order.getPizza().getTopping();
		for (int i=0; i<toppings.length;i++) {
			toppins+="<br>"+toppings[i]+" = 0.20 Eur ";
		}
		if(order.getPizza().getClass()==StuffedCrustPizza.class) {
			stuffedCrust="<br>   -Filling: "+order.getPizza().getFilling();
		}
		if(order.isCoupon()) {
			coupon="<br> 10% off";
		}
		if(order.getClass()==PizzaOrderF.class) {
			shipping="<br> Shipping: 2.20 Eur";
		}
		lblCheck.setText(
				"<html>"
				+ "<br> date: "+ order.getDate()
				+ "<br> Recipient: "+order.getName()+" "+order.getSurname()
				+ "<br> ---------------------------------"
				+ "<br>Pizza size: "+order.getPizza().getDiameter()+" cm "
				+ toppins
				+ "<br> Sauce: "+order.getPizza().getSauce()
				+ "<br> Crust: "+order.getPizza().getCrust()
				+ stuffedCrust
				
				+ "<br> ---------------------------------"
				+ "<br> Amount = "+dfInt.format(order.getAmount())
				+ shipping
				+ coupon
				+ "<br> ---------------------------------"
				+ "<br> Total = "+df.format(order.getPrice())+" Eur"
				+ "<br> ---------------------------------"
				+ "<br> Order ID - "+order.getOrderID()
				+ "</html>");

	}
}
