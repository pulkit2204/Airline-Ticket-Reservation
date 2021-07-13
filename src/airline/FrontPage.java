package airline;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class FrontPage extends JFrame {

	private JPanel contentPane;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontPage frame = new FrontPage();
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
	public FrontPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 139, 139));
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x=arg0.getXOnScreen();
				int y=arg0.getYOnScreen();
				FrontPage.this.setLocation(x-xx, y-xy);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx=e.getX();
				xy=e.getY();
			}
		});
		panel.setBounds(0, 0, 521, 543);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Toolkit toolkit = getToolkit();
		Dimension size=toolkit.getScreenSize();
		setLocation(size.width/2-getWidth()/2,size.height/2-getHeight()/2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(240, 248, 255));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(255, 255, 255)));
		lblNewLabel.setBounds(116, 134, 277, 292);
		panel.add(lblNewLabel);
		ImageIcon img =new ImageIcon(this.getClass().getResource("/aeroplane.png"));
		lblNewLabel.setIcon(img);
		
		JLabel lblNewLabel_1 = new JLabel("AIRLINE RESERVATION SYSTEM");
		lblNewLabel_1.setForeground(new Color(245, 222, 179));
		lblNewLabel_1.setBorder(new MatteBorder(9, 9, 9, 9, (Color) new Color(255, 255, 255)));
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(25, 52, 457, 71);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.setToolTipText("Click to ENTER");
		ImageIcon img1 =new ImageIcon(this.getClass().getResource("/FrontPage.png"));
		btnNewButton.setIcon(img1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage p = new MainPage();
				FrontPage.this.setVisible(false);
				p.setVisible(true);

			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		btnNewButton.setBackground(new Color(255, 99, 71));
		btnNewButton.setBorder(new MatteBorder(6, 6, 6, 6, (Color) new Color(255, 255, 255)));
		btnNewButton.setBounds(154, 444, 202, 71);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setToolTipText("Close");
		ImageIcon img2 =new ImageIcon(this.getClass().getResource("/close.png"));
		lblNewLabel_2.setIcon(img2);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_2.setBorder(null);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(479, 11, 32, 41);
		panel.add(lblNewLabel_2);
		
		setUndecorated(true);
		
		
		
		
	}
}
