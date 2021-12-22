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

	public boolean Registrazione(String strNome, String strCognome, String id, String password, String cf, String dataN) throws SQLException {
		
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query ="INSERT INTO operatore (nome,cognome,dataN,id,CF,password) VALUES(?,?,?,?,?,?)";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, strNome);
			statement.setString(2, strCognome);
			statement.setString(3, dataN);
			statement.setString(4, id);
			statement.setString(5, cf);
			statement.setString(6, password);
			
			statement.executeUpdate();
			
			st.close();
			conn.close();
		}
		catch(SQLException e){
			System.out.println("Connessione fallita");
			e.printStackTrace();
		}
		
		return true;
		
		
		
		
	}
}
