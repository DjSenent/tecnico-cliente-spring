package com.formacion.clientetecnico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.clientetecnico.entity.Asignacion;
import com.formacion.clientetecnico.repository.AsignacionRepository;

@Service
public class AsignacionServiceImpl implements AsignacionService{
	@Autowired
	private AsignacionRepository repositorio;

	@Override
	@Transactional(readOnly = true)
	public List<Asignacion> mostrarAsignaciones() {
		return (List<Asignacion>) repositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Asignacion buscarAsignacion(long id_tecnico, long id_proyecto) {
		return repositorio.findByIdCompuesto(id_tecnico, id_proyecto);
	}

	@Override
	@Transactional
	public Asignacion guardarAsignacion(Asignacion asignacion) {
		return repositorio.save(asignacion);
	}

	@Override
	@Transactional
	public Asignacion borrarAsignacion(long id_tecnico, long id_proyecto) {
		Asignacion asignacionBorrada = buscarAsignacion(id_tecnico, id_proyecto);
		repositorio.deleteByIdCompuesto(id_tecnico,id_proyecto);
		
		return asignacionBorrada;
		
		
	}
}
