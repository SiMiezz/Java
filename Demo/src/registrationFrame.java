import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.text.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class registrationFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwdField;
	
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtID;
	private JTextField txtCF;
	private JComboBox boxSceltaRegistration;
	
	public JComboBox getBoxSceltaRegistration() {
		return boxSceltaRegistration;
	}

	public void setBoxSceltaRegistration(JComboBox boxSceltaRegistration) {
		this.boxSceltaRegistration = boxSceltaRegistration;
	}

	Controller theController;
	private JTextField txtData;
	private JLabel lblNewLabel;
	private JButton btnLogin;

	public registrationFrame(Controller c) {
		theController=c;
		
		setTitle("REGISTRATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel pwdLbl = new JLabel("Password");
		pwdLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pwdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pwdLbl.setBounds(85, 232, 120, 14);
		contentPane.add(pwdLbl);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(215, 231, 150, 20);
		contentPane.add(pwdField);
		
		boxSceltaRegistration = new JComboBox();
		boxSceltaRegistration.setModel(new DefaultComboBoxModel(new String[] {"Studente", "Operatore"}));
		boxSceltaRegistration.setSelectedIndex(1);
		boxSceltaRegistration.setBounds(455, 284, 100, 20);
		contentPane.add(boxSceltaRegistration);
		
		txtNome = new JTextField();
		txtNome.setBounds(215, 51, 150, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setBounds(215, 82, 150, 20);
		contentPane.add(txtCognome);
		txtCognome.setColumns(10);
		
		JLabel nomeLbl = new JLabel("Nome");
		nomeLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nomeLbl.setBounds(85, 52, 120, 14);
		contentPane.add(nomeLbl);
		
		JLabel cognomeLbl = new JLabel("Cognome");
		cognomeLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cognomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cognomeLbl.setBounds(85, 81, 120, 18);
		contentPane.add(cognomeLbl);
		
		txtID = new JTextField();
		txtID.setBounds(215, 200, 150, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel idLbl = new JLabel("ID o Matricola");
		idLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idLbl.setHorizontalAlignment(SwingConstants.CENTER);
		idLbl.setBounds(85, 201, 120, 14);
		contentPane.add(idLbl);
		
		JButton btnRegistration = new JButton("REGISTRATI");
		btnRegistration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtNome.getText().isBlank() && !txtCognome.getText().isBlank() && !txtID.getText().isBlank() && !pwdField.getPassword().toString().isBlank() && !txtCF.getText().isBlank()) {
					String nome = txtNome.getText();
					String cognome = txtCognome.getText();
					String id = txtID.getText();
					String password = String.valueOf(pwdField.getPassword());
					String cf = txtCF.getText();
					Date data = Date.valueOf(txtData.getText());
					
					if(c.registrazione(nome, cognome, id, password, cf, data)) {
						c.confirmRegistration();
					}
					else {
						c.alertRegistration();
					}
				}
				else {
					c.alertRegistration();
				}
				
				txtNome.setText(null);
				txtCognome.setText(null);
				txtID.setText(null);
				pwdField.setText(null);
				txtCF.setText(null);
				txtData.setText(null);
			}
		});
		btnRegistration.setBounds(434, 315, 140, 35);
		contentPane.add(btnRegistration);
		
		txtCF = new JTextField();
		txtCF.setBounds(215, 169, 150, 20);
		contentPane.add(txtCF);
		txtCF.setColumns(10);
		
		JLabel lblDataN = new JLabel("Data di nascita");
		lblDataN.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataN.setBounds(85, 139, 120, 14);
		contentPane.add(lblDataN);
		
		JLabel lblCF = new JLabel("Codice Fiscale");
		lblCF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCF.setBounds(85, 170, 120, 14);
		contentPane.add(lblCF);
		
		txtData = new JTextField();
		txtData.setBounds(215, 138, 150, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		lblNewLabel = new JLabel("yyyy-mm-dd");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(215, 113, 150, 18);
		contentPane.add(lblNewLabel);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.backLogin();
			}
		});
		btnLogin.setBounds(10, 325, 80, 25);
		contentPane.add(btnLogin);
	}
	

}
