package com.greenmile.projeto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Importacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 120)
	private String projectName;
	
	@Temporal(TemporalType.DATE)
	private Date planedStart;
	@Temporal(TemporalType.DATE)
	private Date planedEnd;
	
	@Column(length = 120)
	private String pm;
	@Column(length = 80)
	private String pmEmail;
	@Column(length = 120)
	private String pmSkills;
	
	@Column(length = 120)
	private String employeeName;
	@Column(length = 80)
	private String employeeEmail;
	@Column(length = 120)
	private String employeeTeam;
	@Column(length = 120)
	private String employeeSkills;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Date getPlanedStart() {
		return planedStart;
	}
	public void setPlanedStart(Date planedStart) {
		this.planedStart = planedStart;
	}
	public Date getPlanedEnd() {
		return planedEnd;
	}
	public void setPlanedEnd(Date planedEnd) {
		this.planedEnd = planedEnd;
	}
	public String getPm() {
		return pm;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
	public String getPmEmail() {
		return pmEmail;
	}
	public void setPmEmail(String pmEmail) {
		this.pmEmail = pmEmail;
	}
	public String getPmSkills() {
		return pmSkills;
	}
	public void setPmSkills(String pmSkills) {
		this.pmSkills = pmSkills;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeTeam() {
		return employeeTeam;
	}
	public void setEmployeeTeam(String employeeTeam) {
		this.employeeTeam = employeeTeam;
	}
	public String getEmployeeSkills() {
		return employeeSkills;
	}
	public void setEmployeeSkills(String employeeSkills) {
		this.employeeSkills = employeeSkills;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeEmail == null) ? 0 : employeeEmail.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((employeeSkills == null) ? 0 : employeeSkills.hashCode());
		result = prime * result + ((employeeTeam == null) ? 0 : employeeTeam.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((planedEnd == null) ? 0 : planedEnd.hashCode());
		result = prime * result + ((planedStart == null) ? 0 : planedStart.hashCode());
		result = prime * result + ((pm == null) ? 0 : pm.hashCode());
		result = prime * result + ((pmEmail == null) ? 0 : pmEmail.hashCode());
		result = prime * result + ((pmSkills == null) ? 0 : pmSkills.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
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
		Importacao other = (Importacao) obj;
		if (employeeEmail == null) {
			if (other.employeeEmail != null)
				return false;
		} else if (!employeeEmail.equals(other.employeeEmail))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (employeeSkills == null) {
			if (other.employeeSkills != null)
				return false;
		} else if (!employeeSkills.equals(other.employeeSkills))
			return false;
		if (employeeTeam == null) {
			if (other.employeeTeam != null)
				return false;
		} else if (!employeeTeam.equals(other.employeeTeam))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (planedEnd == null) {
			if (other.planedEnd != null)
				return false;
		} else if (!planedEnd.equals(other.planedEnd))
			return false;
		if (planedStart == null) {
			if (other.planedStart != null)
				return false;
		} else if (!planedStart.equals(other.planedStart))
			return false;
		if (pm == null) {
			if (other.pm != null)
				return false;
		} else if (!pm.equals(other.pm))
			return false;
		if (pmEmail == null) {
			if (other.pmEmail != null)
				return false;
		} else if (!pmEmail.equals(other.pmEmail))
			return false;
		if (pmSkills == null) {
			if (other.pmSkills != null)
				return false;
		} else if (!pmSkills.equals(other.pmSkills))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		return true;
	}
	
	
}
