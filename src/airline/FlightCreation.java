package airline;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FlightCreation extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	
	private JTextField txtflightname;
	private JComboBox txtsource;
	private JComboBox txtdepart;
	private JTextField txtdate;
	private JTextField txtdtime;
	private JTextField txtartime;
	private JTextField txtflightcharge;
	
	int xx, xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightCreation frame = new FlightCreation();
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
	
	int id1 = 0;
	
	public FlightCreation() {
		setUndecorated(true);
		Connect();
		flight_Load();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 393);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			int x=arg0.getXOnScreen();
			int y=arg0.getYOnScreen();
			FlightCreation.this.setLocation(x-xx, y-xy);
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
		
		JLabel lblNewLabel = new JLabel("FLIGHT ID");
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/identification (1).png"));
		lblNewLabel.setIcon(img1);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(35, 94, 119, 20);
		contentPane.add(lblNewLabel);
		
		txtid = new JTextField();
		txtid.setToolTipText("Enter Flight ID");
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtid.setEditable(false);
					JOptionPane.showMessageDialog(FlightCreation.this,"Enter Numbers Only");
					
				}else {
					txtid.setEditable(true);		
				}
			}
		});
		txtid.setBounds(195, 90, 169, 29);
		txtid.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtid.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("FLIGHT NAME");
		ImageIcon img=new ImageIcon(this.getClass().getResource("/airplane.png"));
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(35, 143, 150, 29);
		contentPane.add(lblNewLabel_1);
		
		txtflightname = new JTextField();
		txtflightname.setToolTipText("Enter Flightname");
		txtflightname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt1) {
				char n=evt1.getKeyChar();
				if(Character.isDigit(n))
				{
					txtflightname.setEditable(false);
					JOptionPane.showMessageDialog(FlightCreation.this,"Enter Aphabets Only");	
				}else {
					txtflightname.setEditable(true);		
				}
			}
		});
		txtflightname.setBounds(195, 143, 169, 29);
		txtflightname.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtflightname.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtflightname);
		txtflightname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("SOURCE");
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/flight.png"));
		lblNewLabel_2.setIcon(img2);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(35, 187, 119, 38);
		contentPane.add(lblNewLabel_2);
		
		txtsource = new JComboBox();
		txtsource.setToolTipText("Select the source");
		txtsource.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtsource.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtsource.setModel(new DefaultComboBoxModel(new String[] {"India", "Srilanka", "UK", "USA", "Canada", "China"}));
		txtsource.setBounds(195, 193, 166, 32);
		contentPane.add(txtsource);
		
		JLabel lblNewLabel_3 = new JLabel("DEPARTURE");
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/departures.png"));
		lblNewLabel_3.setIcon(img3);
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(35, 237, 138, 39);
		contentPane.add(lblNewLabel_3);
		
		txtdepart = new JComboBox();
		txtdepart.setToolTipText("Select the departure");
		txtdepart.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtdepart.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		txtdepart.setModel(new DefaultComboBoxModel(new String[] {"India", "Srilanka", "UK", "USA", "Canada", "China"}));
		txtdepart.setBounds(195, 240, 169, 32);
		contentPane.add(txtdepart);
		
		JLabel lblNewLabel_4 = new JLabel("DATE");
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/calendar.png"));
		lblNewLabel_4.setIcon(img4);
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setBounds(400, 90, 89, 29);
		contentPane.add(lblNewLabel_4);
		
		txtdate = new JTextField();
		txtdate.setToolTipText("Enter date");
		txtdate.setBounds(573, 90, 169, 29);
		txtdate.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtdate.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtdate);
		txtdate.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("DEP TIME");
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/boarding.png"));
		lblNewLabel_5.setIcon(img5);
		lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setBounds(401, 143, 120, 29);
		contentPane.add(lblNewLabel_5);
		
		txtdtime = new JTextField();
		txtdtime.setToolTipText("Enter departure time");
		txtdtime.setBounds(573, 143, 169, 29);
		txtdtime.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtdtime.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtdtime);
		txtdtime.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("ARR TIME");
		ImageIcon img6 =new ImageIcon(this.getClass().getResource("/arrival.png"));
		lblNewLabel_6.setIcon(img6);
		lblNewLabel_6.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_6.setBounds(400, 192, 121, 33);
		contentPane.add(lblNewLabel_6);
		
		txtartime = new JTextField();
		txtartime.setToolTipText("Enter arrival time");
		txtartime.setBounds(573, 192, 169, 29);
		txtartime.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtartime.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtartime);
		txtartime.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("FLIGHT CHARGE");
		ImageIcon img7 =new ImageIcon(this.getClass().getResource("/ticket.png"));
		lblNewLabel_7.setIcon(img7);
		lblNewLabel_7.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_7.setBounds(400, 242, 175, 34);
		contentPane.add(lblNewLabel_7);
		
		txtflightcharge = new JTextField();
		txtflightcharge.setToolTipText("Enter Flight Charge");
		txtflightcharge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c))
				{
					txtflightcharge.setEditable(false);
					JOptionPane.showMessageDialog(FlightCreation.this,"Enter Numbers Only");
					
				}else {
					txtflightcharge.setEditable(true);		
				}
			}
		});
		txtflightcharge.setBounds(573, 247, 169, 29);
		txtflightcharge.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		txtflightcharge.setFont(new Font("Century Schoolbook", Font.ITALIC, 18));
		contentPane.add(txtflightcharge);
		txtflightcharge.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.setToolTipText("Click to add details");
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img10 =new ImageIcon(this.getClass().getResource("/add.png"));
		btnNewButton_2.setIcon(img10);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String flightname = txtflightname.getText();
				String source = txtsource.getSelectedItem().toString().trim();
				String departure = txtdepart.getSelectedItem().toString().trim();
				String ddate = txtdate.getText();
				String departtime = txtdtime.getText();
				String arrtime = txtartime.getText();
				String flightcharge = txtflightcharge.getText();
				
				try {
					String query="select max(id) from Flight";
		            pst = con.prepareStatement(query);
		            rs = pst.executeQuery();
		            if(rs.next()) {
		            	id1 = rs.getInt(1);
						id1++;
						txtid.setText(Integer.toString(id1));
		            	
					pst = con.prepareStatement("insert into Flight(id,flightname,source,departure,ddate,departtime,arrtime,flightcharge) values(?,?,?,?,?,?,?,?)");
					pst.setInt(1,id1);
					pst.setString(2,flightname);
					pst.setString(3,source);
					pst.setString(4,departure);
					pst.setString(5,ddate);
					pst.setString(6,departtime);
					pst.setString(7,arrtime);
					pst.setString(8,flightcharge);
					
					int k = pst.executeUpdate();
					
					if(k>0)
					{
						JOptionPane.showMessageDialog(FlightCreation.this,"Flight Created");
						txtid.setText(""); 
						txtflightname.setText("");
						txtsource.setSelectedIndex(-1);
						txtdepart.setSelectedIndex(-1);
						txtdate.setText("");
						txtdtime.setText("");
						txtartime.setText("");
						txtflightcharge.setText("");
						txtflightname.requestFocus();
					}
					else
					{
						JOptionPane.showMessageDialog(FlightCreation.this,"Error");
					}}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(137, 314, 150, 44);
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setToolTipText("Click to go back to flight section");
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img11 =new ImageIcon(this.getClass().getResource("/back.png"));
		btnNewButton_1.setIcon(img11);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FlightSection f=new FlightSection();
				FlightCreation.this.setVisible(false);
				f.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_1.setBounds(505, 314, 145, 44);
		contentPane.add(btnNewButton_1);
		
		btnNewButton = new JButton("VIEW TABLE");
		btnNewButton.setToolTipText("Click to view table");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img13 =new ImageIcon(this.getClass().getResource("/view.png"));
		btnNewButton.setIcon(img13);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightDetails c=new FlightDetails();
				FlightCreation.this.setVisible(false);
				c.setVisible(true);
			}
		});
		btnNewButton.setBounds(315, 314, 163, 44);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton);
		
		lblNewLabel_8 = new JLabel("NEW FLIGHT");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel_8.setBounds(298, 23, 191, 34);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setToolTipText("Close");
		lblNewLabel_9.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
				public void mouseDragged(MouseEvent arg0) {
					int x=arg0.getXOnScreen();
					int y=arg0.getYOnScreen();
			        FlightCreation.this.setLocation(x-xx, y-xy);
			}
		});
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
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
		lblNewLabel_9.setIcon(img12);
		lblNewLabel_9.setBounds(726, 11, 32, 34);
		contentPane.add(lblNewLabel_9);
		
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JButton btnNewButton;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	
	
	
	public void Connect(){		
		try{
			Class.forName ("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","pulkit");
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public void flight_Load() {	
		try {
			
			Statement st= con.createStatement();
			rs=st.executeQuery("select * from Flight");
	         	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
