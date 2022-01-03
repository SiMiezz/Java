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
import javax.swing.JFormattedTextField;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class loginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
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
		setBounds(100, 100, 550, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtID = new JTextField();
		txtID.setBounds(192, 127, 148, 22);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblID = new JLabel("ID/MATRICOLA");
		lblID.setLabelFor(txtID);
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID.setBounds(62, 129, 120, 14);
		contentPane.add(lblID);
		
		JLabel lblPwd = new JLabel("PASSWORD");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPwd.setBounds(62, 162, 120, 14);
		contentPane.add(lblPwd);
		
		JButton btnGo = new JButton("LOGIN");
		btnGo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtID.getText();
				String pwd = String.valueOf(pwdField.getPassword());
				
				if(c.checkUser(id, pwd)) {
					c.confirmLogin();
				}
				else {
					c.alertLogin();
				}
				
				txtID.setText(null);
				pwdField.setText(null);
			}
		});
		btnGo.setBounds(362, 315, 162, 35);
		contentPane.add(btnGo);
		
		pwdField = new JPasswordField();
		lblPwd.setLabelFor(pwdField);
		pwdField.setBounds(192, 160, 148, 22);
		contentPane.add(pwdField);
		
		BoxSceltaLogin = new JComboBox();
		BoxSceltaLogin.setBackground(Color.WHITE);
		BoxSceltaLogin.setModel(new DefaultComboBoxModel(new String[] {"Studente", "Operatore"}));
		BoxSceltaLogin.setToolTipText("");
		BoxSceltaLogin.setEditable(true);
		BoxSceltaLogin.setBounds(270, 53, 100, 20);
		contentPane.add(BoxSceltaLogin);
		
		JButton btnRegistrati = new JButton("REGISTRATI");
		btnRegistrati.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.goRegistrazioneFrame();
			}
		});
		btnRegistrati.setBounds(20, 321, 120, 25);
		contentPane.add(btnRegistrati);
		
		JLabel lblLoginTitle = new JLabel("LOGIN");
		lblLoginTitle.setForeground(Color.RED);
		lblLoginTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginTitle.setBounds(192, 11, 148, 25);
		contentPane.add(lblLoginTitle);
		
		JLabel lblTipoLogin = new JLabel("Selezionare il tipo di login:\r\n");
		lblTipoLogin.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTipoLogin.setLabelFor(BoxSceltaLogin);
		lblTipoLogin.setBounds(63, 53, 197, 17);
		contentPane.add(lblTipoLogin);
		
		JLabel lblRegistrati = new JLabel("Non sei registrato? Clicca qui...");
		lblRegistrati.setBounds(20, 307, 181, 14);
		contentPane.add(lblRegistrati);
	}
}
