package com.contact.manager.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.contact.manager.model.Contact;
import com.contact.manager.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	/**
	 * this method will display dashboard page with list of available contacts
	 * 
	 * @param map
	 * @return
	 */
	@GetMapping(value = "/dashboard.htm")
	public String viewHomePage(Map<String, Object> map) {
		map.put("contactList", contactService.getAllContact());
		return "index";
	}

	/**
	 * this method will add new contact to the db
	 * 
	 * @param map
	 * @return
	 */
	@GetMapping(value = "/addNewContact")
	public String addNewContact(Map map) {
		Contact contact = new Contact();
		map.put("contact", contact);
		return "new_contact";
	}

	/**
	 * this method will save the new contact to the database
	 * 
	 * @param contact
	 * @param errors
	 * @return
	 */
	@PostMapping(value = "/saveContact")
	public String saveContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult errors) {
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "new_contact";
		}
		contactService.saveContact(contact);
		return "redirect:/dashboard.htm";
	}

	/**
	 * this method will update the existing contact
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@GetMapping("/updateContact/{id}")
	public String updateContact(@PathVariable("id") long id, Map<String, Object> map) {
		Contact contact = contactService.getContactById(id);

		map.put("contact", contact);
		return "update_contact";
	}

	/**
	 * this method will delete the contact
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable("id") long id) {
		contactService.deleteContactById(id);
		return "redirect:/dashboard.htm";
	}
	
	@GetMapping("/detailsContact/{id}")
	public String contactDetails(@PathVariable("id") long id, Map<String, Object> map) {
		Contact contact = contactService.getContactById(id);

		map.put("contact", contact);
		return "details_contact";
	}
}
