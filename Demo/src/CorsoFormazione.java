
public class CorsoFormazione {
	private String nome,descrizione;
	private int presenzeMin,maxPartecipanti;
	private Operatore op = new Operatore();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getPresenzeMin() {
		return presenzeMin;
	}
	public void setPresenzeMin(int presenzeMin) {
		this.presenzeMin = presenzeMin;
	}
	public int getMaxPartecipanti() {
		return maxPartecipanti;
	}
	public void setMaxPartecipanti(int maxPartecipanti) {
		this.maxPartecipanti = maxPartecipanti;
	}
	public Operatore getOp() {
		return op;
	}
	public void setOp(Operatore op) {
		this.op = op;
	}
}
