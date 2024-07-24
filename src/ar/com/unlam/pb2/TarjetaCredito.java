package ar.com.unlam.pb2;

import java.util.Objects;

public class TarjetaCredito implements Pagador {

	private Integer num;
	private Double limite;
	
	public TarjetaCredito(Integer num, Double limite) {
		this.num = num;
		this.limite = limite;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TarjetaCredito other = (TarjetaCredito) obj;
		return Objects.equals(num, other.num);
	}

	@Override
	public Boolean pagar(Persona vendedor, Double importe) {
		if(this.limite < importe) {
			throw new ExcedeLimiteDeCompraException();
		}else {
			return true;
		}
	}
}
