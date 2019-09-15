package com.cristoreiapi.atacado.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cristoreiapi.atacado.domain.Cliente;
import com.cristoreiapi.atacado.domain.Endereco;
import com.cristoreiapi.atacado.domain.Pedido;
import com.cristoreiapi.atacado.services.PedidosService;

@RestController
@RequestMapping("/pedidos")
public class PedidosResources {

	@Autowired
	private PedidosService pedidosService;

	// obtem recurso
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Pedido>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(pedidosService.listar());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Pedido pedido) {
		pedido = pedidosService.salvar(pedido);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getIdPedido())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Long id) {

		Optional<Pedido> pedido = pedidosService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(pedido);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		pedidosService.deletar(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Pedido pedido, @PathVariable("id") Long id) {
		pedido.setIdPedido(id);
		pedidosService.atualizar(pedido);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}/enderecos", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionarEndereco(@PathVariable("id") Long pedidoId, @RequestBody Endereco endereco) {
		
		pedidosService.salvarEndereco(pedidoId, endereco);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(uri).build();

	}
	

	@RequestMapping(value = "/{id}/clientes", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionarEndereco(@PathVariable("id") Long pedidoId, @RequestBody Cliente cliente) {
		
		pedidosService.salvarCliente(pedidoId, cliente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(uri).build();

	}


}
