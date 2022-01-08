import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

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
	
	public ArrayList<CorsoFormazione> getCorsiNoIscrizione(Studente stud){
		return corsodao.getCorsiNoIscrizione(stud);
	}
	
	public ArrayList<CorsoFormazione> getCorsiPkey(String key,Operatore op){
		return corsodao.getCorsiPKey(key,op);
	}
	
	public ArrayList<CorsoFormazione> getCorsiData(Date data,Operatore op){
		return corsodao.getCorsiData(data,op);
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
	
	public ArrayList<Lezione> getLezioniNoPartecipa(Studente stud){
		return lezdao.getLezioniNoPartecipa(stud);
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
	
	public boolean inserisciCorso(String nome, String descrizione, Date data, int presenzeMin, int maxPartecipanti, Operatore op) {
		return corsodao.aggiungiCorso(nome, descrizione, data, presenzeMin, maxPartecipanti, op);
	}
	
	public boolean iscriviti(Studente stud,CorsoFormazione corso) {
		return iscdao.aggiungiIscrizione(stud,corso);
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
		JOptionPane.showMessageDialog(rf,"Registrazione avvenuta con successo come " +rf.getBoxSceltaRegistration().getSelectedItem(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		rf.setVisible(false);
		lf.setVisible(true);
	}

	public void alertRegistration() {
		JOptionPane.showMessageDialog(rf, "Registrazione errata. Riprova", "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public void alertLogin(){
		JOptionPane.showMessageDialog(lf,"Credenziali Errate o non inserite", "ERROR", JOptionPane.ERROR_MESSAGE);		
	}
	
	public void confirmLogin() {
		JOptionPane.showMessageDialog(lf,"Login effettuato come " + lf.getBoxSceltaLogin().getSelectedItem(), "INFO", JOptionPane.INFORMATION_MESSAGE);
		
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
		JOptionPane.showMessageDialog(hpo, "Corso aggiunto correttamente", "INFO", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void alertInsertCorso() {
		JOptionPane.showMessageDialog(hpo, "Errore nell'inserimento del corso", "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public void confirmInsertIscrizione() {
		JOptionPane.showMessageDialog(hps, "Iscrizione avvenuta correttamente", "INFO", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void alertInsertIscrizione() {
		JOptionPane.showMessageDialog(hps, "Errore nell'iscrizione", "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public void confirmUpdate() {
		JOptionPane.showMessageDialog(hpo, "Corso aggiornato correttamente", "INFO", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void alertUpdate() {
		JOptionPane.showMessageDialog(hpo, "Errore nell'aggiornamento del corso", "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public void alertSeleziona() {
		if(hpo == null || !hpo.isShowing()) {
			JOptionPane.showMessageDialog(hps, "Selezionare il corso!", "WARNING", JOptionPane.WARNING_MESSAGE);
		}
		else if (hps == null || !hps.isShowing()){
			JOptionPane.showMessageDialog(hpo, "Selezionare il corso!", "WARNING", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void confirmInsertAree() {
		JOptionPane.showMessageDialog(hpo, "Area Tematica aggiunta correttamente", "INFO", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void alertInsertAree() {
		JOptionPane.showMessageDialog(hpo, "Errore nell'iserimento dell'Area", "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public void confirmInsertPresenza() {
		JOptionPane.showMessageDialog(hps, "Presenza effettuata", "INFO", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void alertInsertPresenza() {
		JOptionPane.showMessageDialog(hps, "Presenza non effettuata", "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public void confirmTermina() {
		JOptionPane.showMessageDialog(hpo, "Corso Terminato", "INFO", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void alertTermina() {
		JOptionPane.showMessageDialog(hpo, "Corso non terminato", "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public String insertKey() {
		String key = JOptionPane.showInputDialog(hpo, "Inserisci la parola chiave", "QUESTION", JOptionPane.QUESTION_MESSAGE);
		return key;
	}
	
	public static Date tryParse(String text) {
		try {
			return Date.valueOf(text);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	
	public Date insertData() {
		Date data = tryParse(JOptionPane.showInputDialog(hpo, "Inserisci una data (yyyy-mm-dd)", "QUESTION", JOptionPane.QUESTION_MESSAGE));
		return data;
	}
	
	public void aggiungiTabella(JScrollPane scroll) {
		JOptionPane.showMessageDialog(hpo, scroll);
	}
}