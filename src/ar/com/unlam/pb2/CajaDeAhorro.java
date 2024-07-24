package ar.com.unlam.pb2;

public class CajaDeAhorro extends CuentaBancaria{

	private Double sobregiro;
	
	public CajaDeAhorro(Integer cbu, Double saldo, Double sobregiro) {
		super(cbu, saldo);
		this.sobregiro = sobregiro;
	}

	public Double getSobregiro() {
		return sobregiro;
	}

	public void setSobregiro(Double sobregiro) {
		this.sobregiro = sobregiro;
	}
	
	@Override
	public Boolean extraer(Double importe) {
		if(importe <= getSaldo() + sobregiro) {
			Double nuevoSaldo = this.getSaldo() - importe;
			
			// Si el importe es mayor que mi saldo
			if (nuevoSaldo >= 0) { 
				// Pongo nuevo saldo normalmente
				super.setSaldo(nuevoSaldo);			
			} else {
				// Pongo saldo 0 y sobregiro igual a lo que me pase
				super.setSaldo(0.0);
				sobregiro = sobregiro + nuevoSaldo; // Se suma porque nuevo saldo es negativo
			}		
			return true;
		} else {
			throw new SaldoInsuficienteException();
		}
	}

}
