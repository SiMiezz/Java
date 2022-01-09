import java.sql.*;
import java.util.*;

public class LezioneDAO {
	
	public ArrayList<Lezione> getLezioni(Studente stud){
		ArrayList <Lezione> lezioni = new ArrayList<Lezione>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * "
					+ "FROM (lezione AS lez JOIN iscritto AS isc ON lez.idcorso = isc.idcorso) JOIN corsoformazione AS cs ON cs.idcorso = lez.idcorso "
					+ "WHERE isc.matricola = ?";
			
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
			
			return lezioni;
		}
		catch(SQLException e) {
			return null;
		}	
	}
	
	public ArrayList<Lezione> getLezioniNoPartecipa(Studente stud){
		ArrayList <Lezione> lezioni = new ArrayList<Lezione>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * "
					+ "FROM (lezione AS lez JOIN iscritto AS isc ON lez.idcorso = isc.idcorso) JOIN corsoformazione AS csf ON csf.idcorso = lez.idcorso "
					+ "WHERE isc.matricola = ? AND lez.idlezione NOT IN "
					+ "(SELECT lez.idlezione "
					+ "FROM (lezione AS lez JOIN iscritto AS isc ON lez.idcorso = isc.idcorso) JOIN partecipa AS par ON par.idlezione = lez.idlezione AND par.matricola = isc.matricola "
					+ "WHERE par.matricola = ?) "
					+ "AND lez.idcorso NOT IN "
					+ "(SELECT DISTINCT lez.idcorso "
					+ "FROM (lezione AS lez JOIN iscritto AS isc ON lez.idcorso = isc.idcorso) JOIN terminazione AS ter ON ter.idcorso = lez.idcorso "
					+ "WHERE isc.matricola = ?)";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, stud.getMatricola());
			statement.setString(2, stud.getMatricola());
			statement.setString(3, stud.getMatricola());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Lezione lezione = extractLezione(rs);
				lezioni.add(lezione);
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return lezioni;
		}
		catch(SQLException e) {
			return null;
		}	
	}
	
	public Lezione extractLezione(ResultSet rs) throws SQLException{
		Lezione lezione = new Lezione();
		
		lezione.setIdlezione(rs.getInt(1));
		lezione.setTitolo(rs.getString(2));
		lezione.setDescrizione(rs.getString(3));
		lezione.setDurata(rs.getTime(4));
		lezione.setDatainizio(rs.getDate(5));
		lezione.setOrarioinizio(rs.getTime(6));
		
		CorsoFormazione corso = new CorsoFormazione();
		corso.setIdCorso(rs.getInt(10));
		corso.setNome(rs.getString(11));
		corso.setDescrizione(rs.getString(12));
		corso.setData(rs.getDate(13));
		corso.setPresenzeMin(rs.getInt(14));
		corso.setMaxPartecipanti(rs.getInt(15));
		
		lezione.setCorso(corso);
		
		return lezione;
	}

}
