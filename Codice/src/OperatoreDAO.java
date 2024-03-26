import java.sql.*;

public class OperatoreDAO {

	public boolean checkOp(String id,String pwd){
		boolean check = false;
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM operatore");
			
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
	
	public Operatore getOp(String id){
		Operatore op = new Operatore();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * FROM operatore WHERE id = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, id);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				op.setId(id);
				op.setNome(rs.getString(2));
				op.setCognome(rs.getString(3));
				op.setData(rs.getDate(4));
				op.setCf(rs.getString(5));
				op.setPassword(rs.getString(6));
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return op;
		}
		catch (SQLException e) {
			return null;
		}
	}

	public boolean registrazioneOP(String nome, String cognome, String id, String password, String cf, Date data){
		try {
			if(nome !=null && cognome !=null && id!=null && password !=null && cf!=null) {
				Connection conn = DataBaseConnection.getInstance().getConnection();
				Statement st= conn.createStatement();
				String query ="INSERT INTO operatore VALUES(?,?,?,?,?,?)";
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, id);
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
