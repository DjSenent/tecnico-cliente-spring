package com.formacion.clientetecnico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.clientetecnico.entity.Tecnico;
import com.formacion.clientetecnico.repository.TecnicoRepository;

@Service
public class TecnicoServiceImpl implements TecnicoService{
	
	@Autowired
	private TecnicoRepository repositorio;

	@Override
	@Transactional(readOnly = true)
	public List<Tecnico> mostrarTecnicos() {
		return (List<Tecnico>) repositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Tecnico buscarTecnico(long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Tecnico guardarTecnico(Tecnico tecnico) {
		return repositorio.save(tecnico);
	}

	@Override
	@Transactional
	public Tecnico borrarTecnico(long id) {
		Tecnico tecnicoBorrado = buscarTecnico(id);
		repositorio.deleteById(id);
		
		return tecnicoBorrado;
		
		
	}
	
}
