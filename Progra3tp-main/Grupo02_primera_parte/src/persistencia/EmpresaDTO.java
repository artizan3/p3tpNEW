package persistencia;

import java.io.Serializable;
import java.util.ArrayList;

import abonado.Abonado;
import empresa.Contratacion;
import empresa.Factura;
import empresa.IFactura;
import empresa.Tecnico;
import metodosdepago.FactoryPago;
/*
 * la clase EmpresaDTO, funciona como una clase recopilador, la cual junta toda la informacion
 * de la clase empresa para poder persistirla
 */
public class EmpresaDTO implements Serializable {


	private ArrayList<Abonado> listaAbonado = new ArrayList<Abonado>();
	private ArrayList<Contratacion> listaContrataciones = new ArrayList<Contratacion>();
	private ArrayList<Tecnico> listaTecnico = new ArrayList<Tecnico>();
	private transient FactoryPago creacion = new FactoryPago();
	private int fechaMes;
	private int fechaAnio;
	private int fechaDia;
	
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna mes.<br>
	 */
	public int getFechaMes() {
		return fechaMes;
	}
	/**
	 * <b>Pre</b>:mes debe ser >0<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: setea mes.<br>
	 */
	public void setFechaMes(int fechaMes) {
		assert fechaMes>0:"el mes no puede ser mayor a 0";
		this.fechaMes = fechaMes;
	}
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna anio.<br>
	 */
	public int getFechaAnio() {
		return fechaAnio;
	}
	/**
	 * <b>Pre</b>:fehcaAnio debe ser >0<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: setea anio.<br>
	 */
	public void setFechaAnio(int fechaAnio) {
		assert fechaAnio>0:"el mes no puede ser mayor a 0";
		this.fechaAnio = fechaAnio;
	}
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna dia.<br>
	 */
	public int getFechaDia() {
		return fechaDia;
	}
	/**
	 * <b>Pre</b>:fechaDia debe ser >0<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: setea dia.<br>
	 */
	public void setFechaDia(int fechaDia) {
		assert fechaDia>0:"el mes no puede ser mayor a 0";
		this.fechaDia = fechaDia;
	}
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna lista de abonados.<br>
	 */
	public ArrayList<Abonado> getListaAbonado() {
		return listaAbonado;
	}
	/**
	 * <b>Pre</b>:ListaAbonado debe ser !=null<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: setea lista de abonados.<br>
	 */
	public void setListaAbonado(ArrayList<Abonado> listaAbonado) {
		assert listaAbonado!=null:"el mes no puede ser mayor a 0";
		this.listaAbonado = listaAbonado;
	}
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna lista de contrataciones.<br>
	 */
	public ArrayList<Contratacion> getListaContrataciones() {
		return listaContrataciones;
	}
	/**
	 * <b>Pre</b>:listaContrataciones debe ser !=null<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: setea lista de contrataciones.<br>
	 */
	public void setListaContrataciones(ArrayList<Contratacion> listaContrataciones) {
		assert listaContrataciones!=null:"la lista no puede ser null";
		this.listaContrataciones = listaContrataciones;
	}
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna lista de tecnicos.<br>
	 */
	public ArrayList<Tecnico> getListaTecnico() {
		return listaTecnico;
	}
	/**
	 * <b>Pre</b>:listaTennico debe ser !=null<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: setea lista de tecnicos.<br>
	 */
	public void setListaTecnico(ArrayList<Tecnico> listaTecnico) {
		assert listaTecnico!=null:"la lista no puede ser null";
		this.listaTecnico = listaTecnico;
	}
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: Retorna creacion.<br>
	 */
	public FactoryPago getCreacion() {
		return creacion;
	}
	/**
	 * <b>Pre</b>:<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: setea creacion.<br>
	 */
	public void setCreacion(FactoryPago creacion) {
		this.creacion = creacion;
	}
}
