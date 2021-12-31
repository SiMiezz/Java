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
	private LezioneDAO lezdao = new LezioneDAO();
	private AreeTematicheDAO areedao = new AreeTematicheDAO();
	private PartecipaDAO pardao = new PartecipaDAO();
	private StatisticheDAO statdao = new StatisticheDAO();
	
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
	
	public ArrayList<CorsoFormazione> getCorsiOperatore(Operatore op) {
		try {
			return corsodao.getCorsiOperatore(op);
		}catch(SQLException e){
			//e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<CorsoFormazione> getCorsiIscrizione(Studente stud){
		try {
			return corsodao.getCorsiIscrizione(stud);
		}catch(SQLException e){
			//e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<CorsoFormazione> getCorsiAree(String tipo){
		try {
			return corsodao.getCorsiAree(tipo);
		}catch(SQLException e){
			//e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Lezione> getLezioni(Studente stud){
		try {
			return lezdao.getLezioni(stud);
		}catch(SQLException e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Lezione> getLezioniPartecipa(Studente stud){
		try {
			return lezdao.getLezioniPartecipa(stud);
		}catch(SQLException e) {
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
	
	public Statistiche getStat(CorsoFormazione corso) {
		try {
			return statdao.getStat(corso);
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
	
	public ArrayList<AreeTematiche> getAree(Operatore op) {
		try {
			return areedao.getAree(op);
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
	
	public boolean iscriviti(Studente stud,int id) {
		try {
			if(iscdao.aggiungiIscrizione(stud,id)) {
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
	
	public boolean partecipa(Studente stud,int id) {
		try {
			if(pardao.aggiungiPartecipa(stud,id)) {
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
	
	public boolean aggiungiAree(String tipo,String descrizione,CorsoFormazione corso,Operatore op) {
		try {
			if(areedao.aggiungiAree(tipo,descrizione,corso,op)) {
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
	
	public void logout() {
		if(hpo == null || !hpo.isShowing()) {
			hps.setVisible(false);
		}
		else if (hps == null || !hps.isShowing()){
			hpo.setVisible(false);
		}
		
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
	
	public void confirmInsertCorso() {
		JOptionPane.showMessageDialog(hpo, "Corso aggiunto correttamente");
	}
	
	public void alertInsertCorso() {
		JOptionPane.showMessageDialog(hpo, "Errore nell'inserimento del corso");
	}
	
	public void confirmInsertIscrizione() {
		JOptionPane.showMessageDialog(hps, "Iscrizione avvenuta correttamente");
	}
	
	public void alertInsertIscrizione() {
		JOptionPane.showMessageDialog(hps, "Errore nell'iscrizione");
	}
	
	public void confirmUpdate() {
		JOptionPane.showMessageDialog(hpo, "Corso aggiornato correttamente");
	}
	
	public void alertUpdate() {
		JOptionPane.showMessageDialog(hpo, "Errore nell'aggiornamento del corso");
	}
	
	public void alertSeleziona() {
		if(hpo == null || !hpo.isShowing()) {
			JOptionPane.showMessageDialog(hps, "Selezionare l'id del corso!");
		}
		else if (hps == null || !hps.isShowing()){
			JOptionPane.showMessageDialog(hpo, "Selezionare l'id del corso!");
		}
	}
	
	public void confirmInsertAree() {
		JOptionPane.showMessageDialog(hpo, "Area Tematica aggiunta correttamente");
	}
	
	public void alertInsertAree() {
		JOptionPane.showMessageDialog(hpo, "Errore nell'iserimento dell'Area");
	}
	
	public void confirmInsertPresenza() {
		JOptionPane.showMessageDialog(hps, "Presenza effettuata");
	}
	
	public void alertInsertPresenza() {
		JOptionPane.showMessageDialog(hps, "Presenza non effettuata");
	}
}