import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import java.util.*;

public class Controller {

	private loginFrame lf;
	private registrationFrame rf;
	private homePageStud hps;
	private homePageOp hpo;
	
	private CorsoFormazioneDAO corsodao = new CorsoFormazioneDAO();
	private StudenteDAO stdao = new StudenteDAO();
	private OperatoreDAO opdao = new OperatoreDAO();
	private IscrittoDAO iscdao = new IscrittoDAO();
	
	public static void main(String[] args) {
		Controller c= new Controller();
	}
	
	public Controller() {
		lf = new loginFrame(this);
		rf = new registrationFrame(this);
		lf.setVisible(true);
	}
	
	public boolean checkUser(String id,String pwd){
		try {
			if(lf.getBoxSceltaLogin().getSelectedItem().equals("Studente")) {
				if(stdao.checkStud(id,pwd)) {
					hps = new homePageStud(this,id,pwd);
					return true;
				}
				else {
					return false;
				}
			}else{
				if(opdao.checkOp(id,pwd)) {
					hpo = new homePageOp(this,id,pwd);
					return true;
				}
				else {
					return false;
				}
			}
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
	}

	public boolean registrazione(String nome, String cognome, String id, String password, String cf,Date data) 
	{
		try {
			if(rf.getBoxSceltaRegistration().getSelectedItem().equals("Operatore")) {
				if(opdao.registrazioneOP(nome, cognome, id, password, cf, data))
				{
					return true;
				}
				else {
					return false;
				}
			}
			else {
				if(stdao.registrazioneStud(nome, cognome, id, password, cf, data))
				{
					return true;
				}
				else {
					return false;
				}
			}
			
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
	}
		
	public Studente getStud(String matricola) {
		try {
			return stdao.getStud(matricola);
		} catch (SQLException e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	public Operatore getOp(String id) {
		try {
			return opdao.getOp(id);
		} catch (SQLException e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<CorsoFormazione> getCorsi(Operatore op) {
		try {
			return corsodao.getCorsi(op);
		}catch(SQLException e){
			//e.printStackTrace();
			return null;
		}
	}
	
	public CorsoFormazione getCorso(int id) {
		try {
			return corsodao.getCorso(id);
		}catch(SQLException e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<CorsoFormazione> getAllCorsi() {
		try {
			return corsodao.getAllCorsi();
		}catch(SQLException e){
			//e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Iscritto> getIscrizioni(Studente stud) {
		try {
			return iscdao.getIscrizioni(stud);
		}catch(SQLException e){
			//e.printStackTrace();
			return null;
		}
	}
	
	public boolean inserisciCorso(String nome, String descrizione, int presenzeMin, int maxPartecipanti, Operatore op) {
		try {
			if(corsodao.aggiungiCorso(nome, descrizione, presenzeMin, maxPartecipanti, op)) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException e) {
			//e.printStackTrace();
			return false;
		}
	}
	
	public boolean aggiornaCorso(String nome, String descrizione, int presenzeMin, int maxPartecipanti, int id) {
		try {
			if(corsodao.aggiornaCorso(nome, descrizione, presenzeMin, maxPartecipanti, id)) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException e) {
			//e.printStackTrace();
			return false;
		}
	}

	public void goRegistrazioneFrame() {
		lf.setVisible(false);
		rf.setVisible(true);
	}

	public void backLogin() {
		rf.setVisible(false);
		lf.setVisible(true);
	}

	public void confirmRegistration() {
		JOptionPane.showMessageDialog(rf,"Registrazione avvenuta con successo come " +rf.getBoxSceltaRegistration().getSelectedItem() +"\nverrete riportati alla pagina di Login");
		rf.setVisible(false);
		lf.setVisible(true);
	}

	public void alertRegistration() {
		JOptionPane.showMessageDialog(rf,"Registrazione errata. Riprova");
	}
	
	public void alertLogin(){
		JOptionPane.showMessageDialog(lf,"Credenziali Errate o non inserite");			
	}
	
	public void confirmLogin() {
		JOptionPane.showMessageDialog(lf,"Login effettuato come " + lf.getBoxSceltaLogin().getSelectedItem());
		
		if(lf.getBoxSceltaLogin().getSelectedItem().equals("Studente")) {
			lf.setVisible(false);
			hps.setVisible(true);
		}
		else {
			lf.setVisible(false);
			hpo.setVisible(true);
		}
	}
	
	public void confirmInsert() {
		JOptionPane.showMessageDialog(hpo, "Corso aggiunto correttamente");
	}
	
	public void alertInsert() {
		JOptionPane.showMessageDialog(hpo, "Errore nell'inserimento del corso");
	}
	
	public void confirmUpdate() {
		JOptionPane.showMessageDialog(hpo, "Corso aggiornato correttamente");
	}
	
	public void alertUpdate() {
		JOptionPane.showMessageDialog(hpo, "Errore nell'aggiornamento del corso");
	}

}

