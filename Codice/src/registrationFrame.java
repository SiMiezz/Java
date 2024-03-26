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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Date;
import java.awt.Color;

public class registrationFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwdField;
	
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtID;
	private JTextField txtCF;
	private JComboBox boxSceltaRegistration;
	private JTextField txtData;
	Controller theController;
	
	public static Date tryParse(String text) {
		try {
			return Date.valueOf(text);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public registrationFrame(Controller c) {
		setResizable(false);
		theController=c;
		
		setTitle("REGISTRAZIONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPwd = new JLabel("Password");
		lblPwd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setBounds(109, 314, 120, 14);
		contentPane.add(lblPwd);
		
		pwdField = new JPasswordField();
		pwdField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPwd.setLabelFor(pwdField);
		pwdField.setBounds(239, 313, 150, 20);
		contentPane.add(pwdField);
		
		boxSceltaRegistration = new JComboBox();
		boxSceltaRegistration.setFont(new Font("Tahoma", Font.PLAIN, 12));
		boxSceltaRegistration.setModel(new DefaultComboBoxModel(new String[] {"Studente", "Operatore"}));
		boxSceltaRegistration.setSelectedIndex(1);
		boxSceltaRegistration.setBounds(289, 344, 100, 20);
		contentPane.add(boxSceltaRegistration);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(239, 132, 150, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCognome.setBounds(239, 163, 150, 20);
		contentPane.add(txtCognome);
		txtCognome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setLabelFor(txtNome);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(109, 133, 120, 14);
		contentPane.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setLabelFor(txtCognome);
		lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setBounds(109, 162, 120, 18);
		contentPane.add(lblCognome);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtID.setBounds(239, 282, 150, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblId = new JLabel("ID o Matricola");
		lblId.setLabelFor(txtID);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(109, 283, 120, 14);
		contentPane.add(lblId);
		
		JButton btnRegistration = new JButton("REGISTRATI");
		btnRegistration.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtNome.getText().isBlank() && !txtCognome.getText().isBlank() && !txtID.getText().isBlank() && !pwdField.getPassword().toString().isBlank() && !txtCF.getText().isBlank()) {
					String nome = txtNome.getText();
					String cognome = txtCognome.getText();
					String id = txtID.getText();
					String password = String.valueOf(pwdField.getPassword());
					String cf = txtCF.getText();
					Date data = tryParse(txtData.getText());
					String scelta = (String) boxSceltaRegistration.getSelectedItem();
					
					if(c.registrazione(nome, cognome, id, password, cf, data, scelta)) {
						c.confirmRegistration(scelta);
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
		btnRegistration.setBounds(449, 415, 150, 35);
		contentPane.add(btnRegistration);
		
		txtCF = new JTextField();
		txtCF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCF.setBounds(239, 251, 150, 20);
		contentPane.add(txtCF);
		txtCF.setColumns(10);
		
		JLabel lblDataN = new JLabel("Data di nascita");
		lblDataN.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataN.setBounds(109, 223, 120, 14);
		contentPane.add(lblDataN);
		
		JLabel lblCF = new JLabel("Codice Fiscale");
		lblCF.setLabelFor(txtCF);
		lblCF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCF.setBounds(109, 252, 120, 14);
		contentPane.add(lblCF);
		
		txtData = new JTextField();
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataN.setLabelFor(txtData);
		txtData.setBounds(239, 220, 150, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblInserimentoData = new JLabel("[yyyy-mm-dd]");
		lblInserimentoData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInserimentoData.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserimentoData.setBounds(239, 191, 150, 18);
		contentPane.add(lblInserimentoData);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(Color.BLUE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.backLogin();
			}
		});
		btnLogin.setBounds(10, 421, 100, 25);
		contentPane.add(btnLogin);
		
		JLabel lblRegistratiTiltle = new JLabel("REGISTRAZIONE");
		lblRegistratiTiltle.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistratiTiltle.setForeground(Color.RED);
		lblRegistratiTiltle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistratiTiltle.setBounds(10, 11, 589, 28);
		contentPane.add(lblRegistratiTiltle);
		
		JLabel lblDati = new JLabel("Inserisci i seguenti dati:");
		lblDati.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDati.setForeground(Color.BLUE);
		lblDati.setHorizontalAlignment(SwingConstants.CENTER);
		lblDati.setBounds(148, 92, 241, 20);
		contentPane.add(lblDati);
		
		JLabel lblBack = new JLabel("Effettua Login");
		lblBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBack.setForeground(Color.BLUE);
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setBounds(10, 396, 100, 14);
		contentPane.add(lblBack);
		

	}
}
