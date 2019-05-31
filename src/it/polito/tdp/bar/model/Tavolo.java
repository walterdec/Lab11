package it.polito.tdp.bar.model;

public class Tavolo {
	
	private int numeroPostiDisponibili;
	private int numeroTavoliDisponibili;
	
	public Tavolo(int numeroPostiDisponibili, int numeroTavoliDisponibili) {
		this.numeroPostiDisponibili = numeroPostiDisponibili;
		this.numeroTavoliDisponibili = numeroTavoliDisponibili;
	}

	public int getNumeroPostiDisponibili() {
		return this.numeroPostiDisponibili;
	}
	
	public int getNumeroTavoliDisponibili() {
		return this.numeroTavoliDisponibili;
	}
	
	public void incrementaTavoli(){
		this.numeroTavoliDisponibili++;
	}
	public void decrementaTavoli(){
		this.numeroTavoliDisponibili--;
	}

	@Override
	public String toString() {
		return "Tavolo [numeroPostiDisponibili=" + numeroPostiDisponibili + ", numeroTavoliDisponibili="
				+ numeroTavoliDisponibili + "]";
	}

	
	

}
