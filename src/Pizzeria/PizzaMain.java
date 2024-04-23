package Pizzeria;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

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
	private JTextField txtPostal;

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
		
		JRadioButton crust1Rdbtn = new JRadioButton("Thick");
		crust1Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		crust1Rdbtn.setBounds(30, 83, 111, 23);
		orderPanel1.add(crust1Rdbtn);
		
		JRadioButton crust2Rdbtn = new JRadioButton("Thin");
		crust2Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		crust2Rdbtn.setBounds(30, 109, 111, 23);
		orderPanel1.add(crust2Rdbtn);
		
		JRadioButton crust3Rdbtn = new JRadioButton("Stuffed");
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
		
		JLabel cheeseLbl = new JLabel("Crust Filling");
		cheeseLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		cheeseLbl.setBounds(213, 43, 116, 33);
		orderPanel1.add(cheeseLbl);
		
		JRadioButton cheese1Rdbtn = new JRadioButton("Cheese");
		cheese1Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		cheese1Rdbtn.setBounds(213, 83, 111, 23);
		orderPanel1.add(cheese1Rdbtn);
		
		JRadioButton cheese2Rdbtn = new JRadioButton("Double-Cheese");
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
						Pizza yummyPizza = new Pizza(crust, sauce, toppingsArray, sizeSlider.getValue());
					}else {
						if(cheese1Rdbtn.isSelected())
							filling="Cheese";
						else
							filling="Double-Cheese";
						
						StuffedCrustPizza yummyPizza = new StuffedCrustPizza(crust, sauce, toppingsArray, sizeSlider.getValue(),filling);
					}
						
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
		
		JLabel yourOrderLbl = new JLabel("Your Order");
		yourOrderLbl.setHorizontalAlignment(SwingConstants.CENTER);
		yourOrderLbl.setFont(new Font("Hot Slice", Font.BOLD, 40));
		yourOrderLbl.setBounds(178, 0, 176, 51);
		orderPanel2.add(yourOrderLbl);
		
		JRadioButton deliverRdbtn1 = new JRadioButton("Ship to Address");
		deliverRdbtn1.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		deliverRdbtn1.setBounds(32, 115, 134, 23);
		orderPanel2.add(deliverRdbtn1);
		
		JRadioButton deliverRdbtn = new JRadioButton("Pick up at Store");
		deliverRdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		deliverRdbtn.setBounds(32, 89, 134, 23);
		orderPanel2.add(deliverRdbtn);
		
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
		ButtonGroup deliverChoice = new ButtonGroup();
		deliverChoice.add(deliverRdbtn);
		deliverChoice.add(deliverRdbtn1);
		
		txtName = new JTextField();
		txtName.setToolTipText("");
		txtName.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		txtName.setBounds(32, 191, 104, 23);
		orderPanel2.add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setToolTipText("");
		txtSurname.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		txtSurname.setColumns(10);
		txtSurname.setBounds(32, 235, 104, 23);
		orderPanel2.add(txtSurname);
		
		textAddress1 = new JTextField();
		textAddress1.setToolTipText("");
		textAddress1.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		textAddress1.setColumns(10);
		textAddress1.setBounds(32, 289, 316, 23);
		orderPanel2.add(textAddress1);
		
		textAddress2 = new JTextField();
		textAddress2.setToolTipText("");
		textAddress2.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		textAddress2.setColumns(10);
		textAddress2.setBounds(32, 334, 316, 23);
		orderPanel2.add(textAddress2);
		
		JLabel lblNameField = new JLabel("Name");
		lblNameField.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblNameField.setBounds(32, 176, 104, 23);
		orderPanel2.add(lblNameField);
		
		JLabel lblSurnameField = new JLabel("Surname");
		lblSurnameField.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblSurnameField.setBounds(32, 220, 104, 23);
		orderPanel2.add(lblSurnameField);
		
		JLabel lblAddrField = new JLabel("Address Line 1");
		lblAddrField.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblAddrField.setBounds(32, 274, 134, 23);
		orderPanel2.add(lblAddrField);
		
		JLabel lblAddressLine = new JLabel("Address Line 2");
		lblAddressLine.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblAddressLine.setBounds(32, 319, 134, 23);
		orderPanel2.add(lblAddressLine);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Save information");
		chckbxNewCheckBox.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		chckbxNewCheckBox.setBounds(211, 415, 143, 23);
		orderPanel2.add(chckbxNewCheckBox);
		
		JButton nextBtn_1 = new JButton("Next");
		nextBtn_1.setFont(new Font("Hot Slice", Font.ITALIC, 30));
		nextBtn_1.setBounds(367, 467, 116, 40);
		orderPanel2.add(nextBtn_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		spinner.setBounds(449, 49, 34, 33);
		orderPanel2.add(spinner);
		
		JLabel amountLbl = new JLabel("(size)  Amount");
		amountLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		amountLbl.setBounds(286, 48, 197, 33);
		orderPanel2.add(amountLbl);
		
		JLabel lblPostalIndex = new JLabel("Postal Index");
		lblPostalIndex.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblPostalIndex.setBounds(32, 368, 104, 23);
		orderPanel2.add(lblPostalIndex);
		
		txtPostal = new JTextField();
		txtPostal.setToolTipText("");
		txtPostal.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		txtPostal.setColumns(10);
		txtPostal.setBounds(32, 383, 91, 23);
		orderPanel2.add(txtPostal);
		
		JLabel totalLbl = new JLabel("<html>\r\n(Size) Pizzas: (amount)x (eur)\r\n<br>Shipping(ifSelected): (eur)\r\n<br>----------\r\n<br>Total: (total)\r\n</html>");
		totalLbl.setHorizontalAlignment(SwingConstants.LEFT);
		totalLbl.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		totalLbl.setBounds(286, 105, 226, 125);
		orderPanel2.add(totalLbl);
		
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
}
