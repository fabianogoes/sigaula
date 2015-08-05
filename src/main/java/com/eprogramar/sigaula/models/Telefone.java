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
	@Column(length = 14, nullable=false)	
	private String numero; 

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "pessoa_id", nullable = false, updatable = true)
	private Pessoa pessoa;

	public Telefone() {
	}

	public Telefone(Long id, String numero, Pessoa pessoa) {
		this.id = id;
		this.numero = numero;
		this.pessoa = pessoa;
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", numero=" + numero + ", pessoa=" + pessoa
				+ "]";
	}

}
