import java.sql.*;

public class StudenteDAO {
	
	public boolean checkStud(String id,String pwd) throws SQLException{
		boolean check = false;
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM studente");
			
			while(rs.next() && (check == false)) {
				if(rs.getString(5).equals(id) && rs.getString(6).equals(pwd)) {
					check = true;
				}
			}
			
			rs.close();
			st.close();
			conn.close();
		}
		catch(SQLException e){
			//e.printStackTrace();
		}
		
		return check;
	}
	
	public boolean registrazioneStud(String nome, String cognome, String matricola, String password, String cf) throws SQLException {
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query ="INSERT INTO studente (nome,cognome,matricola,cf,password) VALUES(?,?,?,?,?)";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, nome);
			statement.setString(2, cognome);
			//statement.setDate(3,);
			statement.setString(3, matricola);
			statement.setString(4, cf);
			statement.setString(5, password);
			
			statement.executeUpdate();
			
			st.close();
			conn.close();
			return true;
		}
		catch(SQLException e){
			//e.printStackTrace();
			return false;
		}
	}
}
