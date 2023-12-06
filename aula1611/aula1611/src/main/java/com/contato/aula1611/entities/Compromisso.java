package com.contato.aula1611.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_compromissos")
public class Compromisso {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String data;
	
	@Column(length = 50, nullable = false)
	private String hora;
	
	@Column(length = 1, nullable = false)
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "local_id")
	private Local local;
	
	@ManyToOne
	@JoinColumn(name = "contato_id")
	private Contato contato;
	
	public Compromisso(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Compromisso(Long id, Local local, Contato contato, String data, String hora, String status) {
		super();
		this.id = id;
		this.local = local;
		this.contato = contato;
		this.data = data;
		this.hora = hora;
		this.status = status;
	}
}
