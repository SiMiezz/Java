import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class homePageStud extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtData;
	private JTextField txtCF;
	private JTextField txtMatricola;
	Controller TheController;
	
	private void switchPanel(JLayeredPane layeredPane, JPanel panelInserisci) {
		layeredPane.removeAll();
        layeredPane.add(panelInserisci);
        layeredPane.repaint();
        layeredPane.revalidate();
	}

	public homePageStud(Controller c, String matricola, String pwd) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 525);
		
		TheController=c;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 564, 442);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelProfilo = new JPanel();
		panelProfilo.setLayout(null);
		layeredPane.add(panelProfilo, "name_367346658513700");
		
		JLabel lblNewLabel = new JLabel("PROFILO STUDENTE");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(168, 11, 226, 31);
		panelProfilo.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setText((String) null);
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(168, 68, 226, 22);
		panelProfilo.add(txtNome);
		
		txtCognome = new JTextField();
		txtCognome.setText((String) null);
		txtCognome.setEditable(false);
		txtCognome.setColumns(10);
		txtCognome.setBounds(168, 106, 226, 22);
		panelProfilo.add(txtCognome);
		
		txtData = new JTextField();
		txtData.setText("<dynamic>\r\n");
		txtData.setEditable(false);
		txtData.setColumns(10);
		txtData.setBounds(168, 149, 226, 22);
		panelProfilo.add(txtData);
		
		txtCF = new JTextField();
		txtCF.setText((String) null);
		txtCF.setEditable(false);
		txtCF.setColumns(10);
		txtCF.setBounds(168, 182, 226, 22);
		panelProfilo.add(txtCF);
		
		txtMatricola = new JTextField();
		txtMatricola.setText("<dynamic>");
		txtMatricola.setEditable(false);
		txtMatricola.setColumns(10);
		txtMatricola.setBounds(168, 215, 226, 22);
		panelProfilo.add(txtMatricola);
		
		Studente stud = new Studente();
		
		stud.setMatricola(matricola);
		stud.setPassword(pwd);
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
		txtCF.setText(stud.getCf());
		txtMatricola.setText(matricola);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(31, 72, 114, 14);
		panelProfilo.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCognome.setBounds(31, 104, 114, 22);
		panelProfilo.add(lblCognome);
		
		JLabel lblData = new JLabel("Data di nascita");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(31, 151, 114, 14);
		panelProfilo.add(lblData);
		
		JLabel lblCf = new JLabel("Codice Fiscale");
		lblCf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCf.setBounds(31, 186, 114, 14);
		panelProfilo.add(lblCf);
		
		JLabel lblMatricola = new JLabel("Matricola");
		lblMatricola.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatricola.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatricola.setBounds(31, 219, 114, 14);
		panelProfilo.add(lblMatricola);
		
		JPanel panelCorsi = new JPanel();
		panelCorsi.setLayout(null);
		layeredPane.add(panelCorsi, "name_367386059393600");
		
		JLabel lblCorsi = new JLabel("VISUALIZZA CORSI");
		lblCorsi.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorsi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorsi.setBounds(10, 11, 544, 14);
		panelCorsi.add(lblCorsi);
		
		JScrollPane scrollPaneCorsi = new JScrollPane();
		scrollPaneCorsi.setBounds(10, 36, 542, 219);
		panelCorsi.add(scrollPaneCorsi);
		
		JTextArea txtCorsi = new JTextArea();
		scrollPaneCorsi.setViewportView(txtCorsi);
		txtCorsi.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtCorsi.setEditable(false);
		
		JPanel panelIscrizioni = new JPanel();
		layeredPane.add(panelIscrizioni, "name_367500255637100");
		panelIscrizioni.setLayout(null);
		
		JLabel lblIscrizioni = new JLabel("VISUALIZZA ISCRIZIONI");
		lblIscrizioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblIscrizioni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIscrizioni.setBounds(10, 11, 544, 14);
		panelIscrizioni.add(lblIscrizioni);
		
		JScrollPane scrollPaneIscrizioni = new JScrollPane();
		scrollPaneIscrizioni.setBounds(10, 36, 540, 217);
		panelIscrizioni.add(scrollPaneIscrizioni);
		
		JTextArea txtIscrizioni = new JTextArea();
		scrollPaneIscrizioni.setViewportView(txtIscrizioni);
		txtIscrizioni.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtIscrizioni.setEditable(false);
		
		JPanel panelNewIscrizione = new JPanel();
		layeredPane.add(panelNewIscrizione, "name_367633326808700");
		panelNewIscrizione.setLayout(null);
		
		JLabel lblNewIscrizione = new JLabel("EFFETTUA ISCRIZIONE");
		lblNewIscrizione.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewIscrizione.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewIscrizione.setBounds(10, 11, 544, 14);
		panelNewIscrizione.add(lblNewIscrizione);
		
		JLabel lblAlertIscrizione = new JLabel("Seleziona l'id del corso");
		lblAlertIscrizione.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertIscrizione.setForeground(Color.BLUE);
		lblAlertIscrizione.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertIscrizione.setBounds(141, 36, 285, 14);
		panelNewIscrizione.add(lblAlertIscrizione);
		
		JScrollPane scrollPaneNewIscrizione = new JScrollPane();
		scrollPaneNewIscrizione.setBounds(143, 61, 283, 168);
		panelNewIscrizione.add(scrollPaneNewIscrizione);
		
		JTextArea txtNewIscrizione = new JTextArea();
		scrollPaneNewIscrizione.setViewportView(txtNewIscrizione);
		txtNewIscrizione.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtNewIscrizione.setEditable(false);
		
		JButton btnIscriviti = new JButton("ISCRIVITI");
		btnIscriviti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNewIscrizione.getSelectedText() != null) {
					int id = Integer.valueOf(txtNewIscrizione.getSelectedText());
					
					if(c.iscriviti(stud,id)) {
						c.confirmInsertIscrizione();
					}
					else {
						c.alertInsertIscrizione();
					}
				}
				else {
					c.alertSeleziona();
				}
			}
		});
		btnIscriviti.setBounds(337, 240, 89, 23);
		panelNewIscrizione.add(btnIscriviti);
		
		JPanel panelLezioni = new JPanel();
		layeredPane.add(panelLezioni, "name_367792570924600");
		panelLezioni.setLayout(null);
		
		JLabel lblVisualizzaLezioni = new JLabel("VISUALIZZA LEZIONI");
		lblVisualizzaLezioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisualizzaLezioni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVisualizzaLezioni.setBounds(10, 11, 544, 14);
		panelLezioni.add(lblVisualizzaLezioni);
		
		JScrollPane scrollPaneLezioni = new JScrollPane();
		scrollPaneLezioni.setBounds(10, 32, 540, 217);
		panelLezioni.add(scrollPaneLezioni);
		
		JTextArea txtLezioni = new JTextArea();
		scrollPaneLezioni.setViewportView(txtLezioni);
		txtLezioni.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtLezioni.setEditable(false);
		
		JPanel panelPartecipa = new JPanel();
		layeredPane.add(panelPartecipa, "name_367912807561300");
		panelPartecipa.setLayout(null);
		
		JLabel lblPartecipaLezioni = new JLabel("PARTECIPA LEZIONE");
		lblPartecipaLezioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartecipaLezioni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPartecipaLezioni.setBounds(10, 11, 544, 14);
		panelPartecipa.add(lblPartecipaLezioni);
		
		JLabel lblAlertPartecipa = new JLabel("Seleziona l'id della lezione");
		lblAlertPartecipa.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertPartecipa.setForeground(Color.BLUE);
		lblAlertPartecipa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertPartecipa.setBounds(141, 36, 285, 14);
		panelPartecipa.add(lblAlertPartecipa);
		
		JScrollPane scrollPanePartecipa = new JScrollPane();
		scrollPanePartecipa.setBounds(141, 61, 281, 166);
		panelPartecipa.add(scrollPanePartecipa);
		
		JTextArea txtPartecipa = new JTextArea();
		scrollPanePartecipa.setViewportView(txtPartecipa);
		txtPartecipa.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtPartecipa.setEditable(false);
		
		JButton btnPartecipa = new JButton("PARTECIPA");
		btnPartecipa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtLezioni.getSelectedText() != null) {
					int id = Integer.valueOf(txtLezioni.getSelectedText());
					
					if(c.partecipa(stud,id)) {
						c.confirmInsertPresenza();
					}
					else {
						c.alertInsertPresenza();
					}
				}
				else {
					c.alertSeleziona();
				}
			}
		});
		btnPartecipa.setBounds(326, 238, 100, 23);
		panelPartecipa.add(btnPartecipa);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProfilo = new JMenu("PROFILO");
		menuBar.add(mnProfilo);
		
		JMenuItem mntmProfilo = new JMenuItem("Visualizza Profilo");
		mntmProfilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelProfilo);
			}
		});
		mnProfilo.add(mntmProfilo);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stud.setMatricola(null);
				stud.setPassword(null);
				stud.setNome(null);
				stud.setCognome(null);
				stud.setData(null);
				stud.setCf(null);
				stud.setIscrizioni(null);
				
				c.logout();
			}
		});
		mnProfilo.add(mntmLogout);
		
		JMenu mnCorsi = new JMenu("CORSI");
		menuBar.add(mnCorsi);
		
		JMenuItem mntmVisualizzaCorsi = new JMenuItem("Visualizza Corsi");
		mntmVisualizzaCorsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelCorsi);
				
				txtCorsi.setText(null);
				for(CorsoFormazione corso:c.getAllCorsi()) {
					txtCorsi.append(corso.getIdCorso() + " " + corso.getNome() + " " + corso.getDescrizione() + "\n");
				}
			}
		});
		mnCorsi.add(mntmVisualizzaCorsi);
		
		JMenu mnIscrizioni = new JMenu("ISCRIZIONI");
		menuBar.add(mnIscrizioni);
		
		JMenuItem mntmVisualizzaIscrizioni = new JMenuItem("Visualizza Iscrizioni");
		mntmVisualizzaIscrizioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelIscrizioni);
				
				stud.setIscrizioni(c.getIscrizioni(stud));
                txtIscrizioni.setText(null);
				for(Iscritto iscrizione:stud.getIscrizioni()) {
					txtIscrizioni.append(iscrizione.getCorso().getIdCorso() + " " + iscrizione.getCorso().getNome() + " " + iscrizione.getCorso().getDescrizione() + "\n");
				}
			}
		});
		mnIscrizioni.add(mntmVisualizzaIscrizioni);
		
		JMenuItem mntmAggiungiIscrizioni = new JMenuItem("Effettua Iscrizione");
		mntmAggiungiIscrizioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelNewIscrizione);
				
				txtNewIscrizione.setText(null);
				for(CorsoFormazione corso:c.getCorsiIscrizione(stud)) {
					txtNewIscrizione.append(corso.getIdCorso() + " " + corso.getNome() + " " + corso.getDescrizione() + "\n");
				}
			}
		});
		mnIscrizioni.add(mntmAggiungiIscrizioni);
		
		JMenu mnLezioni = new JMenu("LEZIONI");
		menuBar.add(mnLezioni);
		
		JMenuItem mntmVisualizzaLezioni = new JMenuItem("Visualizza Lezioni");
		mntmVisualizzaLezioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelLezioni);
				
				txtLezioni.setText(null);
				for(Lezione lezione:c.getLezioni(stud)) {
					txtLezioni.append(lezione.getIdlezione() + " " + lezione.getTitolo() + " " + lezione.getDatainizio() + " " + lezione.getOrarioinizio() + "\n");
				}
			}
		});
		mnLezioni.add(mntmVisualizzaLezioni);
		
		JMenuItem mntmPartecipaLezioni = new JMenuItem("Partecipa Lezione");
		mntmPartecipaLezioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelPartecipa);
				
				txtPartecipa.setText(null);
				for(Lezione lezione:c.getLezioniPartecipa(stud)) {
					txtPartecipa.append(lezione.getIdlezione() + " " + lezione.getTitolo() + " " + lezione.getDatainizio() + "\n");
				}
			}
		});
		mnLezioni.add(mntmPartecipaLezioni);
	}
}
