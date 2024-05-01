package Pizzeria;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class PizzaMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane layeredPane;
	private int selectedI;
	private JPanel contentPane;
	private JPanel orderPanel1;
	private JPanel orderHistoryPanel;
	private JPanel orderPanel2;
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField textAddress1;
	private JTextField textAddress2;
	private JTextField txtCoupon;
	private JFormattedTextField txtNumber;
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
	private JRadioButton cheese1Rdbtn;
	private JRadioButton cheese2Rdbtn;
	private JLabel cheeseLbl;
	private JRadioButton crust3Rdbtn;
	private JRadioButton crust2Rdbtn;
	private JRadioButton crust1Rdbtn;
	private JLabel toppingLayer3lbl;
	private JLabel toppingLayer2lbl_4;
	private JLabel toppingLayer1lbl_2;
	private JLabel toppingLayer2lbl_3;
	private JLabel toppingLayer2lbl;
	private JLabel toppingLayer3lbl_2;
	private JLabel toppingLayer3lbl_3;
	private JLabel toppingLayer1lbl_1;
	private JLabel toppingLayer3lbl_1;
	private JLabel toppingLayer2lbl_5;
	private JLabel toppingLayer2lbl_1;
	private JLabel toppingLayer1lbl;
	private JLabel toppingLayer3lbl_5;
	private JLabel toppingLayer1lbl_4;
	private JLabel toppingLayer2lbl_2;
	private JLabel toppingLayer2lbl_6;
	private JLabel toppingLayer3lbl_4;
	private JLabel toppingLayer1lbl_3;
	private ButtonGroup topping1Choice, topping2Choice, topping3Choice;
	private JLabel lblOrderBackground2;
	private JLabel historyLbl;
	private JLabel backgroundLbl;
	private JButton backBtn_1;
	private ArrayList<PizzaOrderS> orders = new ArrayList<>();
	private DefaultListModel<String> orderModel = new DefaultListModel<>();
	private JList<String> orderJList;
	private JScrollPane scrollPane;
	private JButton btnRemove;
	public PizzaMain frame;
	
	public static void main(String[] args) {
		try {
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		    for (Window window : Window.getWindows()) {
		        SwingUtilities.updateComponentTreeUI(window);
		    }
		} catch (ClassNotFoundException | InstantiationException
		        | IllegalAccessException | UnsupportedLookAndFeelException e) {
		    e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzaMain frame = new PizzaMain();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		}

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
		layeredPane.setBounds(0, 103, 534, 560);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel mainMenuPanel = new JPanel();
		layeredPane.add(mainMenuPanel, "name_4048253251658200");
		mainMenuPanel.setLayout(null);
		
		JButton QuitBtn = new JButton("Quit");
		QuitBtn.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.RED));
		QuitBtn.setBackground(Color.DARK_GRAY);
		QuitBtn.setForeground(Color.RED);
		QuitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		QuitBtn.setFont(new Font("Hot Slice", Font.PLAIN, 30));
		QuitBtn.setBounds(170, 222, 199, 53);
		mainMenuPanel.add(QuitBtn);
		
		JButton OrderBtn = new JButton("New Order");
		OrderBtn.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
		OrderBtn.setBackground(Color.DARK_GRAY);
		OrderBtn.setForeground(Color.ORANGE);
		OrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(orderPanel1);
			}
		});
		OrderBtn.setFont(new Font("Hot Slice", Font.PLAIN, 30));
		OrderBtn.setBounds(170, 94, 199, 53);
		mainMenuPanel.add(OrderBtn);
		
		JButton OrderHistoryBtn = new JButton("Order History");
		OrderHistoryBtn.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
		OrderHistoryBtn.setBackground(Color.DARK_GRAY);
		OrderHistoryBtn.setForeground(Color.ORANGE);
		OrderHistoryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderJList.clearSelection();
				orders = FileFunctions.returnOrders("orderHistory");
				orderModel.clear();
				for(int i=0;i<orders.size();i++) {
					orderModel.addElement((orders.get(i)).getName()+" "+(orders.get(i)).getSurname()+" "+(orders.get(i)).getOrderID());
				}
				if(orderModel.isEmpty()) {
					scrollPane.setVisible(false);
					orderJList.setVisible(false);
					btnRemove.setVisible(false);
					backgroundLbl.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/emptyBackgroundMain.png")));
				}else {
					btnRemove.setVisible(true);
					orderJList.setVisible(true);
					scrollPane.setVisible(true);
					backgroundLbl.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/emptyBackgroundMain1.png")));
					orderJList.setModel(orderModel);
				}
				switchPanels(orderHistoryPanel);
			}
		});
		OrderHistoryBtn.setFont(new Font("Hot Slice", Font.PLAIN, 30));
		OrderHistoryBtn.setBounds(170, 158, 199, 53);
		mainMenuPanel.add(OrderHistoryBtn);
		
		JLabel lblMenuBackground = new JLabel("");
		lblMenuBackground.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/backgroundMain1.png")));
		lblMenuBackground.setBounds(0, 0, 534, 560);
		mainMenuPanel.add(lblMenuBackground);
		
		orderPanel1 = new JPanel();
		orderPanel1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				updateTotal(yummyPizza);
			}
		});
		orderPanel1.setLayout(null);
		layeredPane.add(orderPanel1, "name_4048253304074500");
		
		JButton topping3Rm = new JButton("-");
		topping3Rm.setForeground(Color.ORANGE);
		topping3Rm.setBackground(Color.RED);
		topping3Rm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topping3Choice.clearSelection();
				setTopping3("nothing");
			}
		});
		topping3Rm.setFont(new Font("Hot Slice", Font.ITALIC, 30));
		topping3Rm.setBounds(124, 409, 22, 14);
		orderPanel1.add(topping3Rm);
		
		JButton topping2Rm = new JButton("-");
		topping2Rm.setForeground(Color.ORANGE);
		topping2Rm.setBackground(Color.RED);
		topping2Rm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topping2Choice.clearSelection();
				setTopping2("nothing");
			}
		});
		topping2Rm.setFont(new Font("Hot Slice", Font.ITALIC, 30));
		topping2Rm.setBounds(124, 348, 22, 14);
		orderPanel1.add(topping2Rm);
		
		JButton topping1Rm = new JButton("-");
		topping1Rm.setForeground(Color.ORANGE);
		topping1Rm.setBackground(Color.RED);
		topping1Rm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topping1Choice.clearSelection();
				setTopping1("nothing");
			}
		});
		topping1Rm.setFont(new Font("Hot Slice", Font.ITALIC, 30));
		topping1Rm.setBounds(124, 287, 22, 14);
		orderPanel1.add(topping1Rm);
		
		toppingLayer3lbl_4 = new JLabel("");
		toppingLayer3lbl_4.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer3lbl_4.setBounds(408, 375, 60, 40);
		orderPanel1.add(toppingLayer3lbl_4);
		
		toppingLayer3lbl = new JLabel("");
		toppingLayer3lbl.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer3lbl.setBounds(315, 269, 60, 40);
		orderPanel1.add(toppingLayer3lbl);
		
		toppingLayer3lbl_1 = new JLabel("");
		toppingLayer3lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer3lbl_1.setBounds(230, 341, 60, 40);
		orderPanel1.add(toppingLayer3lbl_1);
		
		toppingLayer3lbl_2 = new JLabel("");
		toppingLayer3lbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer3lbl_2.setBounds(382, 314, 60, 40);
		orderPanel1.add(toppingLayer3lbl_2);
		
		toppingLayer3lbl_3 = new JLabel("");
		toppingLayer3lbl_3.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer3lbl_3.setBounds(302, 356, 60, 40);
		orderPanel1.add(toppingLayer3lbl_3);
		
		toppingLayer3lbl_5 = new JLabel("");
		toppingLayer3lbl_5.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer3lbl_5.setBounds(325, 454, 60, 40);
		orderPanel1.add(toppingLayer3lbl_5);
		
		toppingLayer1lbl = new JLabel("");
		toppingLayer1lbl.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer1lbl.setBounds(288, 441, 60, 40);
		orderPanel1.add(toppingLayer1lbl);
		
		toppingLayer1lbl_1 = new JLabel("");
		toppingLayer1lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer1lbl_1.setBounds(269, 354, 60, 40);
		orderPanel1.add(toppingLayer1lbl_1);
		
		toppingLayer1lbl_2 = new JLabel("");
		toppingLayer1lbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer1lbl_2.setBounds(315, 305, 60, 40);
		orderPanel1.add(toppingLayer1lbl_2);
		
		toppingLayer1lbl_3 = new JLabel("");
		toppingLayer1lbl_3.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer1lbl_3.setBounds(382, 354, 60, 40);
		orderPanel1.add(toppingLayer1lbl_3);
		
		toppingLayer1lbl_4 = new JLabel("");
		toppingLayer1lbl_4.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer1lbl_4.setBounds(367, 441, 60, 40);
		orderPanel1.add(toppingLayer1lbl_4);
		
		JLabel toppingLayer1lbl_1_1 = new JLabel("");
		toppingLayer1lbl_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer1lbl_1_1.setBounds(325, 375, 60, 40);
		orderPanel1.add(toppingLayer1lbl_1_1);
		
		toppingLayer2lbl = new JLabel("");
		toppingLayer2lbl.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer2lbl.setBounds(341, 341, 60, 40);
		orderPanel1.add(toppingLayer2lbl);
		
		toppingLayer2lbl_1 = new JLabel("");
		toppingLayer2lbl_1.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer2lbl_1.setBounds(288, 390, 60, 40);
		orderPanel1.add(toppingLayer2lbl_1);
		
		toppingLayer2lbl_2 = new JLabel("");
		toppingLayer2lbl_2.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer2lbl_2.setBounds(352, 395, 60, 40);
		orderPanel1.add(toppingLayer2lbl_2);
		
		toppingLayer2lbl_3 = new JLabel("");
		toppingLayer2lbl_3.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer2lbl_3.setBounds(382, 287, 60, 40);
		orderPanel1.add(toppingLayer2lbl_3);
		
		toppingLayer2lbl_4 = new JLabel("");
		toppingLayer2lbl_4.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer2lbl_4.setBounds(278, 303, 60, 40);
		orderPanel1.add(toppingLayer2lbl_4);
		
		toppingLayer2lbl_5 = new JLabel("");
		toppingLayer2lbl_5.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer2lbl_5.setBounds(243, 405, 60, 40);
		orderPanel1.add(toppingLayer2lbl_5);
		
		toppingLayer2lbl_6 = new JLabel("");
		toppingLayer2lbl_6.setHorizontalAlignment(SwingConstants.CENTER);
		toppingLayer2lbl_6.setBounds(408, 405, 60, 40);
		orderPanel1.add(toppingLayer2lbl_6);
		
		JLabel pizzaLbl = new JLabel("");
		pizzaLbl.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/EmptyPizza.png")));
		pizzaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pizzaLbl.setForeground(new Color(255, 128, 0));
		pizzaLbl.setBorder(null);
		pizzaLbl.setBackground(new Color(255, 128, 0));
		pizzaLbl.setBounds(213, 235, 300, 300);
		orderPanel1.add(pizzaLbl);
		
		JLabel yourPizzaLbl = new JLabel("Your Pizza");
		yourPizzaLbl.setForeground(Color.WHITE);
		yourPizzaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		yourPizzaLbl.setFont(new Font("Hot Slice", Font.ITALIC, 40));
		yourPizzaLbl.setBounds(184, 0, 164, 51);
		orderPanel1.add(yourPizzaLbl);
		
		JLabel crustLbl = new JLabel("Crust Type");
		crustLbl.setForeground(Color.GRAY);
		crustLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		crustLbl.setBounds(30, 43, 116, 33);
		orderPanel1.add(crustLbl);
		
		crust1Rdbtn = new JRadioButton("Thick");
		crust1Rdbtn.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/checked.png")));
		crust1Rdbtn.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/unchecked.png")));
		crust1Rdbtn.setForeground(Color.LIGHT_GRAY);
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
		crust2Rdbtn.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/checked.png")));
		crust2Rdbtn.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/unchecked.png")));
		crust2Rdbtn.setForeground(Color.LIGHT_GRAY);
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
		crust3Rdbtn.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/checked.png")));
		crust3Rdbtn.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/unchecked.png")));
		crust3Rdbtn.setForeground(Color.LIGHT_GRAY);
		crust3Rdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					cheeseLbl.setVisible(true);
					cheese1Rdbtn.setVisible(true);
					cheese2Rdbtn.setVisible(true);
			}
		});
		crust1Rdbtn.setOpaque(false);
		crust2Rdbtn.setOpaque(false);
		crust3Rdbtn.setOpaque(false);

		crust3Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		crust3Rdbtn.setBounds(30, 135, 111, 23);
		orderPanel1.add(crust3Rdbtn);
		
		JLabel topping1ChoiceLbl = new JLabel("Topping 1");
		topping1ChoiceLbl.setForeground(Color.LIGHT_GRAY);
		topping1ChoiceLbl.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		topping1ChoiceLbl.setBounds(30, 286, 116, 23);
		orderPanel1.add(topping1ChoiceLbl);
		
		JRadioButton topping1 = new JRadioButton("");
		topping1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTopping1("cheese");
			}
		});
		
		JLabel toppingsChoiceLbl = new JLabel("Toppings");
		toppingsChoiceLbl.setForeground(Color.GRAY);
		toppingsChoiceLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		toppingsChoiceLbl.setBounds(30, 235, 148, 33);
		orderPanel1.add(toppingsChoiceLbl);
		topping1.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/cheeseS.png")));
		topping1.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/cheese.png")));
		topping1.setBounds(21, 305, 40, 40);
		orderPanel1.add(topping1);
		
		JRadioButton topping1_1 = new JRadioButton("");
		topping1_1.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/pepperoniS.png")));
		topping1_1.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/pepperoni.png")));
		topping1_1.setIconTextGap(0);
		topping1_1.setHideActionText(true);
		topping1_1.setOpaque(false);
		topping1_1.setBounds(60, 305, 40, 40);
		topping1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTopping1("pepperoni");
			}
		});
		orderPanel1.add(topping1_1);
		
		JRadioButton topping1_2 = new JRadioButton("");
		topping1_2.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/sweetPepperS.png")));
		topping1_2.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/sweetPepper.png")));
		topping1_2.setBounds(99, 305, 40, 40);
		topping1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTopping1("sweetPepper");
			}
		});
		orderPanel1.add(topping1_2);
		
		JRadioButton topping1_3 = new JRadioButton("");
		topping1_3.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/champignonS.png")));
		topping1_3.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/champignon.png")));
		topping1_3.setBounds(138, 305, 40, 40);
		topping1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTopping1("champignon");
			}
		});
		orderPanel1.add(topping1_3);
		
		JRadioButton topping2 = new JRadioButton("");
		topping2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		topping2.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/cheese.png")));
		topping2.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/cheeseS.png")));
		topping2.setBounds(21, 363, 40, 40);
		topping2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTopping2("cheese");
			}
		});
		orderPanel1.add(topping2);
		
		JLabel topping2ChoiceLbl = new JLabel("Topping 2");
		topping2ChoiceLbl.setForeground(Color.LIGHT_GRAY);
		topping2ChoiceLbl.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		topping2ChoiceLbl.setBounds(30, 343, 116, 23);
		orderPanel1.add(topping2ChoiceLbl);
		
		JRadioButton topping2_1 = new JRadioButton("");
		topping2_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		topping2_1.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/pepperoni.png")));
		topping2_1.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/pepperoniS.png")));
		topping2_1.setBounds(60, 363, 40, 40);
		topping2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTopping2("pepperoni");
			}
		});
		orderPanel1.add(topping2_1);
		
		JRadioButton topping2_2 = new JRadioButton("");
		topping2_2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		topping2_2.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/sweetPepper.png")));
		topping2_2.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/sweetPepperS.png")));
		topping2_2.setBounds(99, 363, 40, 40);
		topping2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTopping2("sweetPepper");
			}
		});
		orderPanel1.add(topping2_2);
		
		JRadioButton topping2_3 = new JRadioButton("");
		topping2_3.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		topping2_3.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/champignon.png")));
		topping2_3.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/champignonS.png")));
		topping2_3.setBounds(138, 363, 40, 40);
		orderPanel1.add(topping2_3);
		topping2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTopping2("champignon");
			}
		});
		
		JRadioButton topping3 = new JRadioButton("");
		topping3.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/cheese.png")));
		topping3.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/cheeseS.png")));
		topping3.setBounds(21, 427, 40, 40);
		orderPanel1.add(topping3);
		topping3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTopping3("cheese");
			}
		});
		JLabel topping3ChoiceLbl = new JLabel("Topping 3");
		topping3ChoiceLbl.setForeground(Color.LIGHT_GRAY);
		topping3ChoiceLbl.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		topping3ChoiceLbl.setBounds(30, 406, 116, 23);
		orderPanel1.add(topping3ChoiceLbl);
		
		JRadioButton topping3_1 = new JRadioButton("");
		topping3_1.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/pepperoni.png")));
		topping3_1.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/pepperoniS.png")));
		topping3_1.setBounds(60, 427, 40, 40);
		topping3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTopping3("pepperoni");
			}
		});
		orderPanel1.add(topping3_1);
		
		JRadioButton topping3_2 = new JRadioButton("");
		topping3_2.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/sweetPepper.png")));
		topping3_2.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/sweetPepperS.png")));
		topping3_2.setBounds(99, 427, 40, 40);
		topping3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTopping3("sweetPepper");
			}
		});
		orderPanel1.add(topping3_2);
		
		JRadioButton topping3_3 = new JRadioButton("");
		topping3_3.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/champignon.png")));
		topping3_3.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/champignonS.png")));
		topping3_3.setBounds(138, 427, 40, 40);
		topping3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTopping3("champignon");
			}
		});
		orderPanel1.add(topping3_3);
		topping1.setOpaque(false);
		topping1_2.setOpaque(false);
		topping1_3.setOpaque(false);
		
		topping2.setOpaque(false);
		topping2_1.setOpaque(false);
		topping2_2.setOpaque(false);
		topping2_3.setOpaque(false);
		
		topping3.setOpaque(false);
		topping3_1.setOpaque(false);
		topping3_2.setOpaque(false);
		topping3_3.setOpaque(false);
		
		JLabel sauceLbl = new JLabel("Sauce Type");
		sauceLbl.setForeground(Color.GRAY);
		sauceLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		sauceLbl.setBounds(372, 43, 116, 33);
		orderPanel1.add(sauceLbl);
		
		JRadioButton sauce1Rdbtn = new JRadioButton("Tomato");
		sauce1Rdbtn.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/checked.png")));
		sauce1Rdbtn.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/unchecked.png")));
		sauce1Rdbtn.setForeground(Color.LIGHT_GRAY);
		sauce1Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		sauce1Rdbtn.setBounds(372, 83, 111, 23);
		orderPanel1.add(sauce1Rdbtn);
		
		JRadioButton sauce2Rdbtn = new JRadioButton("Pesto");
		sauce2Rdbtn.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/checked.png")));
		sauce2Rdbtn.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/unchecked.png")));
		sauce2Rdbtn.setForeground(Color.LIGHT_GRAY);
		sauce2Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		sauce2Rdbtn.setBounds(372, 109, 111, 23);
		orderPanel1.add(sauce2Rdbtn);
		
		JRadioButton sauce3Rdbtn = new JRadioButton("Alfredo");
		sauce3Rdbtn.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/checked.png")));
		sauce3Rdbtn.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/unchecked.png")));
		sauce3Rdbtn.setForeground(Color.LIGHT_GRAY);
		sauce3Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		sauce3Rdbtn.setBounds(372, 135, 111, 23);
		orderPanel1.add(sauce3Rdbtn);
		sauce1Rdbtn.setOpaque(false);
		sauce2Rdbtn.setOpaque(false);
		sauce3Rdbtn.setOpaque(false);
		cheeseLbl = new JLabel("Crust Filling");
		cheeseLbl.setForeground(Color.WHITE);
		cheeseLbl.setVisible(false);
		cheeseLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		cheeseLbl.setBounds(213, 43, 116, 33);
		orderPanel1.add(cheeseLbl);
		
		cheese1Rdbtn = new JRadioButton("Cheese");
		cheese1Rdbtn.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/checked.png")));
		cheese1Rdbtn.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/unchecked.png")));
		cheese1Rdbtn.setForeground(Color.LIGHT_GRAY);
		cheese1Rdbtn.setVisible(false);
		cheese1Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		cheese1Rdbtn.setBounds(213, 83, 111, 23);
		orderPanel1.add(cheese1Rdbtn);
		
		cheese2Rdbtn = new JRadioButton("Double-Cheese");
		cheese2Rdbtn.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/checked.png")));
		cheese2Rdbtn.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/unchecked.png")));
		cheese2Rdbtn.setForeground(Color.LIGHT_GRAY);
		cheese2Rdbtn.setVisible(false);
		cheese2Rdbtn.setFont(new Font("Hot Slice", Font.PLAIN, 18));
		cheese2Rdbtn.setBounds(213, 109, 149, 23);
		orderPanel1.add(cheese2Rdbtn);
		cheese1Rdbtn.setOpaque(false);
		cheese2Rdbtn.setOpaque(false);
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
		
		 topping1Choice = new ButtonGroup();
		topping1Choice.add(topping1);
		topping1Choice.add(topping1_1);
		topping1Choice.add(topping1_2);
		topping1Choice.add(topping1_3);
		
		 topping2Choice = new ButtonGroup();
		topping2Choice.add(topping2);
		topping2Choice.add(topping2_1);
		topping2Choice.add(topping2_2);
		topping2Choice.add(topping2_3);
		
		 topping3Choice = new ButtonGroup();
		topping3Choice.add(topping3);
		topping3Choice.add(topping3_1);
		topping3Choice.add(topping3_2);
		topping3Choice.add(topping3_3);
		
		JSlider sizeSlider = new JSlider();
		sizeSlider.setOpaque(false);
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
		sizeLbl.setForeground(Color.GRAY);
		sizeLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		sizeLbl.setBounds(213, 191, 116, 33);
		orderPanel1.add(sizeLbl);
		
		
		JButton nextBtn = new JButton("Next");
		nextBtn.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
		nextBtn.setForeground(Color.ORANGE);
		nextBtn.setBackground(Color.DARK_GRAY);
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
					if(crust3Rdbtn.isSelected()) {
						crust="Stuffed";
						isStuffed=true;
						if(cheesesChoice.getSelection()==null)
							aintSelected=true;
					}
				}
				/////////
				if(null==sauceChoice.getSelection()) {
					aintSelected=true;
				}else {
					if(sauce1Rdbtn.isSelected())
						sauce="Tomato";
					if(sauce2Rdbtn.isSelected())
						sauce="Pesto";
					if(sauce3Rdbtn.isSelected())
						sauce="Alfredo";
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
						toppingsP[toppingsAmount]="Pepperoni"; //pepperoni
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
		
		JLabel toppingsChoiceLbl1 = new JLabel("0.20 Eur");
		toppingsChoiceLbl1.setForeground(Color.DARK_GRAY);
		toppingsChoiceLbl1.setFont(new Font("Hot Slice", Font.BOLD, 15));
		toppingsChoiceLbl1.setBounds(116, 235, 61, 33);
		orderPanel1.add(toppingsChoiceLbl1);
		
		JLabel lblOrderBackground1 = new JLabel("");
		lblOrderBackground1.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/backgroundMain2.png")));
		lblOrderBackground1.setBounds(0, 0, 534, 560);
		orderPanel1.add(lblOrderBackground1);
		
		orderPanel2 = new JPanel();
		orderPanel2.setLayout(null);
		layeredPane.add(orderPanel2, "name_4048253355859500");
		
		JLabel errorLbl_5 = new JLabel("");
		errorLbl_5.setForeground(Color.RED);
		errorLbl_5.setFont(new Font("Hot Slice", Font.BOLD, 20));
		errorLbl_5.setBounds(368, 386, 21, 23);
		orderPanel2.add(errorLbl_5);
		
		JLabel errorLbl_1 = new JLabel("");
		errorLbl_1.setForeground(Color.RED);
		errorLbl_1.setFont(new Font("Hot Slice", Font.BOLD, 20));
		errorLbl_1.setBounds(155, 235, 21, 23);
		orderPanel2.add(errorLbl_1);
		
		JLabel errorLbl_2 = new JLabel("");
		errorLbl_2.setForeground(Color.RED);
		errorLbl_2.setFont(new Font("Hot Slice", Font.BOLD, 20));
		errorLbl_2.setBounds(368, 289, 21, 23);
		orderPanel2.add(errorLbl_2);
		
		JLabel errorLbl = new JLabel("");
		errorLbl.setForeground(new Color(255, 0, 0));
		errorLbl.setFont(new Font("Hot Slice", Font.BOLD, 20));
		errorLbl.setBounds(155, 191, 21, 23);
		orderPanel2.add(errorLbl);
		
		JLabel errorLbl_3 = new JLabel("");
		errorLbl_3.setForeground(Color.RED);
		errorLbl_3.setFont(new Font("Hot Slice", Font.BOLD, 20));
		errorLbl_3.setBounds(368, 334, 21, 23);
		orderPanel2.add(errorLbl_3);
		ButtonGroup deliverChoice = new ButtonGroup();
		
		deliverRdbtn1 = new JRadioButton("Shipping");
		deliverRdbtn1.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/checked.png")));
		deliverRdbtn1.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/unchecked.png")));
		deliverRdbtn1.setForeground(new Color(255, 255, 255));
		deliverRdbtn1.setOpaque(false);
		deliverRdbtn1.setSelected(true);
		deliverRdbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTotal(yummyPizza);
				lblOrderBackground2.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/backgroundMain3.png")));
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
		
		deliverRdbtn = new JRadioButton("Pick up");
		deliverRdbtn.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/checked.png")));
		deliverRdbtn.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/unchecked.png")));
		deliverRdbtn.setOpaque(false);
		deliverRdbtn.setForeground(new Color(255, 255, 255));
		deliverRdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblOrderBackground2.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/backgroundMain3_1.png")));
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
		saveInfo.setForeground(new Color(255, 255, 255));
		saveInfo.setOpaque(false);
		saveInfo.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/unchecked.png")));
		saveInfo.setSelectedIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/checked.png")));
		saveInfo.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		saveInfo.setBounds(180, 415, 174, 23);
		orderPanel2.add(saveInfo);
		
		txtName = new JTextField();
		txtName.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 0, 0)));
		txtName.setBackground(new Color(250, 250, 210));
		txtName.setToolTipText("");
		txtName.setFont(new Font("Hot Slice", Font.PLAIN, 19));
		txtName.setBounds(32, 191, 104, 23);
		orderPanel2.add(txtName);
		txtName.setColumns(10);
		
		textAddress2 = new JTextField();
		textAddress2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 0, 0)));
		textAddress2.setBackground(new Color(250, 250, 210));
		textAddress2.setToolTipText("");
		textAddress2.setFont(new Font("Hot Slice", Font.PLAIN, 19));
		textAddress2.setColumns(10);
		textAddress2.setBounds(32, 334, 316, 23);
		orderPanel2.add(textAddress2);
		
		txtSurname = new JTextField();
		txtSurname.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 0, 0)));
		txtSurname.setBackground(new Color(250, 250, 210));
		txtSurname.setToolTipText("");
		txtSurname.setFont(new Font("Hot Slice", Font.PLAIN, 19));
		txtSurname.setColumns(10);
		txtSurname.setBounds(32, 235, 104, 23);
		orderPanel2.add(txtSurname);
		
		textAddress1 = new JTextField();
		textAddress1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 0, 0)));
		textAddress1.setBackground(new Color(250, 250, 210));
		textAddress1.setToolTipText("");
		textAddress1.setFont(new Font("Hot Slice", Font.PLAIN, 19));
		textAddress1.setColumns(10);
		textAddress1.setBounds(32, 289, 316, 23);
		orderPanel2.add(textAddress1);
		
		txtCoupon = new JTextField();
		txtCoupon.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 0, 0)));
		txtCoupon.setBackground(new Color(250, 250, 210));
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
		
		try {
		    MaskFormatter mask = new MaskFormatter("########");
		    txtNumber = new JFormattedTextField(mask);
		    txtNumber.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 0, 0)));
		    txtNumber.setBackground(new Color(250, 250, 210));
		    txtNumber.setToolTipText("");
		    txtNumber.setFont(new Font("Hot Slice", Font.PLAIN, 19));
		    txtNumber.setBounds(170, 385, 178, 23);
		} catch (ParseException e) {
		    e.printStackTrace();
		}


		orderPanel2.add(txtNumber);
		
		JLabel yourOrderLbl = new JLabel("Your Order");
		yourOrderLbl.setForeground(new Color(255, 255, 255));
		yourOrderLbl.setHorizontalAlignment(SwingConstants.CENTER);
		yourOrderLbl.setFont(new Font("Hot Slice", Font.BOLD, 40));
		yourOrderLbl.setBounds(178, 0, 176, 51);
		orderPanel2.add(yourOrderLbl);
		
		JLabel deliverLbl = new JLabel("Delivery Option");
		deliverLbl.setForeground(Color.GRAY);
		deliverLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		deliverLbl.setBounds(32, 49, 151, 33);
		orderPanel2.add(deliverLbl);
		
		orderHistoryPanel = new JPanel();
		orderHistoryPanel.setLayout(null);
		layeredPane.add(orderHistoryPanel, "name_4048253396953400");
		
		btnRemove = new JButton("Remove");
		btnRemove.setBackground(Color.DARK_GRAY);
		btnRemove.setForeground(Color.RED);
		btnRemove.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.RED));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> orderModelN = new DefaultListModel<>();
				//int i = orderJList.getSelectedIndex();
				if(selectedI!=-1) {
					ArrayList<PizzaOrderS> orders = FileFunctions.returnOrders("orderHistory");
		    		orders.remove(selectedI);
		    		FileFunctions.serializeOrders(orders, "orderHistory");
		    		orders = FileFunctions.returnOrders("orderHistory");

		    		for(int j=0;j<orders.size();j++) {
		    			orderModelN.addElement((orders.get(j)).getName()+" "+(orders.get(j)).getSurname()+" "+(orders.get(j)).getOrderID());
		    		}
		    		if(orderModelN.isEmpty()) {
		    			scrollPane.setVisible(false);
		    			orderJList.setVisible(false);
		    			btnRemove.setVisible(false);
		    			backgroundLbl.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/emptyBackgroundMain.png")));
		    		}else {
		    			btnRemove.setVisible(true);
		    			orderJList.setVisible(true);
		    			scrollPane.setVisible(true);
		    			backgroundLbl.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/emptyBackgroundMain1.png")));
		    		}
		    		orderJList.setModel(orderModelN);
				}
			}
		});
		btnRemove.setFont(new Font("Hot Slice", Font.ITALIC, 30));
		btnRemove.setBounds(205, 383, 128, 40);
		orderJList = new JList<String>(orderModel);
		orderJList.setValueIsAdjusting(true);
		orderJList.setFont(new Font("Arial", Font.PLAIN, 15));
		orderJList.setForeground(Color.WHITE);
		orderJList.setSelectionForeground(Color.WHITE);
		orderJList.setSelectionBackground(Color.ORANGE);
		orderJList.setFixedCellHeight(44);
		orderJList.setBackground(Color.BLACK);
		orderJList.setSize(new Dimension(50, 50));
		orderJList.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		orderJList.setAlignmentX(Component.RIGHT_ALIGNMENT);
		orderHistoryPanel.add(btnRemove);
		scrollPane = new JScrollPane(orderJList);
		scrollPane.setForeground(Color.WHITE);
		scrollPane.setBackground(Color.BLACK);
		scrollPane.setFont(new Font("Hot Slice", Font.PLAIN, 11));
		scrollPane.setLocation(75, 133);
		scrollPane.setSize(386, 235);
		orderHistoryPanel.add(scrollPane);
		orderJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		orderJList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                	 selectedI = orderJList.getSelectedIndex();
                     System.out.println(orderJList.getSelectedIndex());
                    CheckWindow.checkWindow(orders.get(selectedI));
                }
            }
        });
		backBtn_1 = new JButton("Back");
		backBtn_1.setBackground(Color.DARK_GRAY);
		backBtn_1.setForeground(Color.ORANGE);
		backBtn_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
		backBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(mainMenuPanel);
				orderJList.clearSelection();
			}
		});
		backBtn_1.setFont(new Font("Hot Slice", Font.ITALIC, 30));
		backBtn_1.setBounds(30, 495, 116, 40);
		orderHistoryPanel.add(backBtn_1);
		
		historyLbl = new JLabel("Order History");
		historyLbl.setHorizontalAlignment(SwingConstants.CENTER);
		historyLbl.setForeground(Color.WHITE);
		historyLbl.setFont(new Font("Hot Slice", Font.BOLD, 40));
		historyLbl.setBounds(163, 0, 217, 51);
		orderHistoryPanel.add(historyLbl);
		
		backgroundLbl = new JLabel("");
		backgroundLbl.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/emptyBackgroundMain1.png")));
		backgroundLbl.setBounds(0, 0, 534, 560);
		orderHistoryPanel.add(backgroundLbl);
		
		lblNameField = new JLabel("Name");
		lblNameField.setForeground(Color.DARK_GRAY);
		lblNameField.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblNameField.setBounds(32, 176, 104, 23);
		orderPanel2.add(lblNameField);
		
		lblSurnameField = new JLabel("Surname");
		lblSurnameField.setForeground(Color.DARK_GRAY);
		lblSurnameField.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblSurnameField.setBounds(32, 220, 104, 23);
		orderPanel2.add(lblSurnameField);
		
		lblAddrField = new JLabel("Address Line 1");
		lblAddrField.setForeground(Color.DARK_GRAY);
		lblAddrField.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblAddrField.setBounds(32, 274, 134, 23);
		orderPanel2.add(lblAddrField);
		
		lblAddrField1 = new JLabel("Address Line 2");
		lblAddrField1.setForeground(Color.DARK_GRAY);
		lblAddrField1.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblAddrField1.setBounds(32, 319, 134, 23);
		orderPanel2.add(lblAddrField1);
		
		spinner = new JSpinner();
		spinner.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 0, 0)));
		spinner.setOpaque(false);
		spinner.setBackground(new Color(250, 250, 210));
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				updateTotal(yummyPizza);
			}
		});
		spinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner.setFont(new Font("Hot Slice", Font.PLAIN, 20));
		spinner.setBounds(362, 45, 34, 33);
		orderPanel2.add(spinner);
		
		amountLbl = new JLabel("Pizza  Amount");
		amountLbl.setForeground(Color.GRAY);
		amountLbl.setFont(new Font("Hot Slice", Font.BOLD, 25));
		amountLbl.setBounds(211, 48, 272, 33);
		orderPanel2.add(amountLbl);
		
		lblCoupon = new JLabel("Coupon");
		lblCoupon.setForeground(Color.DARK_GRAY);
		lblCoupon.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblCoupon.setBounds(32, 368, 104, 23);
		orderPanel2.add(lblCoupon);
		
		totalLbl = new JLabel("<html>\r\n(Size) Pizzas: (amount)x (eur)\r\n<br>Shipping(ifSelected): (eur)\r\n<br>----------\r\n<br>Total: (total)\r\n</html>");
		totalLbl.setForeground(new Color(255, 255, 255));
		totalLbl.setVerticalAlignment(SwingConstants.TOP);
		totalLbl.setHorizontalAlignment(SwingConstants.LEFT);
		totalLbl.setFont(new Font("Hot Slice", Font.PLAIN, 16));
		totalLbl.setBounds(211, 89, 260, 159);
		orderPanel2.add(totalLbl);
		
		lblNumber = new JLabel("Phone Number");
		lblNumber.setForeground(Color.DARK_GRAY);
		lblNumber.setFont(new Font("Hot Slice", Font.ITALIC, 20));
		lblNumber.setBounds(170, 370, 178, 23);
		orderPanel2.add(lblNumber);
		
		JButton nextBtn_1 = new JButton("Confirm");
		nextBtn_1.setForeground(new Color(0, 255, 0));
		nextBtn_1.setBackground(Color.DARK_GRAY);
		nextBtn_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 0)));
		nextBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<PizzaOrderS> temp = new ArrayList<>();
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
					PizzaOrderF bigOrder = new PizzaOrderF(yummyPizza,addr1, addr2, name, surname, pnumber,((Number) spinner.getValue()).intValue(), orderID, coupon, total,(LocalDate.now()).format(DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH)));
					switchPanels(mainMenuPanel);
					temp = FileFunctions.returnOrders("orderHistory");
					temp.add(bigOrder);
					FileFunctions.serializeOrders(temp,"orderHistory");
					CheckWindow.checkWindow(bigOrder);
				}else if(aizpildits && deliverRdbtn.isSelected()) {
					PizzaOrderS bigOrder = new PizzaOrderS(yummyPizza, name, surname, pnumber,((Number) spinner.getValue()).intValue(), orderID, coupon, total,(LocalDate.now()).format(DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH)));
					switchPanels(mainMenuPanel);
					temp = FileFunctions.returnOrders("orderHistory");
					temp.add(bigOrder);
					FileFunctions.serializeOrders(temp,"orderHistory");
					CheckWindow.checkWindow(bigOrder);
					}
				if(aizpildits) {
					if(!saveInfo.isSelected()) {
						txtName.setText("");
						txtSurname.setText("");
						textAddress1.setText("");
						textAddress2.setText("");
						txtNumber.setText("");
						txtCoupon.setText("");
					}
					crustChoice.clearSelection();
					sauceChoice.clearSelection();
					cheesesChoice.clearSelection();
					topping1Choice.clearSelection();
					topping2Choice.clearSelection();
					topping3Choice.clearSelection();
					setTopping1("nothing");
					setTopping2("nothing");
					setTopping3("nothing");
				}
				}
		});
		nextBtn_1.setFont(new Font("Hot Slice", Font.ITALIC, 30));
		nextBtn_1.setBounds(367, 495, 116, 40);
		orderPanel2.add(nextBtn_1);
		
		JButton backBtn = new JButton("Back");
		backBtn.setForeground(Color.ORANGE);
		backBtn.setBackground(Color.DARK_GRAY);
		backBtn.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(orderPanel1);
			}
		});
		backBtn.setFont(new Font("Hot Slice", Font.ITALIC, 30));
		backBtn.setBounds(30, 495, 116, 40);
		orderPanel2.add(backBtn);
		
		lblOrderBackground2 = new JLabel("");
		lblOrderBackground2.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/backgroundMain3.png")));
		lblOrderBackground2.setBounds(0, 0, 534, 560);
		orderPanel2.add(lblOrderBackground2);
		JLabel Logo = new JLabel("Martin's Pizza");

		Logo.setForeground(Color.WHITE);
		Logo.setHorizontalAlignment(SwingConstants.CENTER);
		Logo.setFont(new Font("Lindra", Font.PLAIN, 50));
		Logo.setBounds(10, 11, 516, 81);
		contentPane.add(Logo);
		
		JLabel lblBackgroundMain = new JLabel("");
		lblBackgroundMain.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/backgroundMain.png")));
		lblBackgroundMain.setBounds(0, 0, 534, 661);
		contentPane.add(lblBackgroundMain);
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
	public void setTopping1(String topping) {
		toppingLayer1lbl.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
		toppingLayer1lbl_1.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
		toppingLayer1lbl_2.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
		toppingLayer1lbl_3.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
		toppingLayer1lbl_4.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
	}
	public void setTopping2(String topping) {
		toppingLayer2lbl.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
		toppingLayer2lbl_1.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
		toppingLayer2lbl_2.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
		toppingLayer2lbl_3.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
		toppingLayer2lbl_4.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
		toppingLayer2lbl_5.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
		toppingLayer2lbl_6.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
	}

	public void setTopping3(String topping) {
		toppingLayer3lbl.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
		toppingLayer3lbl_1.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
		toppingLayer3lbl_2.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
		toppingLayer3lbl_3.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
		toppingLayer3lbl_4.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
		toppingLayer3lbl_5.setIcon(new ImageIcon(PizzaMain.class.getResource("/Resources/"+topping+".png")));
	}
}