package com.formacion.clientetecnico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.clientetecnico.entity.Asignacion;

@Repository
public interface AsignacionRepository extends CrudRepository<Asignacion, Long>{

	
	@Query(value = "SELECT * FROM asignaciones u WHERE u.id_proyecto = ?1", nativeQuery = true)
	public List<Asignacion> findByProyectoId(long id_proyecto);
	
	@Query(value = "SELECT * FROM asignaciones u WHERE u.id_tecnico = ?1", nativeQuery = true)
	public List<Asignacion> findByTecnicoId(long id_tecnico);
}
