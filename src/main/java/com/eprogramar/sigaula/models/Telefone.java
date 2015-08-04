package com.eprogramar.sigaula.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Telefone {
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * (11)98765-0987
	 */
	@Column(length = 14)	
	private String numero; 

	@ManyToOne
	@JsonIgnore
	@JoinColumn(nullable = false, updatable = true)
	private Aluno aluno;

	public Telefone() {
	}

	public Telefone(Long id, String numero, Aluno aluno) {
		this.id = id;
		this.numero = numero;
		this.aluno = aluno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", numero=" + numero + ", aluno=" + aluno
				+ "]";
	}

}
