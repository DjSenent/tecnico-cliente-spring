package com.formacion.clientetecnico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.clientetecnico.entity.Tecnico;

@Repository
public interface TecnicoRepository extends CrudRepository<Tecnico, Long>{

}
