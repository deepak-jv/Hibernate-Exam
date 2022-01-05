package com.java.countryManagement.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity

public class Sport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "country_sport", joinColumns = @JoinColumn(name = "sport_id"), inverseJoinColumns = @JoinColumn(name = "country_id"))
	private List<Country> country;

	public Sport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sport(String name) {
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

	public void addCountry(Country tempcountry) {

		if (country == null) {
			country = new ArrayList<Country>();
		}
		country.add(tempcountry);
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
	
	
}
