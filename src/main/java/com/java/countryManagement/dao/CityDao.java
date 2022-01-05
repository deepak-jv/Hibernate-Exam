package com.java.countryManagement.dao;

import org.hibernate.Session;

import com.java.countryManagement.model.City;
import com.java.countryManagement.model.Country;
import com.java.countryManagement.util.HibernateUtil;

public class CityDao {

	HibernateUtil util = new HibernateUtil();



	

	public City getById(int id) {

		Session session = util.getSessionFactory().openSession();
		session.beginTransaction();
		City city = session.get(City.class, id);
		session.getTransaction().commit();
		return city;
	}

}
