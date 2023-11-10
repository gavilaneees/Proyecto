/**
 * 
 */
package com.curso.proyecto;

/**
 * @author David Gavilanes de Dios
 * @version 1.0.0
 * @since 2023
 *
 */
public class ExceptionPersonalizada extends Exception {
	private int codigoError;
	
	/**
	 * 
	 * @param codigoError: código del error a mostrar
	 */
	public ExceptionPersonalizada (int codigoError) {
		super();
		this.codigoError = codigoError;
	}
	
	@Override
	public String getMessage() {
		String mensaje = "";
		switch(codigoError) {
		case 111:
			mensaje = "ERROR DE ENTRADA/SALIDA CON EL FICHERO.";
			break;
		}
		return mensaje;
	}
}
