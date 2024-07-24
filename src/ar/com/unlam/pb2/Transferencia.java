package ar.com.unlam.pb2;

public class Transferencia extends Transaccion {

	private Integer cvuCbuEmisor;
	private Integer cvuCbuReceptor;
	
	public Transferencia(Integer id, Double importe, Integer cvuCbuEmisor, Integer cvuCbuReceptor) {
		super(id, importe);
		this.cvuCbuEmisor = cvuCbuEmisor;
		this.cvuCbuReceptor = cvuCbuReceptor;
	}

	public Integer getCvuCbuEmisor() {
		return cvuCbuEmisor;
	}

	public void setCvuCbuEmisor(Integer cvuCbuEmisor) {
		this.cvuCbuEmisor = cvuCbuEmisor;
	}

	public Integer getCvuCbuReceptor() {
		return cvuCbuReceptor;
	}

	public void setCvuCbuReceptor(Integer cvuCbuReceptor) {
		this.cvuCbuReceptor = cvuCbuReceptor;
	}
	
	
}
