import java.sql.*;

public class AreeTematicheDAO {
	
	public boolean aggiungiAree(String tipo,String descrizione,CorsoFormazione corso) throws SQLException{
		try {
			if(tipo !=null && corso!=null) {
				Connection conn = DataBaseConnection.getInstance().getConnection();
				Statement st= conn.createStatement();
				String query ="INSERT INTO areetematiche (tipo,descrizione,idcorso) VALUES(?,?,?)";
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, tipo);
				statement.setString(2, descrizione);
				statement.setInt(3, corso.getIdCorso());
				
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
			//e.printStackTrace();
			return false;
		}
	}
}
