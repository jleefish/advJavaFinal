package ca.sheridancollege.dao;

import org.hibernate.*;

import org.hibernate.boot.registry.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.*;

import ca.sheridancollege.beans.User;

import java.util.List;
import java.util.ArrayList;


public class DAO {

	// Grabs our config settings, configures hibernate to use them,
	// and builds a session factory we can use to open a database
	// session with.
	SessionFactory sessionFactory = new Configuration().configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();
	
	public User findByUserName(String username) {
		List<User> users = sessionFactory.openSession()
			.createQuery("from User where username=:user")
			.setParameter("user", username)
			.list();

		if (users.size() > 0) return users.get(0);
		else return null;
	}
	
//	public User findByUserName(String username) {
//		List<User> users = sessionFactory.openSession().createQuery("from User where username=:user")​​​.setParameter("user", username)​​​.list();
//		​​if (users.size() > 0) return users.get(0);
//		​​else return null;
//	}	
}
