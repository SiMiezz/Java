import java.sql.*;

public class StudenteDAO {
	
	public boolean checkStud(String id,String pwd){
		boolean check = false;
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM studente");
			
			while(rs.next() && (check == false)) {
				if(rs.getString(1).equals(id) && rs.getString(6).equals(pwd)) {
					check = true;
				}
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return check;
		}
		catch(SQLException e){
			return false;
		}
	}
	
	public Studente getStud(String matricola){
		Studente stud = new Studente();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * FROM studente WHERE matricola = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, matricola);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				stud.setMatricola(matricola);
				stud.setNome(rs.getString(2));
				stud.setCognome(rs.getString(3));
				stud.setData(rs.getDate(4));
				stud.setCf(rs.getString(5));
				stud.setPassword(rs.getString(6));
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return stud;
		}
		catch (SQLException e) {
			return null;
		}	
	}
	
	public boolean registrazioneStud(String nome, String cognome, String matricola, String password, String cf, Date data){
		try {
			if(nome !=null && cognome !=null && matricola!=null && password !=null && cf!=null) {
				Connection conn = DataBaseConnection.getInstance().getConnection();
				Statement st= conn.createStatement();
				String query ="INSERT INTO studente VALUES(?,?,?,?,?,?)";
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, matricola);
				statement.setString(2, nome);
				statement.setString(3, cognome);
				statement.setDate(4, data);
				statement.setString(5, cf);
				statement.setString(6, password);
				
				statement.executeUpdate();
				
				st.close();
				conn.close();
				
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException e){
			return false;
		}
	}
}
