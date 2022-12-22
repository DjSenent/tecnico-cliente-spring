package com.formacion.clientetecnico.service;

import java.util.List;

import com.formacion.clientetecnico.entity.Tecnico;

public interface TecnicoService {
	
	//metodo para mostrar todos los clientes
		public List<Tecnico> mostrarTecnicos();
		
		//metodo que busque cliente por id
		public Tecnico buscarTecnico(long id);
		
		//metodo para crear un nuevo cliente
		public Tecnico guardarTecnico(Tecnico tecnico);
		
		//metodo para borrar un cliente
		public Tecnico borrarTecnico(long id);

}
