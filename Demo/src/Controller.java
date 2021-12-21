
public class Controller {

	loginFrame lf;
	registrationFrame rf;
	
	public static void main(String[] args) {
		Controller c= new Controller();
	}
	
	public Controller() {
		lf = new loginFrame(this);
		rf = new registrationFrame(this);
		lf.setVisible(true);
		rf.setVisible(true);
	}

}
