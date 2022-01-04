import java.sql.*;

public class TerminazioneDAO {
	
	public boolean terminaCorso(CorsoFormazione corso,Operatore op){
		try {
			if(corso!=null && op!=null) {
				Connection conn = DataBaseConnection.getInstance().getConnection();
				Statement st= conn.createStatement();
				String query ="INSERT INTO terminazione (idcorso,id) VALUES(?,?)";
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setInt(1, corso.getIdCorso());
				statement.setString(2, op.getId());
				
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
		}
		
		return false;
	}
}
