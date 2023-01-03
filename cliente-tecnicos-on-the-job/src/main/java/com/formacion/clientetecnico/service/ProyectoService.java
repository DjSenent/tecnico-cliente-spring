package com.formacion.clientetecnico.service;

import java.util.List;

import com.formacion.clientetecnico.entity.Proyecto;
import com.formacion.clientetecnico.entity.Tecnico;

public interface ProyectoService {
	
	public List<Proyecto> mostrarProyectos();
	
	public Proyecto buscarProyecto(long id);
	
	public Proyecto guardarProyecto(Proyecto proyecto);
	
	public Proyecto borrarProyecto(long id);
	
	public List<Number> indexProyectoId();
	
	//public List<Tecnico> mostarTecnicosAsignados(long id);
	
	

}
