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

import com.formacion.clientetecnico.entity.Tecnico;
import com.formacion.clientetecnico.service.TecnicoService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins="http://localhost:4200/")
public class TecnicoController {

	//inyectamos el servicio
		@Autowired
		private TecnicoService servicio; 
		
		@GetMapping("tecnicos")//define peticion http get
		//@RequestMapping(method = RequestMethod.GET,path = "clientes")
		public List<Tecnico> index(){
			return servicio.mostrarTecnicos();
		}
		
		@GetMapping("tecnicos/{id}")
		public Tecnico show(@PathVariable long id) {
			return servicio.buscarTecnico(id);
		}
		
		@PostMapping("tecnicos")
		@ResponseStatus(HttpStatus.CREATED)
		public Tecnico save(@RequestBody Tecnico tecnico) {
			return servicio.guardarTecnico(tecnico);
		}	
		
		
		@PutMapping("tecnicos/{id}")
		@ResponseStatus(HttpStatus.CREATED)
		public Tecnico update(@PathVariable long id,@RequestBody Tecnico tecnico) {
			Tecnico tecnicoUpdate = servicio.buscarTecnico(id);
			
			tecnicoUpdate.setNombre(tecnico.getNombre());
			tecnicoUpdate.setApellido1(tecnico.getApellido1());
			tecnicoUpdate.setApellido2(tecnico.getApellido2());
			tecnicoUpdate.setExperiencia(tecnico.getExperiencia());
			
			return servicio.guardarTecnico(tecnicoUpdate);
		}
		
		//ejercicio, agregar manejo de errores en este metodo
		@DeleteMapping("tecnicos/{id}")
		public Tecnico delete(@PathVariable long id) {
			return servicio.borrarTecnico(id);
			
		}
		
}
