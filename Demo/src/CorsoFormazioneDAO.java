import java.sql.*;
import java.util.*;

public class CorsoFormazioneDAO {
	
	public boolean aggiungiCorso(String nome, String descrizione, int presenzeMin, int maxPartecipanti, Operatore op) throws SQLException {
		try {
			if(nome !=null && presenzeMin!=0 && maxPartecipanti !=0 && op!=null) {
				Connection conn = DataBaseConnection.getInstance().getConnection();
				Statement st= conn.createStatement();
				String query ="INSERT INTO corsoformazione (nome,descrizione,presenzemin,maxpartecipanti,id) VALUES(?,?,?,?,?)";
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, nome);
				statement.setString(2, descrizione);
				statement.setInt(3, presenzeMin);
				statement.setInt(4, maxPartecipanti);
				statement.setString(5, op.getId());
				
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
	
	public boolean aggiornaCorso(String nome, String descrizione, int presenzeMin, int maxPartecipanti, int id) throws SQLException{
		try {
			if(nome !=null && presenzeMin!=0 && maxPartecipanti !=0) {
				Connection conn = DataBaseConnection.getInstance().getConnection();
				Statement st= conn.createStatement();
				String query ="UPDATE corsoformazione SET nome = ?, descrizione = ?, presenzemin = ?, maxpartecipanti = ? WHERE idcorso = ?";
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, nome);
				statement.setString(2, descrizione);
				statement.setInt(3, presenzeMin);
				statement.setInt(4, maxPartecipanti);
				statement.setInt(5, id);
				
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
	
	public ArrayList<CorsoFormazione> getCorsiOperatore(Operatore op) throws SQLException {
		ArrayList <CorsoFormazione> corsi = new ArrayList<CorsoFormazione>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * FROM corsoformazione WHERE id = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, op.getId());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				CorsoFormazione corso = extractCorso(rs,op);
				corsi.add(corso);
			}
			
			rs.close();
			st.close();
			conn.close();
		}
		catch(SQLException e) {
			//e.printStackTrace();
		}
		
		return corsi;
	}
	
	public ArrayList<CorsoFormazione> getCorsiIscrizione(Studente stud) throws SQLException {
		ArrayList <CorsoFormazione> corsi = new ArrayList<CorsoFormazione>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * FROM corsoformazione WHERE idcorso NOT IN (SELECT cs.idcorso FROM corsoformazione AS cs JOIN iscritto AS isc ON cs.idcorso = isc.idcorso WHERE isc.matricola = ?)";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, stud.getMatricola());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				CorsoFormazione corso = extractCorsi(rs);
				corsi.add(corso);
			}
			
			rs.close();
			st.close();
			conn.close();
		}
		catch(SQLException e) {
			//e.printStackTrace();
		}
		
		return corsi;
	}
	
	public CorsoFormazione getCorso(int id) throws SQLException{
		CorsoFormazione corso = new CorsoFormazione();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * FROM corsoformazione WHERE idcorso = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				corso.setIdCorso(id);
				corso.setNome(rs.getString(2));
				corso.setDescrizione(rs.getString(3));
				corso.setPresenzeMin(rs.getInt(4));
				corso.setMaxPartecipanti(rs.getInt(5));
			}
			
			rs.close();
			st.close();
			conn.close();
		}
		catch(SQLException e) {
			//e.printStackTrace();
		}
		
		return corso;
	}
	
	public ArrayList<CorsoFormazione> getCorsiNoTermina(Operatore op) throws SQLException {
		ArrayList <CorsoFormazione> corsi = new ArrayList<CorsoFormazione>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * FROM corsoformazione AS cs WHERE cs.id = ? AND cs.idcorso NOT IN (SELECT cs.idcorso FROM corsoformazione AS cs JOIN terminazione AS ter ON cs.idcorso = ter.idcorso WHERE cs.id = ?)";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, op.getId());
			statement.setString(2, op.getId());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				CorsoFormazione corso = extractCorso(rs,op);
				corsi.add(corso);
			}
			
			rs.close();
			st.close();
			conn.close();
		}
		catch(SQLException e) {
			//e.printStackTrace();
		}
		
		return corsi;
	}
	
	public ArrayList<CorsoFormazione> getCorsiTermina(Operatore op) throws SQLException {
		ArrayList <CorsoFormazione> corsi = new ArrayList<CorsoFormazione>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * FROM corsoformazione AS cs JOIN terminazione AS ter ON cs.idcorso = ter.idcorso WHERE cs.id = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, op.getId());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				CorsoFormazione corso = extractCorso(rs,op);
				corsi.add(corso);
			}
			
			rs.close();
			st.close();
			conn.close();
		}
		catch(SQLException e) {
			//e.printStackTrace();
		}
		
		return corsi;
	}
	
	public ArrayList<CorsoFormazione> getAllCorsi() throws SQLException {
		ArrayList <CorsoFormazione> corsi = new ArrayList<CorsoFormazione>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM corsoformazione");
			
			while(rs.next()) {
				CorsoFormazione corso = extractCorsi(rs);
				corsi.add(corso);
			}
			
			rs.close();
			st.close();
			conn.close();
		}
		catch(SQLException e) {
			//e.printStackTrace();
		}
		
		return corsi;
	}
	
	public CorsoFormazione extractCorso(ResultSet rs,Operatore op) throws SQLException{
		CorsoFormazione corso = new CorsoFormazione();
		
		corso.setIdCorso(rs.getInt(1));
		corso.setNome(rs.getString(2));
		corso.setDescrizione(rs.getString(3));
		corso.setPresenzeMin(rs.getInt(4));
		corso.setMaxPartecipanti(rs.getInt(5));
		corso.setOp(op);
		
		return corso;
	}
	
	public CorsoFormazione extractCorsi(ResultSet rs) throws SQLException{
		CorsoFormazione corso = new CorsoFormazione();
		
		corso.setIdCorso(rs.getInt(1));
		corso.setNome(rs.getString(2));
		corso.setDescrizione(rs.getString(3));
		corso.setPresenzeMin(rs.getInt(4));
		corso.setMaxPartecipanti(rs.getInt(5));
		
		return corso;
	}
}
