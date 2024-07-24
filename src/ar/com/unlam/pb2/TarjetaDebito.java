package ar.com.unlam.pb2;

import java.util.Objects;

public class TarjetaDebito implements Pagador {

	private Integer num;
	private Double saldo;
	
	public TarjetaDebito(Integer num, Double saldo) {
		this.num = num;
		this.saldo = saldo;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
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
		TarjetaDebito other = (TarjetaDebito) obj;
		return Objects.equals(num, other.num);
	}

	@Override
	public Boolean pagar(Persona vendedor, Double importe) {
		if(this.saldo < importe) {
			throw new SaldoInsuficienteException();
		}else {
			return true;
		}
	}
}
