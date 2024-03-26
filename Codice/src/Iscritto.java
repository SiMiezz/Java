
public class Iscritto {
	private Studente studente = new Studente();
	private CorsoFormazione corso = new CorsoFormazione();
	
	public Studente getStudente() {
		return studente;
	}
	public void setStudente(Studente studente) {
		this.studente = studente;
	}
	public CorsoFormazione getCorso() {
		return corso;
	}
	public void setCorso(CorsoFormazione corso) {
		this.corso = corso;
	}
}
