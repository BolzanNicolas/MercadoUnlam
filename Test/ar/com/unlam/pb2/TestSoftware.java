package ar.com.unlam.pb2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestSoftware {
	
	Software uniPay = new Software("UniPay");
	
	@Before
	public void setup() {
		uniPay = new Software("UniPay");
	}
	
//1  TODO: PROBAR DISTINTOS TIPOS
//	@Test
//	public void queSePuedanAlmacenarLosDistintosTiposDeTransacciones() { 
//		Transaccion transaccion = new Transaccion();
//		assertTrue(uniPay.almacenarTransaccion(transaccion));
//	}

//2	
	@Test
	public void queSePuedanAlmacenarLosDistintosTiposDePersonas() {
		PersonaJuridica vendedor = new PersonaJuridica("Nico", 3425);
		PersonaFisica cliente = new PersonaFisica("Juli", 3465);
		
		assertTrue(uniPay.almacenarPersona(vendedor));
		assertTrue(uniPay.almacenarPersona(cliente));
	}
//3 
	@Test
	public void queSePuedanAsociadACadaPersonaSusMedios() {
		PersonaFisica juli = new PersonaFisica("Juli", 3465);
		PersonaFisica ciri = new PersonaFisica("Ciri", 1810);
		
		TarjetaCredito tarjetaCredito= new TarjetaCredito(1234, 5000.0);
		TarjetaDebito tarjetaDebito = new TarjetaDebito(3514, 5000.0);

		assertTrue(juli.asociarMedio(tarjetaCredito));
		assertTrue(ciri.asociarMedio(tarjetaDebito));
	}
//4 
	@Test
	public void queSePuedanRealizarCompras() {
		PersonaJuridica vendedor = new PersonaJuridica("Nico", 3425);
		PersonaFisica juli = new PersonaFisica("Juli", 3465);
		
		TarjetaCredito tarjetaCredito = new TarjetaCredito(1234, 5000.0);
		CuentaVirtual cuentaVirtual = new CuentaVirtual(2145, 100.0);
		TarjetaDebito tarjetaDebito = new TarjetaDebito(4362, 3600.0);
		
		uniPay.almacenarPersona(vendedor);
		uniPay.almacenarPersona(juli);
		juli.asociarMedio(tarjetaCredito);
		juli.asociarMedio(cuentaVirtual);
		juli.asociarMedio(tarjetaDebito);
		
		assertTrue(uniPay.realizarCompra(vendedor, juli, 21.3, tarjetaCredito));
		assertTrue(uniPay.realizarCompra(vendedor, juli, 3400.5, tarjetaDebito));

	}	
//5 
	@Test
	public void queSePuedanRealizarTransferencias() {
		CuentaBancaria cuentaBancaria = new CuentaBancaria(92834, 5400.2);
		CuentaVirtual cuentaVirtual = new CuentaVirtual(35564, 3000.0);

		assertTrue(uniPay.realizarTransferencia(4050.1, 92834, cuentaBancaria, 35564, cuentaVirtual));
	}
//6 
	@Test
	public void queSeLanceUnaExcepcionSiElSaldoDeLaTarjetaEsInsuficienteParaHacerUnaCompra() {
		PersonaJuridica vendedor = new PersonaJuridica("Nico", 3425);
		PersonaFisica juli = new PersonaFisica("Juli", 3465);
		
		TarjetaCredito tarjetaCredito = new TarjetaCredito(1234, 5000.0);
		TarjetaDebito tarjetaDebito = new TarjetaDebito(4362, 3600.0);

		
		uniPay.almacenarPersona(vendedor);
		uniPay.almacenarPersona(juli);
		juli.asociarMedio(tarjetaCredito);
		juli.asociarMedio(tarjetaDebito);
		
		//EXCEPTION CON ASSERT
		assertThrows(
			SaldoInsuficienteException.class,
			() -> { uniPay.realizarCompra(vendedor, juli, 4250.5, tarjetaDebito); }
		);
		
		//EXCEPTION CON CATCH
		try {
			uniPay.realizarCompra(vendedor, juli, 6000.3, tarjetaCredito);
			fail("No se produjo exception");
		}catch (ExcedeLimiteDeCompraException exception) {
		}
	}
//7 
	@Test
	public void queSeLanceUnaExcepcionSiElSaldoDeLaCuentaVirtualEsInsuficienteParaHacerUnaCompra() {
		PersonaJuridica vendedor = new PersonaJuridica("Nico", 3425);
		PersonaFisica juli = new PersonaFisica("Juli", 3465);
		
		CuentaVirtual cuentaVirtual = new CuentaVirtual(2145, 100.0);
		
		uniPay.almacenarPersona(vendedor);
		uniPay.almacenarPersona(juli);
		juli.asociarMedio(cuentaVirtual);
		
		//EXCEPTION CON ASSERT
		assertThrows(
			SaldoInsuficienteException.class,
			() -> { uniPay.realizarCompra(vendedor, juli, 250.5, cuentaVirtual); }
		);
	}
//8 
	@Test
	public void queSeLanceUnaExcepcionSiElLimiteDeCompraDeLaTarjetaEsInsuficienteParaHacerUnaCompra() {
		PersonaFisica juli = new PersonaFisica("Juli", 3465);
		PersonaJuridica vendedor = new PersonaJuridica("Nico", 3425);

		TarjetaCredito tarjetaCredito = new TarjetaCredito(1234, 5000.0);

		uniPay.almacenarPersona(juli);
		uniPay.almacenarPersona(vendedor);

		juli.asociarMedio(tarjetaCredito);

		//EXCEPTION CON CATCH
		try {
			uniPay.realizarCompra(vendedor, juli, 6000.3, tarjetaCredito);
			fail("No se produjo exception");
		}catch (ExcedeLimiteDeCompraException exception) {
		}
	}	
//9 
	@Test
	public void queSeLanceUnaExcepcionSiElSaldoDeLaCuentaEsInsuficienteParaHacerUnaTransferencia() {
		CuentaCorriente cuentaCorriente = new CuentaCorriente(3214, 220.0, 40.0);
		CajaDeAhorro cajaDeAhorro = new CajaDeAhorro(1234, 40.0, 60.0);

		try {
			uniPay.realizarTransferencia(270.0, 3214, cuentaCorriente, 1234, cajaDeAhorro);
			fail("No se produjo exception");
		}catch (SaldoInsuficienteException exception) {
		}
	}
//10 
	@Test
	public void queDesdeUnaCuentaCorrienteSePuedaRealizarUnaTransferenciaPorEncimaDeSuSaldo() {
		CuentaCorriente cuentaCorriente = new CuentaCorriente(3214, 220.0, 40.0);
		CuentaCorriente cuentaCorriente2 = new CuentaCorriente(1444, 60.0, 10.0);

		assertTrue(uniPay.realizarTransferencia(230.0, 3213, cuentaCorriente, 1444, cuentaCorriente2));
	}
}
