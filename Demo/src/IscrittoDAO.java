import java.sql.Date;
import java.sql.Time;
import java.sql.*;
import java.util.*;

public class IscrittoDAO {
	
	public boolean aggiungiIscrizione(Date data,Time orario,Studente stud,int id) throws SQLException{
		try {
			if(data!=null && stud!=null && id!=0) {
				Connection conn = DataBaseConnection.getInstance().getConnection();
				Statement st= conn.createStatement();
				String query ="INSERT INTO iscritto (data,orario,matricola,idcorso) VALUES(?,?,?,?)";
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setDate(1, data);
				statement.setTime(2, orario);
				statement.setString(3, stud.getMatricola());
				statement.setInt(4, id);
				
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
		
		iscrizione.setData(rs.getDate(1));
		iscrizione.setOrario(rs.getTime(2));
		iscrizione.setStud(stud);
		
		CorsoFormazione corso = new CorsoFormazione();
		corso.setIdCorso(rs.getInt(5));
		corso.setNome(rs.getString(6));
		corso.setDescrizione(rs.getString(7));
		corso.setPresenzeMin(rs.getInt(8));
		corso.setMaxPartecipanti(rs.getInt(9));
		
		iscrizione.setCorso(corso);
		
		return iscrizione;
	}

}
