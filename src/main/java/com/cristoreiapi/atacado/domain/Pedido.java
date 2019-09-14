package com.cristoreiapi.atacado.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Pedido {

	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;

	@JsonInclude(Include.NON_NULL)
	private Long quantidade;
	
	@JsonInclude(Include.NON_NULL)
	private String item;
	
	@JsonInclude(Include.NON_NULL)
	private Date dataEntrega;
	
	@JsonInclude(Include.NON_NULL)
	private Double valor;
	
	@JsonInclude(Include.NON_NULL)
	private String observacao;
	
	@JsonInclude(Include.NON_NULL)
	@Transient
	private List<Endereco> endereco;
	
	/*Construtor*/ 
	public Pedido() {}
	
	/*Construtor*/
	public Pedido(Long idPedido, String item, Long d, Double valor) {
		this.idPedido = idPedido; 
		this.item = item; 
		this.item = item; 
		this.quantidade = d; 
		this.valor = valor; 
	}
	

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	
}
