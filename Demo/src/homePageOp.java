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
		
		JTextArea txtVisualizza = new JTextArea();
		txtVisualizza.setEditable(false);
		txtVisualizza.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtVisualizza.setBounds(33, 92, 278, 188);
		panelVisualizza.add(txtVisualizza);
		
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
				String nome = txtInsertNome.getText();	
				String descrizione = txtInsertDesc.getText();
				int presenze = Integer.valueOf(txtInsertPresenze.getText());
				int partecipanti = Integer.valueOf(txtInsertPartecipanti.getText());
				
				if(c.inserisciCorso(nome,descrizione,presenze,partecipanti,op)){
					c.confirmInsert();
				}
				else {
					c.alertInsert();
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
		
		JTextArea txtModifica = new JTextArea();
		txtModifica.setEditable(false);
		txtModifica.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtModifica.setBounds(34, 51, 270, 167);
		panelModifica.add(txtModifica);
		
		JButton btnSeleziona = new JButton("Seleziona");
		btnSeleziona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtModifica.getSelectedText();
				
				//System.out.println(nome);
			}
		});
		btnSeleziona.setBounds(123, 239, 89, 23);
		panelModifica.add(btnSeleziona);
		
		txtModificaNome = new JTextField();
		txtModificaNome.setBounds(154, 288, 150, 20);
		panelModifica.add(txtModificaNome);
		txtModificaNome.setColumns(10);
		
		txtModificaDesc = new JTextField();
		txtModificaDesc.setBounds(154, 319, 150, 20);
		panelModifica.add(txtModificaDesc);
		txtModificaDesc.setColumns(10);
		
		txtModificaPresenze = new JTextField();
		txtModificaPresenze.setBounds(154, 348, 150, 20);
		panelModifica.add(txtModificaPresenze);
		txtModificaPresenze.setColumns(10);
		
		txtModificaPartecipanti = new JTextField();
		txtModificaPartecipanti.setBounds(154, 381, 150, 20);
		panelModifica.add(txtModificaPartecipanti);
		txtModificaPartecipanti.setColumns(10);
		
		JLabel lblModNome = new JLabel("Nome");
		lblModNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblModNome.setBounds(24, 289, 120, 14);
		panelModifica.add(lblModNome);
		
		JLabel lblNewLabel_1 = new JLabel("Descrizione");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(24, 319, 120, 17);
		panelModifica.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Presenze minime");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(24, 351, 120, 14);
		panelModifica.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Partecipanti max");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(24, 382, 120, 14);
		panelModifica.add(lblNewLabel_3);
		
		JButton btnAggiorna = new JButton("AGGIORNA");
		btnAggiorna.setBounds(243, 455, 89, 23);
		panelModifica.add(btnAggiorna);
		
		JPanel panelRimuovi = new JPanel();
		layeredPane.add(panelRimuovi, "name_503500694014400");
		panelRimuovi.setLayout(null);
		
		JLabel lblRimuovi = new JLabel("RIMUOVI CORSO");
		lblRimuovi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRimuovi.setHorizontalAlignment(SwingConstants.CENTER);
		lblRimuovi.setBounds(10, 11, 322, 14);
		panelRimuovi.add(lblRimuovi);
		
		JButton btnVisualizza = new JButton("Visualizza Corsi");
		btnVisualizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
                layeredPane.add(panelVisualizza);
                layeredPane.repaint();
                layeredPane.revalidate();
                
                op.setCorsi(c.getCorsi(op));
                for (CorsoFormazione corso:op.getCorsi()) {
        			txtVisualizza.append(corso.getNome() + "\n");
        		}
			}
		});
		btnVisualizza.setBounds(10, 265, 115, 23);
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
		btnInserisci.setBounds(146, 265, 107, 23);
		contentPane.add(btnInserisci);
		
		JButton btnModifica = new JButton("Modifica Corso");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
                layeredPane.add(panelModifica);
                layeredPane.repaint();
                layeredPane.revalidate();
                
                op.setCorsi(c.getCorsi(op));
                for (CorsoFormazione corso:op.getCorsi()) {
        			txtModifica.append(corso.getNome() + "\n");
        		}
			}
		});
		btnModifica.setBounds(10, 299, 115, 22);
		contentPane.add(btnModifica);
		
		JButton btnRimuovi = new JButton("Rimuovi Corso");
		btnRimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
                layeredPane.add(panelRimuovi);
                layeredPane.repaint();
                layeredPane.revalidate();
			}
		});
		btnRimuovi.setBounds(146, 299, 107, 23);
		contentPane.add(btnRimuovi);
		
	}
}
