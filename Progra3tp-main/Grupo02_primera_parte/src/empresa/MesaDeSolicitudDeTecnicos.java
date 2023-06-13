package empresa;

import java.io.Serializable;
import java.util.Observable;

import abonado.Abonado;
/*
 * La clase MesaDeSolicitudDeTecnicos se encarga de organizar los hilos de tecnicos y abonados
 * para que utilicen un espacion en comun para soluciona el problema
 */
public class MesaDeSolicitudDeTecnicos extends Observable implements Serializable{

	private Abonado abonadoEsperando = null;
	
	/**
	 * <b>Pre</b>:abonado debe ser !=null<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: el abonando solicitara una reparacion y esa reparacion sera ejecutada, luego avisan a todos los demas hilos<br>
	 */
	public synchronized void  solicitarReparacion (Abonado abonado){
		assert abonado!=null:"el abonado no pueder ser null";
	
		this.setChanged();
		notifyObservers("El abonado " + abonado.getNombre() +" ha solicitado reparación, se agrega a lista de espera");
		
		while (abonadoEsperando!=null)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		this.abonadoEsperando = abonado;	
		notifyAll();
	}
	/**
	 * <b>Pre</b>:tecnico debe ser !=null<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: un tecnico ejecuta una reparacion y esta es solucionada, luego avisan a todos los demas hilos.<br>
	 */
	public synchronized void getAbonado (Tecnico tecnico) {
		assert tecnico!=null:"el abonado no pueder ser null";
		this.setChanged();
		notifyObservers("El tecnico " +tecnico.getNombre()+ " está esperando para reparar");
		
		while(this.abonadoEsperando==null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		tecnico.setAbonado(this.abonadoEsperando);
		this.abonadoEsperando=null;
		notifyAll();
		this.setChanged();
		notifyObservers("El tecnico " + tecnico.getNombre() +" ha comenzado a trabajar en la reparación solicitada por " + tecnico.getAbonado().getNombre());		
		
	}
	/**
	 * <b>Pre</b>:tecnico debe ser !=null<br>
	 * <b>Inv</b>:<br>
	 * <b>Post</b>: el abonado ligado al tecnico confirma la reparacion.<br>
	 */
	public void informarFinDeTrabajo (Tecnico tecnico) {
		assert tecnico!=null:"el abonado no pueder ser null";
		tecnico.getAbonado().setNecesitaReparacion(false);
		this.setChanged();
		notifyObservers("El tecnico " + tecnico.getNombre() +" ha terminado a trabajar en la reparación solicitada por " + tecnico.getAbonado().getNombre());
		
	}
}
