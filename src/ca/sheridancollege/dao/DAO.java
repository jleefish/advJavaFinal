package ca.sheridancollege.dao;

import org.hibernate.*;

import org.hibernate.boot.registry.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.*;

import ca.sheridancollege.beans.Contact;
import ca.sheridancollege.beans.User;

import java.util.List;
import java.util.ArrayList;


public class DAO {

	// Grabs our config settings, configures hibernate to use them,
	// and builds a session factory we can use to open a database
	// session with.
	SessionFactory sessionFactory = new Configuration().configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();
	
	public void generateContact() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		for(int i = 0; i < 10 ; i++) {
			Contact contact = new Contact("name "+i, "number "+i, "Address "+i, "Email "+i, ((new Contact()).getRoles())[i%3]);			
			session.save(contact);
		}
				
		// Commit the transaction and close the session
		session.getTransaction().commit();
		session.close();
	}
	
	public void addContact(Contact contact){
		// Open a session and begin a transaction
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				
				session.save(contact);
						
				// Commit the transaction and close the session
				session.getTransaction().commit();
				session.close();
		
	}
	
	public Contact findByContactId(int id) {
		List<Contact> contacts = sessionFactory.openSession()
			.createQuery("from Contact where id=:id")
			.setParameter("id", id)
			.list();

		if (contacts.size() > 0) return contacts.get(0);
		else return null;
	}
	
	public User findByUserName(String username) {
		List<User> users = sessionFactory.openSession()
			.createQuery("from User where username=:user")
			.setParameter("user", username)
			.list();

		if (users.size() > 0) return users.get(0);
		else return null;
	}

	public ArrayList<Contact> getContacts() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Contact.class);
		
		ArrayList<Contact> contactList = (ArrayList<Contact>)criteria.list();
		
//		for (Contact contact : contactList) {
//			System.out.println(contact.getName());
//		}
		
		session.getTransaction().commit();
		session.close();
		
		return contactList;
	}

	public void deleteContact(Contact contact) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.delete(contact);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
//	public User findByUserName(String username) {
//		List<User> users = sessionFactory.openSession().createQuery("from User where username=:user")​​​.setParameter("user", username)​​​.list();
//		​​if (users.size() > 0) return users.get(0);
//		​​else return null;
//	}	
}
