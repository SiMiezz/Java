import java.sql.Date;
import java.sql.Time;

public class Iscritto {
	private Date data;
	private Time orario;
	private Studente stud = new Studente();
	private CorsoFormazione corso = new CorsoFormazione();
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getOrario() {
		return orario;
	}
	public void setOrario(Time orario) {
		this.orario = orario;
	}
	public Studente getStud() {
		return stud;
	}
	public void setStud(Studente stud) {
		this.stud = stud;
	}
	public CorsoFormazione getCorso() {
		return corso;
	}
	public void setCorso(CorsoFormazione corso) {
		this.corso = corso;
	}
}
