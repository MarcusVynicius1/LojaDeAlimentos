package br.edu.iff.LojaDeAlimentos.exception;

public class ErrorException {

	public final String url;
	public final String exception;
	
	public ErrorException(String url, Exception exception) {
		this.url = url;
		this.exception = exception.getLocalizedMessage();
	}
}
