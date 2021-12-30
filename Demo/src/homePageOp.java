import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
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
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;

public class homePageOp extends JFrame {

	private JPanel contentPane;
	Controller TheController;
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtData;
	private JTextField txtCf;
	private JTextField txtID;
	private JTextField txtInsertNome;
	private JTextField txtInsertDesc;
	private JTextField txtInsertPresenze;
	private JTextField txtInsertPartecipanti;
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

	public homePageOp(Controller c, String id, String pwd) {
		setResizable(false);
		setTitle("OPERATORE");
		
		TheController= c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProfilo = new JLabel("PROFILO OPERATORE");
		lblProfilo.setForeground(Color.RED);
		lblProfilo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfilo.setBounds(10, 21, 181, 22);
		contentPane.add(lblProfilo);
		
		txtNome = new JTextField();
		txtNome.setDisabledTextColor(new Color(109, 109, 109));
		txtNome.setBackground(new Color(255, 255, 255));
		txtNome.setEditable(false);
		txtNome.setBounds(118, 54, 135, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setEditable(false);
		txtCognome.setBounds(118, 87, 135, 22);
		contentPane.add(txtCognome);
		txtCognome.setColumns(10);
		
		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setBounds(118, 120, 135, 22);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		txtCf = new JTextField();
		txtCf.setEditable(false);
		txtCf.setBounds(118, 153, 135, 22);
		contentPane.add(txtCf);
		txtCf.setColumns(10);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(118, 192, 135, 22);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 54, 98, 22);
		contentPane.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCognome.setBounds(10, 91, 98, 22);
		contentPane.add(lblCognome);
		
		JLabel lblData = new JLabel("Data di Nascita");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 124, 98, 22);
		contentPane.add(lblData);
		
		JLabel lblCf = new JLabel("Codice Fiscale");
		lblCf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCf.setBounds(10, 157, 98, 22);
		contentPane.add(lblCf);
		
		JLabel lblID = new JLabel("Id");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblID.setBounds(10, 189, 98, 22);
		contentPane.add(lblID);
		
		Operatore op = new Operatore();
		op.setId(id);
		op.setPassword(pwd);
		op.setNome(c.getOp(id).getNome());
		op.setCognome(c.getOp(id).getCognome());
		op.setData(c.getOp(id).getData());
		op.setCf(c.getOp(id).getCf());
		op.setCorsi(c.getCorsi(op));
		
		txtNome.setText(op.getNome());
		txtCognome.setText(op.getCognome());
		
		Date data = op.getData();
		String strdata = data.toString();
		
