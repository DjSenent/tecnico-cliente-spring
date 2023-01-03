package com.formacion.clientetecnico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.formacion.clientetecnico.entity.Asignacion;
import com.formacion.clientetecnico.entity.Proyecto;
import com.formacion.clientetecnico.entity.Tecnico;

public interface ProyectoRepository extends CrudRepository<Proyecto, Long>{
	
	@Query(value = "SELECT id FROM proyectos", nativeQuery = true)
	public List<Number> indexProyectoId();
}
