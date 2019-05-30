package it.polito.tdp.bar.model;

public class Tavolo {
	
	private int numeroPostiDisponibili;
	private int numeroPostiOccupati;
	private int numeroTavoliDisponibili;
	
	public Tavolo(int numeroPostiDisponibili, int numeroTavoliDisponibili) {
		this.numeroPostiDisponibili = numeroPostiDisponibili;
		this.numeroTavoliDisponibili = numeroTavoliDisponibili;
		numeroPostiOccupati = 0;
	}

	public int getNumeroPostiOccupati() {
		return numeroPostiOccupati;
	}

	public void setNumeroPostiOccupati(int numeroPostiOccupati) {
		this.numeroPostiOccupati = numeroPostiOccupati;
	}

	public int getNumeroPostiDisponibili() {
		return numeroPostiDisponibili;
	}
	
	public int getNumeroTavoliDisponibili() {
		return numeroTavoliDisponibili;
	}
	
	public void setNumeroTavoliDisponibili(int num) {
		this.numeroTavoliDisponibili = num;
	}
	
	

}
