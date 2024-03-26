
public class Statistiche {
	private int idStatistiche,numMedioStud,minStud,maxStud,riempimentoMedio;
	CorsoFormazione corso = new CorsoFormazione();
	
	public int getIdStatistiche() {
		return idStatistiche;
	}
	public void setIdStatistiche(int idStatistiche) {
		this.idStatistiche = idStatistiche;
	}
	public int getNumMedioStud() {
		return numMedioStud;
	}
	public void setNumMedioStud(int numMedioStud) {
		this.numMedioStud = numMedioStud;
	}
	public int getMinStud() {
		return minStud;
	}
	public void setMinStud(int minStud) {
		this.minStud = minStud;
	}
	public int getMaxStud() {
		return maxStud;
	}
	public void setMaxStud(int maxStud) {
		this.maxStud = maxStud;
	}
	public int getRiempimentoMedio() {
		return riempimentoMedio;
	}
	public void setRiempimentoMedio(int riempimentoMedio) {
		this.riempimentoMedio = riempimentoMedio;
	}
	public CorsoFormazione getCorso() {
		return corso;
	}
	public void setCorso(CorsoFormazione corso) {
		this.corso = corso;
	}
}
