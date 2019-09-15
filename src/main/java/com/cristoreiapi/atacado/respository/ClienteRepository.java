package com.cristoreiapi.atacado.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristoreiapi.atacado.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long > {

}
