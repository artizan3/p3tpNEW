package abonado;

import java.io.Serializable;
import java.time.LocalDate;

import empresa.Contratacion;
import empresa.IFactura;
import excepciones.ContratacionInvalidaException;
import excepciones.FacturaInexistenteException;

public class ConContratacion implements IState, Serializable {

private Fisica abonado;
	
	/**
 	* Constructor de la clase <br>
 	* <br>
 	* <b>Pre</b>: Se espera que abonado sea distinto de null<br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: Se setea el atributo.<br>
 	*/
	public ConContratacion(Fisica abonado) {
		assert abonado != null : "El abonado no puede ser null";
		this.abonado = abonado;
	}

	/**
 	* <br>
 	* <b>Pre</b>: Se espera que factura y fechaDePago sea distinto de null<br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: Si el abonado tiene 2 o mas facturas impagas chequea en que estado esta.<br>
 	*/
	@Override
    public void pagarFactura(IFactura factura, LocalDate fechaDePago) throws FacturaInexistenteException {
		assert factura    != null: "La factura no puede ser null";
		assert fechaDePago!= null: "La fecha no puede ser null";
        if (abonado.cantidadDeFacturasImpagas() >= 2) 
           chequeaCambio();
    }

	/**
 	* <br>
 	* <b>Pre</b>: Se espera que contrato sea distinto de null<br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: Se aniade un contrato a la lista de contrataciones .<br>
 	*/
	@Override
	public void contratarServicio(Contratacion contrato) {
		assert contrato != null: "El contrato no puede ser null";
		abonado.aniadirContratacion(contrato);
		//No cambia de estado
	}

	/**
 	* <br>
 	* <b>Pre</b>: Se espera que contrato sea distinto de null<br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: Se elimina un contrato de la lista de contrataciones y además si
 	* no tiene ninguna contratacion luego de eliminar se setea al abonado en el 
 	* estado "SinContratacion".<br>
 	*/
	@Override
	public void bajarServicio(Contratacion contrato) throws ContratacionInvalidaException {
		assert contrato != null: "El contrato no puede ser null";
		abonado.eliminaContratacion(contrato);
		if (abonado.listaDeContrataciones.size() == 0)
			abonado.setEstado(new SinContratacion(abonado));
	}
	
	
	/**
 	* <br>
 	* <b>Pre</b>: <br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: Si el abonado tiene mas de una factura impaga se cambia su estado a
 	* "Moroso" y si su lista esta vacia se cambia su estado a "SinContratacion".<br>
 	*/
	@Override
	public void chequeaCambio() {
		if(abonado.cantidadDeFacturasImpagas() > 1)
			abonado.setEstado(new Moroso(abonado));
		if (this.abonado.getListaDeContrataciones().isEmpty()) {
			this.abonado.setEstado(new SinContratacion(this.abonado));
		}
	}

	/**
 	* <br>
 	* <b>Pre</b>: <br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: .<br>
 	* @return devuelve una abreviatura de "Contratacion"
 	*/
	@Override
	public String toString() {
		return "C/C";
	}
	
	/**
 	* <br>
 	* <b>Pre</b>: <br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: <br>
 	* @return devuelve la suma de las contrataciones del abonado
 	*/
	public double valorTotal() {
		double aux = 0;
		for (Contratacion contratacion :this.abonado.getListaDeContrataciones() )
			aux += contratacion.getValorTotal();			
		return aux;
	}
	
}
