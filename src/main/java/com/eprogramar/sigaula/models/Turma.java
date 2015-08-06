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

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@OneToOne
	private Pessoa professor;

	@OneToOne
	private Pessoa aluno;

	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@Temporal(TemporalType.DATE)
	private Date dataFinal;

	@Temporal(TemporalType.TIME)
	private Date horaInicioAula;

	@Temporal(TemporalType.TIME)
	private Date horaFimAula;

	public Turma() {
	}

	public Turma(Long id, Pessoa professor, Pessoa aluno) {
		this.id = id;
		this.professor = professor;
		this.aluno = aluno;
	}

	public Turma(Long id, Pessoa professor, Pessoa aluno, Date dataInicio,
			Date dataFinal, Date horaInicioAula, Date horaFimAula) {
		this(id, professor, aluno);
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.horaInicioAula = horaInicioAula;
		this.horaFimAula = horaFimAula;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getProfessor() {
		return professor;
	}

	public void setProfessor(Pessoa professor) {
		this.professor = professor;
	}

	public Pessoa getAluno() {
		return aluno;
	}

	public void setAluno(Pessoa aluno) {
		this.aluno = aluno;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getHoraInicioAula() {
		return horaInicioAula;
	}

	public void setHoraInicioAula(Date horaInicioAula) {
		this.horaInicioAula = horaInicioAula;
	}

	public Date getHoraFimAula() {
		return horaFimAula;
	}

	public void setHoraFimAula(Date horaFimAula) {
		this.horaFimAula = horaFimAula;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", professor=" + professor + ", aluno="
				+ aluno + ", dataInicio=" + dataInicio + ", dataFinal="
				+ dataFinal + ", horaInicioAula=" + horaInicioAula
				+ ", horaFimAula=" + horaFimAula + "]";
	}

}
