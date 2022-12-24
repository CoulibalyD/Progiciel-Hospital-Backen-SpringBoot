package com.dracoul.formations.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email" )})
public class Personnel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String age;
	private String type;
	private String phone; 
	private String address;
	private String genre;
	private String imageUrl;
	@Column(nullable = false, updatable = false)
	private String personnelCode;
	
	@JsonIgnore
	@OneToMany(mappedBy = "personnel")
	private Set<Rdv> rdv = new HashSet<>();
	
	public Personnel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Set<Rdv> getRdv() {
		return rdv;
	}


	public void setRdv(Set<Rdv> rdv) {
		this.rdv = rdv;
	}


	@SuppressWarnings("unused")
	private Personnel(Long id, String firstName, String lastName, String email, String password, String age,
			String type, String phone, String address, String genre, String imageUrl, String personnelCode) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.age = age;
		this.type = type;
		this.phone = phone;
		this.address = address;
		this.genre = genre;
		this.imageUrl = imageUrl;
		this.personnelCode = personnelCode;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPersonnelCode() {
		return personnelCode;
	}

	public void setPersonnelCode(String personnelCode) {
		this.personnelCode = personnelCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Personnel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", age=" + age + ", type=" + type + ", phone=" + phone + ", address="
				+ address + ", genre=" + genre + ", imageUrl=" + imageUrl + ", personnelCode=" + personnelCode + "]";
	}


	
	
	
}
