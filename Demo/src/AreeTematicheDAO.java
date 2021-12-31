import java.sql.*;
import java.util.ArrayList;

public class AreeTematicheDAO {
	
	public boolean aggiungiAree(String tipo,String descrizione,CorsoFormazione corso,Operatore op) throws SQLException{
		try {
			if(tipo !=null && corso!=null) {
				Connection conn = DataBaseConnection.getInstance().getConnection();
				Statement st= conn.createStatement();
				String query ="INSERT INTO areetematiche (tipo,descrizione,idcorso,id) VALUES(?,?,?,?)";
				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, tipo);
				statement.setString(2, descrizione);
				statement.setInt(3, corso.getIdCorso());
				statement.setString(4, op.getId());
				
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
	
	public ArrayList<AreeTematiche> getAree(Operatore op) throws SQLException {
		ArrayList <AreeTematiche> aree = new ArrayList<AreeTematiche>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * FROM areetematiche AS ar JOIN corsoformazione AS cs ON ar.idcorso = cs.idcorso WHERE ar.id = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, op.getId());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				AreeTematiche area = extractAree(rs,op);
				aree.add(area);
			}
			
			rs.close();
			st.close();
			conn.close();
		}
		catch(SQLException e) {
			//e.printStackTrace();
		}
		
		return aree;
	}
	
	public AreeTematiche extractAree(ResultSet rs,Operatore op) throws SQLException{
		AreeTematiche area = new AreeTematiche();
		
		area.setTipo(rs.getString(1));
		area.setDescrizione(rs.getString(2));
		
		CorsoFormazione corso = new CorsoFormazione();
		corso.setIdCorso(rs.getInt(4));
		corso.setNome(rs.getString(5));
		corso.setDescrizione(rs.getString(6));
		corso.setPresenzeMin(rs.getInt(7));
		corso.setMaxPartecipanti(rs.getInt(8));
		
		area.setCorso(corso);
		area.setOp(op);
		
		return area;
	}
}
