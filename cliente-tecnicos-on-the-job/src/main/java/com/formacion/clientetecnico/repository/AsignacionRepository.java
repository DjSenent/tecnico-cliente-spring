package com.formacion.clientetecnico.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacion.clientetecnico.entity.Asignacion;

@Repository
public interface AsignacionRepository extends CrudRepository<Asignacion, Long>{
	
	@Query("select u from Asignacion u where u.id_tecnico = ?1 and u.id_proyecto = ?2")
	public Asignacion findByIdCompuesto(long id_tecnico, long id_proyecto);
	
	@Query("delete u from Asignacion u where u.id_tecnico = ?1 and u.id_proyecto = ?2")
	public Asignacion deleteByIdCompuesto(long id_tecnico, long id_proyecto);

}
