import java.sql.*;

public class StatisticheDAO {
	
	public Statistiche getStat(CorsoFormazione corso) throws SQLException{
		Statistiche stat = new Statistiche();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * FROM statistiche WHERE idcorso = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, corso.getIdCorso());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				stat.setIdStatistiche(rs.getInt(1));
				stat.setNumMedioStud(rs.getInt(2));
				stat.setMinStud(rs.getInt(3));
				stat.setMaxStud(rs.getInt(4));
				stat.setRiempimentoMedio(rs.getInt(5));
				stat.setCorso(corso);
			}
			
			rs.close();
			st.close();
			conn.close();
		}
		catch(SQLException e) {
			//e.printStackTrace();
		}
		
		return stat;
	}

}
