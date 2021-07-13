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

public class WorkerSection extends JFrame {
	
	private JPanel contentPane;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkerSection frame = new WorkerSection();
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
	public WorkerSection() 
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 415);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
			int x=arg0.getXOnScreen();
			int y=arg0.getYOnScreen();
			WorkerSection.this.setLocation(x-xx, y-xy);
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
		
		JButton btnNewButton = new JButton("CUSTOMER");
		btnNewButton.setToolTipText("click here for Customer Section");
		btnNewButton.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/Customer1.png"));
		btnNewButton.setIcon(img1);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CustomerSection c = new CustomerSection();
				WorkerSection.this.setVisible(false);
				c.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(50, 125, 196, 47);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("FLIGHT");
		btnNewButton_1.setToolTipText("click here for flight section");
		btnNewButton_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/airplane.png"));
		btnNewButton_1.setIcon(img2);
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(SystemColor.inactiveCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FlightSection f = new FlightSection();
				WorkerSection.this.setVisible(false);
				f.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(50, 220, 196, 47);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("TICKET BOOKING");
		btnNewButton_2.setToolTipText("click here for Ticket Booking Section");
		btnNewButton_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img3 =new ImageIcon(this.getClass().getResource("/ticket-booking.png"));
		btnNewButton_2.setIcon(img3);
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TicketBookingSection t = new TicketBookingSection();
				WorkerSection.this.setVisible(false);
				t.setVisible(true);	
				
			}
			
		});
		btnNewButton_2.setBounds(321, 125, 215, 47);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("TICKET REPORT");
		btnNewButton_3.setToolTipText("click here for Viewing ticket report");
		btnNewButton_3.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img4 =new ImageIcon(this.getClass().getResource("/report.png"));
		btnNewButton_3.setIcon(img4);
		btnNewButton_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_3.setBackground(SystemColor.inactiveCaption);
		btnNewButton_3.setForeground(Color.DARK_GRAY);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TicketReport r = new TicketReport();
				WorkerSection.this.setVisible(false);
				r.setVisible(true);
				
			}
		});
		btnNewButton_3.setBounds(321, 220, 215, 47);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_7 = new JButton("LOGOUT");
		btnNewButton_7.setToolTipText("Click here for logout");
		btnNewButton_7.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		ImageIcon img8 =new ImageIcon(this.getClass().getResource("/MainPic8.png"));
		btnNewButton_7.setIcon(img8);
		btnNewButton_7.setForeground(Color.DARK_GRAY);
		btnNewButton_7.setBackground(SystemColor.inactiveCaption);
		btnNewButton_7.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    WorkerLogin w = new WorkerLogin();
				WorkerSection.this.setVisible(false);
				w.setVisible(true);
				
			}	
		});
		btnNewButton_7.setBounds(201, 312, 183, 47);
		contentPane.add(btnNewButton_7);
		
		JLabel lblNewLabel = new JLabel("WORKER SECTION");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(157, 31, 301, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Close");
		lblNewLabel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
				public void mouseDragged(MouseEvent arg0){
					int x=arg0.getXOnScreen();
					int y=arg0.getYOnScreen();
					WorkerSection.this.setLocation(x-xx, y-xy);
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
		lblNewLabel_1.setBounds(520, 11, 36, 47);
		contentPane.add(lblNewLabel_1);
		
		
		
		
	}
}
