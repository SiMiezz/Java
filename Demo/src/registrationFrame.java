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

public class registrationFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwdField;
	
	Controller theController;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtID;

	public registrationFrame(Controller c) {
		
		theController=c;
		
		
		setTitle("REGISTRATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel pwdLbl = new JLabel("Password");
		pwdLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pwdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pwdLbl.setBounds(35, 122, 85, 25);
		contentPane.add(pwdLbl);
		
		
		
		pwdField = new JPasswordField();
		pwdField.setBounds(130, 126, 174, 20);
		contentPane.add(pwdField);
		
		
		
		JComboBox boxSceltaRegistration = new JComboBox();
		boxSceltaRegistration.setModel(new DefaultComboBoxModel(new String[] {"Studente", "Operatore"}));
		boxSceltaRegistration.setSelectedIndex(1);
		boxSceltaRegistration.setBounds(390, 26, 111, 20);
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
		txtID.setBounds(130, 94, 174, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel idLbl = new JLabel("ID o Matricola");
		idLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idLbl.setHorizontalAlignment(SwingConstants.CENTER);
		idLbl.setBounds(10, 94, 110, 17);
		contentPane.add(idLbl);
		
		JButton btnRegistration = new JButton("Registrati");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String strNome = txtNome.getText();
				String strCognome = txtCognome.getText();
				String id = txtID.getText();
				String Password = String.valueOf(pwdField.getPassword());
				
				
			}
		});
		btnRegistration.setBounds(384, 76, 127, 25);
		contentPane.add(btnRegistration);
	}
}
