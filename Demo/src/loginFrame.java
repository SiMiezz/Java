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
		textID.setBounds(158, 81, 148, 26);
		contentPane.add(textID);
		textID.setColumns(10);
		
		JLabel lblID = new JLabel("ID/MATRICOLA");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID.setBounds(31, 79, 117, 26);
		contentPane.add(lblID);
		
		JLabel lblPwd = new JLabel("PASSWORD");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPwd.setBounds(41, 120, 107, 26);
		contentPane.add(lblPwd);
		
		JButton btnGo = new JButton("LOGIN");
		btnGo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textID.getText();
				String pwd = String.valueOf(pwdField.getPassword());
				
				if(c.checkUser(id, pwd)) {
					confirmLogin();
				}
				else {
					alertLogin();
				}
				
			}
		});
		btnGo.setBounds(354, 259, 106, 26);
		contentPane.add(btnGo);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(158, 122, 148, 26);
		contentPane.add(pwdField);
		
		BoxSceltaLogin = new JComboBox();
		BoxSceltaLogin.setBackground(Color.WHITE);
		BoxSceltaLogin.setModel(new DefaultComboBoxModel(new String[] {"Studente", "Operatore"}));
		BoxSceltaLogin.setToolTipText("");
		BoxSceltaLogin.setEditable(true);
		BoxSceltaLogin.setBounds(354, 226, 106, 22);
		contentPane.add(BoxSceltaLogin);
	}
	
	public void alertLogin()
	{
		JOptionPane.showMessageDialog(this,"Credenziali Errate o non inserite");
	}
	
	public void confirmLogin() {
		JOptionPane.showMessageDialog(this,"Login effettuato come " + BoxSceltaLogin.getSelectedItem());
	}	
}
