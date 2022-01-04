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
	private SuperamentoDAO supdao = new SuperamentoDAO();
	private TerminazioneDAO terminadao = new TerminazioneDAO();
	
	public static void main(String[] args) {
		Controller c= new Controller();
	}
	
	public Controller() {
		lf = new loginFrame(this);
		rf = new registrationFrame(this);
		lf.setVisible(true);
	}
	
	public boolean checkUser(String id,String pwd){
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
	}

	public boolean registrazione(String nome, String cognome, String id, String password, String cf,Date data) 
	{
		if(rf.getBoxSceltaRegistration().getSelectedItem().equals("Operatore")) {
			return opdao.registrazioneOP(nome, cognome, id, password, cf, data);
		}
		else {
			return stdao.registrazioneStud(nome, cognome, id, password, cf, data);
		}
	}
		
	public Studente getStud(String matricola) {
		return stdao.getStud(matricola);
	}
	
	public Operatore getOp(String id) {
		return opdao.getOp(id);
	}
	
	public ArrayList<CorsoFormazione> getCorsiOperatore(Operatore op) {
		return corsodao.getCorsiOperatore(op);
	}
	
	public ArrayList<CorsoFormazione> getCorsiIscrizione(Studente stud){
		return corsodao.getCorsiIscrizione(stud);
	}
	
	public ArrayList<CorsoFormazione> getCorsiNoTermina(Operatore op){
		return corsodao.getCorsiNoTermina(op);
	}
	
	public ArrayList<CorsoFormazione> getCorsiTermina(Operatore op){
		return corsodao.getCorsiTermina(op);
	}
	
	public ArrayList<AreeTematiche> getAreeCorso(CorsoFormazione corso,Operatore op){
		return areedao.getAreeCorso(corso,op);
	}
	
	public ArrayList<Lezione> getLezioni(Studente stud){
		return lezdao.getLezioni(stud);
	}
	
	public ArrayList<Lezione> getLezioniPartecipa(Studente stud){
		return lezdao.getLezioniPartecipa(stud);
	}
	
	public CorsoFormazione getCorso(int id) {
		return corsodao.getCorso(id);
	}
	
	public Statistiche getStat(CorsoFormazione corso) {
		return statdao.getStat(corso);
	}
	
	public ArrayList<CorsoFormazione> getAllCorsi() {
		return corsodao.getAllCorsi();
	}
	
	public ArrayList<Iscritto> getIscrizioni(Studente stud) {
		return iscdao.getIscrizioni(stud);
	}
	
	public ArrayList<Superamento> getStudSupera(CorsoFormazione corso) {
		return supdao.getStudSupera(corso);
	}
	
	public boolean inserisciCorso(String nome, String descrizione, int presenzeMin, int maxPartecipanti, Operatore op) {
		return corsodao.aggiungiCorso(nome, descrizione, presenzeMin, maxPartecipanti, op);
	}
	
	public boolean iscriviti(Studente stud,int id) {
		return iscdao.aggiungiIscrizione(stud,id);
	}
	
	public boolean partecipa(Studente stud,int id) {
		return pardao.aggiungiPartecipa(stud,id);
	}
	
	public boolean aggiungiAree(String tipo,String descrizione,CorsoFormazione corso,Operatore op) {
		return areedao.aggiungiAree(tipo,descrizione,corso,op);
	}
	
	public boolean terminaCorso(CorsoFormazione corso,Operatore op) {
		return terminadao.terminaCorso(corso,op);
	}
	
	public boolean aggiornaCorso(String nome, String descrizione, int presenzeMin, int maxPartecipanti, int id) {
		return corsodao.aggiornaCorso(nome, descrizione, presenzeMin, maxPartecipanti, id);
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
	
	public void confirmTermina() {
		JOptionPane.showMessageDialog(hpo, "Corso Terminato");
	}
	
	public void alertTermina() {
		JOptionPane.showMessageDialog(hpo, "Corso non terminato");
	}
}