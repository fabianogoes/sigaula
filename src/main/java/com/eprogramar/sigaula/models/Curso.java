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

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Fabiano Góes - 05/08/2015
 * @version 1.0
 *
 */
@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 50)
	private String nome;

	/**
	 * Conhecimento prévio para melhor aproveitamento do Curso, quando
	 * necessário
	 */
	private String requisitos;

	/**
	 * Quantidade de horas/aulas total do Curso
	 */
	private Integer cargaHoraria;

	/**
	 * Valor total do Curso
	 */
	private BigDecimal preco;

	/**
	 * INDIVIDUAL = um aluno por aula GRUPO = quantidade indefinida
	 */
	@Column(columnDefinition = "varchar(20) default 'INDIVIDUAL'")
	@Enumerated(EnumType.STRING)
	private CursoTipo tipo;

	/**
	 * Periodicidade das aulas, SEMANAL = 1 aula por semana QUINZENAL = 1 aula a
	 * cada 15 dias MENSAL = 1 uma aula por mes DIARIO = 1 aula por dia
	 * PERIODICO = aulas exporadicas
	 */
	@Column(columnDefinition = "varchar(20) default 'SEMANAL'")
	@Enumerated(EnumType.STRING)
	private CursoCategoria categoria;

	/**
	 * Tempo de duração por aula
	 */
	private int duracaoAula;

	/**
	 * X horas por aula X minutos por aula
	 */
	@Column(columnDefinition = "varchar(10) default 'HORA'")
	private String sulfixoDuracaoAula;

	private String observacoes;

	public Curso() {
	}

	public Curso(Long id, String nome) {
		this.id = id;
		this.nome = nome;
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

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public CursoTipo getTipo() {
		return tipo;
	}

	public void setTipo(CursoTipo tipo) {
		this.tipo = tipo;
	}

	public CursoCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(CursoCategoria categoria) {
		this.categoria = categoria;
	}

	public Integer getDuracaoAula() {
		return duracaoAula;
	}

	public void setDuracaoAula(Integer duracaoAula) {
		this.duracaoAula = duracaoAula;
	}

	public String getSulfixoDuracaoAula() {
		return sulfixoDuracaoAula;
	}

	public void setSulfixoDuracaoAula(String sulfixoDuracaoAula) {
		this.sulfixoDuracaoAula = sulfixoDuracaoAula;
	}

	public void setDuracaoAula(int duracaoAula) {
		this.duracaoAula = duracaoAula;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", requisitos="
				+ requisitos + ", cargaHoraria=" + cargaHoraria + ", preco="
				+ preco + ", tipo=" + tipo + ", categoria=" + categoria
				+ ", duracaoAula=" + duracaoAula + ", sulfixoDuracaoAula="
				+ sulfixoDuracaoAula + ", observacoes=" + observacoes + "]";
	}

}
