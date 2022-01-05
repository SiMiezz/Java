import java.util.*;
import java.sql.Date;

public class CorsoFormazione {
	private String nome,descrizione;
	private int presenzeMin,maxPartecipanti,idCorso;
	private Date data;
	private Operatore op = new Operatore();
	private ArrayList <Lezione> lezioni = new ArrayList<Lezione>();
	
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Operatore getOp() {
		return op;
	}
	public void setOp(Operatore op) {
		this.op = op;
	}
	public int getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}
	public ArrayList<Lezione> getLezioni() {
		return lezioni;
	}
	public void setLezioni(ArrayList<Lezione> lezioni) {
		this.lezioni = lezioni;
	}
}
