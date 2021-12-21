import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class loginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame frame = new loginFrame();
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
	public loginFrame() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textUser = new JTextField();
		textUser.setBounds(158, 89, 148, 26);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		textPwd = new JTextField();
		textPwd.setBounds(158, 148, 148, 26);
		contentPane.add(textPwd);
		textPwd.setColumns(10);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(54, 89, 73, 26);
		contentPane.add(lblUser);
		
		JLabel lblPwd = new JLabel("Password");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPwd.setBounds(54, 146, 73, 26);
		contentPane.add(lblPwd);
		
		JRadioButton btnOp = new JRadioButton("Operatore");
		btnOp.setBounds(208, 218, 109, 23);
		contentPane.add(btnOp);
		
		JRadioButton btnStud = new JRadioButton("Studente");
		btnStud.setBounds(208, 192, 109, 23);
		contentPane.add(btnStud);
		
		JButton btnGo = new JButton("Login");
		btnGo.setBounds(335, 120, 89, 23);
		contentPane.add(btnGo);
	}
}
