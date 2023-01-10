package com.formacion.clientetecnico.controller;

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

import com.formacion.clientetecnico.entity.Calendario;
import com.formacion.clientetecnico.entity.Proyecto;
import com.formacion.clientetecnico.service.CalendarioService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins="http://localhost:4200/")
public class CalendarioController {
	
	@Autowired
	private CalendarioService servicio;
	
	@GetMapping("calendarios")
	public List<Calendario> index(){
		return servicio.mostrarCalendarios();
	}
	
	@GetMapping("calendarios/{id}")
	public ResponseEntity<?> show(@PathVariable long id){
		Calendario calendario = null;
		Map<String,Object> response =new HashMap<>();
		
		try {
			calendario = servicio.buscarCalendario(id);
			
			if(calendario == null) {
				response.put("mensaje", "El calendario con ID: "+id+" no existe en la base de datos");
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			}
		} catch (DataAccessException e) {
			//si hay error desde la base de datos
			response.put("mensaje","Error al realizar consulta en la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
				
		return new ResponseEntity<Calendario>(calendario,HttpStatus.OK);
	}
	
	@PostMapping("calendarios")
	public ResponseEntity<?> save(@RequestBody Calendario calendario){
		Calendario calendarioNew = null;
		Map<String,Object> response = new HashMap<>();
		try {
			calendarioNew = servicio.guardarCalendario(calendario);
		} catch (DataAccessException e){
			response.put("mensaje","Error al realizar insert en la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","El calendario se ha guardado con éxito!");
		response.put("calendario",calendarioNew);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("calendarios/{id}")
	public ResponseEntity<?> update(@PathVariable long id,@RequestBody Calendario calendario){
		Calendario calendarioUpdate = null;
		Map<String,Object> response = new HashMap<>();
		
		try {		
			calendarioUpdate = servicio.buscarCalendario(id);
			if(calendarioUpdate != null) {
				calendarioUpdate.setMes(calendario.getMes());
				calendarioUpdate.setAño(calendario.getAño());
				calendarioUpdate.setHoras_trabajadas(calendario.getHoras_trabajadas());
				calendarioUpdate.setTecnico(calendario.getTecnico());
			}else {
				response.put("mensaje","Error: no se puede editar, el calendario con ID: "+id+" no existe en la base de datos");	
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
			}		
			servicio.guardarCalendario(calendarioUpdate);		
		} catch (DataAccessException e) {
			//si hay error desde la base de datos
			response.put("mensaje","Error al realizar update en la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		response.put("mensaje","El calendario ha sido actualizado con éxito!");
		response.put("proyecto",calendarioUpdate);
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping("calendarios/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		Map<String,Object> response =new HashMap<>();
		Calendario calendarioDelete = null;
		try {
			calendarioDelete = servicio.borrarCalendario(id);

		} catch (DataAccessException e) {
			//si hay error desde la base de datos
			response.put("mensaje","Error al realizar delete en la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El proyecto ha sido eliminado con éxito!");
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
	}
	
	@GetMapping("calendarios/tecnico/{id}")
	public List<Calendario> tecnicoId(@PathVariable long id){
		return servicio.findTecnicoCalendario(id);
	}
	
	
	@GetMapping("calendarios/anyo/{anyo}")
	public List<Calendario> getCalendarioPorAnyo(@PathVariable int anyo){
		return servicio.findCalendarioPorAnyo(anyo);
	}
}
