package airline;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class TicketBookingSection extends JFrame {

	private JPanel contentPane;
	int xx,xy;
	private JTable table;
	private JTextField txtticket;
	private JTextField txtcustid;
	private JTextField txtfirstname;
	private JTextField txtlastname;
	private JTextField txtpassport;
	private JTextField txtflightid;
	private JTextField txtflightname;
	private JTextField txtdept;
	private JTextField txtprice;
	private JTextField txttotal;
	private JTextField txtdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketBookingSection frame = new TicketBookingSection();
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
	public TicketBookingSection() {
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1069, 709);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			int x=arg0.getXOnScreen();
			int y=arg0.getYOnScreen();
			TicketBookingSection.this.setLocation(x-xx, y-xy);
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("Close");
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
				public void mouseDragged(MouseEvent arg0) {
					int x=arg0.getXOnScreen();
					int y=arg0.getYOnScreen();
			        TicketBookingSection.this.setLocation(x-xx, y-xy);
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
		
		ImageIcon img=new ImageIcon(this.getClass().getResource("/close.png"));
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(1027, 10, 32, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SELECT COUNTRY");
		ImageIcon img1=new ImageIcon(this.getClass().getResource("/map.png"));
		lblNewLabel_1.setIcon(img1);
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel_1.setBounds(68, 102, 251, 51);
		contentPane.add(lblNewLabel_1);
	
		JLabel lblNewLabel_2 = new JLabel("SOURCE");
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/flight.png"));
		lblNewLabel_2.setIcon(img2);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(73, 153, 108, 34);
		contentPane.add(lblNewLabel_2);
		
		JComboBox txtsource = new JComboBox();
		txtsource.setToolTipText("Select the source");
		txtsource.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtsource.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtsource.setModel(new DefaultComboBoxModel(new String[] {"India", "Srilanka", "UK", "USA", "Canada", "China"}));
		txtsource.setBounds(72, 194, 172, 32);
		contentPane.add(txtsource);
		
		JLabel lblNewLabel_3 = new JLabel("DEPARTURE");
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/departures.png"));
		lblNewLabel_3.setIcon(img3);
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(280, 153, 151, 34);
		contentPane.add(lblNewLabel_3);
		
		JComboBox txtdepart = new JComboBox();
		txtdepart.setToolTipText("Select the departure");
		txtdepart.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtdepart.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtdepart.setModel(new DefaultComboBoxModel(new String[] {"India", "Srilanka", "UK", "USA", "Canada", "China"}));
		txtdepart.setBounds(263, 195, 189, 32);
		contentPane.add(txtdepart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel Df = (DefaultTableModel)table.getModel();
				int selectIndex = table.getSelectedRow();
				
				txtflightid.setText(Df.getValueAt(selectIndex, 0).toString());
				txtflightname.setText(Df.getValueAt(selectIndex, 1).toString());
				txtdept.setText(Df.getValueAt(selectIndex, 5).toString());
				txtprice.setText(Df.getValueAt(selectIndex, 7).toString());				
				
			}
		});
		scrollPane.setBounds(25, 304, 554, 302);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		Object[] column = {"ID","Flight Name","Source","Departure","Ddate","DepTime","ArrTime","charge"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_4 = new JLabel("TICKET ID");
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/ticket.png"));
		lblNewLabel_4.setIcon(img4);
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setBounds(24, 55, 147, 34);
		contentPane.add(lblNewLabel_4);
		
		txtticket = new JTextField();
		txtticket.setToolTipText("Enter Ticket number");
		txtticket.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtticket.setEditable(false);
					JOptionPane.showMessageDialog(TicketBookingSection.this,"Enter Numbers Only");
					
				}else {
					txtticket.setEditable(true);		
				}
			}
		});
		txtticket.setBounds(182, 55, 161, 34);
		txtticket.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtticket.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtticket);
		txtticket.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("CUSTOMER ID");
		ImageIcon img7 =new ImageIcon(this.getClass().getResource("/Category Pic1.png"));
		lblNewLabel_5.setIcon(img7);
		lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setBounds(622, 97, 146, 34);
		contentPane.add(lblNewLabel_5);
		
		txtcustid = new JTextField();
		txtcustid.setToolTipText("Enter Customer ID");
		txtcustid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtcustid.setEditable(false);
					JOptionPane.showMessageDialog(TicketBookingSection.this,"Enter Numbers Only");
					
				}else {
					txtcustid.setEditable(true);		
				}
			}
		});
		txtcustid.setBounds(778, 97, 94, 34);
		txtcustid.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtcustid.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtcustid);
		txtcustid.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("FIRST NAME");
		ImageIcon img8=new ImageIcon(this.getClass().getResource("/Author name.png"));
		lblNewLabel_6.setIcon(img8);
		lblNewLabel_6.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_6.setBounds(622, 151, 146, 30);
		contentPane.add(lblNewLabel_6);
		
		txtfirstname = new JTextField();
		txtfirstname.setToolTipText("Enter Customer Firstname");
		txtfirstname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtfirstname.setEditable(false);
					JOptionPane.showMessageDialog(TicketBookingSection.this,"Enter Aphabets Only");	
				}else {
					txtfirstname.setEditable(true);		
				}
			}
		});
		txtfirstname.setBounds(778, 149, 172, 34);
		txtfirstname.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtfirstname.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtfirstname);
		txtfirstname.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("LAST NAME");
		ImageIcon img9 =new ImageIcon(this.getClass().getResource("/Author name.png"));
		lblNewLabel_7.setIcon(img9);
		lblNewLabel_7.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_7.setBounds(622, 199, 146, 28);
		contentPane.add(lblNewLabel_7);
		
		txtlastname = new JTextField();
		txtlastname.setToolTipText("Enter Customer Lastname");
		txtlastname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtlastname.setEditable(false);
					JOptionPane.showMessageDialog(TicketBookingSection.this,"Enter Aphabets Only");	
				}else {
					txtlastname.setEditable(true);		
				}
			}
		});
		txtlastname.setBounds(778, 197, 172, 34);
		txtlastname.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtlastname.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtlastname);
		txtlastname.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("PASSPORT ID");
		ImageIcon img10 =new ImageIcon(this.getClass().getResource("/passport.png"));
		lblNewLabel_8.setIcon(img10);
		lblNewLabel_8.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_8.setBounds(621, 239, 146, 37);
		contentPane.add(lblNewLabel_8);
		
		txtpassport = new JTextField();
		txtpassport.setToolTipText("Enter Passport ID");
		txtpassport.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtpassport.setEditable(false);
					JOptionPane.showMessageDialog(TicketBookingSection.this,"Enter Numbers Only");
					
				}else {
					txtpassport.setEditable(true);		
				}
			}
		});
		txtpassport.setBounds(778, 242, 172, 34);
		txtpassport.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtpassport.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtpassport);
		txtpassport.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("FLIGHT ID");
		ImageIcon img11 =new ImageIcon(this.getClass().getResource("/identification (1).png"));
		lblNewLabel_9.setIcon(img11);
		lblNewLabel_9.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_9.setBounds(624, 354, 139, 34);
		contentPane.add(lblNewLabel_9);
		
		txtflightid = new JTextField();
		txtflightid.setToolTipText("Enter Flight ID");
		txtflightid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtflightid.setEditable(false);
					JOptionPane.showMessageDialog(TicketBookingSection.this,"Enter Numbers Only");
					
				}else {
					txtflightid.setEditable(true);		
				}
			}
		});
		txtflightid.setBounds(792, 354, 107, 34);
		txtflightid.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtflightid.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtflightid);
		txtflightid.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("FLIGHT NAME");
		ImageIcon img12=new ImageIcon(this.getClass().getResource("/airplane.png"));
		lblNewLabel_10.setIcon(img12);
		lblNewLabel_10.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_10.setBounds(623, 397, 160, 32);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("DEPART TIME");
		ImageIcon img13 =new ImageIcon(this.getClass().getResource("/boarding.png"));
		lblNewLabel_11.setIcon(img13);
		lblNewLabel_11.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_11.setBounds(623, 440, 160, 38);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("CLASS");
		ImageIcon img14 =new ImageIcon(this.getClass().getResource("/departures.png"));
		lblNewLabel_12.setIcon(img14);
		lblNewLabel_12.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_12.setBounds(623, 486, 139, 36);
		contentPane.add(lblNewLabel_12);
		
		JComboBox txtclass = new JComboBox();
		txtclass.setToolTipText("Select the class");
		txtclass.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtclass.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtclass.setModel(new DefaultComboBoxModel(new String[] {"Economy", "Business"}));
		txtclass.setBounds(791, 487, 160, 34);
		contentPane.add(txtclass);
		
		JLabel lblNewLabel_13 = new JLabel("PRICE");
		ImageIcon img15 =new ImageIcon(this.getClass().getResource("/ticket.png"));
		lblNewLabel_13.setIcon(img15);
		lblNewLabel_13.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_13.setBounds(623, 532, 139, 34);
		contentPane.add(lblNewLabel_13);
		
		txtprice = new JTextField();
		txtprice.setToolTipText("Enter price");
		txtprice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtprice.setEditable(false);
					JOptionPane.showMessageDialog(TicketBookingSection.this,"Enter Numbers Only");
					
				}else {
					txtprice.setEditable(true);		
				}
			}
		});
		txtprice.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtprice.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtprice.setBounds(793, 532, 160, 34);
		contentPane.add(txtprice);
		txtprice.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("SEATS");
		ImageIcon img16 =new ImageIcon(this.getClass().getResource("/seat.png"));
		lblNewLabel_14.setIcon(img16);
		lblNewLabel_14.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_14.setBounds(623, 574, 120, 41);
		contentPane.add(lblNewLabel_14);
		
		JSpinner txtseats = new JSpinner();
		txtseats.setToolTipText("Select the no. of seats");
		txtseats.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtseats.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtseats.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				int price = Integer.parseInt(txtprice.getText());
				int qty = Integer.parseInt(txtseats.getValue().toString());
				
				int total = price*qty;
				txttotal.setText(String.valueOf(total));			
			}
		});
		txtseats.setBounds(791, 577, 160, 34);
		contentPane.add(txtseats);
		
		JButton btnNewButton = new JButton("BOOK");
		btnNewButton.setToolTipText("Click to BOOK TICKET");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img18 =new ImageIcon(this.getClass().getResource("/online-booking.png"));
		btnNewButton.setIcon(img18);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    String id = txtticket.getText();
			    String flightid = txtflightid.getText();
			    String custid = txtcustid.getText();
				
				String flightclass= txtclass.getSelectedItem().toString().trim();
				String price = txtprice.getText();
			    String seats = txtseats.getValue().toString();
			    String dates = txtdate.getText();
			    
				try {
					Class.forName ("oracle.jdbc.driver.OracleDriver");
					Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pulkit");
					PreparedStatement pst = con.prepareStatement("select max(id) from ticket" );
		            
		           ResultSet rs = pst.executeQuery();
		            if(rs.next()) {
		               id1 = rs.getInt(1);
				       id1++;
					   txtticket.setText(Integer.toString(id1));
		            	
					pst = con.prepareStatement("insert into ticket(id,flightid,custid,flightclass,price,seats,dates) values(?,?,?,?,?,?,?)");
					pst.setInt(1,id1);
					pst.setString(2,flightid);
				    pst.setString(3,custid);
				    pst.setString(4,flightclass);
					pst.setString(5,price);
					pst.setString(6,seats);
				    pst.setString(7,dates);
					
					int k = pst.executeUpdate();
					
					if(k>0)
					{
						JOptionPane.showMessageDialog(TicketBookingSection.this,"Ticket Booked");
				        txtticket.setText(""); 
						txtflightid.setText("");
						txtcustid.setText("");
						txtclass.setSelectedIndex(-1);
						txtprice.setText("");
						txtseats.setValue("");
						txtdate.setText("");			
						
					}
					else
					{
						JOptionPane.showMessageDialog(TicketBookingSection.this,"Error");
					}
			}
				} catch (SQLException e1) {			
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton.setBounds(660, 648, 160, 44);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setToolTipText("Click to go back to worker section");
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img19 =new ImageIcon(this.getClass().getResource("/back.png"));
		btnNewButton_1.setIcon(img19);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WorkerSection w=new WorkerSection();
				TicketBookingSection.this.setVisible(false);
				w.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(867, 650, 151, 43);
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_15 = new JLabel("TICKET BOOKING SECTION");
		lblNewLabel_15.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel_15.setBounds(342, 14, 382, 38);
		contentPane.add(lblNewLabel_15);
		
		JButton btnNewButton_2 = new JButton("SEARCH");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String source = txtsource.getSelectedItem().toString().trim();
				String departure = txtdepart.getSelectedItem().toString().trim();
				
				try {
					Class.forName ("oracle.jdbc.driver.OracleDriver");
					Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pulkit");
					PreparedStatement pst = con.prepareStatement("select * from Flight where source=? and departure=?" );
					pst.setString(1, source);
					pst.setString(2, departure);
					ResultSet rs = pst.executeQuery();
					
					ResultSetMetaData rsm = rs.getMetaData();
					int c;
					c = rsm.getColumnCount();
					
					DefaultTableModel Df = (DefaultTableModel)table.getModel();
					Df.setRowCount(0);
					
					while(rs.next()) {
						Vector<String> v2 = new Vector<String>();
						
						for(int i=1; i<=c; i++) {
							v2.add(rs.getString("id"));
							v2.add(rs.getString("flightname"));
							v2.add(rs.getString("source"));
							v2.add(rs.getString("departure"));
							v2.add(rs.getString("ddate"));
							v2.add(rs.getString("departtime"));
							v2.add(rs.getString("arrtime"));
							v2.add(rs.getString("flightcharge"));
							
						}
						Df.addRow(v2);
					}
					
					
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				   catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setToolTipText("Click to search details");
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/transparency.png"));
		btnNewButton_2.setIcon(img5);
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_2.setBounds(248, 240, 151, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("SEARCH");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String id = txtcustid.getText();
				
				try {
					Class.forName ("oracle.jdbc.driver.OracleDriver");
					Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pulkit");
					PreparedStatement pst = con.prepareStatement("select * from Customer where id = ?" );
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next() == false)
					{
						JOptionPane.showMessageDialog(TicketBookingSection.this, "Record not found");
					}
					else
					{
						String fname = rs.getString("firstname");
						String lname = rs.getString("lastname");
						String passport = rs.getString("passport");
						
						txtfirstname.setText(fname.trim());
						txtlastname.setText(lname.trim());
						txtpassport.setText(passport.trim());	
						
						}
				} catch (SQLException e1) {
					e1.printStackTrace();
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
					
				}
				
			}
		});
		btnNewButton_3.setBounds(888, 91, 131, 40);
		btnNewButton_3.setToolTipText("Click to search details");
		btnNewButton_3.setForeground(Color.DARK_GRAY);
		btnNewButton_3.setBackground(SystemColor.inactiveCaption);
		btnNewButton_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img20 =new ImageIcon(this.getClass().getResource("/transparency.png"));
		btnNewButton_3.setIcon(img20);
		btnNewButton_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_18 = new JLabel("TOTAL PRICE");
		ImageIcon img21 =new ImageIcon(this.getClass().getResource("/price.png"));
		lblNewLabel_18.setIcon(img21);
		lblNewLabel_18.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel_18.setBounds(97, 638, 209, 34);
		contentPane.add(lblNewLabel_18);
		
		txttotal = new JTextField();
		txttotal.setToolTipText("Total price will be shown here");
		txttotal.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txttotal.setFont(new Font("Century Schoolbook", Font.ITALIC, 23));
		txttotal.setBounds(325, 636, 186, 38);
		contentPane.add(txttotal);
		txttotal.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("DATE");
		ImageIcon img17 =new ImageIcon(this.getClass().getResource("/calendar.png"));
		lblNewLabel_17.setIcon(img17);
		lblNewLabel_17.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_17.setBounds(942, 320, 86, 32);
		contentPane.add(lblNewLabel_17);
		
		txtdate = new JTextField();
		txtdate.setToolTipText("Enter date");
		txtdate.setBounds(932, 354, 110, 34);
		txtdate.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtdate.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		
		contentPane.add(txtdate);
		txtdate.setColumns(10);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(73, 619, 459, 71);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(new Color(0, 139, 139));
		panel_2.setBounds(602, 80, 450, 207);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(new Color(0, 139, 139));
		panel_3.setBounds(602, 303, 450, 328);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		txtdept = new JTextField();
		txtdept.setBounds(188, 143, 160, 34);
		panel_3.add(txtdept);
		txtdept.setToolTipText("Enter departure time");
		txtdept.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtdept.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtdept.setColumns(10);
		
		txtflightname = new JTextField();
		txtflightname.setBounds(188, 98, 160, 34);
		panel_3.add(txtflightname);
		txtflightname.setToolTipText("Enter Flightname");
		txtflightname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtflightname.setEditable(false);
					JOptionPane.showMessageDialog(TicketBookingSection.this,"Enter Aphabets Only");	
				}else {
					txtflightname.setEditable(true);		
				}
			}
		});
		txtflightname.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtflightname.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtflightname.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(23, 104, 553, 184);
		contentPane.add(panel);
	
		Toolkit toolkit = getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
		
	
	}
}
