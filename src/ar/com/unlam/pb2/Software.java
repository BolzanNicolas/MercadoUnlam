package ar.com.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Software {

	private String nombre;
	private TreeSet<Persona> personas;
	private ArrayList<Transaccion> transacciones;
	private HashSet<Pagador> mediosAsociados;
	
	public Software(String nombre) {
		this.nombre = nombre;
		this.personas = new TreeSet<Persona>();
		this.transacciones = new ArrayList<Transaccion>();
		this.mediosAsociados = new HashSet<Pagador>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TreeSet<Persona> getPersonas() {
		return personas;
	}

	public void setPersonasJuridicas(TreeSet<Persona> personas) {
		this.personas = personas;
	}

	public ArrayList<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setCompras(ArrayList<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	public HashSet<Pagador> getMediosAsociados() {
		return mediosAsociados;
	}

	public void setMediosAsociados(HashSet<Pagador> mediosAsociados) {
		this.mediosAsociados = mediosAsociados;
	}
	
	public Boolean almacenarTransaccion(Transaccion transaccion) {
		return transacciones.add(transaccion);
	}

	public Boolean almacenarPersona(Persona persona) {
		return personas.add(persona);
	}

	public Boolean realizarCompra(Persona vendedor, Persona comprador, Double importe, Pagador pagarCon) {
		Compra compra = new Compra(transacciones.size(), importe, vendedor, comprador, pagarCon);
		
		if(pagarCon.pagar(vendedor, importe)){
			transacciones.add(compra);		
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean realizarTransferencia(Double importe, Integer cbuEmisor, Transferible emisorTransfiereCon, Integer cbuReceptor, Transferible receptorTransfiereCon) {
		Transferencia transferencia = new Transferencia(transacciones.size(), importe, cbuEmisor, cbuReceptor);
		
		if(emisorTransfiereCon.extraer(importe)) {
			receptorTransfiereCon.depositar(importe);
			return transacciones.add(transferencia);		
		} else {
			return false;
		}
	}
}
