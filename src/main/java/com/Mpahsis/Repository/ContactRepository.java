package com.Mpahsis.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.Mpahsis.Entity.Contact;

public interface ContactRepository extends JpaRepositoryImplementation<Contact, Long> {

	
	List<Contact> findByName(String name);
	
}
