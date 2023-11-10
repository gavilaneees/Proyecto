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
	
	private final int codigoError;
	
	static final int TIPO_NO_ENCONTRADO = 1;
	private static final int OTRO_ERROR = 2;
	
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
		case 1:
			mensaje = "TIPO DE POKÉMON NO VÁLIDO.";
			break;
		}
		return mensaje;
	}
}
