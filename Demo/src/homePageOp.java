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
import javax.swing.JOptionPane;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSlider;
import javax.swing.JProgressBar;

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
					long millis=System.currentTimeMillis();
					Date datacreazione=new Date(millis);
					
					if(c.inserisciCorso(nome,descrizione,datacreazione,presenze,partecipanti,op)){
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
		
		JPanel panelCorsi = new JPanel();
		panelCorsi.setBackground(new Color(176, 224, 230));
		layeredPane.add(panelCorsi, "name_302338902470800");
		panelCorsi.setLayout(null);
		
		JLabel lblCorsi = new JLabel("VISUALIZZA CORSI");
		lblCorsi.setForeground(Color.RED);
		lblCorsi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCorsi.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorsi.setBounds(10, 11, 544, 14);
		panelCorsi.add(lblCorsi);
		
		JScrollPane scrollPaneCorsi = new JScrollPane();
		scrollPaneCorsi.setBounds(10, 69, 544, 270);
		panelCorsi.add(scrollPaneCorsi);
		
		tableCorsi = new JTable();
		tableCorsi.setRowSelectionAllowed(false);
		tableCorsi.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		modelCorsi = new DefaultTableModel();
		Object[] columnCorsi = {"ID", "Nome", "Descrizione", "Data", "PresenzeMin", "maxPartecipanti"};
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
		
		JLabel lblAlertModifica = new JLabel("Seleziona il corso");
		lblAlertModifica.setForeground(Color.BLUE);
		lblAlertModifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertModifica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertModifica.setBounds(10, 36, 544, 14);
		panelModifica.add(lblAlertModifica);
		
		txtModificaNome = new JTextField();
		txtModificaNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModificaNome.setBounds(209, 270, 175, 20);
		panelModifica.add(txtModificaNome);
		txtModificaNome.setColumns(10);
		
		txtModificaDesc = new JTextField();
		txtModificaDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModificaDesc.setBounds(209, 301, 175, 20);
		panelModifica.add(txtModificaDesc);
		txtModificaDesc.setColumns(10);
		
		txtModificaPresenze = new JTextField();
		txtModificaPresenze.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModificaPresenze.setBounds(209, 337, 175, 20);
		panelModifica.add(txtModificaPresenze);
		txtModificaPresenze.setColumns(10);
		
		txtModificaPartecipanti = new JTextField();
		txtModificaPartecipanti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModificaPartecipanti.setBounds(209, 366, 175, 20);
		panelModifica.add(txtModificaPartecipanti);
		txtModificaPartecipanti.setColumns(10);
		
		txtModificaID = new JTextField();
		txtModificaID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModificaID.setEditable(false);
		txtModificaID.setBounds(209, 397, 175, 20);
		panelModifica.add(txtModificaID);
		txtModificaID.setColumns(10);
		
		JLabel lblModNome = new JLabel("Nome");
		lblModNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblModNome.setBounds(69, 273, 130, 14);
		panelModifica.add(lblModNome);
		
		JLabel txtModDesc = new JLabel("Descrizione");
		txtModDesc.setHorizontalAlignment(SwingConstants.CENTER);
		txtModDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModDesc.setBounds(69, 306, 130, 14);
		panelModifica.add(txtModDesc);
		
		JLabel lblModPresenze = new JLabel("Presenze minime");
		lblModPresenze.setHorizontalAlignment(SwingConstants.CENTER);
		lblModPresenze.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModPresenze.setBounds(69, 340, 130, 14);
		panelModifica.add(lblModPresenze);
		
		JLabel lblModPartecipanti = new JLabel("Partecipanti max");
		lblModPartecipanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblModPartecipanti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModPartecipanti.setBounds(69, 367, 130, 18);
		panelModifica.add(lblModPartecipanti);
		
		JLabel lblModId = new JLabel("IDCorso");
		lblModId.setHorizontalAlignment(SwingConstants.CENTER);
		lblModId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModId.setBounds(69, 400, 130, 14);
		panelModifica.add(lblModId);
		
		JScrollPane scrollPaneModifica = new JScrollPane();
		scrollPaneModifica.setBounds(10, 61, 544, 185);
		panelModifica.add(scrollPaneModifica);
		
		tableModifica = new JTable();
		tableModifica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableModifica.getSelectedRow();
				
				txtModificaID.setText(modelModifica.getValueAt(i, 0).toString());
				txtModificaNome.setText(modelModifica.getValueAt(i, 1).toString());
				txtModificaDesc.setText(modelModifica.getValueAt(i, 2).toString());
				txtModificaPresenze.setText(modelModifica.getValueAt(i, 3).toString());
				txtModificaPartecipanti.setText(modelModifica.getValueAt(i, 4).toString());
			}
		});
		modelModifica = new DefaultTableModel();
		Object[] columnModifica = {"ID", "Nome", "Descrizione", "PresenzeMin", "maxPartecipanti"};
		Object[] rowModifica = new Object[5];
		tableModifica.setModel(modelModifica);
		modelModifica.setColumnIdentifiers(columnModifica);
		scrollPaneModifica.setViewportView(tableModifica);
		
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
				txtModificaPresenze.setText(null);
				txtModificaPartecipanti.setText(null);
				txtModificaID.setText(null);
			}
		});
		btnAggiorna.setBounds(426, 397, 100, 23);
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
		
		JLabel lblAlertStatistiche = new JLabel("Seleziona il corso");
		lblAlertStatistiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertStatistiche.setForeground(Color.BLUE);
		lblAlertStatistiche.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertStatistiche.setBounds(10, 36, 544, 14);
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
		scrollPaneStatistiche.setBounds(10, 61, 544, 185);
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
		tableStatistiche.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		modelStatistiche = new DefaultTableModel();
		Object[] columnStatistiche = {"ID", "Nome", "Descrizione", "PresenzeMin", "maxPartecipanti"};
		Object [] rowStatistiche = new Object[5];
		tableStatistiche.setModel(modelStatistiche);
		modelStatistiche.setColumnIdentifiers(columnStatistiche);
		scrollPaneStatistiche.setViewportView(tableStatistiche);
		
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
		
		JLabel lblAlertNewAree = new JLabel("Seleziona il corso");
		lblAlertNewAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertNewAree.setForeground(Color.BLUE);
		lblAlertNewAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertNewAree.setBounds(10, 36, 544, 14);
		panelNewAreeTematiche.add(lblAlertNewAree);
		
		txtTipoAree = new JTextField();
		txtTipoAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTipoAree.setBounds(193, 289, 175, 20);
		panelNewAreeTematiche.add(txtTipoAree);
		txtTipoAree.setColumns(10);
		
		txtDescAree = new JTextField();
		txtDescAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescAree.setBounds(193, 320, 175, 20);
		panelNewAreeTematiche.add(txtDescAree);
		txtDescAree.setColumns(10);
		
		txtIdAree = new JTextField();
		txtIdAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtIdAree.setEditable(false);
		txtIdAree.setBounds(193, 351, 175, 20);
		panelNewAreeTematiche.add(txtIdAree);
		txtIdAree.setColumns(10);
		
		JLabel lblTipoAree = new JLabel("Tipo");
		lblTipoAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoAree.setBounds(83, 290, 100, 18);
		panelNewAreeTematiche.add(lblTipoAree);
		
		JLabel lblDescAree = new JLabel("Descrizione");
		lblDescAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescAree.setBounds(83, 323, 100, 14);
		panelNewAreeTematiche.add(lblDescAree);
		
		JLabel lblIdAree = new JLabel("IDCorso");
		lblIdAree.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdAree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdAree.setBounds(83, 354, 100, 14);
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
		btnCreaAree.setBounds(385, 351, 100, 23);
		panelNewAreeTematiche.add(btnCreaAree);
		
		JScrollPane scrollPaneNewAree = new JScrollPane();
		scrollPaneNewAree.setBounds(85, 61, 400, 185);
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
                txtCorsiAree.setText(null);
                for (CorsoFormazione corso:c.getCorsiOperatore(op)) {
                	txtCorsiAree.append(corso.getIdCorso() + " " + corso.getNome() + " " + corso.getDescrizione() + "\n");
        		}
			}
		});
		mnAreeTematiche.add(mntmVisualizzaAree);
	}
}
