import java.sql.*;

public class Lezione {
	private int idlezione;
	private String titolo,descrizione;
	private Date datainizio;
	private Time durata,orarioinizio;
	private CorsoFormazione corso = new CorsoFormazione();
	
	public int getIdlezione() {
		return idlezione;
	}
	public void setIdlezione(int idlezione) {
		this.idlezione = idlezione;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Date getDatainizio() {
		return datainizio;
	}
	public void setDatainizio(Date datainizio) {
		this.datainizio = datainizio;
	}
	public Time getDurata() {
		return durata;
	}
	public void setDurata(Time durata) {
		this.durata = durata;
	}
	public Time getOrarioinizio() {
		return orarioinizio;
	}
	public void setOrarioinizio(Time orarioinizio) {
		this.orarioinizio = orarioinizio;
	}
	public CorsoFormazione getCorso() {
		return corso;
	}
	public void setCorso(CorsoFormazione corso) {
		this.corso = corso;
	}
}
