package com.dracoul.formations.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Materiel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String nom;
	private String date;
	private String etat;
	@Column(nullable = false, updatable = false)
	private String materielCode;
	
	private Materiel() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Materiel(Long id, String nom, String date, String etat, String materielCode) {
		super();
		this.id = id;
		this.nom = nom;
		this.date = date;
		this.etat = etat;
		this.materielCode = materielCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public String getMaterielCode() {
		return materielCode;
	}

	public void setMaterielCode(String materielCode) {
		this.materielCode = materielCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Materiel [id=" + id + ", nom=" + nom + ", date=" + date + ", etat=" + etat + ", materielCode="
				+ materielCode + "]";
	}

	
	
	

}
