import java.sql.Date;

public class Controller {

	private loginFrame lf;
	private registrationFrame rf;
	private homePageStud hps;
	private homePageOp hpo;
	
	private StudenteDAO stdao = new StudenteDAO();
	private OperatoreDAO opdao = new OperatoreDAO();
	
	public static void main(String[] args) {
		Controller c= new Controller();
	}
	
	public Controller() {
		lf = new loginFrame(this);
		rf = new registrationFrame(this);
		hps = new homePageStud(this);
		hpo = new homePageOp(this);
		//lf.setVisible(true);
		rf.setVisible(true);
	}
	
	public boolean checkUser(String id,String pwd){
		try {
			if(lf.getBoxSceltaLogin().getSelectedItem().equals("Studente")) {
				if(stdao.checkStud(id,pwd)) {
					hps.setVisible(true);
					return true;
				}
				else {
					return false;
				}
			}else{
				if(opdao.checkOp(id,pwd)) {
					hpo.setVisible(true);
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
					lf.setVisible(true);
					rf.setVisible(false);
					return true;
				}
				else {
					return false;
				}
			}
			else {
				if(stdao.registrazioneStud(nome, cognome, id, password, cf, data))
				{
					lf.setVisible(true);
					rf.setVisible(false);
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
}
