package com.eprogramar.sigaula.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	private String nome;
	private String telefone;

	public Curso() {
	}

	public Curso(Long id, String nome, String telefone) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", telefone=" + telefone
				+ "]";
	}

}
