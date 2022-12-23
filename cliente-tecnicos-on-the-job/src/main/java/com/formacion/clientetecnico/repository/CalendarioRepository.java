package com.formacion.clientetecnico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.formacion.clientetecnico.entity.Calendario;

public interface CalendarioRepository extends CrudRepository<Calendario, Long>{
	
	@Query(value = "SELECT * FROM calendarios WHERE id_tecnico = ?1", nativeQuery = true)
	public List<Calendario> findTecnicoCalendario(long id);

}
