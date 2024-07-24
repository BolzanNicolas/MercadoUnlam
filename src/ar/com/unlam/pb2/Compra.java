package ar.com.unlam.pb2;

public class Compra extends Transaccion{

	private Persona vendedor;
	private Persona comprador;
	private Pagador pagarCon;
	
	public Compra(Integer id, Double importe, Persona vendedor, Persona comprador, Pagador pagarCon) {
		super(id, importe);
		this.vendedor = vendedor;
		this.comprador = comprador;
		this.pagarCon = pagarCon;
	}

	public Persona getVendedor() {
		return vendedor;
	}

	public void setVendedor(Persona vendedor) {
		this.vendedor = vendedor;
	}

	public Persona getComprador() {
		return comprador;
	}

	public void setComprador(Persona comprador) {
		this.comprador = comprador;
	}

	public Pagador getPagarCon() {
		return pagarCon;
	}

	public void setPagarCon(Pagador pagarCon) {
		this.pagarCon = pagarCon;
	}

	
	
}
