/******************************************************************************
 The MIT License (MIT)

 Copyright (c) 2015 Fabiano Góes

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 ******************************************************************************/
package com.eprogramar.sigaula.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 
 * @author Fabiano Góes - 05/08/2015
 * @version 1.0
 *
 */
@Entity
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * EX: 11
	 */
	@Column(columnDefinition = "varchar(2) default '11'", nullable = false)
	private String ddd;

	/**
	 * EX: 98765-0987
	 */
	@Column(length = 15, nullable = false)
	private String numero;

	private Boolean principal;

	@Column(columnDefinition = "varchar(20) default 'RESIDENCIAL'")
	@Enumerated(EnumType.STRING)
	private TelefoneTipo tipo;

	// @ManyToOne
	// @JsonIgnore
	// @JoinColumn(name = "pessoa_id", nullable = false, updatable = true)
	// private Pessoa pessoa;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "pessoa_id", nullable = false, updatable = true)
	private Pessoa pessoa;

	public Telefone() {
	}

	public Telefone(Long id, String numero) {
		this.id = id;
		this.numero = numero;
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

	// public Pessoa getPessoa() {
	// return pessoa;
	// }
	//
	// public void setPessoa(Pessoa pessoa) {
	// this.pessoa = pessoa;
	// }

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public TelefoneTipo getTipo() {
		return tipo;
	}

	public void setTipo(TelefoneTipo tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", ddd=" + ddd + ", numero=" + numero
				+ ", principal=" + principal + ", tipo=" + tipo + "]";
	}

}
