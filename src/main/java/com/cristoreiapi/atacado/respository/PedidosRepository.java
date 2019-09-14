package com.cristoreiapi.atacado.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristoreiapi.atacado.domain.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido, Long>{
	

}
