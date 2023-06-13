package empresa;

import java.time.LocalDate;

import abonado.Abonado;
/*
 * La interfaz IFactura permite generaliza el modelo de una factura, brindado los metodos especficos para 
 * el calculo de diferentes aspectos dentro de la factura
 */
public interface IFactura {
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna el monto.<br>
	 * @return monto de la factura
	 */
	double getMonto();
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna el monto sin el tipo de pago.<br>
	 * @return monto (sin tipo de pago) de la factura
	 */
	double getMontoSinTipoDePago();
	
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna la factura sin patron decorator.<br>
	 * @return factura sin patron
	 */
	IFactura getFactura();
	
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna la fecha de pago.<br>
	 * @return fecha de pago
	 */
	LocalDate getFechaDePago();

	void setFechaDePago(LocalDate fechaDePago);
	
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna la fecha de emision.<br>
	 * @return fecha de emision
	 */
	LocalDate getFechaDeEmision();
	
	public boolean isPago();
	
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna el abonado dueno de la factura.<br>
	 * @return abonado ligado a la factura
	 */
	public Abonado getAbonado();

	Object clone() throws CloneNotSupportedException;
	
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna interes por deber diferentes facturas.<br>
	 * @return el interes por deber diferentes facturas
	 */
	public void setInteresPorMora(boolean interesPorMora);
	
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna si la factura tiene interes por mora.<br>
	 * @return true or false dependiendo la condicion
	 */
	public boolean isInteresPorMora();
}
