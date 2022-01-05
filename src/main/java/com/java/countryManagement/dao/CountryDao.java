package com.java.countryManagement.dao;

import java.sql.SQLException;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.java.countryManagement.model.Country;
import com.java.countryManagement.util.HibernateUtil;

public class CountryDao {

	HibernateUtil util = new HibernateUtil();

	public Country getById(int id) throws SQLException {

		Session session = util.getSessionFactory().openSession();
		session.beginTransaction();
		Country country = session.get(Country.class, id);
		session.getTransaction().commit();
		return country;
	}

	public Criteria getCriteria() throws SQLException {
		Session session = util.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Country.class);
		Criterion id = Restrictions.ge("id", 1);
		Projection ids = Projections.property("id");
		Projection name = Projections.property("name");
		ProjectionList plist = Projections.projectionList();
		plist.add(ids);
		plist.add(name);
		criteria.setProjection(plist);
		session.getTransaction().commit();
		return criteria;
		

	}

}
