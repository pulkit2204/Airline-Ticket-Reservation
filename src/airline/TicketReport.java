package airline;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.MatteBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class TicketReport extends JFrame {

	private JPanel contentPane;
	private JTable table;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketReport frame = new TicketReport();
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
	public TicketReport() {
		setUndecorated(true);
		Connect();
		TicketDetails_Load();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 451);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Toolkit toolkit = getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("Close");
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
				public void mouseDragged(MouseEvent arg0) {
					int x=arg0.getXOnScreen();
					int y=arg0.getYOnScreen();
					TicketReport.this.setLocation(x-xx, y-xy);
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
		ImageIcon img5 =new ImageIcon(this.getClass().getResource("/close.png"));
		lblNewLabel.setIcon(img5);
		lblNewLabel.setBounds(720, 11, 37, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LOAD");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setToolTipText("load the table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from Ticket";
		            pst = con.prepareStatement(query);
		            rs = pst.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            	
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(621, 151, 124, 45);
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/loading.png"));
		btnNewButton.setIcon(img3);
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setToolTipText("go back to worker section frame");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				WorkerSection w=new WorkerSection();
				w.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(621, 260, 124, 39);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/back.png"));
		btnNewButton_1.setIcon(img4);
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("TABLE");
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(26, 77, 585, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("TICKET REPORT");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel_1.setBounds(172, 30, 254, 33);
		contentPane.add(lblNewLabel_1);
	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
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
	
	public void TicketDetails_Load() {
		
		try {
			
			Statement st= con.createStatement();
			rs=st.executeQuery("select * from Ticket");
	         	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	

