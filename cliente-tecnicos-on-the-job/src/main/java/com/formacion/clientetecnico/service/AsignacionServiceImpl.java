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
	public Asignacion buscarAsignacion(long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Asignacion guardarAsignacion(Asignacion asignacion) {
		return repositorio.save(asignacion);
	}

	@Override
	@Transactional
	public Asignacion borrarAsignacion(long id) {
		Asignacion asignacionBorrada = buscarAsignacion(id);
		repositorio.deleteById(id);
		
		return asignacionBorrada;
		
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asignacion> buscarAsignacionPorTecnico(long id_tecnico) {
		return (List<Asignacion>) repositorio.findByTecnicoId(id_tecnico);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asignacion> buscarAsignacionPorProyecto(long id_proyecto) {
		return (List<Asignacion>) repositorio.findByProyectoId(id_proyecto);
	}
}
