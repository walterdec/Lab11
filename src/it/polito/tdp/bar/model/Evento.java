package it.polito.tdp.bar.model;

public class Evento implements Comparable<Evento>{
	
	public enum TipoEvento{
		GRUPPO_CLIENTI_ARRIVA,
		GRUPPO_CLIENTI_ABBANDONA,
	}
	
	private int istante;
	private TipoEvento tipo;
	private Gruppo gruppo;
	private Tavolo tavolo;

	public Evento(int istante, TipoEvento tipo, Gruppo gruppo) {
		this.istante = istante;
		this.tipo = tipo;
		this.gruppo=gruppo;
	}

	public int getIstante() {
		return istante;
	}
	
	public TipoEvento getTipo() {
		return tipo;
	}
	

	public Gruppo getGruppo() {
		return gruppo;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	@Override
	public String toString() {
		return "Evento [istante=" + istante + ", tipo=" + tipo + ", gruppo=" + gruppo + ", tavolo=" + tavolo + "]";
	}

	@Override
	public int compareTo(Evento altro) {
		return this.istante - altro.istante;
	}
	
	
	

}
