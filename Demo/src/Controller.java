import java.sql.*;

import javax.swing.JOptionPane;

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
		lf.setVisible(true);

	}
	
	public boolean checkUser(String user,String pwd){
		try {
			if(lf.getBoxSceltaLogin().getSelectedItem().equals("Studente")) {
				if(stdao.checkStud(user,pwd)) {
					hps.setVisible(true);
					return true;
				}
				else {
					return false;
				}
			}else if (lf.getBoxSceltaLogin().getSelectedItem().equals("Operatore")){
				if(opdao.checkOp(user,pwd)) {
					hpo.setVisible(true);
					return true;
				}
				else {
					return false;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void AlertLogin()
	{
		JOptionPane.showMessageDialog(lf,"Credenziali Errate o non inserite");
	}
	
	

}
