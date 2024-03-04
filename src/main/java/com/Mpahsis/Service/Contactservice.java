package com.Mpahsis.Service;

import java.util.List;

import com.Mpahsis.Entity.Contact;
import com.Mpahsis.Payload.ContactDto;

public interface Contactservice {
	
	ContactDto createContact(ContactDto contactDto);
	
	List<ContactDto> fetchAllContact();
	
	void deleteContact(Long id);
	
	ContactDto updateContact(long id,ContactDto contactDto);
	
	
	List<Contact> findContactByName(String name);
	
	ContactDto getContactById(long id);
	

}
