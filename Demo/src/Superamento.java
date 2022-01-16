
public class Superamento {
	private boolean superato;
	private Studente studente = new Studente();
	private CorsoFormazione corso = new CorsoFormazione();
	
	public boolean isSuperato() {
		return superato;
	}
	public void setSuperato(boolean superato) {
		this.superato = superato;
	}
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
