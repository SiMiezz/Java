import java.sql.*;
import java.util.*;

public class IscrittoDAO {
	
	public boolean aggiungiIscrizione(Studente stud,int id) throws SQLException{
		try {
			if(stud!=null && id!=0) {
				Connection conn = DataBaseConnection.getInstance().getConnection();
				Statement st= conn.createStatement();
				String query ="INSERT INTO iscritto (matricola,idcorso) VALUES(?,?)";
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, stud.getMatricola());
				statement.setInt(2, id);
				
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
		
		iscrizione.setStud(stud);
		
		CorsoFormazione corso = new CorsoFormazione();
		corso.setIdCorso(rs.getInt(3));
		corso.setNome(rs.getString(4));
		corso.setDescrizione(rs.getString(5));
		corso.setPresenzeMin(rs.getInt(6));
		corso.setMaxPartecipanti(rs.getInt(7));
		
		iscrizione.setCorso(corso);
		
		return iscrizione;
	}

}
