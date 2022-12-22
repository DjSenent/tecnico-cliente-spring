package com.formacion.clientetecnico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.clientetecnico.entity.Asignacion;
import com.formacion.clientetecnico.service.AsignacionService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins="http://localhost:4200/")
public class AsignacionController {

	//inyectamos el servicio
		@Autowired
		private AsignacionService servicio; 
		
		@GetMapping("asignaciones")//define peticion http get
		public List<Asignacion> index(){
			return servicio.mostrarAsignaciones();
		}
		
		@GetMapping("asignaciones/{id}")
		public Asignacion show(@PathVariable long id) {
			return servicio.buscarAsignacion(id);
		}
		
		@PostMapping("asignaciones")
		@ResponseStatus(HttpStatus.CREATED)
		public Asignacion save(@RequestBody Asignacion asignacion) {
			return servicio.guardarAsignacion(asignacion);
		}	
		
		
		@PutMapping("asignaciones/{id}")
		@ResponseStatus(HttpStatus.CREATED)
		public Asignacion update(@PathVariable long id,@RequestBody Asignacion asignacion) {
			Asignacion asignacionUpdate = servicio.buscarAsignacion(id);
			
			asignacionUpdate.setProyecto(asignacion.getProyecto());
			asignacionUpdate.setTecnico(asignacion.getTecnico());
			asignacionUpdate.setPorcentaje(asignacion.getPorcentaje());
			
			return servicio.guardarAsignacion(asignacionUpdate);
		}
		
		//ejercicio, agregar manejo de errores en este metodo
		@DeleteMapping("asignaciones/{id}")
		public Asignacion delete(@PathVariable long id) {
			return servicio.borrarAsignacion(id);
		}
		
		@GetMapping("asignaciones/tecnico/{id_tecnico}")//define peticion http get
		public List<Asignacion> showTecnico(@PathVariable long id_tecnico) {
			return servicio.buscarAsignacionPorTecnico(id_tecnico);
		}
		
		@GetMapping("asignaciones/proyecto/{id_proyecto}")//define peticion http get
		public List<Asignacion> showProyecto(@PathVariable long id_proyecto) {
			return servicio.buscarAsignacionPorProyecto(id_proyecto);
		}
		
}
