package com.java.countryManagement.dao;

import java.util.List;

import org.hibernate.Session;

import com.java.countryManagement.model.Country;
import com.java.countryManagement.model.Sport;
import com.java.countryManagement.util.HibernateUtil;

public class SportDao {

	HibernateUtil util = new HibernateUtil();

	public void save(Sport sport1) {

		Session session = util.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(sport1);
		session.getTransaction().commit();

	}

	public void update(Sport sport) {

		Session session = util.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(sport);
		session.getTransaction().commit();

	}

	public void delete(int id) {

		Session session = util.getSessionFactory().openSession();
		session.beginTransaction();
		Sport sport = session.get(Sport.class, id);
		if (sport != null) {
			session.delete(sport);
			System.out.println("country is deleted");
			session.getTransaction().commit();
		}

	}

	public Sport getById(int id) {

		Session session = util.getSessionFactory().openSession();
		session.beginTransaction();
		Sport sport = session.get(Sport.class, id);
		session.getTransaction().commit();
		return sport;
	}

}
