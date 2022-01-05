package com.java.countryManagement.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Language {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="language")
	private List<Country> country;
	
	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Language(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Country> getCountry() {
		return country;
	}
	public void setCountry(List<Country> country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
	public List<Country> addcountry(Country tempcountry) {
		if(country==null) {
			country = new ArrayList<Country>();
		}
		country.add(tempcountry);
		tempcountry.setLanguage(this);
		
		return country;
	}


	
	
}
