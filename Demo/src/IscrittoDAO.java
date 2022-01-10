import java.sql.*;
import java.util.*;

public class IscrittoDAO {
	
	public boolean aggiungiIscrizione(Studente stud,CorsoFormazione corso){
		try {
			if(stud!=null && corso!=null) {
				Connection conn = DataBaseConnection.getInstance().getConnection();
				Statement st= conn.createStatement();
				String query ="INSERT INTO iscritto (matricola,idcorso) VALUES(?,?)";
				
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
			return false;
		}
	}
	
	public ArrayList<Iscritto> getIscrizioni(Studente stud){
		ArrayList <Iscritto> iscrizioni = new ArrayList<Iscritto>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * "
					+ "FROM iscritto AS st JOIN corsoformazione AS cs ON st.idcorso = cs.idcorso "
					+ "WHERE st.matricola = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, stud.getMatricola());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Iscritto iscrizione = extractIscrizione(rs,stud);
				iscrizioni.add(iscrizione);
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return iscrizioni;
		}
		catch(SQLException e) {
			return null;
		}	
	}
	
	public ArrayList<Iscritto> getIscrizioniCorso(CorsoFormazione corso){
		ArrayList <Iscritto> iscrizioni = new ArrayList<Iscritto>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * "
					+ "FROM iscritto AS isc JOIN studente AS std ON isc.matricola = std.matricola "
					+ "WHERE isc.idcorso = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, corso.getIdCorso());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Iscritto iscrizione = extractIscrizioneCorso(rs,corso);
				iscrizioni.add(iscrizione);
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return iscrizioni;
		}
		catch(SQLException e) {
			return null;
		}	
	}
	
	public Iscritto extractIscrizione(ResultSet rs,Studente stud) throws SQLException{
		Iscritto iscrizione = new Iscritto();
		
		iscrizione.setStud(stud);
		
		CorsoFormazione corso = new CorsoFormazione();
		corso.setIdCorso(rs.getInt(3));
		corso.setNome(rs.getString(4));
		corso.setDescrizione(rs.getString(5));
		corso.setData(rs.getDate(6));
		corso.setPresenzeMin(rs.getInt(7));
		corso.setMaxPartecipanti(rs.getInt(8));
		
		iscrizione.setCorso(corso);
		
		return iscrizione;
	}
	
	public Iscritto extractIscrizioneCorso(ResultSet rs, CorsoFormazione corso) throws SQLException{
		Iscritto iscrizione = new Iscritto();
		
		Studente stud = new Studente();
		stud.setMatricola(rs.getString(3));
		stud.setNome(rs.getString(4));
		stud.setCognome(rs.getString(5));
		stud.setData(rs.getDate(6));
		stud.setCf(rs.getString(7));
		
		iscrizione.setStud(stud);
		iscrizione.setCorso(corso);
		
		return iscrizione;
	}

}
