import java.sql.*;
import java.util.*;

public class SuperamentoDAO {
	
	public ArrayList<Superamento> getStudSupera(CorsoFormazione corso) throws SQLException{
		ArrayList<Superamento> superati = new ArrayList<Superamento>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * FROM superamento AS sup JOIN studente AS stud ON sup.matricola = stud.matricola WHERE sup.idcorso = ? AND sup.superato = true";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, corso.getIdCorso());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Superamento superato = extractSuperato(rs,corso);
				superati.add(superato);
			}
			
			rs.close();
			st.close();
			conn.close();
		}
		catch(SQLException e) {
			//e.printStackTrace();
		}
		
		return superati;
	}
	
	public Superamento extractSuperato(ResultSet rs,CorsoFormazione corso) throws SQLException{
		Superamento sup = new Superamento();
		
		sup.setSuperato(rs.getBoolean(1));
		
		Studente stud = new Studente();
		stud.setMatricola(rs.getString(4));
		stud.setNome(rs.getString(5));
		stud.setCognome(rs.getString(6));
		stud.setData(rs.getDate(7));
		stud.setCf(rs.getString(8));
		stud.setPassword(rs.getString(9));
		
		sup.setStud(stud);
		sup.setCorso(corso);
		
		return sup;
	}
}
