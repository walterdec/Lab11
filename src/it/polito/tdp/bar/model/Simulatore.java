package it.polito.tdp.bar.model;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import it.polito.tdp.bar.model.Evento.TipoEvento;

public class Simulatore {
	
	private PriorityQueue<Evento> queue = new PriorityQueue<>();
	
	//stato del mondo
	private Map<Integer, Tavolo> mappaTavoli;
	
	//paramentri di simulazione
	double random = Math.random();
	
	//Statistiche raccolte
	int numeroClientiSoddisfatti;
	int numeroClientiInsoddisfatti;
	int numeroClientiTotali;
	int istanteTempo; //in minuti
	int istanteEvento;
	int intervalloEvento;
	
	public Simulatore() {
		mappaTavoli = new HashMap<>();
	}
	
	public void init() {
		this.queue.clear();
		
		mappaTavoli.put(10, new Tavolo(10, 2));
		mappaTavoli.put(8, new Tavolo(8, 4));
		mappaTavoli.put(6, new Tavolo(6, 4));
		mappaTavoli.put(4, new Tavolo(4, 5));
		
		numeroClientiSoddisfatti = 0;
		numeroClientiInsoddisfatti = 0;
		numeroClientiTotali = 0;
		
		istanteTempo = 0;
		
		for(int i=0; i<2000; i++) {
			double random = Math.random();
			intervalloEvento = (int) ((random * 10) +1);
			istanteTempo += intervalloEvento;
			
			queue.add(new Evento (istanteTempo, TipoEvento.GRUPPO_CLIENTI_ARRIVA, new Gruppo()));
		}
	
	}
	
	public void run() {
		
		while(!queue.isEmpty()) {
			Evento evento = queue.poll();
			
			System.out.println(evento);
			
			switch (evento.getTipo()) {
			
			case GRUPPO_CLIENTI_ARRIVA:
				boolean postoTrovato = false;
				int dimensioneGruppo = evento.getGruppo().getNumeroPersone();
				int postiTavoloMin= Integer.MAX_VALUE;
				for(int postiTavolo : mappaTavoli.keySet()) {
					if(postiTavolo>=dimensioneGruppo && postiTavolo<=(dimensioneGruppo*2) && postiTavoloMin>postiTavolo) {
						postiTavoloMin = postiTavolo;
						if(mappaTavoli.get(postiTavolo).getNumeroTavoliDisponibili()>0) {
							mappaTavoli.get(postiTavolo).setNumeroTavoliDisponibili(mappaTavoli.get(postiTavolo).getNumeroTavoliDisponibili()-1);
							evento.setTavolo(mappaTavoli.get(postiTavolo));
							evento.getGruppo().setTavoloAssegnato(mappaTavoli.get(postiTavolo));
							numeroClientiTotali += dimensioneGruppo;
							numeroClientiSoddisfatti += dimensioneGruppo;
							postoTrovato = true;
							Evento e = new Evento(evento.getIstante()+evento.getGruppo().getPermanenza(), TipoEvento.GRUPPO_CLIENTI_ABBANDONA, evento.getGruppo());
							e.setTavolo(mappaTavoli.get(postiTavolo));
							queue.add(e);
						}
					}
				}
				if(postoTrovato == false) {
					
					if(Math.random() >= 1 - evento.getGruppo().getTolleranza()) {
						numeroClientiSoddisfatti += dimensioneGruppo;
						numeroClientiTotali += dimensioneGruppo;
					} 
					else {
						numeroClientiInsoddisfatti += dimensioneGruppo;
						numeroClientiTotali += dimensioneGruppo;
					}
				
				break;
				}
				
			case GRUPPO_CLIENTI_ABBANDONA:
				evento.getTavolo().setNumeroTavoliDisponibili(evento.getTavolo().getNumeroTavoliDisponibili()+1);
				break;
				
		
			}
		}
		
	}

	@Override
	public String toString() {
		return "Simulatore [numeroClientiSoddisfatti=" + numeroClientiSoddisfatti + ", numeroClientiInsoddisfatti="
				+ numeroClientiInsoddisfatti + ", numeroClientiTotali=" + numeroClientiTotali + "]";
	}
	
}
