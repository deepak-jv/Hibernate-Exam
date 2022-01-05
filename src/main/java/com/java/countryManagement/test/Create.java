package com.java.countryManagement.test;

import org.hibernate.cfg.Configuration;

import com.java.countryManagement.model.City;
import com.java.countryManagement.model.Country;
import com.java.countryManagement.model.Language;
import com.java.countryManagement.model.Sport;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Create {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		SessionFactory session_factory = cfg.addAnnotatedClass(City.class)
				.addAnnotatedClass(Country.class)
				.addAnnotatedClass(Language.class)
				.addAnnotatedClass(Sport.class)
				.configure("com/java/hibernate/configuration/hibernate.cfg.xml")
				.buildSessionFactory();
		Session session = session_factory.openSession();
		session.beginTransaction();
		
		try {
			
//			====Sport===
			Sport sport1 = new Sport();
			sport1.setName("cricket");
			
			Sport sport2 = new Sport();
			sport2.setName("basketball");
			
			Sport sport3 = new Sport();
			sport3.setName("football");
					
			
//			====City====
			City city1 = new City();
			city1.setName("Delhi");
			
			City city2 = new City();
			city2.setName("Washington");
			
			City city3 = new City();
			city3.setName("Maxico city");
			
			City city4 = new City();
			city4.setName("Rio");
			
			City city5 = new City();
			city5.setName("cannbra");
			
			
//			=====language====
			Language lang1 = new Language();
			lang1.setName("Hindi");
			
			Language lang2 = new Language();
			lang2.setName("English");
			
			Language lang3 = new Language();
			lang3.setName("French");
			
	
			
			
//			====Country====	
			Country country1 = new Country();
			country1.setName("India");
			country1.setCapital(city1);
			country1.addSport(sport1);
	
			Country country2 = new Country();
			country2.setName("Usa");
			country2.setCapital(city2);
			country2.setLanguage(lang2);
			country2.addSport(sport2);
			
			Country country3 = new Country();
			country3.setName("Maxico");
			country3.setCapital(city3);
			country3.addSport(sport3);
			
			Country country4 = new Country();
			country4.setName("Brazil");
			country4.setCapital(city4);
			country4.addSport(sport1);
			
			Country country5 = new Country();
			country5.setName("Australia");
			country5.setCapital(city5);
			country5.addSport(sport2);
			
//			---------------------------------------
			sport3.addCountry(country2);
			sport3.addCountry(country1);
			lang3.addcountry(country1);
			lang3.addcountry(country3);
			lang2.addcountry(country4);
			lang1.addcountry(country5);
			lang1.addcountry(country1);
			
			
			session.save(sport1);
			session.save(sport2);
			session.save(sport3);
			session.save(city1);
			session.save(city2);
			session.save(city3);
			session.save(city4);
			session.save(city5);
			session.save(lang1);
			session.save(lang2);
			session.save(lang3);
			session.save(country1);
			session.save(country2);
			session.save(country3);
			session.save(country4);
			session.save(country5);
			
	
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			session.close();
			session_factory.close();
		}
		
		
		
		
		
	}

}
