import java.sql.*;
import java.util.*;

public class IscrittoDAO {
	
	public ArrayList<Iscritto> getIscrizioni(Studente stud) throws SQLException{
		ArrayList <Iscritto> iscrizioni = new ArrayList<Iscritto>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * FROM iscritto AS st JOIN corsoformazione AS cs ON st.idcorso = cs.idcorso WHERE st.matricola = ?";
			
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
		}
		catch(SQLException e) {
			//e.printStackTrace();
		}
		
		return iscrizioni;
	}
	
	public Iscritto extractIscrizione(ResultSet rs,Studente stud) throws SQLException{
		Iscritto iscrizione = new Iscritto();
		
		iscrizione.setData(rs.getDate(1));
		iscrizione.setOrario(rs.getTime(2));
		iscrizione.setStud(stud);
		
		CorsoFormazione corso = new CorsoFormazione();
		corso.setNome(rs.getString(5));
		corso.setDescrizione(rs.getString(6));
		corso.setPresenzeMin(rs.getInt(7));
		corso.setMaxPartecipanti(rs.getInt(8));
		corso.setIdCorso(rs.getInt(10));
		
		iscrizione.setCorso(corso);
		
		return iscrizione;
	}

}
