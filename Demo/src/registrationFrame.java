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
import java.awt.Color;
import javax.swing.JToggleButton;

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
	
	public JComboBox getBoxSceltaRegistration() {
		return boxSceltaRegistration;
	}

	public void setBoxSceltaRegistration(JComboBox boxSceltaRegistration) {
		this.boxSceltaRegistration = boxSceltaRegistration;
	}
	
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
		setBounds(100, 100, 600, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel pwdLbl = new JLabel("Password");
		pwdLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pwdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pwdLbl.setBounds(105, 280, 120, 14);
		contentPane.add(pwdLbl);
		
		pwdField = new JPasswordField();
		pwdLbl.setLabelFor(pwdField);
		pwdField.setBounds(235, 279, 150, 20);
		contentPane.add(pwdField);
		
		boxSceltaRegistration = new JComboBox();
		boxSceltaRegistration.setModel(new DefaultComboBoxModel(new String[] {"Studente", "Operatore"}));
		boxSceltaRegistration.setSelectedIndex(1);
		boxSceltaRegistration.setBounds(285, 310, 100, 20);
		contentPane.add(boxSceltaRegistration);
		
		txtNome = new JTextField();
		txtNome.setBounds(235, 123, 150, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setBounds(235, 154, 150, 20);
		contentPane.add(txtCognome);
		txtCognome.setColumns(10);
		
		JLabel nomeLbl = new JLabel("Nome");
		nomeLbl.setLabelFor(txtNome);
		nomeLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nomeLbl.setBounds(105, 124, 120, 14);
		contentPane.add(nomeLbl);
		
		JLabel cognomeLbl = new JLabel("Cognome");
		cognomeLbl.setLabelFor(txtCognome);
		cognomeLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cognomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cognomeLbl.setBounds(105, 153, 120, 18);
		contentPane.add(cognomeLbl);
		
		txtID = new JTextField();
		txtID.setBounds(235, 248, 150, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel idLbl = new JLabel("ID o Matricola");
		idLbl.setLabelFor(txtID);
		idLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idLbl.setHorizontalAlignment(SwingConstants.CENTER);
		idLbl.setBounds(105, 249, 120, 14);
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
					Date data = tryParse(txtData.getText());
					
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
		btnRegistration.setBounds(424, 390, 150, 35);
		contentPane.add(btnRegistration);
		
		txtCF = new JTextField();
		txtCF.setBounds(235, 217, 150, 20);
		contentPane.add(txtCF);
		txtCF.setColumns(10);
		
		JLabel lblDataN = new JLabel("Data di nascita");
		lblDataN.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataN.setBounds(105, 187, 120, 14);
		contentPane.add(lblDataN);
		
		JLabel lblCF = new JLabel("Codice Fiscale");
		lblCF.setLabelFor(txtCF);
		lblCF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCF.setBounds(105, 218, 120, 14);
		contentPane.add(lblCF);
		
		txtData = new JTextField();
		lblDataN.setLabelFor(txtData);
		txtData.setBounds(235, 186, 150, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblInserimentoData = new JLabel("(yyyy-mm-dd)");
		lblInserimentoData.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblInserimentoData.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserimentoData.setBounds(395, 185, 150, 18);
		contentPane.add(lblInserimentoData);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.backLogin();
			}
		});
		btnLogin.setBounds(10, 396, 100, 25);
		contentPane.add(btnLogin);
		
		JLabel lblRegistratiTiltle = new JLabel("REGISTRAZIONE");
		lblRegistratiTiltle.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistratiTiltle.setForeground(Color.RED);
		lblRegistratiTiltle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistratiTiltle.setBounds(10, 11, 564, 28);
		contentPane.add(lblRegistratiTiltle);
		
		JLabel lblDati = new JLabel("Inserisci i seguenti dati:");
		lblDati.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDati.setForeground(Color.BLUE);
		lblDati.setHorizontalAlignment(SwingConstants.CENTER);
		lblDati.setBounds(144, 83, 241, 20);
		contentPane.add(lblDati);
		
		JLabel lblBack = new JLabel("Effettua Login");
		lblBack.setForeground(Color.BLUE);
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setBounds(10, 371, 100, 14);
		contentPane.add(lblBack);
		

	}
}
