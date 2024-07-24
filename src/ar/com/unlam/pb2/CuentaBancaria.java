package ar.com.unlam.pb2;

import java.util.Objects;

public class CuentaBancaria implements Transferible {

	private Integer cbu;
	private Double saldo;

	public CuentaBancaria(Integer cbu, Double saldo) {
		this.cbu = cbu;
		this.saldo = saldo;
	}

	public Integer getCbu() {
		return cbu;
	}

	public void setCbu(Integer cbu) {
		this.cbu = cbu;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cbu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaBancaria other = (CuentaBancaria) obj;
		return Objects.equals(cbu, other.cbu);
	}

	@Override
	public Double getSaldo() {
		return this.saldo;
	}

	@Override
	public void depositar(Double importe) {
		this.saldo += importe;
	}

	@Override
	public Boolean extraer(Double importe) {
		if(this.saldo < importe) {
			throw new SaldoInsuficienteException();
		}else {
			return true;
		}
	}
	
	
}
