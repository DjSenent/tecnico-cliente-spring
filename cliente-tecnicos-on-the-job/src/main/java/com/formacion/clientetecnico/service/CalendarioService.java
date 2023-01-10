package com.formacion.clientetecnico.service;

import java.util.List;

import com.formacion.clientetecnico.entity.Calendario;

public interface CalendarioService {
	
	public List<Calendario> mostrarCalendarios();
	
	public Calendario buscarCalendario(long id);
	
	public Calendario guardarCalendario(Calendario calendario);
	
	public Calendario borrarCalendario(long id);
	
	public List<Calendario> findTecnicoCalendario(long id);
	public List<Calendario> findCalendarioPorAnyo(int anyo);
}
