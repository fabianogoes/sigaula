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

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 
 * @author Fabiano Góes - 05/08/2015
 * @version 1.0
 *
 */
@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// @Temporal(TemporalType.DATE)
	private String dataInicio;

	// @Temporal(TemporalType.DATE)
	private String dataFinal;

	// @Temporal(TemporalType.TIME)
	private String horaInicioAula;

	// @Temporal(TemporalType.TIME)
	private String horaFimAula;

	@ManyToOne
	@JoinColumn(name = "professor_id", nullable = false, updatable = true)
	private Professor professor;

	@ManyToOne
	@JoinColumn(name = "curso_id", nullable = false, updatable = true)
	private Curso curso;

	@ManyToMany(fetch=FetchType.EAGER)
	//@Fetch(FetchMode.SUBSELECT)
	@JsonIgnore
	@JoinTable(name = "turma_aluno", joinColumns = { @JoinColumn(name = "turma_id") }, inverseJoinColumns = { @JoinColumn(name = "aluno_id") })
	private Set<Aluno> alunos;


	public Turma() {
	}

	public Turma(Long id, String dataInicio, String dataFinal,
			String horaInicioAula, String horaFimAula, Professor professor) {
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.horaInicioAula = horaInicioAula;
		this.horaFimAula = horaFimAula;
		this.professor = professor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getHoraInicioAula() {
		return horaInicioAula;
	}

	public void setHoraInicioAula(String horaInicioAula) {
		this.horaInicioAula = horaInicioAula;
	}

	public String getHoraFimAula() {
		return horaFimAula;
	}

	public void setHoraFimAula(String horaFimAula) {
		this.horaFimAula = horaFimAula;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", dataInicio=" + dataInicio
				+ ", dataFinal=" + dataFinal + ", horaInicioAula="
				+ horaInicioAula + ", horaFimAula=" + horaFimAula
				+ ", professor=" + professor + "]";
	}

}
