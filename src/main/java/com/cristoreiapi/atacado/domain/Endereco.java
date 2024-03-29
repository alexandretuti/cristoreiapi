package com.cristoreiapi.atacado.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 

	@JsonInclude(Include.NON_NULL)
	private String logradouro; 
	
	@JsonInclude(Include.NON_NULL)
	private Long numero;
	
	@JsonInclude(Include.NON_NULL)
	private String cidade; 
	
	@JsonInclude(Include.NON_NULL)
	private String cep;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="PEDIDO_ID")
	@JsonIgnore
	private Pedido pedido;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido2) {
		this.pedido = pedido2;
	}
	
}
