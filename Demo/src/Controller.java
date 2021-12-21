import java.sql.*;

public class Controller {

	loginFrame lf;
	
	registrationFrame rf;
	homePageStud hps= new homePageStud(this);
	homePageOp hpo= new homePageOp(this);
	
	public static void main(String[] args) {
		Controller c= new Controller();
	}
	
	public Controller() {
		
		lf = new loginFrame(this);
		rf = new registrationFrame(this);
		lf.setVisible(true);
//		rf.setVisible(true);
	}
	
	public boolean checkUser(String user,String pwd) {
		boolean check = false;
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM studente");
			
			while(rs.next() && (check == false)) {
				if(rs.getString(1).equals(user) && rs.getString(2).equals(pwd)) {
					check = true;
				}
			}
			
			rs.close();
			st.close();
			conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return check;
	}
	

}
