import java.sql.*;
import java.util.*;

public class LezioneDAO {
	
	public ArrayList<Lezione> getLezioni(Studente stud) throws SQLException {
		ArrayList <Lezione> lezioni = new ArrayList<Lezione>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * FROM lezione AS lez JOIN iscritto AS isc ON lez.idcorso = isc.idcorso WHERE isc.matricola = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, stud.getMatricola());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Lezione lezione = extractLezione(rs);
				lezioni.add(lezione);
			}
			
			rs.close();
			st.close();
			conn.close();
		}
		catch(SQLException e) {
			//e.printStackTrace();
		}
		
		return lezioni;
	}
	
	public Lezione extractLezione(ResultSet rs) throws SQLException{
		Lezione lezione = new Lezione();
		
		lezione.setIdlezione(rs.getInt(1));
		lezione.setTitolo(rs.getString(2));
		lezione.setDescrizione(rs.getString(3));
		lezione.setDurata(rs.getTime(4));
		lezione.setDatainizio(rs.getDate(5));
		lezione.setOrarioinizio(rs.getTime(6));
		
		return lezione;
	}

}
