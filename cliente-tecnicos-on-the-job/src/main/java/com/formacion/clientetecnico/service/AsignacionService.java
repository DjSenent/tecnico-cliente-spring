package com.formacion.clientetecnico.service;

import java.util.List;

import com.formacion.clientetecnico.entity.Asignacion;
import com.formacion.clientetecnico.entity.Proyecto;
import com.formacion.clientetecnico.entity.Tecnico;

public interface AsignacionService {

			public List<Asignacion> mostrarAsignaciones();
			
			public Asignacion buscarAsignacion(long id);
			
			public Asignacion guardarAsignacion(Asignacion asignacion);
			
			public Asignacion borrarAsignacion(long id);
			
			public List<Asignacion> buscarAsignacionPorTecnico(long id_tecnico);
			
			public List<Asignacion> buscarAsignacionPorProyecto(long id_proyecto);
			
}
