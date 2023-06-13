package abonado;

import java.time.LocalDate;

import empresa.Contratacion;
import empresa.Factura;
import empresa.IFactura;
import excepciones.ContratacionInvalidaException;
import excepciones.FacturaInexistenteException;

public interface IState {

	/**
 	* <br>
 	* <b>Pre</b>: se espera que factura y fechaDePago no sea null<br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: <br>
 	*/
	void pagarFactura(IFactura factura, LocalDate fechaDatePago) throws FacturaInexistenteException;
	
	/**
 	* <br>
 	* <b>Pre</b>: se espera que contrato no sea null<br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: <br>
 	*/
	void contratarServicio(Contratacion contrato);
	
	/**
 	* <br>
 	* <b>Pre</b>: se espera que contrato no sea null<br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: <br>
 	*/
	void bajarServicio(Contratacion contrato)throws ContratacionInvalidaException;
	
	void chequeaCambio();
	
	double valorTotal();
}
