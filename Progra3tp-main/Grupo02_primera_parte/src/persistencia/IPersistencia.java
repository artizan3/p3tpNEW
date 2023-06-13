package persistencia;

import java.io.IOException;
/*
 * La interface IPersistencia permite poder persister nuestro software de forma automatica, puede
 * aplicarse la persistencia binaria o de tipo XML
 */
public interface IPersistencia<E> {
		/**
		* <b>Pre</b>:nombre debe ser !=null y !=vacio<br>
	 	* <b>Inv</b>:<br>
	 	* <b>Post</b>: Abre el archivo donde se va a leer la persistencia<br>
	 	* @param nombre del archivo
	 	*/
	    void abrirInput(String nombre) throws IOException;
	    
	    /**
		* <b>Pre</b>:nombre debe ser !=null y !=vacio<br>
	 	* <b>Inv</b>:<br>
	 	* <b>Post</b>: Abre el archivo donde se va a guardar la persistencia<br>
	 	* @param nombre del archivo
	 	*/
	    void abrirOutput(String nombre) throws IOException;
	    
	    /**
		* <b>Pre</b>:<br>
	 	* <b>Inv</b>:<br>
	 	* <b>Post</b>: Cierra el archivo de salida<br>
	 	*/
	    void cerrarOutput() throws IOException;
	    
	    /**
		* <b>Pre</b>:<br>
	 	* <b>Inv</b>:<br>
	 	* <b>Post</b>:Cierra el archivo de entrada<br>
	 	*/
	    void cerrarInput() throws IOException;
	    
	    /**
		* <b>Pre</b>:objeto debe ser !=null<br>
	 	* <b>Inv</b>:<br>
	 	* <b>Post</b>: Escribe en el archivo el objeto parametro<br>
	 	* @param Objeto que vamos a escribir
	 	*/
	    void escribir(E objeto) throws IOException;
	    
	    /**
		* <b>Pre</b>:<br>
	 	* <b>Inv</b>:<br>
	 	* <b>Post</b>: Lee del archivo el objeto escrito<br>
	 	* @return el objeto leido
	 	*/
	    E leer() throws IOException, ClassNotFoundException;
	
}
