package com.formacion.clientetecnico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.clientetecnico.entity.Calendario;
import com.formacion.clientetecnico.repository.CalendarioRepository;

@Service
public class CalendarioServiceImpl implements CalendarioService{
	
	@Autowired
	private CalendarioRepository repositorio;

	@Override
	@Transactional(readOnly = true)
	public List<Calendario> mostrarCalendarios() {
		return (List<Calendario>) repositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Calendario buscarCalendario(long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Calendario guardarCalendario(Calendario calendario) {
		return repositorio.save(calendario);
	}

	@Override
	public Calendario borrarCalendario(long id) {
		Calendario calendarioBorrado = buscarCalendario(id);
		
		repositorio.deleteById(id);
		return calendarioBorrado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Calendario> findTecnicoCalendario(long id) {
		return repositorio.findTecnicoCalendario(id);
	}
	@Override
	@Transactional(readOnly = true)
	public List<Calendario> findCalendarioPorAnyo(int anyo) {
		return repositorio.findCalendarioPorAnyo(anyo);
	}
	
}
