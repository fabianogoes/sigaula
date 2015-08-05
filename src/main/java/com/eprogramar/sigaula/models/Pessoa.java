package com.eprogramar.sigaula.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, length=100)
	private String nome;
	@Column(nullable = false)
	private String email;

	@Column(columnDefinition="varchar(20) default 'ALUNO'", nullable=false)
	@Enumerated(EnumType.STRING)
	private PessoaTipo tipo;

	@OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<Telefone> telefones;

	public Pessoa() {
	}

	public Pessoa(Long id, String nome, String email, PessoaTipo tipo,
			List<Telefone> telefones) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.tipo = tipo;
		this.telefones = telefones;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public PessoaTipo getTipo() {
		return tipo;
	}

	public void setTipo(PessoaTipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return  "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email
				+ ", tipo=" + tipo + ", telefones=" + telefones + "]";
	}

}
