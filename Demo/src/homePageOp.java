import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;

import javax.swing.JSplitPane;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;

public class homePageOp extends JFrame {

	private JPanel contentPane;
	private JTextField txtInsertNome;
	private JTextField txtInsertDesc;
	private JTextField txtInsertPresenze;
	private JTextField txtInsertPartecipanti;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtDataNascita;
	private JTextField txtCF;
	private JTextField txtID;
	private JTextField txtModificaNome;
	private JTextField txtModificaDesc;
	private JTextField txtModificaPresenze;
	private JTextField txtModificaPartecipanti;
	private JTextField txtModificaID;
	private JTextField txtNumMedio;
	private JTextField txtMinStud;
	private JTextField txtMaxStud;
	private JTextField txtRiempimento;
	private JTextField txtTipoAree;
	private JTextField txtDescAree;
	private JTextField txtIdAree;
	Controller TheController;
	private JTable table;
	DefaultTableModel model;

	private void switchPanel(JLayeredPane layeredPane, JPanel panelInserisci) {
		layeredPane.removeAll();
        layeredPane.add(panelInserisci);
        layeredPane.repaint();
        layeredPane.revalidate();
	}
	
	public static Integer tryParse(String text) {
		try {
			return Integer.valueOf(text);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public homePageOp(Controller c, String id, String pwd) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 525);
		
		TheController= c;
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 564, 439);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelProfilo = new JPanel();
		panelProfilo.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelProfilo, "name_680381200185900");
		panelProfilo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PROFILO OPERATORE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setLabelFor(panelProfilo);
		lblNewLabel.setBounds(10, 11, 544, 31);
		panelProfilo.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setText((String) null);
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(168, 68, 200, 22);
		panelProfilo.add(txtNome);
		
		txtCognome = new JTextField();
		txtCognome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCognome.setText((String) null);
		txtCognome.setEditable(false);
		txtCognome.setColumns(10);
		txtCognome.setBounds(168, 106, 200, 22);
		panelProfilo.add(txtCognome);
		
		txtDataNascita = new JTextField();
		txtDataNascita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDataNascita.setText("<dynamic>\r\n");
		txtDataNascita.setEditable(false);
		txtDataNascita.setColumns(10);
		txtDataNascita.setBounds(168, 149, 200, 22);
		panelProfilo.add(txtDataNascita);
		
		txtCF = new JTextField();
		txtCF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCF.setText((String) null);
		txtCF.setEditable(false);
		txtCF.setColumns(10);
		txtCF.setBounds(168, 182, 200, 22);
		panelProfilo.add(txtCF);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtID.setText("<dynamic>");
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(168, 215, 200, 22);
		panelProfilo.add(txtID);
		
		Operatore op = new Operatore();
		op.setId(id);
		op.setPassword(pwd);
		op.setNome(c.getOp(id).getNome());
		op.setCognome(c.getOp(id).getCognome());
		op.setData(c.getOp(id).getData());
		op.setCf(c.getOp(id).getCf());
		op.setCorsi(c.getCorsiOperatore(op));
		
		txtNome.setText(op.getNome());
		txtCognome.setText(op.getCognome());
		
		Date data = op.getData();
		String strdata = data.toString();
		
		txtDataNascita.setText(strdata);
		txtCF.setText(op.getCf());
		txtID.setText(id);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(38, 72, 120, 14);
		panelProfilo.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCognome.setBounds(38, 106, 120, 22);
		panelProfilo.add(lblCognome);
		
		JLabel lblData = new JLabel("Data di nascita");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(38, 153, 120, 14);
		panelProfilo.add(lblData);
		
		JLabel lblCf = new JLabel("Codice Fiscale");
		lblCf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCf.setBounds(38, 186, 120, 14);
		panelProfilo.add(lblCf);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(38, 219, 120, 14);
		panelProfilo.add(lblId);
		
		JPanel panelInserisci = new JPanel();
		panelInserisci.setBackground(new Color(176, 224, 230));
		panelInserisci.setLayout(null);
		layeredPane.add(panelInserisci, "name_679299759213300");
		
		JLabel lblInserisci = new JLabel("INSERISCI CORSO");
		lblInserisci.setForeground(Color.RED);
		lblInserisci.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisci.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblInserisci.setBounds(10, 11, 544, 14);
		panelInserisci.add(lblInserisci);
		
		txtInsertNome = new JTextField();
		txtInsertNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInsertNome.setColumns(10);
		txtInsertNome.setBounds(147, 123, 175, 20);
		panelInserisci.add(txtInsertNome);
		
		txtInsertDesc = new JTextField();
		txtInsertDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInsertDesc.setColumns(10);
		txtInsertDesc.setBounds(147, 154, 175, 20);
		panelInserisci.add(txtInsertDesc);
		
		txtInsertPresenze = new JTextField();
		txtInsertPresenze.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInsertPresenze.setColumns(10);
		txtInsertPresenze.setBounds(147, 185, 175, 20);
		panelInserisci.add(txtInsertPresenze);
		
		txtInsertPartecipanti = new JTextField();
		txtInsertPartecipanti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInsertPartecipanti.setColumns(10);
		txtInsertPartecipanti.setBounds(147, 216, 175, 20);
		panelInserisci.add(txtInsertPartecipanti);
		
		JLabel lblNomeCorso = new JLabel("Nome");
		lblNomeCorso.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCorso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCorso.setBounds(17, 124, 120, 14);
		panelInserisci.add(lblNomeCorso);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrizione.setBounds(17, 155, 120, 14);
		panelInserisci.add(lblDescrizione);
		
		JLabel lblPresenze = new JLabel("Presenze Minime");
		lblPresenze.setHorizontalAlignment(SwingConstants.CENTER);
		lblPresenze.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPresenze.setBounds(17, 186, 120, 14);
		panelInserisci.add(lblPresenze);
		
		JLabel lblPartecipanti = new JLabel("Partecipanti Max");
		lblPartecipanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartecipanti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPartecipanti.setBounds(17, 217, 120, 14);
		panelInserisci.add(lblPartecipanti);
		
		JButton btnInserimento = new JButton("INSERISCI");
		btnInserimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtInsertNome.getText().isBlank() && tryParse(txtInsertPresenze.getText())!=null && tryParse(txtInsertPartecipanti.getText())!=null) {
					String nome = txtInsertNome.getText();
					String descrizione = txtInsertDesc.getText();
					int presenze = tryParse(txtInsertPresenze.getText());
					int partecipanti = tryParse(txtInsertPartecipanti.getText());
					
					if(c.inserisciCorso(nome,descrizione,presenze,partecipanti,op)){
						c.confirmInsertCorso();
					}
					else {
						c.alertInsertCorso();
					}
				}
				else {
					c.alertInsertCorso();
				}
				
				txtInsertNome.setText(null);
				txtInsertDesc.setText(null);
				txtInsertPresenze.setText(null);
				txtInsertPartecipanti.setText(null);
			}
		});
		btnInserimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnInserimento.setBounds(289, 247, 100, 23);
		panelInserisci.add(btnInserimento);
		
		JPanel panelVisualizza = new JPanel();
		panelVisualizza.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelVisualizza, "name_302338902470800");
		panelVisualizza.setLayout(null);
		
		JLabel lblVisualizza = new JLabel("VISUALIZZA CORSI");
		lblVisualizza.setForeground(Color.RED);
		lblVisualizza.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVisualizza.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisualizza.setBounds(10, 11, 544, 14);
		panelVisualizza.add(lblVisualizza);
		
		JScrollPane scrollPaneVisualizza = new JScrollPane();
		scrollPaneVisualizza.setBounds(10, 36, 544, 270);
		panelVisualizza.add(scrollPaneVisualizza);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		model= new DefaultTableModel();
		Object[] column= {"ID", "Nome", "Descrizione", "Presenze min", "Partecipanti max"};
		Object [] row= new Object[5];
		table.setModel(model);
		model.setColumnIdentifiers(column);
		scrollPaneVisualizza.setViewportView(table);
		
		JPanel panelModifica = new JPanel();
		panelModifica.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelModifica, "name_678172324780300");
		panelModifica.setLayout(null);
		
		JLabel lblModifica = new JLabel("MODIFICA CORSO");
		lblModifica.setForeground(Color.RED);
		lblModifica.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifica.setBounds(10, 11, 544, 14);
		panelModifica.add(lblModifica);
		
		JScrollPane scrollPaneModifica = new JScrollPane();
		scrollPaneModifica.setBounds(142, 61, 285, 170);
		panelModifica.add(scrollPaneModifica);
		
		JTextArea txtModifica = new JTextArea();
		scrollPaneModifica.setViewportView(txtModifica);
		txtModifica.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtModifica.setEditable(false);
		
		JLabel lblAlertModifica = new JLabel("Seleziona l'id del corso");
		lblAlertModifica.setForeground(Color.BLUE);
		lblAlertModifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertModifica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertModifica.setBounds(142, 36, 285, 14);
		panelModifica.add(lblAlertModifica);
		
		JButton btnSelezionaModifica = new JButton("SELEZIONA");
		btnSelezionaModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tryParse(txtModifica.getSelectedText())!=null) {
					int id = tryParse(txtModifica.getSelectedText());
					
					txtModificaNome.setText(c.getCorso(id).getNome());
					txtModificaDesc.setText(c.getCorso(id).getDescrizione());
					txtModificaPresenze.setText(Integer.toString(c.getCorso(id).getPresenzeMin()));
					txtModificaPartecipanti.setText(Integer.toString(c.getCorso(id).getMaxPartecipanti()));
					txtModificaID.setText(Integer.toString(id));
				}
				else {
					c.alertSeleziona();
				}
			}
		});
		btnSelezionaModifica.setBounds(327, 238, 100, 23);
		panelModifica.add(btnSelezionaModifica);
		
		txtModificaNome = new JTextField();
		txtModificaNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModificaNome.setBounds(154, 272, 175, 20);
		panelModifica.add(txtModificaNome);
		txtModificaNome.setColumns(10);
		
		txtModificaDesc = new JTextField();
		txtModificaDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModificaDesc.setBounds(154, 303, 175, 20);
		panelModifica.add(txtModificaDesc);
		txtModificaDesc.setColumns(10);
		
		txtModificaPresenze = new JTextField();
		txtModificaPresenze.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModificaPresenze.setBounds(154, 334, 175, 20);
		panelModifica.add(txtModificaPresenze);
		txtModificaPresenze.setColumns(10);
		
		txtModificaPartecipanti = new JTextField();
		txtModificaPartecipanti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModificaPartecipanti.setBounds(154, 365, 175, 20);
		panelModifica.add(txtModificaPartecipanti);
		txtModificaPartecipanti.setColumns(10);
		
		txtModificaID = new JTextField();
		txtModificaID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModificaID.setEditable(false);
		txtModificaID.setBounds(154, 394, 175, 20);
		panelModifica.add(txtModificaID);
		txtModificaID.setColumns(10);
		
		JLabel lblModNome = new JLabel("Nome");
		lblModNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblModNome.setBounds(14, 275, 130, 14);
		panelModifica.add(lblModNome);
		
		JLabel txtModDesc = new JLabel("Descrizione");
		txtModDesc.setHorizontalAlignment(SwingConstants.CENTER);
		txtModDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModDesc.setBounds(14, 306, 130, 14);
		panelModifica.add(txtModDesc);
		
		JLabel lblModPresenze = new JLabel("Presenze minime");
		lblModPresenze.setHorizontalAlignment(SwingConstants.CENTER);
		lblModPresenze.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModPresenze.setBounds(14, 337, 130, 14);
		panelModifica.add(lblModPresenze);
		
		JLabel lblModPartecipanti = new JLabel("Partecipanti max");
		lblModPartecipanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblModPartecipanti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModPartecipanti.setBounds(14, 368, 130, 14);
		panelModifica.add(lblModPartecipanti);
		
		JLabel lblModId = new JLabel("IDCorso");
		lblModId.setHorizontalAlignment(SwingConstants.CENTER);
		lblModId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModId.setBounds(14, 397, 130, 14);
		panelModifica.add(lblModId);
		
		JButton btnAggiorna = new JButton("AGGIORNA");
		btnAggiorna.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtModificaNome.getText().isBlank() && tryParse(txtModificaPresenze.getText())!=null && tryParse(txtModificaPartecipanti.getText())!=null && !txtModificaID.getText().isBlank()) {
					String nome = txtModificaNome.getText();
					String descrizione = txtModificaDesc.getText();
					int presenze = tryParse(txtModificaPresenze.getText());
					int partecipanti = tryParse(txtModificaPartecipanti.getText());
					int id = Integer.valueOf(txtModificaID.getText());
					
					if(c.aggiornaCorso(nome, descrizione, presenze, partecipanti, id)) {
						c.confirmUpdate();
					}
					else {
						c.alertUpdate();
					}
				}
				else {
					c.alertUpdate();
				}
				
				txtModificaNome.setText(null);
				txtModificaDesc.setText(null);
				txtModificaPresenze.setText(null);
				txtModificaPartecipanti.setText(null);
				txtModificaID.setText(null);
			}
		});
		btnAggiorna.setBounds(337, 395, 100, 23);
		panelModifica.add(btnAggiorna);
		
		JPanel panelStatistiche = new JPanel();
		panelStatistiche.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelStatistiche, "name_362930448153500");
		panelStatistiche.setLayout(null);
		
		JLabel lblStatistiche = new JLabel("STATISTICHE CORSO");
		lblStatistiche.setForeground(Color.RED);
		lblStatistiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistiche.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatistiche.setBounds(10, 11, 544, 14);
		panelStatistiche.add(lblStatistiche);
		
		JLabel lblAlertStatistiche = new JLabel("Seleziona l'id del corso");
		lblAlertStatistiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertStatistiche.setForeground(Color.BLUE);
		lblAlertStatistiche.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertStatistiche.setBounds(145, 36, 283, 14);
		panelStatistiche.add(lblAlertStatistiche);
		
		JScrollPane scrollPaneStatistiche = new JScrollPane();
		scrollPaneStatistiche.setBounds(145, 61, 283, 168);
		panelStatistiche.add(scrollPaneStatistiche);
		
		JTextArea txtStatistiche = new JTextArea();
		scrollPaneStatistiche.setViewportView(txtStatistiche);
		txtStatistiche.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtStatistiche.setEditable(false);
		
		JButton btnSelezionaStatistiche = new JButton("SELEZIONA");
		btnSelezionaStatistiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tryParse(txtStatistiche.getSelectedText())!=null) {
					int id = tryParse(txtStatistiche.getSelectedText());
					
					txtNumMedio.setText(Integer.toString(c.getStat(c.getCorso(id)).getNumMedioStud()));
					txtMinStud.setText(Integer.toString(c.getStat(c.getCorso(id)).getMinStud()));
					txtMaxStud.setText(Integer.toString(c.getStat(c.getCorso(id)).getMaxStud()));
					txtRiempimento.setText(Integer.toString(c.getStat(c.getCorso(id)).getRiempimentoMedio()));
				}
				else {
					c.alertSeleziona();
				}
			}
		});
		btnSelezionaStatistiche.setBounds(328, 236, 100, 23);
		panelStatistiche.add(btnSelezionaStatistiche);
		
		txtNumMedio = new JTextField();
		txtNumMedio.setEditable(false);
		txtNumMedio.setBounds(210, 270, 120, 20);
		panelStatistiche.add(txtNumMedio);
		txtNumMedio.setColumns(10);
		
		JLabel lblNumMedio = new JLabel("Numero medio Studenti");
		lblNumMedio.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumMedio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumMedio.setBounds(60, 272, 140, 14);
		panelStatistiche.add(lblNumMedio);
		
		txtMinStud = new JTextField();
		txtMinStud.setEditable(false);
		txtMinStud.setBounds(210, 301, 120, 20);
		panelStatistiche.add(txtMinStud);
		txtMinStud.setColumns(10);
		
		txtMaxStud = new JTextField();
		txtMaxStud.setEditable(false);
		txtMaxStud.setBounds(210, 332, 120, 20);
		panelStatistiche.add(txtMaxStud);
		txtMaxStud.setColumns(10);
		
		txtRiempimento = new JTextField();
		txtRiempimento.setEditable(false);
		txtRiempimento.setBounds(210, 363, 120, 20);
		panelStatistiche.add(txtRiempimento);
		txtRiempimento.setColumns(10);
		
		JLabel lblMinStud = new JLabel("Studenti minimi");
		lblMinStud.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinStud.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMinStud.setBounds(60, 303, 140, 14);
		panelStatistiche.add(lblMinStud);
		
		JLabel lblMaxStud = new JLabel("Studenti massimi");
		lblMaxStud.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxStud.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxStud.setBounds(60, 334, 140, 14);
		panelStatistiche.add(lblMaxStud);
		
		JLabel lblRiempimento = new JLabel("Riempimento medio");
		lblRiempimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblRiempimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRiempimento.setBounds(60, 365, 140, 14);
		panelStatistiche.add(lblRiempimento);
		
		JPanel panelNewAreeTematiche = new JPanel();
		panelNewAreeTematiche.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelNewAreeTematiche, "name_363800109925200");
		panelNewAreeTematiche.setLayout(null);
		
		JLabel lblNewAree = new JLabel("CREA AREE TEMATICHE");
		lblNewAree.setForeground(Color.RED);
		lblNewAree.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewAree.setBounds(10, 11, 544, 14);
		panelNewAreeTematiche.add(lblNewAree);
		
		JScrollPane scrollPaneAree = new JScrollPane();
		scrollPaneAree.setBounds(141, 61, 281, 166);
		panelNewAreeTematiche.add(scrollPaneAree);
		
		JTextArea txtNewAreeTematiche = new JTextArea();
		scrollPaneAree.setViewportView(txtNewAreeTematiche);
		txtNewAreeTematiche.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtNewAreeTematiche.setEditable(false);
		
		JLabel lblAlertNewAree = new JLabel("Seleziona l'id del corso");
		lblAlertNewAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertNewAree.setForeground(Color.BLUE);
		lblAlertNewAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertNewAree.setBounds(139, 36, 283, 14);
		panelNewAreeTematiche.add(lblAlertNewAree);
		
		JButton btnSelezionaNewAree = new JButton("SELEZIONA");
		btnSelezionaNewAree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tryParse(txtNewAreeTematiche.getSelectedText())!=null) {
					int id = tryParse(txtNewAreeTematiche.getSelectedText());
					
					txtIdAree.setText(Integer.toString(id));
				}
				else {
					c.alertSeleziona();
				}
			}
		});
		btnSelezionaNewAree.setBounds(322, 236, 100, 23);
		panelNewAreeTematiche.add(btnSelezionaNewAree);
		
		txtTipoAree = new JTextField();
		txtTipoAree.setBounds(141, 270, 184, 20);
		panelNewAreeTematiche.add(txtTipoAree);
		txtTipoAree.setColumns(10);
		
		txtDescAree = new JTextField();
		txtDescAree.setBounds(141, 301, 184, 20);
		panelNewAreeTematiche.add(txtDescAree);
		txtDescAree.setColumns(10);
		
		txtIdAree = new JTextField();
		txtIdAree.setEditable(false);
		txtIdAree.setBounds(141, 332, 184, 20);
		panelNewAreeTematiche.add(txtIdAree);
		txtIdAree.setColumns(10);
		
		JLabel lblTipoAree = new JLabel("Tipo");
		lblTipoAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoAree.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoAree.setBounds(42, 273, 89, 14);
		panelNewAreeTematiche.add(lblTipoAree);
		
		JLabel lblDescAree = new JLabel("Descrizione");
		lblDescAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescAree.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescAree.setBounds(42, 304, 89, 14);
		panelNewAreeTematiche.add(lblDescAree);
		
		JLabel lblIdAree = new JLabel("IDCorso");
		lblIdAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdAree.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdAree.setBounds(42, 335, 89, 14);
		panelNewAreeTematiche.add(lblIdAree);
		
		JButton btnCreaAree = new JButton("CREA");
		btnCreaAree.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreaAree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtTipoAree.getText().isBlank() && !txtIdAree.getText().isBlank()) {
					String tipo = txtTipoAree.getText();
					String descrizione = txtDescAree.getText();
					int id = Integer.valueOf(txtIdAree.getText());
					
					if(c.aggiungiAree(tipo,descrizione,c.getCorso(id),op)) {
						c.confirmInsertAree();
					}
					else {
						c.alertInsertAree();
					}
				}
				else {
					c.alertInsertAree();
				}
				
				txtTipoAree.setText(null);
				txtDescAree.setText(null);
				txtIdAree.setText(null);
			}
		});
		btnCreaAree.setBounds(322, 363, 100, 23);
		panelNewAreeTematiche.add(btnCreaAree);
		
		JPanel panelSuperamento = new JPanel();
		panelSuperamento.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelSuperamento, "name_364302989866400");
		panelSuperamento.setLayout(null);
		
		JLabel lblSuperamento = new JLabel("VISUALIZZA STUDENTI IDONEI");
		lblSuperamento.setForeground(Color.RED);
		lblSuperamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuperamento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSuperamento.setBounds(10, 11, 544, 14);
		panelSuperamento.add(lblSuperamento);
		
		JLabel lblAlertSuperamento = new JLabel("Seleziona l'id del corso");
		lblAlertSuperamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertSuperamento.setForeground(Color.BLUE);
		lblAlertSuperamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertSuperamento.setBounds(141, 36, 285, 14);
		panelSuperamento.add(lblAlertSuperamento);
		
		JScrollPane scrollPaneCorsiSuperamento = new JScrollPane();
		scrollPaneCorsiSuperamento.setBounds(141, 61, 285, 165);
		panelSuperamento.add(scrollPaneCorsiSuperamento);
		
		JTextArea txtCorsiSuperamento = new JTextArea();
		scrollPaneCorsiSuperamento.setViewportView(txtCorsiSuperamento);
		txtCorsiSuperamento.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtCorsiSuperamento.setEditable(false);
		
		JScrollPane scrollPaneStudSuperamento = new JScrollPane();
		scrollPaneStudSuperamento.setBounds(141, 271, 285, 165);
		panelSuperamento.add(scrollPaneStudSuperamento);
		
		JTextArea txtStudSuperamento = new JTextArea();
		scrollPaneStudSuperamento.setViewportView(txtStudSuperamento);
		txtStudSuperamento.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtStudSuperamento.setEditable(false);
		
		JPanel panelAreeTematiche = new JPanel();
		panelAreeTematiche.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelAreeTematiche, "name_364509658303200");
		panelAreeTematiche.setLayout(null);
		
		JLabel lblAreeTematiche = new JLabel("VISUALIZZA AREE TEMATICHE PER CORSI");
		lblAreeTematiche.setForeground(Color.RED);
		lblAreeTematiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreeTematiche.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAreeTematiche.setBounds(10, 11, 544, 14);
		panelAreeTematiche.add(lblAreeTematiche);
		
		JLabel lblAlertAree = new JLabel("Seleziona l'id del corso");
		lblAlertAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertAree.setForeground(Color.BLUE);
		lblAlertAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertAree.setBounds(144, 36, 285, 14);
		panelAreeTematiche.add(lblAlertAree);
		
		JScrollPane scrollPaneAreeTema = new JScrollPane();
		scrollPaneAreeTema.setBounds(144, 61, 285, 165);
		panelAreeTematiche.add(scrollPaneAreeTema);
		
		JTextArea txtCorsiAree = new JTextArea();
		scrollPaneAreeTema.setViewportView(txtCorsiAree);
		txtCorsiAree.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtCorsiAree.setEditable(false);
		
		JScrollPane scrollPaneCorsiAree = new JScrollPane();
		scrollPaneCorsiAree.setBounds(144, 268, 285, 165);
		panelAreeTematiche.add(scrollPaneCorsiAree);
		
		JTextArea txtAreeTematiche = new JTextArea();
		scrollPaneCorsiAree.setViewportView(txtAreeTematiche);
		txtAreeTematiche.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtAreeTematiche.setEditable(false);
		
		JButton btnSelezionaSuperamento = new JButton("SELEZIONA");
		btnSelezionaSuperamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tryParse(txtCorsiSuperamento.getSelectedText())!=null) {
					int id = tryParse(txtCorsiSuperamento.getSelectedText());
					
	                txtStudSuperamento.setText(null);
	                for (Superamento sup:c.getStudSupera(c.getCorso(id))) {
	                	txtStudSuperamento.append(sup.getStud().getMatricola() + " " + sup.getStud().getNome() + " " + sup.getStud().getCognome() + "\n");
	        		}
				}
				else {
					c.alertSeleziona();
				}
			}
		});
		btnSelezionaSuperamento.setBounds(326, 237, 100, 23);
		panelSuperamento.add(btnSelezionaSuperamento);
		
		JButton btnSelezionaAree = new JButton("SELEZIONA");
		btnSelezionaAree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tryParse(txtCorsiAree.getSelectedText())!=null) {
					int id = tryParse(txtCorsiAree.getSelectedText());
					
	                txtAreeTematiche.setText(null);
	                for (AreeTematiche aree:c.getAreeCorso(c.getCorso(id),op)) {
	                	txtAreeTematiche.append(aree.getTipo() + " " + aree.getDescrizione() + "\n");
	        		}
				}
				else {
					c.alertSeleziona();
				}
			}
		});
		btnSelezionaAree.setBounds(329, 237, 100, 23);
		panelAreeTematiche.add(btnSelezionaAree);
		
		JPanel panelTermina = new JPanel();
		panelTermina.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelTermina, "name_137764646419200");
		panelTermina.setLayout(null);
		
		JLabel lblTermina = new JLabel("TERMINA CORSO");
		lblTermina.setForeground(Color.RED);
		lblTermina.setHorizontalAlignment(SwingConstants.CENTER);
		lblTermina.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTermina.setBounds(10, 11, 544, 14);
		panelTermina.add(lblTermina);
		
		JLabel lblAlertTermina = new JLabel("Seleziona l'id del corso");
		lblAlertTermina.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertTermina.setForeground(Color.BLUE);
		lblAlertTermina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertTermina.setBounds(142, 36, 285, 14);
		panelTermina.add(lblAlertTermina);
		
		JScrollPane scrollPaneTermina = new JScrollPane();
		scrollPaneTermina.setBounds(142, 61, 283, 168);
		panelTermina.add(scrollPaneTermina);
		
		JTextArea txtTermina = new JTextArea();
		scrollPaneTermina.setViewportView(txtTermina);
		txtTermina.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtTermina.setEditable(false);
		
		JButton btnTermina = new JButton("TERMINA");
		btnTermina.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTermina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tryParse(txtTermina.getSelectedText())!=null) {
					int id = tryParse(txtTermina.getSelectedText());
					
					if(c.terminaCorso(c.getCorso(id),op)) {
						c.confirmTermina();
					}
					else {
						c.alertTermina();
					}
				}
				else {
					c.alertSeleziona();
				}
			}
		});
		btnTermina.setBounds(327, 240, 100, 23);
		panelTermina.add(btnTermina);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		setJMenuBar(menuBar);
		
		JMenu mnProfilo = new JMenu("PROFILO");
		mnProfilo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnProfilo);
		
		JMenuItem mntmVisualizzaProfilo = new JMenuItem("Visualizza profilo");
		mntmVisualizzaProfilo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmVisualizzaProfilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelProfilo);
			}
		});
		mnProfilo.add(mntmVisualizzaProfilo);
		
		JMenuItem mntmLogoutProfilo = new JMenuItem("Logout");
		mntmLogoutProfilo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmLogoutProfilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op.setId(null);
				op.setNome(null);
				op.setCognome(null);
				op.setData(null);
				op.setCf(null);
				op.setCorsi(null);
				op.setPassword(null);
				
				c.logout();
			}
		});
		mnProfilo.add(mntmLogoutProfilo);
		
		JMenu mnCorsi = new JMenu("CORSI");
		mnCorsi.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnCorsi);
		
		JMenuItem mntmVisualizzaCorsi = new JMenuItem("Visualizza corsi");
		mntmVisualizzaCorsi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmVisualizzaCorsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelVisualizza);
				
				op.setCorsi(c.getCorsiOperatore(op));
				model.setRowCount(0);
                for (CorsoFormazione corso:op.getCorsi()) {
                	row[0]= corso.getIdCorso();
                	row[1]= corso.getNome();
                	row[2]= corso.getDescrizione();
                	row[3]= corso.getPresenzeMin();
                	row[4]= corso.getMaxPartecipanti();
                	model.addRow(row);
        		}
			}
		});
		mnCorsi.add(mntmVisualizzaCorsi);
		
		JMenuItem mntmInserisciCorsi = new JMenuItem("Inserisci corso");
		mntmInserisciCorsi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmInserisciCorsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelInserisci);
			}
		});
		mnCorsi.add(mntmInserisciCorsi);
		
		JMenuItem mntmModificaCorso = new JMenuItem("Modifica corso");
		mntmModificaCorso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmModificaCorso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelModifica);
				
				op.setCorsi(c.getCorsiOperatore(op));
                txtModifica.setText(null);
                for (CorsoFormazione corso:op.getCorsi()) {
        			txtModifica.append(corso.getIdCorso() + " " + corso.getNome() + " " + corso.getDescrizione() + "\n");
        		}
			}

		});
		mnCorsi.add(mntmModificaCorso);
		
		JMenuItem mntmTerminaCorso = new JMenuItem("Termina corso");
		mntmTerminaCorso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmTerminaCorso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelTermina);
				
				txtTermina.setText(null);
                for (CorsoFormazione corso:c.getCorsiNoTermina(op)) {
                	txtTermina.append(corso.getIdCorso() + " " + corso.getNome() + " " + corso.getDescrizione() + "\n");
        		}
			}
		});
		mnCorsi.add(mntmTerminaCorso);
		
		JMenu mnStatistiche = new JMenu("STATISTICHE");
		mnStatistiche.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnStatistiche);
		
		JMenuItem mntmVisualizzaStat = new JMenuItem("Visualizza Statistiche");
		mntmVisualizzaStat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmVisualizzaStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelStatistiche);
				
                txtStatistiche.setText(null);
                for (CorsoFormazione corso:c.getCorsiTermina(op)) {
                	txtStatistiche.append(corso.getIdCorso() + " " + corso.getNome() + " " + corso.getDescrizione() + "\n");
        		}
			}
		});
		mnStatistiche.add(mntmVisualizzaStat);
		
		JMenuItem mntmStudIdonei = new JMenuItem("Studenti Idonei");
		mntmStudIdonei.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmStudIdonei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelSuperamento);
				
				txtCorsiSuperamento.setText(null);
                for (CorsoFormazione corso:c.getCorsiTermina(op)) {
                	txtCorsiSuperamento.append(corso.getIdCorso() + " " + corso.getNome() + " " + corso.getDescrizione() + "\n");
        		}
			}
		});
		mnStatistiche.add(mntmStudIdonei);
		
		JMenu mnAreeTematiche = new JMenu("AREE TEMATICHE");
		mnAreeTematiche.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnAreeTematiche);
		
		JMenuItem mntmCreaAree = new JMenuItem("Crea Aree Tematiche");
		mntmCreaAree.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmCreaAree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelNewAreeTematiche);
				
				op.setCorsi(c.getCorsiOperatore(op));
                txtNewAreeTematiche.setText(null);
                for (CorsoFormazione corso:op.getCorsi()) {
                	txtNewAreeTematiche.append(corso.getIdCorso() + " " + corso.getNome() + " " + corso.getDescrizione() + "\n");
        		}
			}
		});
		mnAreeTematiche.add(mntmCreaAree);
		
		JMenuItem mntmVisualizzaAree = new JMenuItem("Visualizza Aree Tematiche");
		mntmVisualizzaAree.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmVisualizzaAree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelAreeTematiche);
				
				op.setCorsi(c.getCorsiOperatore(op));
                txtCorsiAree.setText(null);
                for (CorsoFormazione corso:c.getCorsiOperatore(op)) {
                	txtCorsiAree.append(corso.getIdCorso() + " " + corso.getNome() + " " + corso.getDescrizione() + "\n");
        		}
			}
		});
		mnAreeTematiche.add(mntmVisualizzaAree);
	}
}
