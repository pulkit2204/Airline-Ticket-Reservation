package airline;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class CustomerCreation extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtfirstname;
	private JTextField txtlastname;
	private JTextField txtnic;
	private JTextField txtpassport;
	private JTextField txtdob;
	private JTextField txtcontact;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerCreation frame = new CustomerCreation();
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
	
	int id1=0;
	
	public CustomerCreation() {
		setUndecorated(true);
		Connect();
	    Customer_Load();
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 434);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			int x=arg0.getXOnScreen();
			int y=arg0.getYOnScreen();
			CustomerCreation.this.setLocation(x-xx, y-xy);
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
		
		JLabel lblNewLabel = new JLabel("FIRST NAME");
		ImageIcon img=new ImageIcon(this.getClass().getResource("/Author name.png"));
		lblNewLabel.setIcon(img);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(35, 128, 146, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LAST NAME");
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/Author name.png"));
		lblNewLabel_1.setIcon(img1);
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(35, 184, 131, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NIC NO");
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/numbers.png"));
		lblNewLabel_2.setIcon(img2);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(35, 230, 104, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PASSPORT ID");
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/passport.png"));
		lblNewLabel_3.setIcon(img3);
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(35, 282, 146, 26);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ADDRESS");
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/Author Address.png"));
		lblNewLabel_4.setIcon(img4);
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setBounds(35, 337, 125, 29);
		contentPane.add(lblNewLabel_4);
		
		txtfirstname = new JTextField();
		txtfirstname.setToolTipText("Enter Customer Firstname");
		txtfirstname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtfirstname.setEditable(false);
					JOptionPane.showMessageDialog(CustomerCreation.this,"Enter Aphabets Only");	
				}else {
					txtfirstname.setEditable(true);		
				}
			}
		});
		txtfirstname.setBounds(192, 126, 169, 32);
		txtfirstname.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtfirstname.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtfirstname);
		txtfirstname.setColumns(10);
		
		txtlastname = new JTextField();
		txtlastname.setToolTipText("Enter Customer Lastname");
		txtlastname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtlastname.setEditable(false);
					JOptionPane.showMessageDialog(CustomerCreation.this,"Enter Aphabets Only");	
				}else {
					txtlastname.setEditable(true);		
				}
			}
		});
		txtlastname.setBounds(192, 178, 169, 32);
		txtlastname.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtlastname.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtlastname);
		txtlastname.setColumns(10);
		
		txtnic = new JTextField();
		txtnic.setToolTipText("Enter NIC Number");
		txtnic.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtnic.setEditable(false);
					JOptionPane.showMessageDialog(CustomerCreation.this,"Enter Numbers Only");
					
				}else {
					txtnic.setEditable(true);		
				}
			}
		});
		txtnic.setBounds(192, 228, 169, 32);
		txtnic.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtnic.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtnic);
		txtnic.setColumns(10);
		
		txtpassport = new JTextField();
		txtpassport.setToolTipText("Enter Passport ID");
		txtpassport.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtpassport.setEditable(false);
					JOptionPane.showMessageDialog(CustomerCreation.this,"Enter Numbers Only");
					
				}else {
					txtpassport.setEditable(true);		
				}
			}
		});
		txtpassport.setBounds(192, 279, 169, 32);
		txtpassport.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtpassport.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtpassport);
		txtpassport.setColumns(10);
		
		JTextArea txtaddress = new JTextArea();
		txtaddress.setToolTipText("Enter Customer Address");
		txtaddress.setBounds(192, 322, 169, 53);
		txtaddress.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtaddress.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtaddress);
		
		JLabel lblNewLabel_5 = new JLabel("CUSTOMER ID");
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/Category Pic1.png"));
		lblNewLabel_5.setIcon(img5);
		lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setBounds(35, 82, 147, 20);
		contentPane.add(lblNewLabel_5);
		
		txtid = new JTextField();
		txtid.setToolTipText("Enter Customer ID");
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtid.setEditable(false);
					JOptionPane.showMessageDialog(CustomerCreation.this,"Enter Numbers Only");
					
				}else {
					txtid.setEditable(true);		
				}
			}
		});
		txtid.setBounds(192, 78, 169, 29);
		txtid.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtid.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtid);
		txtid.setColumns(10);	
		
		JLabel lblNewLabel_7 = new JLabel("DOB");
		ImageIcon img6 =new ImageIcon(this.getClass().getResource("/calendar.png"));
		lblNewLabel_7.setIcon(img6);
		lblNewLabel_7.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_7.setBounds(420, 127, 85, 31);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("GENDER");
		ImageIcon img7 =new ImageIcon(this.getClass().getResource("/gender.png"));
		lblNewLabel_8.setIcon(img7);
		lblNewLabel_8.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_8.setBounds(420, 180, 104, 29);
		contentPane.add(lblNewLabel_8);
		
		txtdob = new JTextField();
		txtdob.setToolTipText("Enter date of birth");
		txtdob.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtdob.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtdob.setBounds(570, 126, 183, 32);
		contentPane.add(txtdob);
		txtdob.setColumns(10);
		
		JRadioButton r2 = new JRadioButton("FEMALE");
		r2.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
		
		r2.setBounds(662, 184, 91, 23);
		contentPane.add(r2);
		
		JRadioButton r1 = new JRadioButton("MALE");
		r1.setFont(new Font("Century Schoolbook", Font.ITALIC, 14));
		r1.setBounds(570, 184, 79, 23);
		contentPane.add(r1);
		
		JLabel lblNewLabel_9 = new JLabel("CONTACT");
		ImageIcon img8 =new ImageIcon(this.getClass().getResource("/contact-book.png"));
		lblNewLabel_9.setIcon(img8);
		lblNewLabel_9.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_9.setBounds(420, 230, 110, 29);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setFont(new Font("Century Schoolbook", Font.PLAIN, 11));
		txtcontact = new JTextField();
		txtcontact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt2) {
				{
					String PATTERN="^[0-9]{10,10}$";
					Pattern patt=Pattern.compile(PATTERN);
					Matcher match=patt.matcher(txtcontact.getText());
					if(!match.matches())
					{lblNewLabel_11.setText("incorrect");
					}else {lblNewLabel_11.setText(" ");}
					
				}
			}
			
		});
		txtcontact.setToolTipText("Enter Customer phone no.");
		txtcontact.setBounds(570, 228, 183, 32);
		txtcontact.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtcontact.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtcontact);
		txtcontact.setColumns(10);
		
		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.setToolTipText("Click to add details");
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img10 =new ImageIcon(this.getClass().getResource("/add.png"));
		btnNewButton_1.setIcon(img10);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String firstname = txtfirstname.getText();
				String lastname = txtlastname.getText();
				String nic = txtnic.getText();
				String passport = txtpassport.getText();
				String address = txtaddress.getText();
				String dob = txtdob.getText();
				String gender;
				if(r1.isSelected()) {
					gender = "Male";
				
				}
				else
				{
					gender = "Female";
				}
				String contact = txtcontact.getText();
				
				try {
					
					String query="select max(id) from Customer";
		            pst = con.prepareStatement(query);
		            rs = pst.executeQuery();
		            if(rs.next()) {
		            	id1 = rs.getInt(1);
						id1++;
						txtid.setText(Integer.toString(id1));
										
					pst = con.prepareStatement("insert into Customer(id,firstname,lastname,nic,passport,address,dob,gender,contact) values(?,?,?,?,?,?,?,?,?)");
					pst.setInt(1,id1);	
					pst.setString(2,firstname);
					pst.setString(3,lastname);
					pst.setString(4,nic);
					pst.setString(5,passport);
					pst.setString(6,address);
					pst.setString(7,dob);
					pst.setString(8,gender);
					pst.setString(9,contact);		
					
					int k = pst.executeUpdate();
					
					if(k>0)
					{
						JOptionPane.showMessageDialog(CustomerCreation.this," Customer added");
						txtid.setText("");
						txtfirstname.setText(""); 
						txtlastname.setText("");
						txtnic.setText("");
						txtpassport.setText("");
						txtaddress.setText("");
						txtdob.setText("");
						r1.setText("");
						r2.setText("");
						txtcontact.setText("");
						txtfirstname.requestFocus();						
					}
					else
					{
						JOptionPane.showMessageDialog(CustomerCreation.this,"Error");
					}
		            }
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}	
			}
		});	

		btnNewButton_1.setBounds(417, 316, 125, 41);
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.setToolTipText("Click to go back to customer section");
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img11 =new ImageIcon(this.getClass().getResource("/back.png"));
		btnNewButton_2.setIcon(img11);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CustomerSection c=new CustomerSection();
				CustomerCreation.this.setVisible(false);
				c.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_2.setBounds(570, 316, 116, 41);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setToolTipText("Close");
		lblNewLabel_6.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
				public void mouseDragged(MouseEvent arg0) {
					int x=arg0.getXOnScreen();
					int y=arg0.getYOnScreen();
			        CustomerCreation.this.setLocation(x-xx, y-xy);
			}
		});
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
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
		
		ImageIcon img12=new ImageIcon(this.getClass().getResource("/close.png"));
		lblNewLabel_6.setIcon(img12);
		lblNewLabel_6.setBounds(745, 11, 32, 44);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_3 = new JButton("VIEW TABLE");
		btnNewButton_3.setToolTipText("Click to view table");
		btnNewButton_3.setForeground(Color.DARK_GRAY);
		btnNewButton_3.setBackground(SystemColor.inactiveCaption);
		btnNewButton_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img13 =new ImageIcon(this.getClass().getResource("/view.png"));
		btnNewButton_3.setIcon(img13);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDetails c=new CustomerDetails();
				CustomerCreation.this.setVisible(false);
				c.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(465, 368, 163, 41);
		btnNewButton_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_10 = new JLabel("NEW CUSTOMER");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel_10.setBounds(299, 21, 254, 34);
		contentPane.add(lblNewLabel_10);	
		
		
		lblNewLabel_11.setForeground(Color.RED);
		lblNewLabel_11.setBounds(570, 264, 79, 14);
		contentPane.add(lblNewLabel_11);
	}
	
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		public void Connect()
		{
			
			try{
				Class.forName ("oracle.jdbc.driver.OracleDriver");
				con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pulkit");
				
			}catch(Exception e){
				System.out.println(e);
			}
			
		}
		
		public void Customer_Load() {
			try {
				
				Statement st= con.createStatement();
				rs=st.executeQuery("select * from Customer");
		         	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
				}
	

