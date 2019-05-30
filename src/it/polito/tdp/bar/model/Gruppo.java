package it.polito.tdp.bar.model;

public class Gruppo {
	
	private int numeroPersone;
	private int istanteArrivo;
	private int permanenza;
	private float tolleranza;
	double random = Math.random();
	private Tavolo tavoloAssegnato;
	
	public Gruppo() {
		numeroPersone = (int) ((random * 10)+1);
		permanenza = (int) ((random * 60)+60);
		tolleranza = (float) random;
	}

	public int getNumeroPersone() {
		return numeroPersone;
	}

	public int getIstanteArrivo() {
		return istanteArrivo;
	}
	
	public int setIstanteArrivo() {
		return istanteArrivo;
	}

	public int getPermanenza() {
		return permanenza;
	}
	
	public float getTolleranza(){
		return tolleranza;
	}

	public Tavolo getTavoloAssegnato() {
		return tavoloAssegnato;
	}

	public void setTavoloAssegnato(Tavolo tavoloAssegnato) {
		this.tavoloAssegnato = tavoloAssegnato;
	}

	@Override
	public String toString() {
		return "Gruppo [numeroPersone=" + numeroPersone + ", permanenza=" + permanenza + ", tolleranza=" + tolleranza
				+ ", tavoloAssegnato=" + tavoloAssegnato + "]";
	}
	
	
	
	
	
	

}
