package com.formacion.clientetecnico.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="calendarios")
public class Calendario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private int mes;
	
	@Column(name = "anyo")
	private int año;
	
	private int horas_trabajadas;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JoinColumn(name="id_tecnico")
	private Tecnico tecnico;
	
	
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public int getMes() {
		return mes;
	}



	public void setMes(int mes) {
		this.mes = mes;
	}



	public int getAño() {
		return año;
	}



	public void setAño(int año) {
		this.año = año;
	}



	public int getHoras_trabajadas() {
		return horas_trabajadas;
	}



	public void setHoras_trabajadas(int horas_trabajadas) {
		this.horas_trabajadas = horas_trabajadas;
	}



	public Tecnico getTecnico() {
		return tecnico;
	}



	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}



	private static final long serialVersionUID = 1L;
	
}
