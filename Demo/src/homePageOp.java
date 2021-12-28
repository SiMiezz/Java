import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
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

	public homePageOp(Controller c, String id, String pwd) {
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
		layeredPane.setBounds(282, 11, 342, 489);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelVisualizza = new JPanel();
		layeredPane.add(panelVisualizza, "name_503451017127200");
		panelVisualizza.setLayout(null);
		
		JLabel lblVisualizza = new JLabel("VISUALIZZA CORSI");
		lblVisualizza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVisualizza.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisualizza.setBounds(10, 11, 322, 20);
		panelVisualizza.add(lblVisualizza);
		
		JScrollPane scrollPaneVisualizza = new JScrollPane();
		scrollPaneVisualizza.setBounds(33, 92, 278, 188);
		panelVisualizza.add(scrollPaneVisualizza);
		
		JTextArea txtVisualizza = new JTextArea();
		scrollPaneVisualizza.setViewportView(txtVisualizza);
		txtVisualizza.setEditable(false);
		txtVisualizza.setFont(new Font("Monospaced", Font.PLAIN, 16));
		
		JPanel panelInserisci = new JPanel();
		layeredPane.add(panelInserisci, "name_503457154114800");
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
		btnInserimento.setBounds(236, 423, 96, 23);
		panelInserisci.add(btnInserimento);
		
		JPanel panelModifica = new JPanel();
		layeredPane.add(panelModifica, "name_503460830301000");
		panelModifica.setLayout(null);
		
		JLabel lblModifica = new JLabel("MODIFICA CORSO");
		lblModifica.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifica.setBounds(10, 11, 322, 14);
		panelModifica.add(lblModifica);
		
		JScrollPane scrollPaneModifica = new JScrollPane();
		scrollPaneModifica.setBounds(34, 72, 275, 167);
		panelModifica.add(scrollPaneModifica);
		
		JTextArea txtModifica = new JTextArea();
		scrollPaneModifica.setViewportView(txtModifica);
		txtModifica.setEditable(false);
		txtModifica.setFont(new Font("Monospaced", Font.PLAIN, 16));
		
		JButton btnSelezionaMod = new JButton("Seleziona");
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
		lblModNome.setBounds(24, 306, 120, 14);
		panelModifica.add(lblModNome);
		
		JLabel lblModDesc = new JLabel("Descrizione");
		lblModDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModDesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblModDesc.setBounds(24, 337, 120, 14);
		panelModifica.add(lblModDesc);
		
		JLabel lblModPresenze = new JLabel("Presenze minime");
		lblModPresenze.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModPresenze.setHorizontalAlignment(SwingConstants.CENTER);
		lblModPresenze.setBounds(24, 368, 120, 14);
		panelModifica.add(lblModPresenze);
		
		JLabel lblModPartecipanti = new JLabel("Partecipanti max");
		lblModPartecipanti.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModPartecipanti.setHorizontalAlignment(SwingConstants.CENTER);
		lblModPartecipanti.setBounds(24, 399, 120, 14);
		panelModifica.add(lblModPartecipanti);
		
		JButton btnAggiorna = new JButton("AGGIORNA");
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
		btnAggiorna.setBounds(243, 455, 89, 23);
		panelModifica.add(btnAggiorna);
		
		txtModificaID = new JTextField();
		txtModificaID.setEditable(false);
		txtModificaID.setBounds(154, 424, 150, 20);
		panelModifica.add(txtModificaID);
		txtModificaID.setColumns(10);
		
		JLabel lblModID = new JLabel("idCorso");
		lblModID.setHorizontalAlignment(SwingConstants.CENTER);
		lblModID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModID.setBounds(33, 430, 111, 14);
		panelModifica.add(lblModID);
		
		JLabel lblAlertModifica = new JLabel("Seleziona l'id del corso");
		lblAlertModifica.setForeground(Color.BLUE);
		lblAlertModifica.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertModifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertModifica.setBounds(34, 47, 275, 14);
		panelModifica.add(lblAlertModifica);
		
		JPanel panelStatistiche = new JPanel();
		layeredPane.add(panelStatistiche, "name_82724793143400");
		panelStatistiche.setLayout(null);
		
		JLabel lblStatistiche = new JLabel("STATISTICHE");
		lblStatistiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistiche.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatistiche.setBounds(10, 11, 322, 14);
		panelStatistiche.add(lblStatistiche);
		
		JScrollPane scrollPaneStatistiche = new JScrollPane();
		scrollPaneStatistiche.setBounds(28, 78, 288, 175);
		panelStatistiche.add(scrollPaneStatistiche);
		
		JTextArea txtStatistiche = new JTextArea();
		scrollPaneStatistiche.setViewportView(txtStatistiche);
		txtStatistiche.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtStatistiche.setEditable(false);
		
		JLabel lblAlertStatistiche = new JLabel("Seleziona l'id del corso");
		lblAlertStatistiche.setForeground(Color.BLUE);
		lblAlertStatistiche.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlertStatistiche.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlertStatistiche.setBounds(28, 52, 288, 14);
		panelStatistiche.add(lblAlertStatistiche);
		
		JButton btnSelezionaStatistiche = new JButton("Seleziona");
		btnSelezionaStatistiche.setBounds(227, 264, 89, 23);
		panelStatistiche.add(btnSelezionaStatistiche);
		
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
		lblNumMedio.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumMedio.setBounds(10, 319, 146, 17);
		panelStatistiche.add(lblNumMedio);
		
		JLabel lblMinStud = new JLabel("Studenti minimi");
		lblMinStud.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinStud.setBounds(10, 350, 146, 14);
		panelStatistiche.add(lblMinStud);
		
		JLabel lblMaxStud = new JLabel("Studenti massimi");
		lblMaxStud.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxStud.setBounds(10, 378, 146, 14);
		panelStatistiche.add(lblMaxStud);
		
		JLabel lblRiempimento = new JLabel("Riempimento medio");
		lblRiempimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblRiempimento.setBounds(10, 409, 146, 14);
		panelStatistiche.add(lblRiempimento);
		
		JButton btnVisualizza = new JButton("Visualizza Corsi");
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
		btnVisualizza.setBounds(10, 375, 115, 23);
		contentPane.add(btnVisualizza);
		
		JButton btnInserisci = new JButton("Inserisci corso");
		btnInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
                layeredPane.add(panelInserisci);
                layeredPane.repaint();
                layeredPane.revalidate();
			}
		});
		btnInserisci.setBounds(138, 375, 115, 23);
		contentPane.add(btnInserisci);
		
		JButton btnModifica = new JButton("Modifica Corso");
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
		btnModifica.setBounds(10, 409, 115, 22);
		contentPane.add(btnModifica);
		
		JButton btnLogout = new JButton("LOGOUT");
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
		btnStatistiche.setBounds(138, 409, 115, 22);
		contentPane.add(btnStatistiche);
		
	}
}
