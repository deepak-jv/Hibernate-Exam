package com.java.countryManagement.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.countryManagement.model.City;
import com.java.countryManagement.model.Country;
import com.java.countryManagement.model.Language;
import com.java.countryManagement.model.Sport;



public class HibernateUtil {
	
	private static SessionFactory session_factory;

	public static SessionFactory getSessionFactory() throws HibernateException{

	Configuration cfg = new Configuration();
	try {
		session_factory=cfg.addAnnotatedClass(City.class)
				.addAnnotatedClass(Country.class)
				.addAnnotatedClass(Language.class)
				.addAnnotatedClass(Sport.class)
				.configure("com/java/hibernate/configuration/hibernate.cfg.xml")
				.buildSessionFactory();
	} catch (HibernateException e) {
		e.printStackTrace();
	}
	
	
		return session_factory;
	

	}
}
