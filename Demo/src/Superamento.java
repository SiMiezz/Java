
public class Superamento {
	private boolean superato;
	private Studente stud = new Studente();
	private CorsoFormazione corso = new CorsoFormazione();
	
	public boolean isSuperato() {
		return superato;
	}
	public void setSuperato(boolean superato) {
		this.superato = superato;
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
