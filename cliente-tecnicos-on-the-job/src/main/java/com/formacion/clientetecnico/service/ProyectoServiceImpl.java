package com.formacion.clientetecnico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.clientetecnico.entity.Proyecto;
import com.formacion.clientetecnico.entity.Tecnico;
import com.formacion.clientetecnico.repository.ProyectoRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService{
	
	@Autowired
	private ProyectoRepository repositorio;

	@Override
	@Transactional(readOnly = true)
	public List<Proyecto> mostrarProyectos() {
		return (List<Proyecto>) repositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Proyecto buscarProyecto(long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Proyecto guardarProyecto(Proyecto proyecto) {
		return repositorio.save(proyecto);
	}

	@Override
	@Transactional
	public Proyecto borrarProyecto(long id) {
		Proyecto proyectoBorrado =  buscarProyecto(id);
		
		repositorio.deleteById(id);
		return proyectoBorrado;
	}

}
