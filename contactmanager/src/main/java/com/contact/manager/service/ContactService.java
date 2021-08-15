package com.contact.manager.service;

import java.util.List;

import com.contact.manager.model.Contact;

public interface ContactService {
	
	List<Contact> getAllContact();
	void saveContact(Contact contact);
	Contact getContactById(long id);
	void deleteContactById(long id);

}
