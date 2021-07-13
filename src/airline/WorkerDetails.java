package airline;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class WorkerDetails extends JFrame {

	private JPanel contentPane;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkerDetails frame = new WorkerDetails();
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
	public WorkerDetails() {
		setUndecorated(true);
		Connect();
	    WorkerDetails_Load();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 429);
		contentPane = new JPanel();
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
					WorkerDetails.this.setLocation(x-xx, y-xy);
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
		lblNewLabel.setBounds(648, 11, 37, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LOAD");
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setToolTipText("load the table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from worker";
		            pst = con.prepareStatement(query);
		            rs = pst.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
		            	
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(542, 140, 124, 45);
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/loading.png"));
		btnNewButton.setIcon(img3);
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setToolTipText("go back to admin section frame");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminSection a=new AdminSection();
				a.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(542, 249, 124, 39);
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/back.png"));
		btnNewButton_1.setIcon(img4);
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("TABLE");
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(25, 82, 507, 320);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("WORKER DETAILS");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel_1.setBounds(172, 23, 310, 33);
		contentPane.add(lblNewLabel_1);
		
	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTable table;
	
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
	
	public void WorkerDetails_Load() {
		
		try {
			
			Statement st= con.createStatement();
			rs=st.executeQuery("select * from worker");
	         	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	

