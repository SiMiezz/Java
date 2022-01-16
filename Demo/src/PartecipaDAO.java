import java.sql.*;
import java.util.ArrayList;

public class PartecipaDAO {
	
	public boolean aggiungiPartecipa(Studente stud,int id){
		try {
			if(stud!=null && id!=0) {
				Connection conn = DataBaseConnection.getInstance().getConnection();
				Statement st= conn.createStatement();
				String query ="INSERT INTO partecipa (matricola,idlezione) VALUES(?,?)";
				
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
			return false;
		}
	}
	
	public ArrayList<Partecipa> getPartecipaLezione(Lezione lez){
		ArrayList <Partecipa> presenze = new ArrayList<Partecipa>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * "
					+ "FROM partecipa AS par JOIN studente AS stud ON par.matricola = stud.matricola "
					+ "WHERE par.idlezione = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, lez.getIdlezione());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Partecipa presenza = extractPartecipa(rs,lez);
				presenze.add(presenza);
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return presenze;
		}
		catch(SQLException e) {
			return null;
		}	
	}
	
	public ArrayList<Partecipa> getPartecipaStud(Studente stud){
		ArrayList <Partecipa> presenze = new ArrayList<Partecipa>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * "
					+ "FROM partecipa AS par JOIN lezione AS lez ON par.idlezione = lez.idlezione "
					+ "WHERE par.matricola = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, stud.getMatricola());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Partecipa presenza = extractPartecipaStud(rs,stud);
				presenze.add(presenza);
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return presenze;
		}
		catch(SQLException e) {
			return null;
		}	
	}
	
	public Partecipa extractPartecipa(ResultSet rs, Lezione lez) throws SQLException{
		Partecipa presenza = new Partecipa();
		
		presenza.setLez(lez);
		
		Studente stud = new Studente();
		stud.setMatricola(rs.getString(3));
		stud.setNome(rs.getString(4));
		stud.setCognome(rs.getString(5));
		stud.setData(rs.getDate(6));
		stud.setCf(rs.getString(7));
		
		presenza.setStud(stud);
		
		return presenza;
	}
	
	public Partecipa extractPartecipaStud(ResultSet rs, Studente stud) throws SQLException{
		Partecipa presenza = new Partecipa();
		
		presenza.setStud(stud);
		
		Lezione lez = new Lezione();
		lez.setIdlezione(rs.getInt(3));
		lez.setTitolo(rs.getString(4));
		lez.setDescrizione(rs.getString(5));
		lez.setDurata(rs.getTime(6));
		lez.setDatainizio(rs.getDate(7));
		lez.setOrarioinizio(rs.getTime(8));
		
		presenza.setLez(lez);
		
		return presenza;
	}

}
