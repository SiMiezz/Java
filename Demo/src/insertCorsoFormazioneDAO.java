import java.sql.*;


public class insertCorsoFormazioneDAO {
	
	public boolean registrazioneCorso(String nome, String descrizione, int presenzeMin, int maxPartecipanti, String idCorso) throws SQLException {
		try {
			if(nome !=null && presenzeMin!=0 && maxPartecipanti !=0 && idCorso!=null) {
				Connection conn = DataBaseConnection.getInstance().getConnection();
				Statement st= conn.createStatement();
				String query ="INSERT INTO studente (nome,descrizione,presenzemin,maxpartecipanti,idcorso) VALUES(?,?,?,?,?,?)";
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, nome);
				statement.setString(2, descrizione);
				statement.setInt(3, presenzeMin);
				statement.setInt(4, maxPartecipanti);
				statement.setString(5, idCorso);
				
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

}
