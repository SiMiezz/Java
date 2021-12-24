import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

import java.sql.Date;
import javax.swing.JTextArea;

public class homePageStud extends JFrame {

	private JPanel contentPane;
	
	Controller TheController;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtData;
	private JTextField txtCf;
	private JTextField txtMatricola;
	
	public homePageStud(Controller c, String matricola, String pwd) {
		setTitle("STUDENTE");
		TheController=c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProfilo = new JLabel("PROFILO STUDENTE");
		lblProfilo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfilo.setBounds(10, 26, 191, 26);
		contentPane.add(lblProfilo);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setBounds(114, 63, 135, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setEditable(false);
		txtCognome.setBounds(114, 90, 135, 20);
		contentPane.add(txtCognome);
		txtCognome.setColumns(10);
		
		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setBounds(114, 121, 135, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		txtCf = new JTextField();
		txtCf.setEditable(false);
		txtCf.setBounds(114, 152, 135, 20);
		contentPane.add(txtCf);
		txtCf.setColumns(10);
		
		txtMatricola = new JTextField();
		txtMatricola.setEditable(false);
		txtMatricola.setBounds(114, 184, 135, 20);
		contentPane.add(txtMatricola);
		txtMatricola.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 63, 94, 17);
		contentPane.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCognome.setBounds(10, 93, 94, 17);
		contentPane.add(lblCognome);
		
		JLabel lblData = new JLabel("Data di Nascita");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 124, 94, 17);
		contentPane.add(lblData);
		
		JLabel lblCf = new JLabel("Codice Fiscale");
		lblCf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCf.setBounds(10, 155, 94, 17);
		contentPane.add(lblCf);
		
		JLabel lblMatricola = new JLabel("Matricola");
		lblMatricola.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatricola.setBounds(10, 186, 94, 17);
		contentPane.add(lblMatricola);
		
		JTextArea txtCorsi = new JTextArea();
		txtCorsi.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtCorsi.setBounds(341, 254, 270, 184);
		contentPane.add(txtCorsi);
		
		JLabel lblCorsi = new JLabel("ISCRIZIONI CORSI");
		lblCorsi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorsi.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorsi.setBounds(369, 217, 215, 26);
		contentPane.add(lblCorsi);
		
		Studente stud = new Studente();
		
		stud.setMatricola(matricola);
		stud.setNome(c.getStud(matricola).getNome());
		stud.setCognome(c.getStud(matricola).getCognome());
		stud.setData(c.getStud(matricola).getData());
		stud.setCf(c.getStud(matricola).getCf());
		stud.setIscrizioni(c.getIscrizioni(stud));
		
		txtNome.setText(stud.getNome());
		txtCognome.setText(stud.getCognome());
		
		Date data = stud.getData();
		String strdata = data.toString();
		
		txtData.setText(strdata);
		txtCf.setText(stud.getCf());
		txtMatricola.setText(matricola);
		
		for(Iscritto iscrizione:stud.getIscrizioni()) {
			txtCorsi.append(iscrizione.getCorso().getNome() + "\n");
		}
	}
}
