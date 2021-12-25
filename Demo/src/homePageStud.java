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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;

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
		setBounds(100, 100, 650, 550);
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
		
		JLayeredPane layeredPanel = new JLayeredPane();
		layeredPanel.setBounds(297, 25, 327, 475);
		contentPane.add(layeredPanel);
		layeredPanel.setLayout(new CardLayout(0, 0));
		
		JPanel panelCorsi = new JPanel();
		layeredPanel.add(panelCorsi, "name_527413552155300");
		panelCorsi.setLayout(null);
		
		JLabel lblCorsi = new JLabel("CORSI");
		lblCorsi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorsi.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorsi.setBounds(10, 11, 307, 14);
		panelCorsi.add(lblCorsi);
		
		JTextArea txtCorsi = new JTextArea();
		txtCorsi.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtCorsi.setEditable(false);
		txtCorsi.setBounds(36, 65, 263, 184);
		panelCorsi.add(txtCorsi);
		
		JPanel panelIscrizioni = new JPanel();
		layeredPanel.add(panelIscrizioni, "name_527425117892300");
		panelIscrizioni.setLayout(null);
		
		JLabel lblIscrizioni = new JLabel("ISCRIZIONI");
		lblIscrizioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblIscrizioni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIscrizioni.setBounds(10, 11, 307, 14);
		panelIscrizioni.add(lblIscrizioni);
		
		JTextArea txtIscrizioni = new JTextArea();
		txtIscrizioni.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtIscrizioni.setEditable(false);
		txtIscrizioni.setBounds(37, 60, 257, 190);
		panelIscrizioni.add(txtIscrizioni);
		
		JPanel panelLezioni = new JPanel();
		layeredPanel.add(panelLezioni, "name_527436106862699");
		panelLezioni.setLayout(null);
		
		JLabel lblLezioni = new JLabel("LEZIONI");
		lblLezioni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLezioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblLezioni.setBounds(10, 11, 307, 14);
		panelLezioni.add(lblLezioni);
		
		JPanel panelNewIscrizione = new JPanel();
		layeredPanel.add(panelNewIscrizione, "name_529526638992000");
		panelNewIscrizione.setLayout(null);
		
		JLabel lblNewIscrizione = new JLabel("EFFETTUA ISCRIZIONE");
		lblNewIscrizione.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewIscrizione.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewIscrizione.setBounds(10, 11, 307, 14);
		panelNewIscrizione.add(lblNewIscrizione);
		
		JButton btnIscrizioni = new JButton("Visualizza Iscrizioni");
		btnIscrizioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPanel.removeAll();
                layeredPanel.add(panelIscrizioni);
                layeredPanel.repaint();
                layeredPanel.revalidate();
                
                stud.setIscrizioni(c.getIscrizioni(stud));
				for(Iscritto iscrizione:stud.getIscrizioni()) {
					txtIscrizioni.append(iscrizione.getCorso().getNome() + "\n");
				}
			}
		});
		btnIscrizioni.setBounds(128, 259, 121, 21);
		contentPane.add(btnIscrizioni);
		
		JButton btnCorsi = new JButton("Visualizza Corsi");
		btnCorsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPanel.removeAll();
                layeredPanel.add(panelCorsi);
                layeredPanel.repaint();
                layeredPanel.revalidate();
				
				for(CorsoFormazione corso:c.getAllCorsi()) {
					txtCorsi.append(corso.getNome() + "\n");
				}
			}
		});
		btnCorsi.setBounds(10, 259, 112, 20);
		contentPane.add(btnCorsi);
		
		JButton btnNewIscrizione = new JButton("Effettua Iscrizione");
		btnNewIscrizione.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPanel.removeAll();
                layeredPanel.add(panelNewIscrizione);
                layeredPanel.repaint();
                layeredPanel.revalidate();
			}
		});
		btnNewIscrizione.setBounds(128, 291, 121, 20);
		contentPane.add(btnNewIscrizione);
		
		JButton btnLezioni = new JButton("Visualizza lezioni");
		btnLezioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPanel.removeAll();
                layeredPanel.add(panelLezioni);
                layeredPanel.repaint();
                layeredPanel.revalidate();
			}
		});
		btnLezioni.setBounds(10, 290, 112, 20);
		contentPane.add(btnLezioni);
	}
}
