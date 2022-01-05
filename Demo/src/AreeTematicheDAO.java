import java.sql.*;
import java.util.ArrayList;

public class AreeTematicheDAO {
	
	public boolean aggiungiAree(String tipo,String descrizione,CorsoFormazione corso,Operatore op){
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
			return false;
		}	
	}
	
	public ArrayList<AreeTematiche> getAreeCorso(CorsoFormazione corso,Operatore op){
		ArrayList <AreeTematiche> aree = new ArrayList<AreeTematiche>();
		
		try {
			Connection conn = DataBaseConnection.getInstance().getConnection();
			Statement st= conn.createStatement();
			String query = "SELECT * FROM areetematiche AS ar JOIN corsoformazione AS cs ON ar.idcorso = cs.idcorso WHERE cs.idcorso = ?";
			
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, corso.getIdCorso());
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				AreeTematiche area = extractAree(rs,corso,op);
				aree.add(area);
			}
			
			rs.close();
			st.close();
			conn.close();
			
			return aree;
		}
		catch(SQLException e) {
			return null;
		}	
	}
	
	public AreeTematiche extractAree(ResultSet rs,CorsoFormazione corso,Operatore op) throws SQLException{
		AreeTematiche area = new AreeTematiche();
		
		area.setTipo(rs.getString(1));
		area.setDescrizione(rs.getString(2));
		area.setCorso(corso);
		area.setOp(op);
		
		return area;
	}
}
