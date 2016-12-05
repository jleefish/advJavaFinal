package ca.sheridancollege.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.sheridancollege.beans.Contact;
import ca.sheridancollege.beans.User;
import ca.sheridancollege.dao.DAO;


@Controller
public class HomeController {
	
	DAO dao = new DAO();
	
	
	@RequestMapping("/delete/{id}")
	public String deleteContact(Model model, @PathVariable int id){
		
		Contact contact = dao.findByContactId(id);		
		dao.deleteContact(contact);		
		
		ArrayList<Contact> contactList = dao.getContacts();	
		model.addAttribute(contactList);
		
		return "contactList";
	}
	
	@RequestMapping("/edit/{id}")
	public String editContact(Model model, @PathVariable int id){
		
		Contact contact = dao.findByContactId(id);
		dao.deleteContact(contact);
		model.addAttribute(contact);		
		
		return "addContact";
	}
	
	
	@RequestMapping("/contactlist")
	public String showCantacts(Model model){
		
		ArrayList<Contact> contactList = dao.getContacts();
		
		
		System.out.println("list size: "+contactList.size());
		for (Contact contact : contactList) {
			System.out.println(contact.getName());
		}		
		
		model.addAttribute(contactList);
		
		return "contactList";
	}
	
	
	@RequestMapping("/fill")
	public String fill(Model model, @ModelAttribute Contact contact){
		dao.generateContact();
		contact = new Contact();
		model.addAttribute(contact);
		return "addContact";
	}
	
	@RequestMapping("/")
	public String showHome(Model model){		
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "addContact";
	}
	
	@RequestMapping("/savecontact")
	public String saveContact(Model model, @ModelAttribute Contact contact){
				
		dao.addContact(contact);
		contact = new Contact();
		model.addAttribute(contact);
		
		return "addContact";
	}
	
//	@RequestMapping("/secure")
//	public String showSecure(Model model){
//		
//		return "secure";
//	}
}
