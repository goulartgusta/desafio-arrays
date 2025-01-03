package br.com.almaviva.desafio.array.exceptions;

public class ModelCastException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public ModelCastException(String message) {
        super(message);
    }
    
    public ModelCastException(String message, Throwable cause) {
        super(message, cause);
    }
}
