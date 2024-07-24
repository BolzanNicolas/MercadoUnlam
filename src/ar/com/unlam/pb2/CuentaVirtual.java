package ar.com.unlam.pb2;

import java.util.Objects;

public class CuentaVirtual implements Transferible, Pagador{

	private Integer cvu;
	private Double saldo;

	public CuentaVirtual(Integer cvu, Double saldo) {
		this.cvu = cvu;
		this.saldo = saldo;
	}

	public Integer getCvu() {
		return cvu;
	}

	public void setCvu(Integer cvu) {
		this.cvu = cvu;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cvu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaVirtual other = (CuentaVirtual) obj;
		return Objects.equals(cvu, other.cvu);
	}

	@Override
	public Boolean pagar(Persona vendedor, Double importe) {
		if(this.saldo < importe) {
			throw new SaldoInsuficienteException();
		}else {
			this.saldo = this.saldo - importe;
			return true;
		}
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
		if(this.saldo >= importe) {
			Double nuevoSaldo = this.saldo - importe;
			setSaldo(nuevoSaldo);
			return true;
		}else {
			return false;
		}
	}

	
}
