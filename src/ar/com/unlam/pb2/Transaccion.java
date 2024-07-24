package ar.com.unlam.pb2;

import java.util.Calendar;

public class Transaccion {

	private Integer id;
	private long fechaHora;
	private Double importe;
	
	public Transaccion(Integer id, Double importe) {
		this.id = id;
		this.fechaHora = Calendar.getInstance().getTimeInMillis();
		this.importe = importe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getFechaHora() {
		return fechaHora;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
	
}
