package com.formacion.clientetecnico.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.clientetecnico.entity.Proyecto;
import com.formacion.clientetecnico.service.ProyectoService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins="http://localhost:4200/")
public class ProyectoController {

	@Autowired
	private ProyectoService servicio;
	
	@GetMapping("proyectos")
	public List<Proyecto> index(){
		return servicio.mostrarProyectos();
	}
	
	@GetMapping("proyectos/{id}")
	public ResponseEntity<?> show(@PathVariable long id) {
		Proyecto proyecto = null;
		Map<String,Object> response =new HashMap<>();
		
		try {
			proyecto = servicio.buscarProyecto(id);
			
			if(proyecto == null) {
				response.put("mensaje", "El proyecto con ID: "+id+" no existe en la base de datos");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			//si hay error desde la base de datos
			response.put("mensaje","Error al realizar consulta en la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
				
		return new ResponseEntity<Proyecto>(proyecto,HttpStatus.OK);
	}
	
	@PostMapping("proyectos")
	public ResponseEntity<?> save(@RequestBody Proyecto proyecto){
		Proyecto proyectoNew = null;
		Map<String,Object> response = new HashMap<>();
		
		try {
			proyectoNew = servicio.guardarProyecto(proyecto);
		} catch (DataAccessException e){
			response.put("mensaje","Error al realizar insert en la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","El proyecto se ha guardado con éxito!");
		response.put("proyecto",proyectoNew);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		}
	
	@PutMapping("proyectos/{id}")
	public ResponseEntity<?> update(@PathVariable long id,@RequestBody Proyecto proyecto){
		Proyecto proyectoUpdate = null;
		Map<String,Object> response = new HashMap<>();
		
		try {		
			proyectoUpdate = servicio.buscarProyecto(id);
			if(proyectoUpdate != null) {
				proyectoUpdate.setNombre(proyecto.getNombre());
				proyectoUpdate.setHoras_restantes(proyecto.getHoras_restantes());
			}else {
				response.put("mensaje","Error: no se puede editar, el proyecto con ID: "+id+" no existe en la base de datos");	
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			}		
			servicio.guardarProyecto(proyectoUpdate);		
		} catch (DataAccessException e) {
			//si hay error desde la base de datos
			response.put("mensaje","Error al realizar update en la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		response.put("mensaje","El cliente ha sido actualizado con éxito!");
		response.put("proyecto",proyectoUpdate);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	
	}
	
	@DeleteMapping("proyectos/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		Map<String,Object> response =new HashMap<>();
		Proyecto proyectoDelete = null;
		
		try {
			proyectoDelete = servicio.borrarProyecto(id);

		} catch (DataAccessException e) {
			//si hay error desde la base de datos
			response.put("mensaje","Error al realizar delete en la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El proyecto ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	@GetMapping("proyectosId")
	public List<Number> indexId(){
		return servicio.indexProyectoId();
	}
		
	
}
