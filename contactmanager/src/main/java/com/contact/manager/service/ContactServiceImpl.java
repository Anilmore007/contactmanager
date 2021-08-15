package com.contact.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.manager.exception.GenericException;
import com.contact.manager.model.Contact;
import com.contact.manager.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	/**
	 * this method fetch all the contacts from the db
	 */
	@Override
	public List<Contact> getAllContact() {
		return contactRepository.findAll();
	}

	/**
	 * this method will send new contact
	 */
	@Override
	public void saveContact(Contact contact) {
		contactRepository.save(contact);
	}

	/**
	 * this method will get contact by Id
	 */
	@Override
	public Contact getContactById(long id) {
		Optional<Contact> optionalEntity = contactRepository.findById(id);
		Contact contact = null;

		if (optionalEntity.isPresent()) {
			contact = optionalEntity.get();
		} else {
			throw new GenericException("Contact Not Found with Id ::" + id);
		}
		return contact;
	}

	/**
	 * this method will delete the contact
	 */
	@Override
	public void deleteContactById(long id) {
		contactRepository.deleteById(id);
	}

}
