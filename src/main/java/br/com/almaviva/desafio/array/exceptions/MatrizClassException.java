package br.com.almaviva.desafio.array.exceptions;

public class MatrizClassException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public MatrizClassException(String mensagem) {
        super(mensagem);
    }
	
    public MatrizClassException(String message, Throwable cause) {
        super(message, cause);
    }
}
