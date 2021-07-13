package airline;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WorkerLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField txtpass;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkerLogin frame = new WorkerLogin();
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
	public WorkerLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Toolkit toolkit = getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 139, 139));
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				WorkerLogin.this.setLocation(x-xx, y-xy);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
		});
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setBorder(null);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(77, 178, 119, 33);
		ImageIcon img =new ImageIcon(this.getClass().getResource("/Login Pic 1.png"));
		lblNewLabel.setIcon(img);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(77, 222, 132, 33);
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/Login Pic 2.png"));
		lblNewLabel_1.setIcon(img1);
		panel.add(lblNewLabel_1);
		
		txtusername = new JTextField();
		txtusername.setToolTipText("Enter Username");
		txtusername.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtusername.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtusername.setBounds(244, 178, 181, 33);
		panel.add(txtusername);
		txtusername.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setToolTipText("Click here to LOGIN.");
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/FrontPage.png"));
		btnNewButton.setIcon(img2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String username = txtusername.getText();
				String password = txtpass.getText();
				
				boolean status =WorkerLogin.validate(username, password);
				if(status) 
				{
					dispose();
					WorkerSection m = new WorkerSection();
					m.setVisible(true);	
					txtusername.setText("");
					txtpass.setText("");
				}
				
			
				else
				{
					JOptionPane.showMessageDialog(btnNewButton, "Wrong Username");
					txtusername.setText("");
					txtpass.setText("");
					txtusername.requestFocus();
				}
			}
		});
		btnNewButton.setBounds(77, 300, 119, 42);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setToolTipText("Click here to EXIT.");
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/exit.png"));
		btnNewButton_1.setIcon(img3);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				MainPage l=new MainPage();
				WorkerLogin.this.setVisible(false);
				l.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(279, 300, 119, 42);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel_2.setBounds(189, 11, 109, 42);
		panel.add(lblNewLabel_2);
		
		txtpass = new JPasswordField();
		txtpass.setToolTipText("Enter Password");
		txtpass.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtpass.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtpass.setBounds(244, 222, 181, 33);
		panel.add(txtpass);
		
		JLabel label = new JLabel("");
		label.setToolTipText("Close");
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/close.png"));
		label.setIcon(img4);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label.setBorder(null);
		label.setBounds(449, 11, 40, 42);
		panel.add(label);
		
		JLabel lblNewLabel_3 = new JLabel("n");
		lblNewLabel_3.setBounds(173, 50, 125, 128);
		ImageIcon im =new ImageIcon(this.getClass().getResource("/Login Pic 3.png"));
		lblNewLabel_3.setIcon(im);
		panel.add(lblNewLabel_3);
		
		JCheckBox c = new JCheckBox("Show Password");
		c.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		c.setOpaque(false);
		c.setForeground(Color.BLACK);
		c.setBackground(Color.WHITE);
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (c.isSelected())
				{
				 txtpass.setEchoChar((char)0);	
				}
				else
				{
				 txtpass.setEchoChar('*');
				}
			}
		});
		c.setBounds(244, 262, 170, 23);
		panel.add(c);
		setUndecorated(true);
	
	
	}
	
	
public static boolean validate(String username,String password){
		
		boolean status=false;
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pulkit");
			PreparedStatement ps=con.prepareStatement("select * from AdminSection where username=? and password=?");
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
		
		
		
	}
}
