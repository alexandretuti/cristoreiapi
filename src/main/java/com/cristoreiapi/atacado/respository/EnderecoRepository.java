package com.cristoreiapi.atacado.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristoreiapi.atacado.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long > {

}
