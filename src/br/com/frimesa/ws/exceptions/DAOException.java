package br.com.frimesa.ws.exceptions;



public class DAOException extends RuntimeException {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1090410647604129615L;
	private int code;
	
	public DAOException(String message, int code) {
		super(message);
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	

	
}
