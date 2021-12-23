import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class insertCorsoFormazione extends JFrame {

	private JPanel contentPane;
	private Controller TheController;
	private JTextField textNomeC;
	private JTextField textDescrizione;
	private JTextField textPresenzeMin;
	private JTextField textMaxPartecipanti;
	private JTextField textIdCorso;
	private JTextField textField_6;

	/**
	 * Create the frame.
	 */
	public insertCorsoFormazione(Controller c) 
	{
		setTitle("INSERIMENTO NUOVO CORSO");
		
		TheController= c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 322);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNomeC = new JTextField();
		textNomeC.setBounds(87, 11, 146, 20);
		contentPane.add(textNomeC);
		textNomeC.setColumns(10);
		
		textDescrizione = new JTextField();
		textDescrizione.setBounds(87, 52, 146, 20);
		contentPane.add(textDescrizione);
		textDescrizione.setColumns(10);
		
		textPresenzeMin = new JTextField();
		textPresenzeMin.setBounds(87, 94, 146, 20);
		contentPane.add(textPresenzeMin);
		textPresenzeMin.setColumns(10);
		
		textMaxPartecipanti = new JTextField();
		textMaxPartecipanti.setColumns(10);
		textMaxPartecipanti.setBounds(87, 133, 146, 20);
		contentPane.add(textMaxPartecipanti);
		
		textIdCorso = new JTextField();
		textIdCorso.setColumns(10);
		textIdCorso.setBounds(87, 164, 146, 20);
		contentPane.add(textIdCorso);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(87, 195, 146, 20);
		contentPane.add(textField_6);
		
		JButton btnGoHomePageOP = new JButton("INVIO");
		btnGoHomePageOP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeC = textNomeC.getText();
				String descrizione= textDescrizione.getText();
				String presenzeMin = textPresenzeMin.getText();
				String maxPresenze = textMaxPartecipanti.getText();
				String idCorso= textIdCorso.getText();
				
				c.goHomePageOP();	
				
			}
		});
		btnGoHomePageOP.setBounds(345, 213, 89, 23);
		contentPane.add(btnGoHomePageOP);
	}
}
