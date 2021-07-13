package airline;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class AdminSection extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	private JTextField txtid;
	private JTextField txtlname;
	private JTextField txtuser_name;
	private JTextField txtaddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSection frame = new AdminSection();
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
	public AdminSection() 
	{
		setUndecorated(true);
		Connect();
	    AdminSection_Load();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 480);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			int x=arg0.getXOnScreen();
			int y=arg0.getYOnScreen();
			AdminSection.this.setLocation(x-xx, y-xy);
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

		JLabel lblNewLabel_1 = new JLabel("WORKER DETAILS");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel_1.setBounds(257, 11, 300, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("WORKER ID");
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/Category Pic1.png"));
		lblNewLabel_2.setIcon(img2);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(56, 84, 140, 32);
		contentPane.add(lblNewLabel_2);
		
		txtid = new JTextField();
		txtid.setToolTipText("Enter Worker ID");
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtid.setEditable(false);
					JOptionPane.showMessageDialog(AdminSection.this,"Enter Numbers Only");
					
				}else {
					txtid.setEditable(true);		
				}
			}
		});
		txtid.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtid.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtid.setBounds(230, 84, 230, 32);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("WORKER NAME");
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/Author Name.png"));
		lblNewLabel_3.setIcon(img3);
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(55, 145, 175, 23);
		contentPane.add(lblNewLabel_3);
		
		txtlname = new JTextField();
		txtlname.setToolTipText("Enter Worker Name");
		txtlname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtlname.setEditable(false);
					JOptionPane.showMessageDialog(AdminSection.this,"Enter Aphabets Only");	
				}else {
					txtlname.setEditable(true);		
				}
			}
		});
		txtlname.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtlname.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtlname.setBounds(230, 140, 230, 32);
		contentPane.add(txtlname);
		txtlname.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("USERNAME");
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/Login Pic 1.png"));
		lblNewLabel_4.setIcon(img4);
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setBounds(55, 200, 175, 23);
		contentPane.add(lblNewLabel_4);
		
		txtuser_name = new JTextField();
		txtuser_name.setToolTipText("Enter Username for Worker");
		txtuser_name.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtuser_name.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtuser_name.setBounds(230, 195, 230, 32);
		contentPane.add(txtuser_name);
		txtuser_name.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("PASSWORD");
		lblNewLabel_5.setBounds(55, 253, 175, 23);
		lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/Login Pic 2.png"));
		lblNewLabel_5.setIcon(img5);
		contentPane.add(lblNewLabel_5);
					
		JLabel lblNewLabel_6 = new JLabel("ADDRESS");
		ImageIcon img6 =new ImageIcon(this.getClass().getResource("/Author Address.png"));
		lblNewLabel_6.setIcon(img6);
		lblNewLabel_6.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_6.setBounds(56, 311, 175, 23);
		contentPane.add(lblNewLabel_6);
		
		txtaddress = new JTextField();
		txtaddress.setToolTipText("Enter Worker Address ");
		txtaddress.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtaddress.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtaddress.setBounds(230, 306, 230, 44);
		contentPane.add(txtaddress);
		txtaddress.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setToolTipText("Click to ADD details");
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img7 =new ImageIcon(this.getClass().getResource("/add.png"));
		btnNewButton.setIcon(img7);
		
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtid.getText();
				String name = txtlname.getText();
				String username = txtuser_name.getText();
				String password = txtpassword.getText();
				String address = txtaddress.getText();
				
				try {
					String query="select * from worker where id='"+id+"'";
		            pst = con.prepareStatement(query);
		            rs = pst.executeQuery();
		            if(rs.next()) {
		            	JOptionPane.showMessageDialog(null,"Data exist already");
		            	txtid.setText("");
						txtlname.setText(""); 
						txtuser_name.setText("");
						txtpassword.setText("");
						txtaddress.setText("");
		            }
		            else {
					pst = con.prepareStatement("insert into worker(id,name,username,password,address) values(?,?,?,?,?)");
		            pst.setString(1,id);
					pst.setString(2,name);
					pst.setString(3,username);
					pst.setString(4,password);
					pst.setString(5,address);
					
					int k = pst.executeUpdate();
					
					if(k==1)
					{
						JOptionPane.showMessageDialog(AdminSection.this,"Worker Created");
						
						txtid.setText("");
						txtlname.setText(""); 
						txtuser_name.setText("");
						txtpassword.setText("");
						txtaddress.setText("");
						txtlname.requestFocus();						
					}
					else
					{
						JOptionPane.showMessageDialog(AdminSection.this,"Error");
					}
		            }
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}	
			}
		});	

		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton.setBounds(55, 361, 127, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setToolTipText("Click to UPDATE details");
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img8 =new ImageIcon(this.getClass().getResource("/update.png"));
		btnNewButton_1.setIcon(img8);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtid.getText();
				String name = txtlname.getText();
				String username = txtuser_name.getText();
				String password = txtpassword.getText();
				String address = txtaddress.getText();
				
				try {
					pst = con.prepareStatement("update worker set name=?, username=?, password=?, address=? where id=?");
						pst.setString(1,name);
						pst.setString(2,username);
						pst.setString(3,password);
						pst.setString(4,address);
					    pst.setString(5,id);
					int k = pst.executeUpdate();
					
					if(k==1)
					{
                        JOptionPane.showMessageDialog(AdminSection.this,"Worker Record Updated");
						
						txtid.setText("");
						txtlname.setText(""); 
						txtuser_name.setText("");
						txtpassword.setText("");
						txtaddress.setText("");
						txtlname.requestFocus();								
					}
					else
					{
						JOptionPane.showMessageDialog(AdminSection.this,"Error");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}		
			}	
		});
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_1.setBounds(230, 361, 127, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setToolTipText("Click to DELETE Details");
		btnNewButton_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img9 =new ImageIcon(this.getClass().getResource("/trash.png"));
		btnNewButton_2.setIcon(img9);
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                 String id = txtid.getText();
				
			   try {
					pst = con.prepareStatement("delete from worker where id=?");
		           
					pst.setString(1,id);
					int k = pst.executeUpdate();
					if(k==1)
					{
						JOptionPane.showMessageDialog(AdminSection.this,"Worker Record Deleted");
						txtid.setText("");
						txtlname.setText(""); 
						txtuser_name.setText("");
						txtpassword.setText("");
						txtaddress.setText("");
						txtlname.requestFocus();						
					}
					else
					{
						JOptionPane.showMessageDialog(AdminSection.this,"Error");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				} 
			}
		});
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_2.setBounds(55, 417, 127, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LOGOUT");
		btnNewButton_3.setToolTipText("Click here to LOGOUT");
		btnNewButton_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img10 =new ImageIcon(this.getClass().getResource("/MainPic8.png"));
		btnNewButton_3.setIcon(img10);
		btnNewButton_3.setBackground(SystemColor.inactiveCaption);
		btnNewButton_3.setForeground(Color.DARK_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminLogin a=new AdminLogin();
				a.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_3.setBounds(230, 417, 127, 45);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("VIEW TABLE");
		btnNewButton_4.setToolTipText("Click to VIEW TABLE");
		btnNewButton_4.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img11 =new ImageIcon(this.getClass().getResource("/view.png"));
		btnNewButton_4.setIcon(img11);
		btnNewButton_4.setForeground(Color.DARK_GRAY);
		btnNewButton_4.setBackground(SystemColor.inactiveCaption);
		btnNewButton_4.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 WorkerDetails w = new WorkerDetails();
					AdminSection.this.setVisible(false);
					w.setVisible(true);
			
			}
		});
		btnNewButton_4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_4.setBounds(461, 366, 164, 51);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("Close");
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
				public void mouseDragged(MouseEvent arg0) {
					int x=arg0.getXOnScreen();
					int y=arg0.getYOnScreen();
					AdminSection.this.setLocation(x-xx, y-xy);
			}
		});
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
		});
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/close.png"));
		lblNewLabel.setIcon(img1);
		lblNewLabel.setBounds(664, 11, 32, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_5 = new JButton("SEARCH");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="select * from worker where id=?";
				try {
					
					pst = con.prepareStatement(sql);
					pst.setString(1, txtid.getText());
					rs=pst.executeQuery();
					if(rs.next()) {
						
						String add1=rs.getString("name");
						txtlname.setText(add1);
						String add2=rs.getString("username");
						txtuser_name.setText(add2);
						String add4= rs.getString("password");
						txtpassword.setText(add4);
						String add3=rs.getString("address");
						txtaddress.setText(add3);
						rs.close();
						pst.close();	
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Worker ID not Found");
					}					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
		btnNewButton_5.setForeground(Color.DARK_GRAY);
		ImageIcon img12 =new ImageIcon(this.getClass().getResource("/Zoom-icon.png"));
		btnNewButton_5.setIcon(img12);
		btnNewButton_5.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_5.setBounds(488, 80, 164, 41);
		contentPane.add(btnNewButton_5);
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setForeground(Color.RED);
		txtpassword = new JTextField();
		txtpassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String PATTERN="^[A-Z0-9]{1,30}[a-zA-Z0-9]{2,10}[@#$*&%][0-9]{1,5}$";
				Pattern patt=Pattern.compile(PATTERN);
				Matcher match=patt.matcher(txtpassword.getText());
				if(!match.matches())
				{lblNewLabel_7.setText("incorrect");
				}else {lblNewLabel_7.setText(" ");}
				}
			
		});
		txtpassword.setToolTipText("Enter Password for Worker");
		txtpassword.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtpassword.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtpassword.setBounds(230, 248, 230, 32);
		contentPane.add(txtpassword);
		txtpassword.setColumns(10);
		
		lblNewLabel_7.setBounds(242, 281, 115, 14);
		contentPane.add(lblNewLabel_7);
    	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtpassword;
	
	public void Connect()
	{
		
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pulkit");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public void AdminSection_Load() {
		
		try {
			
			Statement st= con.createStatement();
			rs=st.executeQuery("select * from worker");
	         	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	
