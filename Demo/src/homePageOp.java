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
	private JTextField txtNomeCorso;
	private JTextField txtDescrizione;
	private JTextField txtPresenze;
	private JTextField txtPartecipanti;

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
		
		for (CorsoFormazione corso:op.getCorsi()) {
			txtVisualizza.append(corso.getNome() + "\n");
		}
		
		JPanel panelInserisci = new JPanel();
		layeredPane.add(panelInserisci, "name_503457154114800");
		panelInserisci.setLayout(null);
		
		JLabel lblInserisci = new JLabel("INSERISCI CORSO");
		lblInserisci.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInserisci.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisci.setBounds(10, 11, 322, 14);
		panelInserisci.add(lblInserisci);
		
		txtNomeCorso = new JTextField();
		txtNomeCorso.setBounds(147, 123, 150, 20);
		panelInserisci.add(txtNomeCorso);
		txtNomeCorso.setColumns(10);
		
		txtDescrizione = new JTextField();
		txtDescrizione.setBounds(147, 154, 150, 20);
		panelInserisci.add(txtDescrizione);
		txtDescrizione.setColumns(10);
		
		txtPresenze = new JTextField();
		txtPresenze.setBounds(147, 185, 150, 20);
		panelInserisci.add(txtPresenze);
		txtPresenze.setColumns(10);
		
		txtPartecipanti = new JTextField();
		txtPartecipanti.setBounds(147, 216, 150, 20);
		panelInserisci.add(txtPartecipanti);
		txtPartecipanti.setColumns(10);
		
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
				String nome = txtNomeCorso.getText();	
				String descrizione = txtDescrizione.getText();
				/*int presenze = (int) txtPresenze.getText();
				int partecipanti = (int) txtPartecipanti.getText();*/
				
				
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
