import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class loginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JPasswordField pwdField;
	private JComboBox BoxSceltaLogin;
	
	public JComboBox getBoxSceltaLogin() {
		return BoxSceltaLogin;
	}

	public void setBoxSceltaLogin(JComboBox boxSceltaLogin) {
		BoxSceltaLogin = boxSceltaLogin;
	}

	private Controller theController;

	public loginFrame(Controller c) {
		theController=c;
		
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textID = new JTextField();
		textID.setBounds(171, 94, 148, 22);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lblID = new JLabel("ID/MATRICOLA");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID.setBounds(45, 90, 117, 26);
		contentPane.add(lblID);
		
		JLabel lblPwd = new JLabel("PASSWORD");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPwd.setBounds(55, 123, 107, 26);
		contentPane.add(lblPwd);
		
		JButton btnGo = new JButton("LOGIN");
		btnGo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textID.getText();
				String pwd = String.valueOf(pwdField.getPassword());
				
				if(c.checkUser(id, pwd)) {
					c.confirmLogin();
				}
				else {
					c.alertLogin();
				}
				
			}
		});
		btnGo.setBounds(348, 267, 126, 33);
		contentPane.add(btnGo);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(171, 127, 148, 22);
		contentPane.add(pwdField);
		
		BoxSceltaLogin = new JComboBox();
		BoxSceltaLogin.setBackground(Color.WHITE);
		BoxSceltaLogin.setModel(new DefaultComboBoxModel(new String[] {"Studente", "Operatore"}));
		BoxSceltaLogin.setToolTipText("");
		BoxSceltaLogin.setEditable(true);
		BoxSceltaLogin.setBounds(356, 234, 106, 22);
		contentPane.add(BoxSceltaLogin);
		
		JButton btnRegistrati = new JButton("REGISTRATI");
		btnRegistrati.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.goRegistrazioneFrame();
			}
		});
		btnRegistrati.setBounds(10, 276, 118, 24);
		contentPane.add(btnRegistrati);
	}
	
	
}
