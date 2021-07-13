package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JToggleButton;

public class CustomerSection extends JFrame {
	
	private JPanel contentPane;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerSection frame = new CustomerSection();
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
	public CustomerSection() 
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 349);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			int x=arg0.getXOnScreen();
			int y=arg0.getYOnScreen();
			CustomerSection.this.setLocation(x-xx, y-xy);
			}
			});
			contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			xx=e.getX();
			xy=e.getY();
			}
			});
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit toolkit = getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
		
		JButton btnNewButton = new JButton("NEW CUSTOMER");
		btnNewButton.setToolTipText("click here for Customer Creation Section");
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/ccreation.png"));
		btnNewButton.setIcon(img1);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CustomerCreation c = new CustomerCreation();
				CustomerSection.this.setVisible(false);
				c.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(26, 131, 270, 59);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CUSTOMER SEARCH");
		btnNewButton_1.setToolTipText("click here for customer search section");
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/searching.png"));
		btnNewButton_1.setIcon(img2);
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CustomerSearch s = new CustomerSearch();
				CustomerSection.this.setVisible(false);
				s.setVisible(true);	
				
			}
		});
		btnNewButton_1.setBounds(316, 131, 250, 59);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.setToolTipText("click here to go to Worker Section");
		btnNewButton_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/back.png"));
		btnNewButton_2.setIcon(img3);
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WorkerSection s = new WorkerSection();
				CustomerSection.this.setVisible(false);
				s.setVisible(true);	
				
			}
			
		});
		btnNewButton_2.setBounds(423, 266, 143, 47);
		contentPane.add(btnNewButton_2);
				
		JLabel lblNewLabel = new JLabel("CUSTOMER SECTION");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(140, 29, 301, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Close");
		lblNewLabel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
				public void mouseDragged(MouseEvent arg0){
					int x=arg0.getXOnScreen();
					int y=arg0.getYOnScreen();
					CustomerSection.this.setLocation(x-xx, y-xy);
				}
		});
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
			}
		});
		ImageIcon img =new ImageIcon(this.getClass().getResource("/close.png"));
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.setBounds(543, 11, 36, 47);
		contentPane.add(lblNewLabel_1);		
		
	}
}
