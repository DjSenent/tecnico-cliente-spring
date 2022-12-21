package com.formacion.clientetecnico.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tecnicos")
@Getter
@Setter
public class Tecnico implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String nombre;
	
	private String apellido1;
	
	private String apellido2;
	
	@Column(nullable = false)
	private String experiencia;
	
	
	
	private static final long serialVersionUID = 1L;
	
}
