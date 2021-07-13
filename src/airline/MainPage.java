package airline;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class MainPage extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() 
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 389);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				MainPage.this.setLocation(x-xx, y-xy);
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
		
		JLabel lblNewLabel = new JLabel("AEROCITY");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(213, 25, 155, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Close");
		lblNewLabel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
				public void mouseDragged(MouseEvent arg0){
					int x=arg0.getXOnScreen();
					int y=arg0.getYOnScreen();
					MainPage.this.setLocation(x-xx, y-xy);
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
		lblNewLabel_1.setBounds(517, 25, 36, 47);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ADMIN LOGIN");
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/FrontPage.png"));
		btnNewButton.setIcon(img1);
		btnNewButton.setToolTipText("Click to open ADMIN LOGIN.");
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin a = new AdminLogin();
				MainPage.this.setVisible(false);
				a.setVisible(true);
			}
		});
		btnNewButton.setBounds(31, 253, 200, 47);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("WORKER LOGIN");
		
		btnNewButton_1.setToolTipText("Click to open LIBRARIAN LOGIN.");
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/FrontPage.png"));
		btnNewButton_1.setIcon(img2);
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkerLogin l = new WorkerLogin();
				MainPage.this.setVisible(false);
				l.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(316, 253, 208, 47);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EXIT");
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/exit.png"));
		btnNewButton_2.setIcon(img3);
		btnNewButton_2.setToolTipText("Click here to EXIT.");
		btnNewButton_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.setBounds(439, 319, 97, 48);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		ImageIcon im =new ImageIcon(this.getClass().getResource("/Teacher-icon.png"));
		lblNewLabel_2.setIcon(im);
		lblNewLabel_2.setBounds(354, 102, 137, 128);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		ImageIcon im2 =new ImageIcon(this.getClass().getResource("/admin1.png"));
		lblNewLabel_3.setIcon(im2);
		lblNewLabel_3.setBounds(61, 85, 155, 145);
		contentPane.add(lblNewLabel_3);
		
		
		
	}
}