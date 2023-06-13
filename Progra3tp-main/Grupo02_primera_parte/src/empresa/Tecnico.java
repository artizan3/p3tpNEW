package empresa;

import java.io.Serializable;

import abonado.Abonado;

public class Tecnico extends Thread implements Serializable {

	private String nombre;
	private int dni;
	private Abonado abonado;
	private MesaDeSolicitudDeTecnicos mesa;
	
	
	public Abonado getAbonado() {
		return abonado;
	}
	
	public Tecnico(String nombre, int dni, MesaDeSolicitudDeTecnicos mesa ) {
		super();
		this.mesa = mesa;
		this.dni= dni;
		this.nombre = nombre;
		this.start();
	}

	/**
 	* <br>
 	* <b>Pre</b>: se espera que el abonado sea distinto de null<br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: se setea el abonado<br>
 	*/
	public void setAbonado(Abonado abonado) {
		assert abonado != null: "El abondado no puede ser null";
		this.abonado = abonado;
	}

	/**
 	* <br>
 	* <b>Pre</b>: se espera que el abonado sea distinto de null<br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: <br>
 	* @return devuelve un objeto de tipo "MesaDeSolicitudDeTecnicos"
 	*/
	public MesaDeSolicitudDeTecnicos getMesa() {
		return mesa;
	}

	/**
 	* <br>
 	* <b>Pre</b>: se espera que el tipo mesa sea distinto de null<br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: setea el atributo mesa<br>
 	* @return devuelve un objeto de tipo "MesaDeSolicitudDeTecnicos"
 	*/
	public void setMesa(MesaDeSolicitudDeTecnicos mesa) {
		assert mesa != null: "La mesa no puede ser null";
		this.mesa = mesa;
	}

	/**
 	* <br>
 	* <b>Pre</b>: <br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: <br>
 	* @return devuelve el nombre del tecnico
 	*/
	public String getNombre() {
		return nombre;
	}

	/**
 	* <br>
 	* <b>Pre</b>: se espera que el nombre sea distinto de null<br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: setea el nombre del tecnico<br>
 	*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
 	* <br>
 	* <b>Pre</b>: <br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: simula que trabaja el tecnico<br>
 	*/
	public void run() {	
		
		while (true) {
			
			mesa.getAbonado(this);
			try {
				sleep(8000); //tiempo simulado que tarda en reparar
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mesa.informarFinDeTrabajo(this);
			this.abonado=null;
		}
		
	}

	/**
 	* <br>
 	* <b>Pre</b>: <br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: <br>
 	* @return devuelve el dni del tecnico
 	*/
	public int getDni() {
		return dni;
	}

	/**
 	* <br>
 	* <b>Pre</b>: <br>
 	* <b>Inv</b>: <br>
 	* <b>Post</b>: <br>
 	* @return devuelve una cadena con nombre y dni del tecnico
 	*/
	@Override
	public String toString() {
		return "Tecnico [nombre=" + nombre + ", dni=" + dni + "]";
	}

	
}
