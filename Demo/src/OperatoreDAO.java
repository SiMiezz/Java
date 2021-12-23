import java.sql.*;

public class OperatoreDAO {

	public boolean checkOp(String id,String pwd) throws SQLException{
		boolean check = false;
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM operatore");
			
			while(rs.next() && (check == false)) {
				if(rs.getString(4).equals(id) && rs.getString(6).equals(pwd)) {
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
	
	public Operatore getOp(String id) throws SQLException{
		Operatore op = new Operatore();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * FROM operatore WHERE id = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, id);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				op.setNome(rs.getString(1));
				op.setCognome(rs.getString(2));
				op.setData(rs.getDate(3));
				op.setId(id);
				op.setCf(rs.getString(5));
				op.setPassword(rs.getString(6));
			}
			
			rs.close();
			st.close();
			conn.close();
		}
		catch (SQLException e) {
			//e.printStackTrace();
		}
		
		return op;
	}

	public boolean registrazioneOP(String nome, String cognome, String id, String password, String cf, Date data) throws SQLException {
		try {
			if(nome !=null && cognome !=null && id!=null && password !=null && cf!=null) {
				Connection conn = DataBaseConnection.getInstance().getConnection();
				Statement st= conn.createStatement();
				String query ="INSERT INTO operatore (nome,cognome,data,id,cf,password) VALUES(?,?,?,?,?,?)";
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, nome);
				statement.setString(2, cognome);
				statement.setDate(3, data);
				statement.setString(4, id);
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
			e.printStackTrace();
			return false;
		}
		
	}
}
