import java.sql.Date;
import java.util.*;

public class Operatore {
	private String nome,cognome,cf,id,password;
	private Date data;
	private ArrayList <CorsoFormazione> corsi = new ArrayList<CorsoFormazione>();
	private ArrayList <AreeTematiche> aree = new ArrayList<AreeTematiche>();
	
	public ArrayList<AreeTematiche> getAree() {
		return aree;
	}
	public void setAree(ArrayList<AreeTematiche> aree) {
		this.aree = aree;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<CorsoFormazione> getCorsi() {
		return corsi;
	}
	public void setCorsi(ArrayList<CorsoFormazione> corsi) {
		this.corsi = corsi;
	}
}
