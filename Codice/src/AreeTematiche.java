
public class AreeTematiche {
	private String tipo,descrizione;
	private CorsoFormazione corso = new CorsoFormazione();
	private Operatore op = new Operatore();

	public Operatore getOp() {
		return op;
	}

	public void setOp(Operatore op) {
		this.op = op;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public CorsoFormazione getCorso() {
		return corso;
	}

	public void setCorso(CorsoFormazione corso) {
		this.corso = corso;
	}
}
