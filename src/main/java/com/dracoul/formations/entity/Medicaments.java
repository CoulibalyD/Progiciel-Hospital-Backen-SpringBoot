package com.dracoul.formations.entity;

public class Medicaments {

	private Long id;
	private String nom;
	private Integer quantite;
	private String utilisation;
	
	private Medicaments() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Medicaments(Long id, String nom, Integer quantite, String utilisation) {
		super();
		this.id = id;
		this.nom = nom;
		this.quantite = quantite;
		this.utilisation = utilisation;
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

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public String getUtilisation() {
		return utilisation;
	}

	public void setUtilisation(String utilisation) {
		this.utilisation = utilisation;
	}

	@Override
	public String toString() {
		return "Medicaments [id=" + id + ", nom=" + nom + ", quantite=" + quantite + ", utilisation=" + utilisation
				+ "]";
	}
	
	
}
