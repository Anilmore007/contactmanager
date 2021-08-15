package com.contact.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contact.manager.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
