import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

public class ProveHome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textNome;
	private JTextField textCognome;
	private JTextField textDataNascita;
	private JTextField textCF;
	private JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProveHome frame = new ProveHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	private void switchPanel(JLayeredPane layeredPane, JPanel panelInserisci) {
		layeredPane.removeAll();
        layeredPane.add(panelInserisci);
        layeredPane.repaint();
        layeredPane.revalidate();
	}

	/**
	 * Create the frame.
	 */
	public ProveHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 521);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 564, 439);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelProfilo = new JPanel();
		layeredPane.add(panelProfilo, "name_680381200185900");
		panelProfilo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PROFILO OPERATORE");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setLabelFor(panelProfilo);
		lblNewLabel.setBounds(168, 11, 226, 31);
		panelProfilo.add(lblNewLabel);
		
		textNome = new JTextField();
		textNome.setText((String) null);
		textNome.setEditable(false);
		textNome.setColumns(10);
		textNome.setBounds(168, 68, 226, 22);
		panelProfilo.add(textNome);
		
		textCognome = new JTextField();
		textCognome.setText((String) null);
		textCognome.setEditable(false);
		textCognome.setColumns(10);
		textCognome.setBounds(168, 106, 226, 22);
		panelProfilo.add(textCognome);
		
		textDataNascita = new JTextField();
		textDataNascita.setText("<dynamic>\r\n");
		textDataNascita.setEditable(false);
		textDataNascita.setColumns(10);
		textDataNascita.setBounds(168, 149, 226, 22);
		panelProfilo.add(textDataNascita);
		
		textCF = new JTextField();
		textCF.setText((String) null);
		textCF.setEditable(false);
		textCF.setColumns(10);
		textCF.setBounds(168, 182, 226, 22);
		panelProfilo.add(textCF);
		
		textID = new JTextField();
		textID.setText("<dynamic>");
		textID.setEditable(false);
		textID.setColumns(10);
		textID.setBounds(168, 215, 226, 22);
		panelProfilo.add(textID);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(31, 72, 114, 14);
		panelProfilo.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cognome");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(31, 104, 114, 22);
		panelProfilo.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Data di nascita");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(31, 151, 114, 14);
		panelProfilo.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Codice Fiscale");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(31, 186, 114, 14);
		panelProfilo.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("ID Operatore");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(31, 219, 114, 14);
		panelProfilo.add(lblNewLabel_1_2_2);
		
		JPanel panelInserisci = new JPanel();
		panelInserisci.setLayout(null);
		layeredPane.add(panelInserisci, "name_679299759213300");
		
		JLabel lblInserisci = new JLabel("INSERISCI CORSO");
		lblInserisci.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisci.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInserisci.setBounds(10, 11, 322, 14);
		panelInserisci.add(lblInserisci);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(147, 123, 150, 20);
		panelInserisci.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 154, 150, 20);
		panelInserisci.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 185, 150, 20);
		panelInserisci.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(147, 216, 150, 20);
		panelInserisci.add(textField_3);
		
		JLabel lblNomeCorso = new JLabel("Nome");
		lblNomeCorso.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCorso.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		btnInserimento.setBounds(236, 271, 96, 23);
		panelInserisci.add(btnInserimento);
		
		JPanel panelVisualizza = new JPanel();
		layeredPane.add(panelVisualizza, "name_302338902470800");
		panelVisualizza.setLayout(null);
		
		JPanel panelVisualizza_1 = new JPanel();
		panelVisualizza_1.setLayout(null);
		panelVisualizza_1.setBounds(0, 0, 564, 428);
		panelVisualizza.add(panelVisualizza_1);
		
		JScrollPane scrollPaneVisualizza = new JScrollPane();
		scrollPaneVisualizza.setBounds(10, 78, 544, 186);
		panelVisualizza_1.add(scrollPaneVisualizza);
		
		JLabel lblVisualizza = new JLabel("VISUALIZZA CORSI");
		lblVisualizza.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisualizza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVisualizza.setBounds(114, 47, 322, 20);
		panelVisualizza_1.add(lblVisualizza);
		
		JPanel panelModifica = new JPanel();
		layeredPane.add(panelModifica, "name_678172324780300");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProfilo = new JMenu("PROFILO");
		menuBar.add(mnProfilo);
		
		JMenuItem mntmVisualizzaProfilo = new JMenuItem("Visualizza profilo");
		mntmVisualizzaProfilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanel(layeredPane, panelProfilo);
			}
		});
		mnProfilo.add(mntmVisualizzaProfilo);
		
		JMenuItem mntmLogoutProfilo = new JMenuItem("Logout");
		mnProfilo.add(mntmLogoutProfilo);
		
		JMenu mnCorsi = new JMenu("CORSI");
		menuBar.add(mnCorsi);
		
		JMenuItem mntmVisualizzaCorsi = new JMenuItem("Visualizza corsi");
		mntmVisualizzaCorsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelVisualizza);
			}
		});
		mnCorsi.add(mntmVisualizzaCorsi);
		
		JMenuItem mntmInserisciCorsi = new JMenuItem("Inserisci corso");
		mntmInserisciCorsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelInserisci);
			}
		});
		mnCorsi.add(mntmInserisciCorsi);
		
		JMenuItem mntmModificaCorso = new JMenuItem("Modifica corso");
		mntmModificaCorso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(layeredPane, panelModifica);
			}

		});
		mnCorsi.add(mntmModificaCorso);
		
		
		
	}
}
