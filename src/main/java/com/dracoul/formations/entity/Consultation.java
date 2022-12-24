package com.dracoul.formations.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Consultation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String medecin;
	private String date ;
	private String nom;
	private String prenom;
	private String observation;
	private String medicament;

	//private List<Medicaments> medicament;
	@Column(nullable = false, updatable = false)
	private String consultationCode;
	
	private Consultation() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Consultation(Long id, String medecin, String date, String nom, String prenom, String observation,
			String medicament, String consultationCode) {
		super();
		this.id = id;
		this.medecin = medecin;
		this.date = date;
		this.nom = nom;
		this.prenom = prenom;
		this.observation = observation;
		this.medicament = medicament;
		this.consultationCode = consultationCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMedecin() {
		return medecin;
	}

	public void setMedecin(String medecin) {
		this.medecin = medecin;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getMedicament() {
		return medicament;
	}

	public void setMedicament(String medicament) {
		this.medicament = medicament;
	}

	public String getConsultationCode() {
		return consultationCode;
	}

	public void setConsultationCode(String consultationCode) {
		this.consultationCode = consultationCode;
	}

	@Override
	public String toString() {
		return "Consultation [id=" + id + ", medecin=" + medecin + ", date=" + date + ", nom=" + nom + ", prenom="
				+ prenom + ", observation=" + observation + ", medicament=" + medicament + ", consultationCode="
				+ consultationCode + "]";
	}
	
	


}