		txtData.setText(strdata);
		txtCf.setText(op.getCf());
		txtID.setText(id);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.LIGHT_GRAY);
		layeredPane.setBounds(282, 11, 342, 489);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JLayeredPane panelVisualizza = new JLayeredPane();
		layeredPane.add(panelVisualizza, "name_265649558857400");
		panelVisualizza.setLayout(null);
		
		JScrollPane scrollPaneVisualizza = new JScrollPane();
		scrollPaneVisualizza.setBounds(33, 78, 276, 186);
		panelVisualizza.add(scrollPaneVisualizza);
		
		JTextArea txtVisualizza = new JTextArea();
		scrollPaneVisualizza.setViewportView(txtVisualizza);
		txtVisualizza.setEditable(false);
		txtVisualizza.setFont(new Font("Monospaced", Font.PLAIN, 16));
		
		JLabel lblVisualizza = new JLabel("VISUALIZZA CORSI");
		lblVisualizza.setBounds(10, 11, 322, 20);
		lblVisualizza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVisualizza.setHorizontalAlignment(SwingConstants.CENTER);
		panelVisualizza.add(lblVisualizza);
		
		JPanel panelInserisci = new JPanel();
		layeredPane.add(panelInserisci, "name_265649587309300");
		panelInserisci.setLayout(null);
		
		JLabel lblInserisci = new JLabel("INSERISCI CORSO");
		lblInserisci.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInserisci.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisci.setBounds(10, 11, 322, 14);
		panelInserisci.add(lblInserisci);
		
		txtInsertNome = new JTextField();
		txtInsertNome.setBounds(147, 123, 150, 20);
		panelInserisci.add(txtInsertNome);
		txtInsertNome.setColumns(10);
		
		txtInsertDesc = new JTextField();
		txtInsertDesc.setBounds(147, 154, 150, 20);
		panelInserisci.add(txtInsertDesc);
		txtInsertDesc.setColumns(10);
		
		txtInsertPresenze = new JTextField();
		txtInsertPresenze.setBounds(147, 185, 150, 20);
		panelInserisci.add(txtInsertPresenze);
		txtInsertPresenze.setColumns(10);
		
		txtInsertPartecipanti = new JTextField();
		txtInsertPartecipanti.setBounds(147, 216, 150, 20);
		panelInserisci.add(txtInsertPartecipanti);
		txtInsertPartecipanti.setColumns(10);
		
		JLabel lblNomeCorso = new JLabel("Nome");
		lblNomeCorso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCorso.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCorso.setBounds(10, 124, 106, 14);
		panelInserisci.add(lblNomeCorso);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrizione.setBounds(10, 155, 106, 14);
		panelInserisci.add(lblDescrizione);
		
		JLabel lblPresenze = new JLabel("Presenze Minime");
		lblPresenze.setHorizontalAlignment(SwingConstants.CENTER);
		lblPresenze.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPresenze.setBounds(10, 186, 106, 14);
		panelInserisci.add(lblPresenze);
		
		JLabel lblPartecipanti = new JLabel("Partecipanti Max");
		lblPartecipanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartecipanti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPartecipanti.setBounds(10, 217, 106, 14);
		panelInserisci.add(lblPartecipanti);
		
		JButton btnInserimento = new JButton("INSERISCI");
		btnInserimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnInserimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtInsertNome.getText().isBlank() && !txtInsertPresenze.getText().isBlank() && !txtInsertPartecipanti.getText().isBlank()) {
					String nome = txtInsertNome.getText();
					String descrizione = txtInsertDesc.getText();
					int presenze = Integer.valueOf(txtInsertPresenze.getText());
					int partecipanti = Integer.valueOf(txtInsertPartecipanti.getText());
					
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
		btnInserimento.setBounds(236, 271, 96, 23);
		panelInserisci.add(btnInserimento);
		
		JPanel panelModifica = new JPanel();
		layeredPane.add(panelModifica, "name_265649613267400");
		panelModifica.setLayout(null);
		
		JLabel lblModifica = new JLabel("MODIFICA CORSO");
		lblModifica.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifica.setBounds(10, 11, 322, 14);
		panelModifica.add(lblModifica);
		
		JScrollPane scrollPaneModifica = new JScrollPane();
		scrollPaneModifica.setBounds(34, 61, 275, 178);
		panelModifica.add(scrollPaneModifica);
		
		JTextArea txtModifica = new JTextArea();
		scrollPaneModifica.setViewportView(txtModifica);
		txtModifica.setEditable(false);
		txtModifica.setFont(new Font("Monospaced", Font.PLAIN, 16));
		
		JButton btnSelezionaMod = new JButton("Seleziona");
		btnSelezionaMod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSelezionaMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtModifica.getSelectedText()!=null) {
					int id = Integer.valueOf(txtModifica.getSelectedText());
					
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
		btnSelezionaMod.setBounds(220, 250, 89, 23);
		panelModifica.add(btnSelezionaMod);
		
		txtModificaNome = new JTextField();
		txtModificaNome.setBounds(154, 300, 150, 20);
		panelModifica.add(txtModificaNome);
		txtModificaNome.setColumns(10);
		
		txtModificaDesc = new JTextField();
		txtModificaDesc.setBounds(154, 331, 150, 20);
		panelModifica.add(txtModificaDesc);
		txtModificaDesc.setColumns(10);
		
		txtModificaPresenze = new JTextField();
		txtModificaPresenze.setBounds(154, 362, 150, 20);
		panelModifica.add(txtModificaPresenze);
		txtModificaPresenze.setColumns(10);
		
		txtModificaPartecipanti = new JTextField();
		txtModificaPartecipanti.setBounds(154, 393, 150, 20);
		panelModifica.add(txtModificaPartecipanti);
		txtModificaPartecipanti.setColumns(10);
		
		JLabel lblModNome = new JLabel("Nome");
		lblModNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblModNome.setBounds(24, 301, 120, 14);
		panelModifica.add(lblModNome);
		
		JLabel lblModDesc = new JLabel("Descrizione");
		lblModDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModDesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblModDesc.setBounds(24, 332, 120, 14);
		panelModifica.add(lblModDesc);
		
		JLabel lblModPresenze = new JLabel("Presenze minime");
		lblModPresenze.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModPresenze.setHorizontalAlignment(SwingConstants.CENTER);
		lblModPresenze.setBounds(24, 363, 120, 14);
		panelModifica.add(lblModPresenze);
		
		JLabel lblModPartecipanti = new JLabel("Partecipanti max");
		lblModPartecipanti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModPartecipanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblModPartecipanti.setBounds(24, 394, 120, 14);
		panelModifica.add(lblModPartecipanti);
		
		JButton btnAggiorna = new JButton("AGGIORNA");
		btnAggiorna.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtModificaNome.getText().isBlank() && !txtModificaPresenze.getText().isBlank() && !txtModificaPartecipanti.getText().isBlank() && !txtModificaID.getText().isBlank()) {
					String nome = txtModificaNome.getText();
					String descrizione = txtModificaDesc.getText();
					int presenze = Integer.valueOf(txtModificaPresenze.getText());
					int partecipanti = Integer.valueOf(txtModificaPartecipanti.getText());
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
		btnAggiorna.setBounds(232, 455, 100, 23);
		panelModifica.add(btnAggiorna);
		
		txtModificaID = new JTextField();
		txtModificaID.setEditable(false);
		txtModificaID.setBounds(154, 424, 150, 20);
		panelModifica.add(txtModificaID);
		txtModificaID.setColumns(10);
		
		JLabel lblModID = new JLabel("idCorso");
		lblModID.setHorizontalAlignment(SwingConstants.CENTER);
		lblModID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModID.setBounds(33, 425, 111, 14);
		panelModifica.add(lblModID);
		
		JLabel lblAlertModifica = new JLabel("Seleziona l'id del corso");
		lblAlertModifica.setForeground(Color.BLUE);
		lblAlertModifica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertModifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertModifica.setBounds(34, 36, 275, 14);
		panelModifica.add(lblAlertModifica);
		
		JPanel panelStatistiche = new JPanel();
		layeredPane.add(panelStatistiche, "name_265649639062799");
		panelStatistiche.setLayout(null);
		
		JLabel lblStatistiche = new JLabel("STATISTICHE");
		lblStatistiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistiche.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatistiche.setBounds(10, 11, 322, 14);
		panelStatistiche.add(lblStatistiche);
		
		JLabel lblAlertStatistiche = new JLabel("Seleziona l'id del corso");
		lblAlertStatistiche.setForeground(Color.BLUE);
		lblAlertStatistiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertStatistiche.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertStatistiche.setBounds(28, 36, 288, 14);
		panelStatistiche.add(lblAlertStatistiche);
		
		txtNumMedio = new JTextField();
		txtNumMedio.setEditable(false);
		txtNumMedio.setBounds(166, 316, 150, 20);
		panelStatistiche.add(txtNumMedio);
		txtNumMedio.setColumns(10);
		
		txtMinStud = new JTextField();
		txtMinStud.setEditable(false);
		txtMinStud.setBounds(166, 347, 150, 20);
		panelStatistiche.add(txtMinStud);
		txtMinStud.setColumns(10);
		
		txtMaxStud = new JTextField();
		txtMaxStud.setEditable(false);
		txtMaxStud.setBounds(166, 375, 150, 20);
		panelStatistiche.add(txtMaxStud);
		txtMaxStud.setColumns(10);
		
		txtRiempimento = new JTextField();
		txtRiempimento.setEditable(false);
		txtRiempimento.setBounds(166, 406, 150, 20);
		panelStatistiche.add(txtRiempimento);
		txtRiempimento.setColumns(10);
		
		JLabel lblNumMedio = new JLabel("Numero medio studenti ");
		lblNumMedio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumMedio.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumMedio.setBounds(10, 319, 146, 17);
		panelStatistiche.add(lblNumMedio);
		
		JLabel lblMinStud = new JLabel("Studenti minimi");
		lblMinStud.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMinStud.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinStud.setBounds(10, 350, 146, 14);
		panelStatistiche.add(lblMinStud);
		
		JLabel lblMaxStud = new JLabel("Studenti massimi");
		lblMaxStud.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaxStud.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxStud.setBounds(10, 378, 146, 14);
		panelStatistiche.add(lblMaxStud);
		
		JLabel lblRiempimento = new JLabel("Riempimento medio");
		lblRiempimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRiempimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblRiempimento.setBounds(10, 409, 146, 14);
		panelStatistiche.add(lblRiempimento);
		
		JScrollPane scrollPaneStatistiche = new JScrollPane();
		scrollPaneStatistiche.setBounds(28, 61, 286, 192);
		panelStatistiche.add(scrollPaneStatistiche);
		
		JTextArea txtStatistiche = new JTextArea();
		scrollPaneStatistiche.setViewportView(txtStatistiche);
		txtStatistiche.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtStatistiche.setEditable(false);
		
		JPanel panelNewAreeTematiche = new JPanel();
		layeredPane.add(panelNewAreeTematiche, "name_265649664779800");
		panelNewAreeTematiche.setLayout(null);
		
		JLabel lblAreeTematiche = new JLabel("CREA AREE TEMATICHE");
		lblAreeTematiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreeTematiche.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAreeTematiche.setBounds(10, 11, 322, 14);
		panelNewAreeTematiche.add(lblAreeTematiche);
		
		JScrollPane scrollPaneAreeTematiche = new JScrollPane();
		scrollPaneAreeTematiche.setBounds(36, 60, 270, 182);
		panelNewAreeTematiche.add(scrollPaneAreeTematiche);
		
		JTextArea txtAreeTematiche = new JTextArea();
		scrollPaneAreeTematiche.setViewportView(txtAreeTematiche);
		txtAreeTematiche.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtAreeTematiche.setEditable(false);
		
		JLabel lblAlertAreeTematiche = new JLabel("Seleziona l'id del corso");
		lblAlertAreeTematiche.setForeground(Color.BLUE);
		lblAlertAreeTematiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertAreeTematiche.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertAreeTematiche.setBounds(34, 36, 268, 14);
		panelNewAreeTematiche.add(lblAlertAreeTematiche);
		
		JButton btnSelezionaAree = new JButton("Seleziona");
		btnSelezionaAree.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSelezionaAree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtAreeTematiche.getSelectedText()!=null) {
					int id = Integer.valueOf(txtAreeTematiche.getSelectedText());
					
					txtIdAree.setText(Integer.toString(id));
				}
				else {
					c.alertSeleziona();
				}
			}
		});
		btnSelezionaAree.setBounds(217, 253, 89, 23);
		panelNewAreeTematiche.add(btnSelezionaAree);
		
		txtTipoAree = new JTextField();
		txtTipoAree.setBounds(156, 304, 150, 20);
		panelNewAreeTematiche.add(txtTipoAree);
		txtTipoAree.setColumns(10);
		
		txtDescAree = new JTextField();
		txtDescAree.setBounds(156, 335, 150, 20);
		panelNewAreeTematiche.add(txtDescAree);
		txtDescAree.setColumns(10);
		
		txtIdAree = new JTextField();
		txtIdAree.setEditable(false);
		txtIdAree.setBounds(156, 366, 150, 20);
		panelNewAreeTematiche.add(txtIdAree);
		txtIdAree.setColumns(10);
		
		JLabel lblTipoAree = new JLabel("Tipo");
		lblTipoAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoAree.setBounds(57, 303, 89, 18);
		panelNewAreeTematiche.add(lblTipoAree);
		
		JLabel lblDescAree = new JLabel("Descrizione");
		lblDescAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescAree.setBounds(57, 338, 89, 14);
		panelNewAreeTematiche.add(lblDescAree);
		
		JLabel lblIdAree = new JLabel("idCorso");
		lblIdAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdAree.setBounds(57, 369, 89, 14);
		panelNewAreeTematiche.add(lblIdAree);
		
		JButton btnCreaAree = new JButton("CREA");
		btnCreaAree.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCreaAree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtTipoAree.getText().isBlank() && !txtIdAree.getText().isBlank()) {
					String tipo = txtTipoAree.getText();
					String descrizione = txtDescAree.getText();
					int id = Integer.valueOf(txtIdAree.getText());
					
					if(c.aggiungiAree(tipo,descrizione,c.getCorso(id))) {
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
		btnCreaAree.setBounds(243, 411, 89, 23);
		panelNewAreeTematiche.add(btnCreaAree);
		
		JButton btnVisualizza = new JButton("Visualizza Corsi");
		btnVisualizza.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVisualizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
                layeredPane.add(panelVisualizza);
                layeredPane.repaint();
                layeredPane.revalidate();
                
                op.setCorsi(c.getCorsi(op));
                txtVisualizza.setText(null);
                for (CorsoFormazione corso:op.getCorsi()) {
        			txtVisualizza.append(corso.getIdCorso() + " " + corso.getNome() + "\n");
        		}
			}
		});
		btnVisualizza.setBounds(10, 375, 120, 23);
		contentPane.add(btnVisualizza);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogout.addActionListener(new ActionListener() {
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
		btnLogout.setBounds(10, 222, 89, 23);
		contentPane.add(btnLogout);
		
		JButton btnStatistiche = new JButton("Statistiche corso");
		btnStatistiche.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnStatistiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
                layeredPane.add(panelStatistiche);
                layeredPane.repaint();
                layeredPane.revalidate();
                
                op.setCorsi(c.getCorsi(op));
                txtStatistiche.setText(null);
                for (CorsoFormazione corso:op.getCorsi()) {
                	txtStatistiche.append(corso.getIdCorso() + " " + corso.getNome() + "\n");
        		}
			}
		});
		btnStatistiche.setBounds(142, 375, 130, 23);
		contentPane.add(btnStatistiche);
		
		JButton btnAreeTematiche = new JButton("Aree Tematiche");
		btnAreeTematiche.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAreeTematiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
                layeredPane.add(panelNewAreeTematiche);
                layeredPane.repaint();
                layeredPane.revalidate();
                
                op.setCorsi(c.getCorsi(op));
                txtAreeTematiche.setText(null);
                for (CorsoFormazione corso:op.getCorsi()) {
                	txtAreeTematiche.append(corso.getIdCorso() + " " + corso.getNome() + "\n");
        		}
			}
		});
		btnAreeTematiche.setBounds(77, 409, 125, 23);
		contentPane.add(btnAreeTematiche);
		
		JButton btnInserisci = new JButton("INSERISCI CORSO");
		btnInserisci.setBounds(10, 309, 135, 23);
		btnInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
                layeredPane.add(panelInserisci);
                layeredPane.repaint();
                layeredPane.revalidate();
			}
		});
		panelVisualizza.add(btnInserisci);
		
		JButton btnModifica = new JButton("MODIFICA CORSO");
		btnModifica.setBounds(197, 309, 135, 23);
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
                layeredPane.add(panelModifica);
                layeredPane.repaint();
                layeredPane.revalidate();
                
                op.setCorsi(c.getCorsi(op));
                txtModifica.setText(null);
                for (CorsoFormazione corso:op.getCorsi()) {
        			txtModifica.append(corso.getIdCorso() + " " + corso.getNome() + "\n");
        		}
			}
		});
		panelVisualizza.add(btnModifica);
		
		JButton btnSelezionaStatistiche = new JButton("Seleziona");
		btnSelezionaStatistiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtStatistiche.getSelectedText()!=null) {
					int id = Integer.valueOf(txtStatistiche.getSelectedText());
					
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
		btnSelezionaStatistiche.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSelezionaStatistiche.setBounds(227, 264, 89, 23);
		panelStatistiche.add(btnSelezionaStatistiche);
		
		JButton btnSuperamentoCorso = new JButton("SUPERAMENTO CORSO");
		btnSuperamentoCorso.setBounds(182, 455, 150, 23);
		panelStatistiche.add(btnSuperamentoCorso);
	}
}
