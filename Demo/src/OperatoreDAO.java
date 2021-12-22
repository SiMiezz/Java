import java.sql.*;

public class OperatoreDAO {

	public boolean checkOp(String user,String pwd) throws SQLException{
		boolean check = false;
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM operatore");
			
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
			System.out.println("Connessione fallita");
			e.printStackTrace();
		}
		
		return check;
	}
}
