package com.formacion.clientetecnico.service;

import java.util.List;

import com.formacion.clientetecnico.entity.Asignacion;
import com.formacion.clientetecnico.entity.Proyecto;
import com.formacion.clientetecnico.entity.Tecnico;

public interface AsignacionService {

			public List<Asignacion> mostrarAsignaciones();
			
			public Asignacion buscarAsignacion(long id_tecnico, long id_proyecto);
			
			public Asignacion guardarAsignacion(Asignacion asignacion);
			
			public Asignacion borrarAsignacion(long id_tecnico, long id_proyecto);
			
}
