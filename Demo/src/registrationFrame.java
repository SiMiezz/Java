import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class registrationFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField pwdField;
	
	Controller theController;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField textField;

	public registrationFrame(Controller c) {
		theController=c;
		setTitle("REGISTRATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usrLbl = new JLabel("USER");
		usrLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usrLbl.setHorizontalAlignment(SwingConstants.CENTER);
		usrLbl.setBounds(35, 45, 85, 25);
		contentPane.add(usrLbl);
		
		JLabel pwdLbl = new JLabel("PASSWORD");
		pwdLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pwdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pwdLbl.setBounds(35, 76, 85, 25);
		contentPane.add(pwdLbl);
		
		txtUser = new JTextField();
		txtUser.setBounds(130, 49, 174, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(130, 80, 174, 20);
		contentPane.add(pwdField);
		
		JComboBox boxSceltaRegistration = new JComboBox();
		boxSceltaRegistration.setModel(new DefaultComboBoxModel(new String[] {"Studente", "Operatore"}));
		boxSceltaRegistration.setSelectedIndex(1);
		boxSceltaRegistration.setBounds(154, 11, 111, 20);
		contentPane.add(boxSceltaRegistration);
		
		txtNome = new JTextField();
		txtNome.setBounds(130, 124, 174, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setBounds(130, 155, 174, 20);
		contentPane.add(txtCognome);
		txtCognome.setColumns(10);
		
		JLabel nomeLbl = new JLabel("Nome");
		nomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nomeLbl.setBounds(35, 127, 85, 20);
		contentPane.add(nomeLbl);
		
		JLabel cognomeLbl = new JLabel("Cognome");
		cognomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cognomeLbl.setBounds(35, 158, 85, 17);
		contentPane.add(cognomeLbl);
		
		textField = new JTextField();
		textField.setBounds(130, 186, 174, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel cfLbl = new JLabel("Codice Fiscale");
		cfLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cfLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cfLbl.setBounds(10, 186, 110, 17);
		contentPane.add(cfLbl);
		
		JButton btnRegistration = new JButton("Registrati");
		btnRegistration.setBounds(398, 338, 127, 25);
		contentPane.add(btnRegistration);
	}
}
