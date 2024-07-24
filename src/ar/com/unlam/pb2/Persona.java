package ar.com.unlam.pb2;

import java.util.HashSet;

public class Persona implements Comparable<Persona> {

	private String nombre;
	private Integer cuilCuit;
	private HashSet<Pagador> mediosAsocioados;
	
	public Persona(String nombre, Integer cuilCuit) {
		this.nombre = nombre;
		this.cuilCuit = cuilCuit;
		this.mediosAsocioados = new HashSet<Pagador>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Integer getCuilCuit() {
		return this.cuilCuit;
	}
	

	public HashSet<Pagador> getMediosAsocioados() {
		return mediosAsocioados;
	}

	public void setMediosAsocioados(HashSet<Pagador> mediosAsocioados) {
		this.mediosAsocioados = mediosAsocioados;
	}

	public void setCuilCuit(Integer cuilCuit) {
		this.cuilCuit = cuilCuit;
	}

	@Override
	public int compareTo(Persona o) {
		return this.cuilCuit.compareTo(o.getCuilCuit());
	}
	
	public Boolean asociarMedio(Pagador medio) {
		return this.mediosAsocioados.add(medio);
	}
}
