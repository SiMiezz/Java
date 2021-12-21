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
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField pwdField;
	
	Controller theController;

	public loginFrame(Controller c) {
		theController=c;
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textUser = new JTextField();
		textUser.setBounds(158, 81, 148, 26);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblUser = new JLabel("USER");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(54, 79, 73, 26);
		contentPane.add(lblUser);
		
		JLabel lblPwd = new JLabel("Password");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPwd.setBounds(54, 120, 73, 26);
		contentPane.add(lblPwd);
		
		JRadioButton btnOp = new JRadioButton("Operatore");
		btnOp.setBounds(197, 196, 109, 23);
		contentPane.add(btnOp);
		
		JRadioButton btnStud = new JRadioButton("Studente");
		btnStud.setBounds(197, 170, 109, 23);
		contentPane.add(btnStud);
		
		JButton btnGo = new JButton("Login");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textUser.getText();
				String pwd = String.valueOf(pwdField.getPassword());
				
				if(c.checkUser(user, pwd)==true) {
					System.out.println("login effettuato");
				}
			}
		});
		btnGo.setBounds(335, 102, 89, 23);
		contentPane.add(btnGo);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(158, 122, 148, 26);
		contentPane.add(pwdField);
	}
}
