package com.example.Aula.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "tb_locais")
public class Local {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 100, nullable = false)
	private String rua;	
	@Column(length = 5, nullable = false)
	private String numero;	
	@Column(length = 100, nullable = false)
	private String bairro;
	@Column(length = 100, nullable = false)
	private String cidade;
	@Column(length = 9, nullable = false)
	private String cep;
}
