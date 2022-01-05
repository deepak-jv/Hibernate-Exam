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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ManyToAny;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Language language;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "capitalCity_id")
	private City capital;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinTable(name = "country_sport",joinColumns = @JoinColumn(name="country_id"),
	inverseJoinColumns = @JoinColumn(name="sport_id"))
	private List<Sport> sport;
	
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Country(String name, Language language, City capital, List<Sport> sport) {
		super();
		this.name = name;
		this.language = language;
		this.capital = capital;
		this.sport = sport;
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
	
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public City getCapital() {
		return capital;
	}
	public void setCapital(City capital) {
		this.capital = capital;
	}
	public List<Sport> getSport() {
		return sport;
	}
	public void setSport(List<Sport> sport) {
		this.sport = sport;
	}

	
	public List<Sport> addSport(Sport tempsport) {
		if(sport==null) {
			sport = new ArrayList<Sport>(); 
			
		}
		sport.add(tempsport);
		return sport;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", language=" + language + ", capital=" + capital + ", sport="
				+ sport + "]";
	}

	
	
	
	
}
