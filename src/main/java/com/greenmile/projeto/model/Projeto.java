package com.greenmile.projeto.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=120)
	private String nomeProjeto;
	
	@ManyToOne(optional=false, cascade=CascadeType.MERGE)
	@JoinColumn(name="gerente_id")
	private Gerente gerente;
	
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	@Temporal(TemporalType.DATE)
	private Date dataFim;
	
	private String timeSkill;
	private String pmsSkill;
	private String nomeTime;
	
	private Boolean ativo = true;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getTimeSkill() {
		return timeSkill;
	}

	public void setTimeSkill(String timeSkill) {
		this.timeSkill = timeSkill;
	}

	public String getPmsSkill() {
		return pmsSkill;
	}

	public void setPmsSkill(String pmsSkill) {
		this.pmsSkill = pmsSkill;
	}

	public String getNomeTime() {
		return nomeTime;
	}

	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((gerente == null) ? 0 : gerente.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeProjeto == null) ? 0 : nomeProjeto.hashCode());
		result = prime * result + ((nomeTime == null) ? 0 : nomeTime.hashCode());
		result = prime * result + ((pmsSkill == null) ? 0 : pmsSkill.hashCode());
		result = prime * result + ((timeSkill == null) ? 0 : timeSkill.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (gerente == null) {
			if (other.gerente != null)
				return false;
		} else if (!gerente.equals(other.gerente))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeProjeto == null) {
			if (other.nomeProjeto != null)
				return false;
		} else if (!nomeProjeto.equals(other.nomeProjeto))
			return false;
		if (nomeTime == null) {
			if (other.nomeTime != null)
				return false;
		} else if (!nomeTime.equals(other.nomeTime))
			return false;
		if (pmsSkill == null) {
			if (other.pmsSkill != null)
				return false;
		} else if (!pmsSkill.equals(other.pmsSkill))
			return false;
		if (timeSkill == null) {
			if (other.timeSkill != null)
				return false;
		} else if (!timeSkill.equals(other.timeSkill))
			return false;
		return true;
	}

	
	
}
