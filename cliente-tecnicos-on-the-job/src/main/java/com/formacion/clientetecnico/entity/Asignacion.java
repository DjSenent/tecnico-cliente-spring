package com.formacion.clientetecnico.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="asignaciones")
@Getter
@Setter
public class Asignacion implements Serializable{
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JoinColumn(name="id_tecnico")
	private Tecnico tecnico;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JoinColumn(name="id_proyecto")
	private Proyecto proyecto;
	
	private float porcentaje;

}
