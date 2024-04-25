package Pizzeria;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PizzaMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane layeredPane;
	private JPanel contentPane;
	private JPanel orderPanel1;
	private JPanel savedInfoPanel;
	private JPanel orderHistoryPanel;
	private JPanel orderPanel2;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField textAddress1;
	private JTextField textAddress2;
	private JTextField txtCoupon;
	private JTextField txtNumber;
	private JLabel totalLbl;
	private JSpinner spinner;
	private JRadioButton deliverRdbtn;
	private JRadioButton deliverRdbtn1;
	private JLabel amountLbl;
	private Pizza yummyPizza;
	private Double total = 0.0;
	private JLabel lblNameField;
	private JLabel lblSurnameField;
	private JLabel lblAddrField;
	private JLabel lblAddrField1;
	private JLabel lblCoupon;
	private JLabel lblNumber;
	private JCheckBox saveInfo;
	private DecimalFormat df = new DecimalFormat("0.00");
	private DecimalFormat dfInt = new DecimalFormat("0");
	private PizzaOrderF bigOrder;
	private JPanel checkoutPanel;
	private JRadioButton cheese1Rdbtn;
	private JRadioButton cheese2Rdbtn;
	private JLabel cheeseLbl;
	private JRadioButton crust3Rdbtn;
	private JRadioButton crust2Rdbtn;
	private JRadioButton crust1Rdbtn;
	private JLabel lblCheck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzaMain frame = new PizzaMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public PizzaMain() {
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 103, 536, 560);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel mainMenuPanel = new JPanel();
		layeredPane.add(mainMenuPanel, "name_4048253251658200");
		mainMenuPanel.setLayout(null);
		
		JButton QuitBtn = new JButton("Quit");
		QuitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		QuitBtn.setFont(new Font("Hot Slice", Font.PLAIN, 30));
		QuitBtn.setBounds(170, 286, 199, 53);
		mainMenuPanel.add(QuitBtn);
		
		JButton OrderBtn = new JButton("New Order");
		OrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(orderPanel1);
			}
		});
		OrderBtn.setFont(new Font("Hot Slice", Font.PLAIN, 30));
		OrderBtn.setBounds(170, 94, 199, 53);
		mainMenuPanel.add(OrderBtn);
		
		JButton OrderHistoryBtn = new JButton("Order History");
		OrderHistoryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(orderHistoryPanel);
			}
		});
		OrderHistoryBtn.setFont(new Font("Hot Slice", Font.PLAIN, 30));
		OrderHistoryBtn.setBounds(170, 158, 199, 53);
		mainMenuPanel.add(OrderHistoryBtn);
		
		JButton SavedInfoBtn = new JButton("Saved Info");
		SavedInfoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(savedInfoPanel);
			}
		});
		SavedInfoBtn.setFont(new Font("Hot Slice", Font.PLAIN, 30));
		SavedInfoBtn.setBounds(170, 222, 199, 53);
		mainMenuPanel.add(SavedInfoBtn);
		
		orderPanel1 = new JPanel();
		orderPanel1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				updateTotal(yummyPizza);
			}
		});
		orderPanel1.setLayout(null);
		layeredPane.add(orderPanel1, "name_4048253304074500");
		
		JLabel toppingLayer3lbl_4 = new JLabel("3");
		toppingLayer3lbl_4.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer3lbl_4.setBounds(428, 375, 40, 40);
		orderPanel1.add(toppingLayer3lbl_4);
		
		JLabel toppingLayer3lbl = new JLabel("3");
		toppingLayer3lbl.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer3lbl.setBounds(335, 269, 40, 40);
		orderPanel1.add(toppingLayer3lbl);
		
		JLabel toppingLayer3lbl_1 = new JLabel("3");
		toppingLayer3lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer3lbl_1.setBounds(250, 341, 40, 40);
		orderPanel1.add(toppingLayer3lbl_1);
		
		JLabel toppingLayer3lbl_2 = new JLabel("3");
		toppingLayer3lbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer3lbl_2.setBounds(402, 314, 40, 40);
		orderPanel1.add(toppingLayer3lbl_2);
		
		JLabel toppingLayer3lbl_3 = new JLabel("3");
		toppingLayer3lbl_3.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer3lbl_3.setBounds(322, 356, 40, 40);
		orderPanel1.add(toppingLayer3lbl_3);
		
		JLabel toppingLayer3lbl_5 = new JLabel("3");
		toppingLayer3lbl_5.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer3lbl_5.setBounds(345, 454, 40, 40);
		orderPanel1.add(toppingLayer3lbl_5);
		
		JLabel toppingLayer1lbl = new JLabel("1");
		toppingLayer1lbl.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer1lbl.setBounds(308, 441, 40, 40);
		orderPanel1.add(toppingLayer1lbl);
		
		JLabel toppingLayer1lbl_1 = new JLabel("1");
		toppingLayer1lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer1lbl_1.setBounds(289, 354, 40, 40);
		orderPanel1.add(toppingLayer1lbl_1);
		
		JLabel toppingLayer1lbl_2 = new JLabel("1");
		toppingLayer1lbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer1lbl_2.setBounds(335, 305, 40, 40);
		orderPanel1.add(toppingLayer1lbl_2);
		
		JLabel toppingLayer1lbl_3 = new JLabel("1");
		toppingLayer1lbl_3.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer1lbl_3.setBounds(402, 354, 40, 40);
		orderPanel1.add(toppingLayer1lbl_3);
		
		JLabel toppingLayer1lbl_4 = new JLabel("1");
		toppingLayer1lbl_4.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer1lbl_4.setBounds(387, 441, 40, 40);
		orderPanel1.add(toppingLayer1lbl_4);
		
		JLabel toppingLayer1lbl_1_1 = new JLabel("1");
		toppingLayer1lbl_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer1lbl_1_1.setBounds(345, 375, 40, 40);
		orderPanel1.add(toppingLayer1lbl_1_1);
		
		JLabel toppingLayer2lbl = new JLabel("2");
		toppingLayer2lbl.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer2lbl.setBounds(345, 341, 40, 40);
		orderPanel1.add(toppingLayer2lbl);
		
		JLabel toppingLayer2lbl_1 = new JLabel("2");
		toppingLayer2lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer2lbl_1.setBounds(308, 390, 40, 40);
		orderPanel1.add(toppingLayer2lbl_1);
		
		JLabel toppingLayer2lbl_2 = new JLabel("2");
		toppingLayer2lbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer2lbl_2.setBounds(372, 395, 40, 40);
		orderPanel1.add(toppingLayer2lbl_2);
		
		JLabel toppingLayer2lbl_3 = new JLabel("2");
		toppingLayer2lbl_3.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer2lbl_3.setBounds(402, 287, 40, 40);
		orderPanel1.add(toppingLayer2lbl_3);
		
		JLabel toppingLayer2lbl_4 = new JLabel("2");
		toppingLayer2lbl_4.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer2lbl_4.setBounds(278, 303, 40, 40);
		orderPanel1.add(toppingLayer2lbl_4);
		
		JLabel toppingLayer2lbl_5 = new JLabel("2");
		toppingLayer2lbl_5.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer2lbl_5.setBounds(263, 405, 40, 40);
		orderPanel1.add(toppingLayer2lbl_5);
		
		JLabel toppingLayer2lbl_6 = new JLabel("2");
		toppingLayer2lbl_6.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer2lbl_6.setBounds(428, 405, 40, 40);
		orderPanel1.add(toppingLayer2lbl_6);
		
		JLabel pizzaLbl = new JLabel("");
		pizzaLbl.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/EmptyPizza.png")));
		pizzaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pizzaLbl.setForeground(new Color(255, 128, 0));
		pizzaLbl.setBorder(BorderFactory.createLineBorder(Color.black));
		pizzaLbl.setBackground(new Color(255, 128, 0));
		pizzaLbl.setBounds(213, 235, 300, 300);
		orderPanel1.add(pizzaLbl);
		
		JLabel yourPizzaLbl = new JLabel("Your Pizza");
		yourPizzaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		yourPizzaLbl.setFont(new Font("Hot Slice", Font.BOLD, 40));
		yourPizzaLbl.setBounds(184, 0, 164, 51);
		orderPanel1.add(yourPizzaLbl);
		
		JLabel crustLbl = new JLabel("Crust Type");
		crustLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		crustLbl.setBounds(30, 43, 116, 33);
		orderPanel1.add(crustLbl);
		
		crust1Rdbtn = new JRadioButton("Thick");
		crust1Rdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cheeseLbl.setVisible(false);
				cheese1Rdbtn.setVisible(false);
				cheese2Rdbtn.setVisible(false);
			}
		});
		crust1Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		crust1Rdbtn.setBounds(30, 83, 111, 23);
		orderPanel1.add(crust1Rdbtn);
		
		crust2Rdbtn = new JRadioButton("Thin");
		crust2Rdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cheeseLbl.setVisible(false);
				cheese1Rdbtn.setVisible(false);
				cheese2Rdbtn.setVisible(false);
			}
		});
		crust2Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		crust2Rdbtn.setBounds(30, 109, 111, 23);
		orderPanel1.add(crust2Rdbtn);
		
		crust3Rdbtn = new JRadioButton("Stuffed");
		crust3Rdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					cheeseLbl.setVisible(true);
					cheese1Rdbtn.setVisible(true);
					cheese2Rdbtn.setVisible(true);
			}
		});
		
		crust3Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		crust3Rdbtn.setBounds(30, 135, 111, 23);
		orderPanel1.add(crust3Rdbtn);
		
		JLabel toppingsChoiceLbl = new JLabel("Toppings");
		toppingsChoiceLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		toppingsChoiceLbl.setBounds(30, 235, 111, 33);
		orderPanel1.add(toppingsChoiceLbl);
		
		JLabel topping1ChoiceLbl = new JLabel("Topping 1");
		topping1ChoiceLbl.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		topping1ChoiceLbl.setBounds(30, 286, 116, 23);
		orderPanel1.add(topping1ChoiceLbl);
		
		JRadioButton topping1 = new JRadioButton("");
		topping1.setBounds(30, 314, 21, 23);
		orderPanel1.add(topping1);
		
		JRadioButton topping1_1 = new JRadioButton("");
		topping1_1.setBounds(69, 314, 21, 23);
		orderPanel1.add(topping1_1);
		
		JRadioButton topping1_2 = new JRadioButton("");
		topping1_2.setBounds(108, 314, 21, 23);
		orderPanel1.add(topping1_2);
		
		JRadioButton topping1_3 = new JRadioButton("");
		topping1_3.setBounds(147, 314, 21, 23);
		orderPanel1.add(topping1_3);
		
		JRadioButton topping2 = new JRadioButton("");
		topping2.setBounds(30, 371, 21, 23);
		orderPanel1.add(topping2);
		
		JLabel topping2ChoiceLbl = new JLabel("Topping 2");
		topping2ChoiceLbl.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		topping2ChoiceLbl.setBounds(30, 343, 116, 23);
		orderPanel1.add(topping2ChoiceLbl);
		
		JRadioButton topping2_1 = new JRadioButton("");
		topping2_1.setBounds(69, 371, 21, 23);
		orderPanel1.add(topping2_1);
		
		JRadioButton topping2_2 = new JRadioButton("");
		topping2_2.setBounds(108, 371, 21, 23);
		orderPanel1.add(topping2_2);
		
		JRadioButton topping2_3 = new JRadioButton("");
		topping2_3.setBounds(147, 371, 21, 23);
		orderPanel1.add(topping2_3);
		
		JRadioButton topping3 = new JRadioButton("");
		topping3.setBounds(30, 434, 21, 23);
		orderPanel1.add(topping3);
		
		JLabel topping3ChoiceLbl = new JLabel("Topping 3");
		topping3ChoiceLbl.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		topping3ChoiceLbl.setBounds(30, 406, 116, 23);
		orderPanel1.add(topping3ChoiceLbl);
		
		JRadioButton topping3_1 = new JRadioButton("");
		topping3_1.setBounds(69, 434, 21, 23);
		orderPanel1.add(topping3_1);
		
		JRadioButton topping3_2 = new JRadioButton("");
		topping3_2.setBounds(108, 434, 21, 23);
		orderPanel1.add(topping3_2);
		
		JRadioButton topping3_3 = new JRadioButton("");
		topping3_3.setBounds(147, 434, 21, 23);
		orderPanel1.add(topping3_3);
		
		JLabel sauceLbl = new JLabel("Sauce Type");
		sauceLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		sauceLbl.setBounds(372, 43, 116, 33);
		orderPanel1.add(sauceLbl);
		
		JRadioButton sauce1Rdbtn = new JRadioButton("Tomato");
		sauce1Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		sauce1Rdbtn.setBounds(372, 83, 111, 23);
		orderPanel1.add(sauce1Rdbtn);
		
		JRadioButton sauce2Rdbtn = new JRadioButton("Pesto");
		sauce2Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		sauce2Rdbtn.setBounds(372, 109, 111, 23);
		orderPanel1.add(sauce2Rdbtn);
		
		JRadioButton sauce3Rdbtn = new JRadioButton("Alfredo");
		sauce3Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		sauce3Rdbtn.setBounds(372, 135, 111, 23);
		orderPanel1.add(sauce3Rdbtn);
		
		cheeseLbl = new JLabel("Crust Filling");
		cheeseLbl.setVisible(false);
		cheeseLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		cheeseLbl.setBounds(213, 43, 116, 33);
		orderPanel1.add(cheeseLbl);
		
		cheese1Rdbtn = new JRadioButton("Cheese");
		cheese1Rdbtn.setVisible(false);
		cheese1Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		cheese1Rdbtn.setBounds(213, 83, 111, 23);
		orderPanel1.add(cheese1Rdbtn);
		
		cheese2Rdbtn = new JRadioButton("Double-Cheese");
		cheese2Rdbtn.setVisible(false);
		cheese2Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		cheese2Rdbtn.setBounds(213, 109, 135, 23);
		orderPanel1.add(cheese2Rdbtn);
		
		ButtonGroup crustChoice = new ButtonGroup();
		crustChoice.add(crust1Rdbtn);
		crustChoice.add(crust2Rdbtn);
		crustChoice.add(crust3Rdbtn);
		
		ButtonGroup cheesesChoice = new ButtonGroup();
		cheesesChoice.add(cheese1Rdbtn);
		cheesesChoice.add(cheese2Rdbtn);
		
		ButtonGroup sauceChoice = new ButtonGroup();
		sauceChoice.add(sauce1Rdbtn);
		sauceChoice.add(sauce2Rdbtn);
		sauceChoice.add(sauce3Rdbtn);
		
		ButtonGroup topping1Choice = new ButtonGroup();
		topping1Choice.add(topping1);
		topping1Choice.add(topping1_1);
		topping1Choice.add(topping1_2);
		topping1Choice.add(topping1_3);
		
		ButtonGroup topping2Choice = new ButtonGroup();
		topping2Choice.add(topping2);
		topping2Choice.add(topping2_1);
		topping2Choice.add(topping2_2);
		topping2Choice.add(topping2_3);
		
		ButtonGroup topping3Choice = new ButtonGroup();
		topping3Choice.add(topping3);
		topping3Choice.add(topping3_1);
		topping3Choice.add(topping3_2);
		topping3Choice.add(topping3_3);
		
		JSlider sizeSlider = new JSlider();
		sizeSlider.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		sizeSlider.setPaintLabels(true);
		sizeSlider.setMajorTickSpacing(6);
		sizeSlider.setPaintTicks(true);
		sizeSlider.setPaintTrack(false);
		sizeSlider.setValue(21);
		sizeSlider.setSnapToTicks(true);
		sizeSlider.setMaximum(33);
		sizeSlider.setMinorTickSpacing(6);
		sizeSlider.setMinimum(21);
		sizeSlider.setBounds(335, 165, 148, 59);
		orderPanel1.add(sizeSlider);
		
		JLabel sizeLbl = new JLabel("Pizza Size");
		sizeLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		sizeLbl.setBounds(213, 191, 116, 33);
		orderPanel1.add(sizeLbl);
		
		
		JButton nextBtn = new JButton("Next");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String crust="",filling="", sauce="", crustFilling="";
				int toppingsAmount=0;
				boolean aintSelected=false, isStuffed=false;
				///////
				if(null==crustChoice.getSelection()) {
					aintSelected=true;
				}else {
					if(crust1Rdbtn.isSelected())
						crust="Thick";
					if(crust2Rdbtn.isSelected())
						crust="Thin";
					if(crust3Rdbtn.isSelected())
						crust="Stuffed";
					if(crust3Rdbtn.isSelected()) 
						isStuffed=true;
					
				}
				/////////
				if(null==sauceChoice.getSelection()) {
					aintSelected=true;
				}else {
					if(sauce1Rdbtn.isSelected())
						crust="Tomato";
					if(sauce2Rdbtn.isSelected())
						crust="Pesto";
					if(sauce3Rdbtn.isSelected())
						crust="Alfredo";
				}
				////////
				String[] toppingsP = new String[3];
				if(null!=topping1Choice.getSelection()) {
					if(topping1.isSelected())
						toppingsP[toppingsAmount]="Cheese";
					if(topping1_1.isSelected())
						toppingsP[toppingsAmount]="Pepperoni";
					if(topping1_2.isSelected())
						toppingsP[toppingsAmount]="Sweet Pepper";
					if(topping1_3.isSelected())
						toppingsP[toppingsAmount]="Champignon";
					toppingsAmount++;
				}
				if(null!=topping2Choice.getSelection()) {
					if(topping2.isSelected())
						toppingsP[toppingsAmount]="Cheese";
					if(topping2_1.isSelected())
						toppingsP[toppingsAmount]="Pepperoni";
					if(topping2_2.isSelected())
						toppingsP[toppingsAmount]="Sweet Pepper";
					if(topping2_3.isSelected())
						toppingsP[toppingsAmount]="Champignon";
					toppingsAmount++;
				}
				if(null!=topping3Choice.getSelection()) {
					if(topping3.isSelected())
						toppingsP[toppingsAmount]="Cheese";
					if(topping3_1.isSelected())
						toppingsP[toppingsAmount]="Pepperoni";
					if(topping3_2.isSelected())
						toppingsP[toppingsAmount]="Sweet Pepper";
					if(topping3_3.isSelected())
						toppingsP[toppingsAmount]="Champignon";
					toppingsAmount++;
				}
				String[] toppingsArray = new String[toppingsAmount];
				for(int i=0;i<toppingsAmount;i++) {
					toppingsArray[i]=toppingsP[i];
				}
				
				
				if(!aintSelected) {
					if(!isStuffed) {
						yummyPizza = new Pizza(crust, sauce, toppingsArray, sizeSlider.getValue());
					}else {
						if(cheese1Rdbtn.isSelected())
							filling="Cheese";
						else
							filling="Double-Cheese";
						
						yummyPizza = new StuffedCrustPizza(crust, sauce, toppingsArray, sizeSlider.getValue(),filling);
					}
						updateTotal(yummyPizza);
					switchPanels(orderPanel2);
				}
			}
		});
		nextBtn.setFont(new Font("Hot Slice", Font.ITALIC, 30));
		nextBtn.setBounds(30, 495, 116, 40);
		orderPanel1.add(nextBtn);
		
		orderPanel2 = new JPanel();
		orderPanel2.setLayout(null);
		layeredPane.add(orderPanel2, "name_4048253355859500");
		
		JLabel errorLbl_5 = new JLabel("");
		errorLbl_5.setForeground(Color.RED);
		errorLbl_5.setFont(new Font("Hot Slice", Font.BOLD, 20));
		errorLbl_5.setBounds(358, 386, 21, 23);
		orderPanel2.add(errorLbl_5);
		
		JLabel errorLbl_1 = new JLabel("");
		errorLbl_1.setForeground(Color.RED);
		errorLbl_1.setFont(new Font("Hot Slice", Font.BOLD, 20));
		errorLbl_1.setBounds(145, 235, 21, 23);
		orderPanel2.add(errorLbl_1);
		
		JLabel errorLbl_2 = new JLabel("");
		errorLbl_2.setForeground(Color.RED);
		errorLbl_2.setFont(new Font("Hot Slice", Font.BOLD, 20));
		errorLbl_2.setBounds(358, 289, 21, 23);
		orderPanel2.add(errorLbl_2);
		
		JLabel errorLbl = new JLabel("");
		errorLbl.setForeground(new Color(255, 0, 0));
		errorLbl.setFont(new Font("Hot Slice", Font.BOLD, 20));
		errorLbl.setBounds(145, 191, 21, 23);
		orderPanel2.add(errorLbl);
		
		JLabel errorLbl_3 = new JLabel("");
		errorLbl_3.setForeground(Color.RED);
		errorLbl_3.setFont(new Font("Hot Slice", Font.BOLD, 20));
		errorLbl_3.setBounds(358, 334, 21, 23);
		orderPanel2.add(errorLbl_3);
		ButtonGroup deliverChoice = new ButtonGroup();
		
		deliverRdbtn1 = new JRadioButton("Ship to Address");
		deliverRdbtn1.setSelected(true);
		deliverRdbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal(yummyPizza);
				errorLbl_2.setVisible(true);
				errorLbl_3.setVisible(true);
				lblAddrField.setVisible(true);
				lblAddrField1.setVisible(true);
				textAddress1.setVisible(true);
				textAddress2.setVisible(true);

			}
		});
		deliverRdbtn1.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		deliverRdbtn1.setBounds(32, 115, 134, 23);
		orderPanel2.add(deliverRdbtn1);
		deliverChoice.add(deliverRdbtn1);
		
		deliverRdbtn = new JRadioButton("Pick up at Store");
		deliverRdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal(yummyPizza);
				errorLbl_2.setVisible(false);
				errorLbl_3.setVisible(false);
				lblAddrField.setVisible(false);
				lblAddrField1.setVisible(false);
				textAddress1.setVisible(false);
				textAddress2.setVisible(false);
			}
		});
		deliverRdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		deliverRdbtn.setBounds(32, 89, 134, 23);
		orderPanel2.add(deliverRdbtn);
		deliverChoice.add(deliverRdbtn);
		
		saveInfo = new JCheckBox("Save information");
		saveInfo.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		saveInfo.setBounds(211, 415, 143, 23);
		orderPanel2.add(saveInfo);
		
		txtName = new JTextField();
		txtName.setToolTipText("");
		txtName.setFont(new Font("Hot Slice", Font.PLAIN, 19));
		txtName.setBounds(32, 191, 104, 23);
		orderPanel2.add(txtName);
		txtName.setColumns(10);
		
		textAddress2 = new JTextField();
		textAddress2.setToolTipText("");
		textAddress2.setFont(new Font("Hot Slice", Font.PLAIN, 19));
		textAddress2.setColumns(10);
		textAddress2.setBounds(32, 334, 316, 23);
		orderPanel2.add(textAddress2);
		
		txtSurname = new JTextField();
		txtSurname.setToolTipText("");
		txtSurname.setFont(new Font("Hot Slice", Font.PLAIN, 19));
		txtSurname.setColumns(10);
		txtSurname.setBounds(32, 235, 104, 23);
		orderPanel2.add(txtSurname);
		
		textAddress1 = new JTextField();
		textAddress1.setToolTipText("");
		textAddress1.setFont(new Font("Hot Slice", Font.PLAIN, 19));
		textAddress1.setColumns(10);
		textAddress1.setBounds(32, 289, 316, 23);
		orderPanel2.add(textAddress1);
		
		txtCoupon = new JTextField();
		txtCoupon.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				updateTotal(yummyPizza);
			}
		});
		
		txtCoupon.setToolTipText("");
		txtCoupon.setFont(new Font("Hot Slice", Font.PLAIN, 19));
		txtCoupon.setColumns(10);
		txtCoupon.setBounds(32, 383, 91, 23);
		orderPanel2.add(txtCoupon);
		
		txtNumber = new JTextField();
		txtNumber.setToolTipText("");
		txtNumber.setFont(new Font("Hot Slice", Font.PLAIN, 19));
		txtNumber.setColumns(10);
		txtNumber.setBounds(170, 385, 178, 23);
		orderPanel2.add(txtNumber);
		
		JLabel yourOrderLbl = new JLabel("Your Order");
		yourOrderLbl.setHorizontalAlignment(SwingConstants.CENTER);
		yourOrderLbl.setFont(new Font("Hot Slice", Font.BOLD, 40));
		yourOrderLbl.setBounds(178, 0, 176, 51);
		orderPanel2.add(yourOrderLbl);
		
		JLabel deliverLbl = new JLabel("Delivery Option");
		deliverLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		deliverLbl.setBounds(32, 49, 151, 33);
		orderPanel2.add(deliverLbl);
		
		orderHistoryPanel = new JPanel();
		orderHistoryPanel.setLayout(null);
		layeredPane.add(orderHistoryPanel, "name_4048253396953400");
		
		savedInfoPanel = new JPanel();
		savedInfoPanel.setLayout(null);
		layeredPane.add(savedInfoPanel, "name_4048253442632400");
		
		lblNameField = new JLabel("Name");
		lblNameField.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblNameField.setBounds(32, 176, 104, 23);
		orderPanel2.add(lblNameField);
		
		lblSurnameField = new JLabel("Surname");
		lblSurnameField.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblSurnameField.setBounds(32, 220, 104, 23);
		orderPanel2.add(lblSurnameField);
		
		lblAddrField = new JLabel("Address Line 1");
		lblAddrField.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblAddrField.setBounds(32, 274, 134, 23);
		orderPanel2.add(lblAddrField);
		
		lblAddrField1 = new JLabel("Address Line 2");
		lblAddrField1.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblAddrField1.setBounds(32, 319, 134, 23);
		orderPanel2.add(lblAddrField1);
		
		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				updateTotal(yummyPizza);
			}
		});
		spinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		spinner.setBounds(358, 50, 34, 33);
		orderPanel2.add(spinner);
		
		amountLbl = new JLabel("Pizza  Amount");
		amountLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		amountLbl.setBounds(211, 48, 272, 33);
		orderPanel2.add(amountLbl);
		
		lblCoupon = new JLabel("Coupon");
		lblCoupon.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblCoupon.setBounds(32, 368, 104, 23);
		orderPanel2.add(lblCoupon);
		
		totalLbl = new JLabel("<html>\r\n(Size) Pizzas: (amount)x (eur)\r\n<br>Shipping(ifSelected): (eur)\r\n<br>----------\r\n<br>Total: (total)\r\n</html>");
		totalLbl.setVerticalAlignment(SwingConstants.TOP);
		totalLbl.setHorizontalAlignment(SwingConstants.LEFT);
		totalLbl.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		totalLbl.setBounds(211, 89, 301, 189);
		orderPanel2.add(totalLbl);
		
		lblNumber = new JLabel("Phone Number");
		lblNumber.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblNumber.setBounds(170, 370, 178, 23);
		orderPanel2.add(lblNumber);
		
		JButton nextBtn_1 = new JButton("Next");
		nextBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean aizpildits = true;
				String name="",surname="",addr1="",addr2="",pnumber="",orderID="";
				boolean coupon=false;
				System.out.print("|"+txtCoupon.getText()+"|");
				if(txtCoupon.getText().isBlank())
					coupon=true;
				if(txtName.getText().isBlank()) {
					aizpildits = false;
					errorLbl.setText("!");
				}else {
					errorLbl.setText("");
					name=txtName.getText();
				}
				if(txtSurname.getText().isBlank()) {
					aizpildits = false;
					errorLbl_1.setText("!");
				}else {
					surname=txtSurname.getText();
					errorLbl_1.setText("");
				}
				if(textAddress1.getText().isBlank()&&deliverRdbtn1.isSelected()) {
					aizpildits = false;
					errorLbl_2.setText("!");
				}else {
					addr1=textAddress1.getText();
					errorLbl_2.setText("");
				}
				if(textAddress2.getText().isBlank()&&deliverRdbtn1.isSelected()) {
					aizpildits = false;
					errorLbl_3.setText("!");
				}else {
					addr2=textAddress2.getText();
					errorLbl_3.setText("");
				}
				if(txtNumber.getText().isBlank()) {//
					aizpildits = false;
					errorLbl_5.setText("!");
				}else {
					pnumber=txtNumber.getText();
					errorLbl_5.setText("");
				}
				Random rng = new Random();
				for(int i=0;i<=6;i++) {
					orderID+=Integer.toString(rng.nextInt(9));
				}
				if(aizpildits && deliverRdbtn1.isSelected()) {
					PizzaOrderF bigOrder = new PizzaOrderF(yummyPizza,addr1, addr2, name, surname, pnumber,((Number) spinner.getValue()).intValue(), orderID, coupon, total);
					switchPanels(checkoutPanel);
					FileFunctions.serializeObject(bigOrder,"orderHistory");
					updateCheck(bigOrder);
				}else if(aizpildits && deliverRdbtn.isSelected()) {
					PizzaOrderS bigOrder = new PizzaOrderS(yummyPizza, name, surname, pnumber,((Number) spinner.getValue()).intValue(), orderID, coupon, total);
					switchPanels(checkoutPanel);
					FileFunctions.serializeObject(bigOrder,"orderHistory");
					updateCheck(bigOrder);
					}
				}
		});
		nextBtn_1.setFont(new Font("Hot Slice", Font.ITALIC, 30));
		nextBtn_1.setBounds(367, 467, 116, 40);
		orderPanel2.add(nextBtn_1);
		
		checkoutPanel = new JPanel();
		layeredPane.add(checkoutPanel, "name_4302718882001700");
		checkoutPanel.setLayout(null);
		
		JLabel yourCheckLbl = new JLabel("Your Check");
		yourCheckLbl.setHorizontalAlignment(SwingConstants.CENTER);
		yourCheckLbl.setFont(new Font("Hot Slice", Font.BOLD, 40));
		yourCheckLbl.setBounds(178, 0, 176, 51);
		checkoutPanel.add(yourCheckLbl);
		
		lblCheck = new JLabel("");
		lblCheck.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		lblCheck.setBounds(88, 62, 368, 399);
		checkoutPanel.add(lblCheck);
		
		JLabel Logo = new JLabel("Martin's Pizza");
		Logo.setHorizontalAlignment(SwingConstants.CENTER);
		Logo.setFont(new Font("Lindra", Font.PLAIN, 50));
		Logo.setBounds(10, 11, 516, 81);
		contentPane.add(Logo);
	}
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	public void updateTotal(Pizza pizza) {
		total=0.0;
		Double pizzaPrice,pizzaToppingsPrice=0.0,shippingPrice=2.20,multiplier,coupon=0.10; //5, 7, 9
		multiplier = ((Number) spinner.getValue()).doubleValue();
		System.out.print(pizza.getDiameter());
		if(pizza.getDiameter()==33) {
			pizzaPrice=9.0;
		}else if(pizza.getDiameter()==27) {
			pizzaPrice=7.0;
		}else {
			pizzaPrice=5.0;
		}
		String toppins="", shipping="<br>Shipping: "+df.format(shippingPrice)+" Eur\r\n", couponTxt="";
		String[] toppings=pizza.getTopping();
		for (int i=0; i<toppings.length;i++) {
			toppins+="<br>"+toppings[i]+" = 0.20 Eur "+dfInt.format(multiplier)+"x = "+df.format(multiplier*0.20)+" Eur\r\n";
			pizzaToppingsPrice+=0.20;
		}
		total=(pizzaToppingsPrice+pizzaPrice)*multiplier;
		if(!txtCoupon.getText().isBlank()) {
			couponTxt="<br>Coupon \""+txtCoupon.getText()+"\" 10% off\r\n";
			total=total-(total*coupon);
		}
		if(!deliverRdbtn1.isSelected())
			totalLbl.setText("<html>\r\n"+pizza.getDiameter()+"cm Pizza: "+(df.format(pizzaPrice))+" Eur "+dfInt.format(multiplier)+"x = "+df.format(multiplier*pizzaPrice)+" Eur"+"\r\n"+toppins+couponTxt+"<br>----------\r\n<br>Total: "+df.format(total)+"\r\n</html>");
		else {
			total+=shippingPrice;
			totalLbl.setText("<html>\r\n"+pizza.getDiameter()+"cm Pizza: "+df.format(pizzaPrice)+" Eur "+dfInt.format(multiplier)+"x = "+df.format(multiplier*pizzaPrice)+" Eur"+"\r\n"+toppins+shipping+couponTxt+"<br>----------\r\n<br>Total: "+df.format(total)+"\r\n</html>");
			}
		}
	public void updateCheck(PizzaOrderS order) {
		String toppins="";
		String[] toppings=order.getPizza().getTopping();
		for (int i=0; i<toppings.length;i++) {
			toppins+="<br>"+toppings[i]+" = 0.20 Eur "+dfInt.format(order.getAmount())+"x = "+df.format(order.getAmount()*0.20)+" Eur\r\n";
			
		}
		lblCheck.setText("<html>"
				+ "<br>"+order.getPizza().getDiameter()+" cm "
				+ "<br>"
				+ "<br>"
				+ "<br>"
				+ "<br>"
				+ "<br>"
				+ "<br>"
				+ "<br> ID - "+order.getOrderID()
				+ "</html>");
	}
}
