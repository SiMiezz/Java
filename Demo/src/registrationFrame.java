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

import java.util.Date;
import java.text.DateFormat;
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

	public registrationFrame(Controller c) {
		theController=c;
		
		setTitle("REGISTRATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel pwdLbl = new JLabel("Password");
		pwdLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pwdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pwdLbl.setBounds(35, 198, 85, 25);
		contentPane.add(pwdLbl);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(130, 202, 174, 20);
		contentPane.add(pwdField);
		
		boxSceltaRegistration = new JComboBox();
		boxSceltaRegistration.setModel(new DefaultComboBoxModel(new String[] {"Studente", "Operatore"}));
		boxSceltaRegistration.setSelectedIndex(1);
		boxSceltaRegistration.setBounds(430, 159, 111, 20);
		contentPane.add(boxSceltaRegistration);
		
		txtNome = new JTextField();
		txtNome.setBounds(130, 26, 174, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setBounds(130, 57, 174, 20);
		contentPane.add(txtCognome);
		txtCognome.setColumns(10);
		
		JLabel nomeLbl = new JLabel("Nome");
		nomeLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		nomeLbl.setBounds(35, 24, 85, 20);
		contentPane.add(nomeLbl);
		
		JLabel cognomeLbl = new JLabel("Cognome");
		cognomeLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cognomeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cognomeLbl.setBounds(35, 57, 85, 17);
		contentPane.add(cognomeLbl);
		
		txtID = new JTextField();
		txtID.setBounds(130, 171, 174, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel idLbl = new JLabel("ID o Matricola");
		idLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idLbl.setHorizontalAlignment(SwingConstants.CENTER);
		idLbl.setBounds(10, 170, 110, 17);
		contentPane.add(idLbl);
		
		JButton btnRegistration = new JButton("REGISTRATI");
		btnRegistration.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String cognome = txtCognome.getText();
				String id = txtID.getText();
				String password = String.valueOf(pwdField.getPassword());
				String cf = txtCF.getText();
				
				if(c.registrazione(nome, cognome, id, password, cf)) {
					confirmRegistration();
				}
				else {
					alertRegistration();
				}
			}
		});
		btnRegistration.setBounds(416, 198, 141, 33);
		contentPane.add(btnRegistration);
		
		txtCF = new JTextField();
		txtCF.setBounds(130, 126, 174, 20);
		contentPane.add(txtCF);
		txtCF.setColumns(10);
		
		JLabel lblDataN = new JLabel("Data di nascita");
		lblDataN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataN.setBounds(10, 95, 110, 17);
		contentPane.add(lblDataN);
		
		JLabel lblCF = new JLabel("Codice Fiscale");
		lblCF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCF.setBounds(10, 127, 110, 14);
		contentPane.add(lblCF);
	}
	
	public void confirmRegistration() {
		JOptionPane.showMessageDialog(this, "Registrazione effettuata : " + boxSceltaRegistration.getSelectedItem());
	}
	
	public void alertRegistration() {
		JOptionPane.showMessageDialog(this, "Errore registrazione");
	}
}
