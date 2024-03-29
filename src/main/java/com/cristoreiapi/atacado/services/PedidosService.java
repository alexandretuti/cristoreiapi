package com.cristoreiapi.atacado.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cristoreiapi.atacado.domain.Cliente;
import com.cristoreiapi.atacado.domain.Endereco;
import com.cristoreiapi.atacado.domain.Pedido;
import com.cristoreiapi.atacado.respository.ClienteRepository;
import com.cristoreiapi.atacado.respository.EnderecoRepository;
import com.cristoreiapi.atacado.respository.PedidosRepository;
import com.cristoreiapi.atacado.services.exceptions.PedidoNaoEncontratoException;

@Service
public class PedidosService {

	@Autowired
	private PedidosRepository pedidosRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository; 
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Pedido> listar(){
		return pedidosRepository.findAll();
	}
	
	public Optional<Pedido> buscar(Long id) {
		Optional<Pedido> pedido = pedidosRepository.findById(id);
		
		if(!pedido.isPresent()) { 
			throw new PedidoNaoEncontratoException("Pedido não encontrado.");
		}
		
		return pedido; 
	}
	
	public Pedido salvar(Pedido pedido) {
		pedido.setIdPedido(null);
		return pedidosRepository.save(pedido);
	}
	
	public void deletar(Long id) {
		try{
			pedidosRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new PedidoNaoEncontratoException("Pedido não encontrado");
		}
	}
	
	public void atualizar(Pedido pedido) {
		verificarExistencia(pedido);
		pedidosRepository.save(pedido);
	}
	
	private void verificarExistencia(Pedido pedido) {
		buscar(pedido.getIdPedido());
	}
	
	public Endereco salvarEndereco(Long pedidoId, Endereco endereco) {
		Optional<Pedido> pedido = buscar(pedidoId);
		endereco.setPedido(pedido.get());
		return enderecoRepository.save(endereco);
	}
	
	public Cliente salvarCliente(Long pedidoId, Cliente cliente) {
		Optional<Pedido> pedido = buscar(pedidoId);
		cliente.setPedido(pedido.get());
		return clienteRepository.save(cliente);
	}
	
}
