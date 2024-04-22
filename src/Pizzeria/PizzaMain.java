package Pizzeria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class PizzaMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane layeredPane;
	private JPanel contentPane;
	private JPanel orderPanel1;
	private JPanel savedInfoPanel;
	private JPanel orderHistoryPanel;
	private JPanel orderPanel2;

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
		
		orderPanel2 = new JPanel();
		orderPanel2.setLayout(null);
		layeredPane.add(orderPanel2, "name_4048253355859500");
		
		orderHistoryPanel = new JPanel();
		orderHistoryPanel.setLayout(null);
		layeredPane.add(orderHistoryPanel, "name_4048253396953400");
		
		savedInfoPanel = new JPanel();
		savedInfoPanel.setLayout(null);
		layeredPane.add(savedInfoPanel, "name_4048253442632400");
		
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
