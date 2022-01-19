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
import java.awt.Dimension;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class homePageOp extends JFrame {

	private JPanel contentPane;
	private JTextField txtInsertNome;
	private JTextField txtInsertDesc;
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
	private JTextField txtTipoAree;
	private JTextField txtDescAree;
	private JTextField txtIdAree;
	Controller TheController;
	private JTable tableCorsi;
	DefaultTableModel modelCorsi;
	private JTable tableModifica;
	DefaultTableModel modelModifica;
	private JTable tableNewAree;
	DefaultTableModel modelNewAree;
	private JTable tableStatistiche;
	DefaultTableModel modelStatistiche;
	private JTable tableTermina;
	DefaultTableModel modelTermina;
	private JTable tableCorsiAree;
	DefaultTableModel modelCorsiAree;
	private JTable tableLezioni;
	DefaultTableModel modelLezioni;

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
		setBounds(100, 100, 650, 550);
		
		TheController= c;
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 614, 463);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelProfilo = new JPanel();
		panelProfilo.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelProfilo, "name_680381200185900");
		panelProfilo.setLayout(null);
		
		JLabel lblProfilo = new JLabel("PROFILO OPERATORE");
		lblProfilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfilo.setForeground(Color.RED);
		lblProfilo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblProfilo.setLabelFor(panelProfilo);
		lblProfilo.setBounds(10, 11, 594, 31);
		panelProfilo.add(lblProfilo);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setText((String) null);
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(168, 80, 200, 22);
		panelProfilo.add(txtNome);
		
		txtCognome = new JTextField();
		txtCognome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCognome.setText((String) null);
		txtCognome.setEditable(false);
		txtCognome.setColumns(10);
		txtCognome.setBounds(168, 115, 200, 22);
		panelProfilo.add(txtCognome);
		
		txtDataNascita = new JTextField();
		txtDataNascita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDataNascita.setText("<dynamic>\r\n");
		txtDataNascita.setEditable(false);
		txtDataNascita.setColumns(10);
		txtDataNascita.setBounds(168, 150, 200, 22);
		panelProfilo.add(txtDataNascita);
		
		txtCF = new JTextField();
		txtCF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCF.setText((String) null);
		txtCF.setEditable(false);
		txtCF.setColumns(10);
		txtCF.setBounds(168, 185, 200, 22);
		panelProfilo.add(txtCF);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtID.setText("<dynamic>");
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(168, 220, 200, 22);
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
		lblNome.setBounds(38, 84, 120, 14);
		panelProfilo.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCognome.setBounds(38, 115, 120, 22);
		panelProfilo.add(lblCognome);
		
		JLabel lblData = new JLabel("Data di nascita");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(38, 154, 120, 14);
		panelProfilo.add(lblData);
		
		JLabel lblCf = new JLabel("Codice Fiscale");
		lblCf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCf.setBounds(38, 189, 120, 14);
		panelProfilo.add(lblCf);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(38, 224, 120, 14);
		panelProfilo.add(lblId);
		
		JPanel panelInserisci = new JPanel();
		panelInserisci.setBackground(new Color(176, 224, 230));
		panelInserisci.setLayout(null);
		layeredPane.add(panelInserisci, "name_679299759213300");
		
		JLabel lblInserisci = new JLabel("INSERISCI CORSO");
		lblInserisci.setForeground(Color.RED);
		lblInserisci.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisci.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblInserisci.setBounds(10, 11, 594, 14);
		panelInserisci.add(lblInserisci);
		
		txtInsertNome = new JTextField();
		txtInsertNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInsertNome.setColumns(10);
		txtInsertNome.setBounds(160, 123, 175, 20);
		panelInserisci.add(txtInsertNome);
		
		txtInsertDesc = new JTextField();
		txtInsertDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInsertDesc.setColumns(10);
		txtInsertDesc.setBounds(160, 154, 175, 20);
		panelInserisci.add(txtInsertDesc);
		
		txtInsertPartecipanti = new JTextField();
		txtInsertPartecipanti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtInsertPartecipanti.setColumns(10);
		txtInsertPartecipanti.setBounds(160, 226, 175, 20);
		panelInserisci.add(txtInsertPartecipanti);
		
		JLabel lblNomeCorso = new JLabel("Nome");
		lblNomeCorso.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCorso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeCorso.setBounds(20, 126, 130, 14);
		panelInserisci.add(lblNomeCorso);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrizione.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrizione.setBounds(20, 157, 130, 14);
		panelInserisci.add(lblDescrizione);
		
		JLabel lblPresenze = new JLabel("Presenze Minime[%]");
		lblPresenze.setHorizontalAlignment(SwingConstants.CENTER);
		lblPresenze.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPresenze.setBounds(20, 192, 130, 18);
		panelInserisci.add(lblPresenze);
		
		JLabel lblPartecipanti = new JLabel("Partecipanti Max");
		lblPartecipanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartecipanti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPartecipanti.setBounds(20, 227, 130, 18);
		panelInserisci.add(lblPartecipanti);
		
		JLabel lblInsertPercentuale = new JLabel("");
		lblInsertPercentuale.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsertPercentuale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInsertPercentuale.setBounds(343, 192, 40, 14);
		panelInserisci.add(lblInsertPercentuale);
		
		JSlider sliderInsertPresenze = new JSlider();
		sliderInsertPresenze.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sliderInsertPresenze.setEnabled(true);
			}
		});
		sliderInsertPresenze.setEnabled(false);
		sliderInsertPresenze.setSnapToTicks(true);
		sliderInsertPresenze.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(sliderInsertPresenze.isEnabled()) {
					lblInsertPercentuale.setText(Integer.toString(sliderInsertPresenze.getValue()) + "%");
				}
				else {
					lblInsertPercentuale.setText("");
				}
			}
		});
		sliderInsertPresenze.setValue(0);
		sliderInsertPresenze.setPaintTicks(true);
		sliderInsertPresenze.setMinorTickSpacing(5);
		sliderInsertPresenze.setMajorTickSpacing(25);
		sliderInsertPresenze.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderInsertPresenze.setBounds(160, 185, 175, 30);
		panelInserisci.add(sliderInsertPresenze);
		
		JButton btnInserimento = new JButton("INSERISCI");
		btnInserimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtInsertNome.getText().isBlank() && sliderInsertPresenze.isEnabled() && tryParse(txtInsertPartecipanti.getText())!=null) {
					String nome = txtInsertNome.getText();
					String descrizione = txtInsertDesc.getText();
					int presenze = sliderInsertPresenze.getValue();
					int partecipanti = tryParse(txtInsertPartecipanti.getText());
					long millis=System.currentTimeMillis();
					Date datacreazione=new Date(millis);
					
					if(c.inserisciCorso(nome,descrizione,datacreazione,presenze,partecipanti,op)){
						c.confirmInsert();
					}
					else {
						c.alertInsert();
					}
				}
				else {
					c.alertInsert();
				}
				
				txtInsertNome.setText(null);
				txtInsertDesc.setText(null);
				sliderInsertPresenze.setEnabled(false);
				sliderInsertPresenze.setValue(0);
				txtInsertPartecipanti.setText(null);
			}
		});
		btnInserimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnInserimento.setBounds(343, 257, 100, 23);
		panelInserisci.add(btnInserimento);
		
		JPanel panelLezioni = new JPanel();
		panelLezioni.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelLezioni, "name_98411522070500");
		panelLezioni.setLayout(null);
		
		JLabel lblLezioni = new JLabel("VISUALIZZA LEZIONI");
		lblLezioni.setForeground(Color.RED);
		lblLezioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblLezioni.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLezioni.setBounds(10, 11, 594, 14);
		panelLezioni.add(lblLezioni);
		
		JScrollPane scrollPaneLezioni = new JScrollPane();
		scrollPaneLezioni.setBounds(10, 61, 594, 220);
		panelLezioni.add(scrollPaneLezioni);
		
		tableLezioni = new JTable();
		modelLezioni = new DefaultTableModel();
		Object[] columnLezioni= {"ID", "Titolo", "Durata", "Data inizio", "Orario inizio"};
		Object [] rowLezioni= new Object[5];
		tableLezioni.setModel(modelLezioni);
		modelLezioni.setColumnIdentifiers(columnLezioni);
		scrollPaneLezioni.setViewportView(tableLezioni);
		
		JButton btnPresenze = new JButton("PRESENZE");
		btnPresenze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableLezioni.getSelectedRow() != -1) {
					JTable table = new JTable();
					DefaultTableModel model = new DefaultTableModel();
					Object[] cols = {"Matricola", "Nome", "Cognome"};
					Object[] row = new Object[3];
					table.setModel(model);
					model.setColumnIdentifiers(cols);
					
					
					model.setRowCount(0);
					for (Partecipa presenza:c.getPartecipaLezione(c.getLezione((int) (modelLezioni.getValueAt(tableLezioni.getSelectedRow(), 0))))) {
	                	row[0] = presenza.getStudente().getMatricola();
	                	row[1] = presenza.getStudente().getNome();
	                	row[2] = presenza.getStudente().getCognome();
	                	model.addRow(row);
	        		}
	                
	                JScrollPane scroll = new JScrollPane(table);
	                scroll.setPreferredSize(new Dimension(275,125));
					
					c.aggiungiTabella(scroll,"PRESENZE STUDENTI");
				}
				else {
					c.alertSeleziona();
				}
			}
		});
		btnPresenze.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPresenze.setBounds(155, 292, 115, 23);
		panelLezioni.add(btnPresenze);
		
		JButton btnIscrizioni = new JButton("ISCRIZIONI");
		btnIscrizioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable table = new JTable();
				DefaultTableModel model = new DefaultTableModel();
				Object[] cols = {"Matricola", "Nome", "Cognome"};
				Object[] row = new Object[3];
				table.setModel(model);
				model.setColumnIdentifiers(cols);
				
				model.setRowCount(0);
				for (Iscritto isc:c.getIscrizioniCorso(c.getCorso((int) (modelCorsi.getValueAt(tableCorsi.getSelectedRow(), 0))))) {
                	row[0] = isc.getStudente().getMatricola();
                	row[1] = isc.getStudente().getNome();
                	row[2] = isc.getStudente().getCognome();
                	model.addRow(row);
        		}
                
                JScrollPane scroll = new JScrollPane(table);
                scroll.setPreferredSize(new Dimension(275,125));
				
                c.aggiungiTabella(scroll,"ISCRIZIONI CORSO");
			}
		});
		btnIscrizioni.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIscrizioni.setBounds(350, 292, 115, 23);
		panelLezioni.add(btnIscrizioni);
		
		JPanel panelCorsi = new JPanel();
		panelCorsi.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelCorsi, "name_302338902470800");
		panelCorsi.setLayout(null);
		
		JLabel lblCorsi = new JLabel("VISUALIZZA CORSI");
		lblCorsi.setForeground(Color.RED);
		lblCorsi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCorsi.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorsi.setBounds(10, 11, 594, 14);
		panelCorsi.add(lblCorsi);
		
		JScrollPane scrollPaneCorsi = new JScrollPane();
		scrollPaneCorsi.setBounds(10, 69, 594, 270);
		panelCorsi.add(scrollPaneCorsi);
		
		tableCorsi = new JTable();
		tableCorsi.setToolTipText("visualizza lezioni corso");
		tableCorsi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modelLezioni.setRowCount(0);
                for (Lezione lez:c.getLezioniCorso(c.getCorso((int) (modelCorsi.getValueAt(tableCorsi.getSelectedRow(), 0))))) {
                	rowLezioni[0] = lez.getIdlezione();
                	rowLezioni[1] = lez.getTitolo();
                	rowLezioni[2] = lez.getDurata();
                	rowLezioni[3] = lez.getDatainizio();
                	rowLezioni[4] = lez.getOrarioinizio();
                	modelLezioni.addRow(rowLezioni);
        		}
				
				switchPanel(layeredPane,panelLezioni);
			}
		});
		modelCorsi = new DefaultTableModel();
		Object[] columnCorsi = {"ID", "Nome", "Descrizione", "Data", "PresenzeMin[%]", "maxPartecipanti"};
		Object [] rowCorsi = new Object[6];
		tableCorsi.setModel(modelCorsi);
		modelCorsi.setColumnIdentifiers(columnCorsi);
		scrollPaneCorsi.setViewportView(tableCorsi);
		
		JComboBox comboBoxFiltro = new JComboBox();
		comboBoxFiltro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxFiltro.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					if(comboBoxFiltro.getSelectedItem().equals("TUTTI")) {
						
						op.setCorsi(c.getCorsiOperatore(op));
						modelCorsi.setRowCount(0);
		                for (CorsoFormazione corso:op.getCorsi()) {
		                	rowCorsi[0]= corso.getIdCorso();
		                	rowCorsi[1]= corso.getNome();
		                	rowCorsi[2]= corso.getDescrizione();
		                	rowCorsi[3]= corso.getData();
		                	rowCorsi[4]= corso.getPresenzeMin();
		                	rowCorsi[5]= corso.getMaxPartecipanti();
		                	modelCorsi.addRow(rowCorsi);
		        		}
					}
					else if(comboBoxFiltro.getSelectedItem().equals("PAROLA CHIAVE")){
						String key = c.insertKey();
						
						modelCorsi.setRowCount(0);
		                for (CorsoFormazione corso:c.getCorsiPkey(key,op)) {
		                	rowCorsi[0]= corso.getIdCorso();
		                	rowCorsi[1]= corso.getNome();
		                	rowCorsi[2]= corso.getDescrizione();
		                	rowCorsi[3]= corso.getData();
		                	rowCorsi[4]= corso.getPresenzeMin();
		                	rowCorsi[5]= corso.getMaxPartecipanti();
		                	modelCorsi.addRow(rowCorsi);
		        		}
					}
					else {
						Date datacreazione = c.insertData();
						
						modelCorsi.setRowCount(0);
		                for (CorsoFormazione corso:c.getCorsiData(datacreazione,op)) {
		                	rowCorsi[0]= corso.getIdCorso();
		                	rowCorsi[1]= corso.getNome();
		                	rowCorsi[2]= corso.getDescrizione();
		                	rowCorsi[3]= corso.getData();
		                	rowCorsi[4]= corso.getPresenzeMin();
		                	rowCorsi[5]= corso.getMaxPartecipanti();
		                	modelCorsi.addRow(rowCorsi);
		        		}
					}
                }
			}
		});
		comboBoxFiltro.setModel(new DefaultComboBoxModel(new String[] {"TUTTI", "DATA", "PAROLA CHIAVE"}));
		comboBoxFiltro.setSelectedIndex(0);
		comboBoxFiltro.setToolTipText("");
		comboBoxFiltro.setBounds(10, 36, 150, 22);
		panelCorsi.add(comboBoxFiltro);
		
		JButton btnIndietro = new JButton("INDIETRO");
		btnIndietro.setForeground(Color.BLUE);
		btnIndietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane,panelCorsi);
			}
		});
		btnIndietro.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIndietro.setBounds(10, 429, 100, 23);
		panelLezioni.add(btnIndietro);
		
		JLabel lblAlertLezioni = new JLabel("Seleziona la lezione");
		lblAlertLezioni.setForeground(Color.BLUE);
		lblAlertLezioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertLezioni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlertLezioni.setBounds(10, 36, 594, 14);
		panelLezioni.add(lblAlertLezioni);
		
		JPanel panelModifica = new JPanel();
		panelModifica.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelModifica, "name_678172324780300");
		panelModifica.setLayout(null);
		
		JLabel lblModifica = new JLabel("MODIFICA CORSO");
		lblModifica.setForeground(Color.RED);
		lblModifica.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblModifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifica.setBounds(10, 11, 594, 14);
		panelModifica.add(lblModifica);
		
		JLabel lblAlertModifica = new JLabel("Seleziona il corso");
		lblAlertModifica.setForeground(Color.BLUE);
		lblAlertModifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertModifica.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlertModifica.setBounds(10, 36, 594, 14);
		panelModifica.add(lblAlertModifica);
		
		txtModificaNome = new JTextField();
		txtModificaNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModificaNome.setBounds(219, 273, 175, 20);
		panelModifica.add(txtModificaNome);
		txtModificaNome.setColumns(10);
		
		txtModificaDesc = new JTextField();
		txtModificaDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModificaDesc.setBounds(219, 304, 175, 20);
		panelModifica.add(txtModificaDesc);
		txtModificaDesc.setColumns(10);
		
		txtModificaPartecipanti = new JTextField();
		txtModificaPartecipanti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModificaPartecipanti.setBounds(219, 376, 175, 20);
		panelModifica.add(txtModificaPartecipanti);
		txtModificaPartecipanti.setColumns(10);
		
		txtModificaID = new JTextField();
		txtModificaID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModificaID.setEditable(false);
		txtModificaID.setBounds(219, 407, 175, 20);
		panelModifica.add(txtModificaID);
		txtModificaID.setColumns(10);
		
		JLabel lblModNome = new JLabel("Nome");
		lblModNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblModNome.setBounds(79, 276, 130, 14);
		panelModifica.add(lblModNome);
		
		JLabel txtModDesc = new JLabel("Descrizione");
		txtModDesc.setHorizontalAlignment(SwingConstants.CENTER);
		txtModDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModDesc.setBounds(79, 307, 130, 14);
		panelModifica.add(txtModDesc);
		
		JLabel lblModPresenze = new JLabel("Presenze minime[%]");
		lblModPresenze.setHorizontalAlignment(SwingConstants.CENTER);
		lblModPresenze.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModPresenze.setBounds(79, 340, 130, 18);
		panelModifica.add(lblModPresenze);
		
		JLabel lblModPartecipanti = new JLabel("Partecipanti max");
		lblModPartecipanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblModPartecipanti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModPartecipanti.setBounds(79, 377, 130, 18);
		panelModifica.add(lblModPartecipanti);
		
		JLabel lblModId = new JLabel("IDCorso");
		lblModId.setHorizontalAlignment(SwingConstants.CENTER);
		lblModId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModId.setBounds(79, 410, 130, 14);
		panelModifica.add(lblModId);
		
		JLabel lblModPercentuale = new JLabel("");
		lblModPercentuale.setHorizontalAlignment(SwingConstants.CENTER);
		lblModPercentuale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModPercentuale.setBounds(404, 340, 40, 14);
		panelModifica.add(lblModPercentuale);
		
		JSlider sliderModificaPresenze = new JSlider();
		sliderModificaPresenze.setEnabled(false);
		sliderModificaPresenze.setSnapToTicks(true);
		sliderModificaPresenze.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(sliderModificaPresenze.isEnabled()) {
					lblModPercentuale.setText(Integer.toString(sliderModificaPresenze.getValue()) + "%");
				}
				else {
					lblModPercentuale.setText("");
				}
			}
		});
		sliderModificaPresenze.setPaintTicks(true);
		sliderModificaPresenze.setFont(new Font("Tahoma", Font.PLAIN, 10));
		sliderModificaPresenze.setMinorTickSpacing(5);
		sliderModificaPresenze.setMajorTickSpacing(25);
		sliderModificaPresenze.setValue(0);
		sliderModificaPresenze.setBounds(219, 335, 175, 30);
		panelModifica.add(sliderModificaPresenze);
		
		JScrollPane scrollPaneModifica = new JScrollPane();
		scrollPaneModifica.setBounds(34, 61, 544, 185);
		panelModifica.add(scrollPaneModifica);
		
		tableModifica = new JTable();
		tableModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableModifica.getSelectedRow();
				
				txtModificaID.setText(modelModifica.getValueAt(i, 0).toString());
				txtModificaNome.setText(modelModifica.getValueAt(i, 1).toString());
				txtModificaDesc.setText(modelModifica.getValueAt(i, 2).toString());
				txtModificaPartecipanti.setText(modelModifica.getValueAt(i, 4).toString());
				
				sliderModificaPresenze.setEnabled(true);
				sliderModificaPresenze.setValue((int)modelModifica.getValueAt(i, 3));
			}
		});
		modelModifica = new DefaultTableModel();
		Object[] columnModifica = {"ID", "Nome", "Descrizione", "PresenzeMin[%]", "maxPartecipanti"};
		Object[] rowModifica = new Object[5];
		tableModifica.setModel(modelModifica);
		modelModifica.setColumnIdentifiers(columnModifica);
		scrollPaneModifica.setViewportView(tableModifica);
		
		JButton btnAggiorna = new JButton("AGGIORNA");
		btnAggiorna.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAggiorna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtModificaNome.getText().isBlank() && sliderModificaPresenze.isEnabled() && tryParse(txtModificaPartecipanti.getText())!=null && !txtModificaID.getText().isBlank()) {
					String nome = txtModificaNome.getText();
					String descrizione = txtModificaDesc.getText();
					int presenze = sliderModificaPresenze.getValue();
					int partecipanti = tryParse(txtModificaPartecipanti.getText());
					int id = Integer.valueOf(txtModificaID.getText());
					
					if(c.aggiornaCorso(nome, descrizione, presenze, partecipanti, id)) {
						c.confirmOperazione();
					}
					else {
						c.alertOperazione();
					}
				}
				else {
					c.alertOperazione();
				}
				
				op.setCorsi(c.getCorsiOperatore(op));
				modelModifica.setRowCount(0);
                for (CorsoFormazione corso:op.getCorsi()) {
                	rowModifica[0]= corso.getIdCorso();
                	rowModifica[1]= corso.getNome();
                	rowModifica[2]= corso.getDescrizione();
                	rowModifica[3]= corso.getPresenzeMin();
                	rowModifica[4]= corso.getMaxPartecipanti();
                	modelModifica.addRow(rowModifica);
        		}
				
				txtModificaNome.setText(null);
				txtModificaDesc.setText(null);
				sliderModificaPresenze.setEnabled(false);
				sliderModificaPresenze.setValue(0);
				txtModificaPartecipanti.setText(null);
				txtModificaID.setText(null);
			}
		});
		btnAggiorna.setBounds(450, 428, 100, 23);
		panelModifica.add(btnAggiorna);
		
		JPanel panelStatistiche = new JPanel();
		panelStatistiche.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelStatistiche, "name_362930448153500");
		panelStatistiche.setLayout(null);
		
		JLabel lblStatistiche = new JLabel("STATISTICHE CORSO");
		lblStatistiche.setForeground(Color.RED);
		lblStatistiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistiche.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStatistiche.setBounds(10, 11, 594, 14);
		panelStatistiche.add(lblStatistiche);
		
		JLabel lblAlertStatistiche = new JLabel("Seleziona il corso");
		lblAlertStatistiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertStatistiche.setForeground(Color.BLUE);
		lblAlertStatistiche.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlertStatistiche.setBounds(10, 36, 594, 14);
		panelStatistiche.add(lblAlertStatistiche);
		
		txtNumMedio = new JTextField();
		txtNumMedio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNumMedio.setEditable(false);
		txtNumMedio.setBounds(240, 270, 120, 20);
		panelStatistiche.add(txtNumMedio);
		txtNumMedio.setColumns(10);
		
		JLabel lblNumMedio = new JLabel("Numero medio Studenti");
		lblNumMedio.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumMedio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumMedio.setBounds(55, 271, 175, 14);
		panelStatistiche.add(lblNumMedio);
		
		txtMinStud = new JTextField();
		txtMinStud.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMinStud.setEditable(false);
		txtMinStud.setBounds(240, 301, 120, 20);
		panelStatistiche.add(txtMinStud);
		txtMinStud.setColumns(10);
		
		txtMaxStud = new JTextField();
		txtMaxStud.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaxStud.setEditable(false);
		txtMaxStud.setBounds(240, 332, 120, 20);
		panelStatistiche.add(txtMaxStud);
		txtMaxStud.setColumns(10);
		
		JLabel lblMinStud = new JLabel("Studenti minimi");
		lblMinStud.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinStud.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMinStud.setBounds(55, 302, 175, 14);
		panelStatistiche.add(lblMinStud);
		
		JLabel lblMaxStud = new JLabel("Studenti massimi");
		lblMaxStud.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxStud.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaxStud.setBounds(55, 333, 175, 14);
		panelStatistiche.add(lblMaxStud);
		
		JLabel lblRiempimento = new JLabel("Riempimento medio");
		lblRiempimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblRiempimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRiempimento.setBounds(55, 364, 175, 18);
		panelStatistiche.add(lblRiempimento);
		
		JScrollPane scrollPaneStatistiche = new JScrollPane();
		scrollPaneStatistiche.setBounds(34, 61, 544, 185);
		panelStatistiche.add(scrollPaneStatistiche);
		
		JProgressBar progressBarRiempimento = new JProgressBar();
		progressBarRiempimento.setMinimum(0);
		progressBarRiempimento.setMaximum(100);
		progressBarRiempimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		progressBarRiempimento.setStringPainted(true);
		progressBarRiempimento.setBounds(240, 365, 150, 20);
		panelStatistiche.add(progressBarRiempimento);
		
		tableStatistiche = new JTable();
		tableStatistiche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = (int) (modelStatistiche.getValueAt(tableStatistiche.getSelectedRow(), 0));
					
				txtNumMedio.setText(Integer.toString(c.getStat(c.getCorso(id)).getNumMedioStud()));
				txtMinStud.setText(Integer.toString(c.getStat(c.getCorso(id)).getMinStud()));
				txtMaxStud.setText(Integer.toString(c.getStat(c.getCorso(id)).getMaxStud()));
				progressBarRiempimento.setValue((c.getStat(c.getCorso(id)).getRiempimentoMedio()));
			}
		});
		modelStatistiche = new DefaultTableModel();
		Object[] columnStatistiche = {"ID", "Nome", "Descrizione", "PresenzeMin[%]", "maxPartecipanti"};
		Object [] rowStatistiche = new Object[5];
		tableStatistiche.setModel(modelStatistiche);
		modelStatistiche.setColumnIdentifiers(columnStatistiche);
		scrollPaneStatistiche.setViewportView(tableStatistiche);
		
		JButton btnSuperamento = new JButton("STUDENTI IDONEI");
		btnSuperamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableStatistiche.getSelectedRow() != -1) {
					JTable table = new JTable();
					DefaultTableModel model = new DefaultTableModel();
					Object[] cols = {"Matricola", "Nome", "Cognome"};
					Object[] row = new Object[3];
					table.setModel(model);
					model.setColumnIdentifiers(cols);
					
					model.setRowCount(0);
	                for (Superamento sup:c.getStudSupera(c.getCorso((int) (modelStatistiche.getValueAt(tableStatistiche.getSelectedRow(), 0))))) {
	                	row[0] = sup.getStudente().getMatricola();
	                	row[1] = sup.getStudente().getNome();
	                	row[2] = sup.getStudente().getCognome();
	                	model.addRow(row);
	        		}
	                
	                JScrollPane scroll = new JScrollPane(table);
	                scroll.setPreferredSize(new Dimension(275,125));
					
					c.aggiungiTabella(scroll,"STUDENTI IDONEI");
				}
				else {
					c.alertSeleziona();
				}
			}
		});
		btnSuperamento.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSuperamento.setBounds(434, 392, 145, 23);
		panelStatistiche.add(btnSuperamento);
		
		JPanel panelNewAreeTematiche = new JPanel();
		panelNewAreeTematiche.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelNewAreeTematiche, "name_363800109925200");
		panelNewAreeTematiche.setLayout(null);
		
		JLabel lblNewAree = new JLabel("CREA AREE TEMATICHE");
		lblNewAree.setForeground(Color.RED);
		lblNewAree.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewAree.setBounds(10, 11, 594, 14);
		panelNewAreeTematiche.add(lblNewAree);
		
		JLabel lblAlertNewAree = new JLabel("Seleziona il corso");
		lblAlertNewAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertNewAree.setForeground(Color.BLUE);
		lblAlertNewAree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlertNewAree.setBounds(10, 36, 594, 14);
		panelNewAreeTematiche.add(lblAlertNewAree);
		
		txtTipoAree = new JTextField();
		txtTipoAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTipoAree.setBounds(223, 289, 175, 20);
		panelNewAreeTematiche.add(txtTipoAree);
		txtTipoAree.setColumns(10);
		
		txtDescAree = new JTextField();
		txtDescAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescAree.setBounds(223, 320, 175, 20);
		panelNewAreeTematiche.add(txtDescAree);
		txtDescAree.setColumns(10);
		
		txtIdAree = new JTextField();
		txtIdAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIdAree.setEditable(false);
		txtIdAree.setBounds(223, 351, 175, 20);
		panelNewAreeTematiche.add(txtIdAree);
		txtIdAree.setColumns(10);
		
		JLabel lblTipoAree = new JLabel("Tipo");
		lblTipoAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoAree.setBounds(113, 290, 100, 18);
		panelNewAreeTematiche.add(lblTipoAree);
		
		JLabel lblDescAree = new JLabel("Descrizione");
		lblDescAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescAree.setBounds(113, 323, 100, 14);
		panelNewAreeTematiche.add(lblDescAree);
		
		JLabel lblIdAree = new JLabel("IDCorso");
		lblIdAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdAree.setBounds(113, 354, 100, 14);
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
						c.confirmInsert();
					}
					else {
						c.alertInsert();
					}
				}
				else {
					c.alertInsert();
				}
				
				txtTipoAree.setText(null);
				txtDescAree.setText(null);
				txtIdAree.setText(null);
			}
		});
		btnCreaAree.setBounds(408, 382, 100, 23);
		panelNewAreeTematiche.add(btnCreaAree);
		
		JScrollPane scrollPaneNewAree = new JScrollPane();
		scrollPaneNewAree.setBounds(108, 61, 400, 185);
		panelNewAreeTematiche.add(scrollPaneNewAree);
		
		tableNewAree = new JTable();
		tableNewAree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableNewAree.getSelectedRow();
				
				txtIdAree.setText(modelNewAree.getValueAt(i, 0).toString());
			}
		});
		modelNewAree = new DefaultTableModel();
		Object[] columnNewAree = {"ID", "Nome", "Descrizione"};
		Object[] rowNewAree = new Object[3];
		tableNewAree.setModel(modelNewAree);
		modelNewAree.setColumnIdentifiers(columnNewAree);
		scrollPaneNewAree.setViewportView(tableNewAree);
		
		JPanel panelAreeTematiche = new JPanel();
		panelAreeTematiche.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelAreeTematiche, "name_364509658303200");
		panelAreeTematiche.setLayout(null);
		
		JLabel lblAreeTematiche = new JLabel("VISUALIZZA AREE TEMATICHE PER CORSI");
		lblAreeTematiche.setForeground(Color.RED);
		lblAreeTematiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblAreeTematiche.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAreeTematiche.setBounds(10, 11, 594, 14);
		panelAreeTematiche.add(lblAreeTematiche);
		
		JLabel lblAlertAree = new JLabel("Seleziona il corso");
		lblAlertAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertAree.setForeground(Color.BLUE);
		lblAlertAree.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlertAree.setBounds(10, 36, 594, 14);
		panelAreeTematiche.add(lblAlertAree);
		
		JButton btnVisualizzaAree = new JButton("AREE");
		btnVisualizzaAree.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVisualizzaAree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableCorsiAree.getSelectedRow() != -1) {
					JTable table = new JTable();
					DefaultTableModel model = new DefaultTableModel();
					Object[] cols = {"Tipo", "Descrizione"};
					Object[] row = new Object[2];
					table.setModel(model);
					model.setColumnIdentifiers(cols);
					
					model.setRowCount(0);
	                for (AreeTematiche area:c.getAreeCorso(c.getCorso((int) (modelCorsiAree.getValueAt(tableCorsiAree.getSelectedRow(), 0))),op)) {
	                	row[0] = area.getTipo();
	                	row[1] = area.getDescrizione();
	                	model.addRow(row);
	        		}
	                
	                JScrollPane scroll = new JScrollPane(table);
	                scroll.setPreferredSize(new Dimension(275,125));
					
					c.aggiungiTabella(scroll,"AREE TEMATICHE");
				}
				else {
					c.alertSeleziona();
				}
			}
		});
		btnVisualizzaAree.setBounds(408, 257, 100, 23);
		panelAreeTematiche.add(btnVisualizzaAree);
		
		JScrollPane scrollPaneCorsiAree = new JScrollPane();
		scrollPaneCorsiAree.setBounds(108, 61, 400, 185);
		panelAreeTematiche.add(scrollPaneCorsiAree);
		
		tableCorsiAree = new JTable();
		modelCorsiAree = new DefaultTableModel();
		Object[] columnCorsiAree = {"ID", "Nome", "Descrizione"};
		Object[] rowCorsiAree = new Object[3];
		tableCorsiAree.setModel(modelCorsiAree);
		modelCorsiAree.setColumnIdentifiers(columnCorsiAree);
		scrollPaneCorsiAree.setViewportView(tableCorsiAree);
		
		JPanel panelTermina = new JPanel();
		panelTermina.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelTermina, "name_137764646419200");
		panelTermina.setLayout(null);
		
		JLabel lblTermina = new JLabel("TERMINA CORSO");
		lblTermina.setForeground(Color.RED);
		lblTermina.setHorizontalAlignment(SwingConstants.CENTER);
		lblTermina.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTermina.setBounds(10, 11, 594, 14);
		panelTermina.add(lblTermina);
		
		JLabel lblAlertTermina = new JLabel("Seleziona il corso");
		lblAlertTermina.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertTermina.setForeground(Color.BLUE);
		lblAlertTermina.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlertTermina.setBounds(10, 36, 594, 14);
		panelTermina.add(lblAlertTermina);
		
		JScrollPane scrollPaneTermina = new JScrollPane();
		scrollPaneTermina.setBounds(108, 61, 400, 185);
		panelTermina.add(scrollPaneTermina);
		
		tableTermina = new JTable();
		modelTermina = new DefaultTableModel();
		Object[] columnTermina = {"ID", "Nome", "Descrizione"};
		Object[] rowTermina = new Object[3];
		tableTermina.setModel(modelTermina);
		modelTermina.setColumnIdentifiers(columnTermina);
		scrollPaneTermina.setViewportView(tableTermina);
		
		JButton btnTermina = new JButton("TERMINA");
		btnTermina.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTermina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableTermina.getSelectedRow() != -1) {
					int i = tableTermina.getSelectedRow();
					int id = (int) tableTermina.getValueAt(i, 0);
					
					if(c.terminaCorso(c.getCorso(id),op)) {
						c.confirmOperazione();
					}
					else {
						c.alertOperazione();
					}
				}
				else {
					c.alertSeleziona();
				}
				
				modelTermina.setRowCount(0);
                for (CorsoFormazione corso:c.getCorsiNoTermina(op)) {
                	rowTermina[0] = corso.getIdCorso();
                	rowTermina[1] = corso.getNome();
                	rowTermina[2] = corso.getDescrizione();
                	modelTermina.addRow(rowTermina);
        		}
			}
		});
		btnTermina.setBounds(408, 257, 100, 23);
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
				switchPanel(layeredPane, panelCorsi);
				
				op.setCorsi(c.getCorsiOperatore(op));
				modelCorsi.setRowCount(0);
                for (CorsoFormazione corso:op.getCorsi()) {
                	rowCorsi[0] = corso.getIdCorso();
                	rowCorsi[1] = corso.getNome();
                	rowCorsi[2] = corso.getDescrizione();
                	rowCorsi[3] = corso.getData();
                	rowCorsi[4] = corso.getPresenzeMin();
                	rowCorsi[5] = corso.getMaxPartecipanti();
                	modelCorsi.addRow(rowCorsi);
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
				modelModifica.setRowCount(0);
                for (CorsoFormazione corso:op.getCorsi()) {
                	rowModifica[0] = corso.getIdCorso();
                	rowModifica[1] = corso.getNome();
                	rowModifica[2] = corso.getDescrizione();
                	rowModifica[3] = corso.getPresenzeMin();
                	rowModifica[4] = corso.getMaxPartecipanti();
                	modelModifica.addRow(rowModifica);
        		}
			}

		});
		mnCorsi.add(mntmModificaCorso);
		
		JMenuItem mntmTerminaCorso = new JMenuItem("Termina corso");
		mntmTerminaCorso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmTerminaCorso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelTermina);
				
				modelTermina.setRowCount(0);
                for (CorsoFormazione corso:c.getCorsiNoTermina(op)) {
                	rowTermina[0] = corso.getIdCorso();
                	rowTermina[1] = corso.getNome();
                	rowTermina[2] = corso.getDescrizione();
                	modelTermina.addRow(rowTermina);
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
				
				modelStatistiche.setRowCount(0);
                for (CorsoFormazione corso:c.getCorsiTermina(op)) {
                	rowStatistiche[0] = corso.getIdCorso();
                	rowStatistiche[1] = corso.getNome();
                	rowStatistiche[2] = corso.getDescrizione();
                	rowStatistiche[3] = corso.getPresenzeMin();
                	rowStatistiche[4] = corso.getMaxPartecipanti();
                	modelStatistiche.addRow(rowStatistiche);
        		}
			}
		});
		mnStatistiche.add(mntmVisualizzaStat);
		
		JMenu mnAreeTematiche = new JMenu("AREE TEMATICHE");
		mnAreeTematiche.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnAreeTematiche);
		
		JMenuItem mntmCreaAree = new JMenuItem("Crea Aree Tematiche");
		mntmCreaAree.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmCreaAree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelNewAreeTematiche);
				
				op.setCorsi(c.getCorsiOperatore(op));
				modelNewAree.setRowCount(0);
                for (CorsoFormazione corso:op.getCorsi()) {
                	rowNewAree[0] = corso.getIdCorso();
                	rowNewAree[1] = corso.getNome();
                	rowNewAree[2] = corso.getDescrizione();
                	modelNewAree.addRow(rowNewAree);
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
				modelCorsiAree.setRowCount(0);
                for (CorsoFormazione corso:op.getCorsi()) {
                	rowCorsiAree[0] = corso.getIdCorso();
                	rowCorsiAree[1] = corso.getNome();
                	rowCorsiAree[2] = corso.getDescrizione();
                	modelCorsiAree.addRow(rowCorsiAree);
        		}
			}
		});
		mnAreeTematiche.add(mntmVisualizzaAree);
	}
}
