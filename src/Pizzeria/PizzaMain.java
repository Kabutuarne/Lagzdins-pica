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

public class PizzaMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane layeredPane;
	private JPanel contentPane;
	private JPanel mainMenuPanel;

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
		
		mainMenuPanel = new JPanel();
		mainMenuPanel.setBounds(0, 0, 536, 560);
		layeredPane.add(mainMenuPanel);
		mainMenuPanel.setLayout(null);
		
		JButton QuitBtn = new JButton("Quit");
		QuitBtn.setFont(new Font("Hot Slice", Font.PLAIN, 30));
		QuitBtn.setBounds(170, 286, 199, 53);
		mainMenuPanel.add(QuitBtn);
		
		JButton OrderBtn = new JButton("New Order");
		OrderBtn.setFont(new Font("Hot Slice", Font.PLAIN, 30));
		OrderBtn.setBounds(170, 94, 199, 53);
		mainMenuPanel.add(OrderBtn);
		
		JButton OrderHistoryBtn = new JButton("Order History");
		OrderHistoryBtn.setFont(new Font("Hot Slice", Font.PLAIN, 30));
		OrderHistoryBtn.setBounds(170, 158, 199, 53);
		mainMenuPanel.add(OrderHistoryBtn);
		
		JButton SavedInfoBtn = new JButton("Saved Info");
		SavedInfoBtn.setFont(new Font("Hot Slice", Font.PLAIN, 30));
		SavedInfoBtn.setBounds(170, 222, 199, 53);
		mainMenuPanel.add(SavedInfoBtn);
		
		JPanel orderPanel1 = new JPanel();
		orderPanel1.setLayout(null);
		orderPanel1.setBounds(0, 0, 536, 560);
		layeredPane.add(orderPanel1);
		
		JPanel orderPanel2 = new JPanel();
		orderPanel2.setLayout(null);
		orderPanel2.setBounds(0, 0, 536, 560);
		layeredPane.add(orderPanel2);
		
		JPanel orderHistoryPanel = new JPanel();
		orderHistoryPanel.setLayout(null);
		orderHistoryPanel.setBounds(0, 0, 536, 560);
		layeredPane.add(orderHistoryPanel);
		
		JPanel savedInfoPanel = new JPanel();
		savedInfoPanel.setLayout(null);
		savedInfoPanel.setBounds(0, 0, 536, 560);
		layeredPane.add(savedInfoPanel);
		
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
