import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Date;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class homePageOp extends JFrame {

	private JPanel contentPane;
	Controller TheController;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtData;
	private JTextField txtCf;
	private JTextField txtID;

	public homePageOp(Controller c) {
		setTitle("OPERATORE");
		
		TheController= c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProfilo = new JLabel("PROFILO OPERATORE");
		lblProfilo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfilo.setBounds(10, 21, 181, 22);
		contentPane.add(lblProfilo);
		
		txtNome = new JTextField();
		txtNome.setBackground(new Color(255, 255, 255));
		txtNome.setEditable(false);
		txtNome.setBounds(118, 54, 181, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setEditable(false);
		txtCognome.setBounds(118, 87, 181, 22);
		contentPane.add(txtCognome);
		txtCognome.setColumns(10);
		
		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setBounds(118, 120, 181, 22);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		txtCf = new JTextField();
		txtCf.setEditable(false);
		txtCf.setBounds(118, 153, 181, 22);
		contentPane.add(txtCf);
		txtCf.setColumns(10);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(118, 192, 181, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 54, 98, 22);
		contentPane.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCognome.setBounds(10, 91, 98, 22);
		contentPane.add(lblCognome);
		
		JLabel lblData = new JLabel("Data di Nascita");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 124, 98, 22);
		contentPane.add(lblData);
		
		JLabel lblCf = new JLabel("Codice Fiscale");
		lblCf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCf.setBounds(10, 157, 98, 22);
		contentPane.add(lblCf);
		
		JLabel lblID = new JLabel("Id");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblID.setBounds(10, 189, 98, 22);
		contentPane.add(lblID);
		
		String id = Controller.op.getId();
		
		txtNome.setText(c.getOp(id).getNome());
		txtCognome.setText(c.getOp(id).getCognome());
		
		Date data = c.getOp(id).getData();
		String strdata = data.toString();
		
		txtData.setText(strdata);
		txtCf.setText(c.getOp(id).getCf());
		txtID.setText(c.getOp(id).getId());
		
		JButton btnGoInsertCorso = new JButton("Crea Corso");
		btnGoInsertCorso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				c.goInsertCorso();
			
			}
		});
		btnGoInsertCorso.setBounds(187, 261, 89, 23);
		contentPane.add(btnGoInsertCorso);
	}
}
