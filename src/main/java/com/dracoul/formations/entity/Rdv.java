package com.dracoul.formations.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Rdv implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String titre;
	private String email;
	private String specialite;
	private String date;
	private String etat;
	@Column(nullable = false, updatable = false)
	private String rdvCode;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "personnel_id", referencedColumnName = "id")
	private Personnel personnel;
	
	private Rdv() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Rdv(Long id, String titre, String email, String specialite, String date, String etat, String rdvCode,
			Personnel personnel) {
		super();
		this.id = id;
		this.titre = titre;
		this.email = email;
		this.specialite = specialite;
		this.date = date;
		this.etat = etat;
		this.rdvCode = rdvCode;
		this.personnel = personnel;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getRdvCode() {
		return rdvCode;
	}

	public void setRdvCode(String rdvCode) {
		this.rdvCode = rdvCode;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Rdv [id=" + id + ", titre=" + titre + ", email=" + email + ", specialite=" + specialite + ", date="
				+ date + ", etat=" + etat + ", rdvCode=" + rdvCode + ", personnel=" + personnel + "]";
	}

	
}
