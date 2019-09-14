package com.cristoreiapi.atacado.services.exceptions;

public class PedidoNaoEncontratoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PedidoNaoEncontratoException(String mensagem) {
		super(mensagem);
	}
	
	public PedidoNaoEncontratoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
