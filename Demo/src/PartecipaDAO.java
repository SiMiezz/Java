import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PartecipaDAO {
	
	public boolean aggiungiPartecipa(Studente stud,CorsoFormazione corso){
		try {
			if(stud!=null && corso!=null) {
				Connection conn = DataBaseConnection.getInstance().getConnection();
				Statement st= conn.createStatement();
				String query ="INSERT INTO partecipa (matricola,idlezione) VALUES(?,?)";
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, stud.getMatricola());
				statement.setInt(2, corso.getIdCorso());
				
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
