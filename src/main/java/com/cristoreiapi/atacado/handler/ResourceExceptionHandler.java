package com.cristoreiapi.atacado.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cristoreiapi.atacado.domain.DetalhesErro;
import com.cristoreiapi.atacado.services.exceptions.PedidoNaoEncontratoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(PedidoNaoEncontratoException.class)
	public ResponseEntity<DetalhesErro> handlePedidoNaoEncontratoException(PedidoNaoEncontratoException e,
			HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("Pedido nao encontrado");
		erro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
