package com.Mpahsis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mpahsis.Entity.Contact;
import com.Mpahsis.Payload.ApiResponse;
import com.Mpahsis.Payload.ContactDto;
import com.Mpahsis.Service.Contactservice;

@RestController
@RequestMapping("/Contact/Api")
public class ContactController {
	
	@Autowired
	private Contactservice contactservice;
	
	
	
	@PostMapping("/")
	public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto contactDto){
		
		ContactDto createContact = contactservice.createContact(contactDto);
		
		return new ResponseEntity<>(createContact,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<ContactDto>> fetchAll(){
		
		List<ContactDto> fetchAllContact = contactservice.fetchAllContact();
		
		return ResponseEntity.ok(fetchAllContact);
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<ContactDto> updateContact(@PathVariable("id") long id,@RequestBody ContactDto contactDto){
		
		ContactDto contactUpdate = contactservice.updateContact(id, contactDto);
		
		return ResponseEntity.ok(contactUpdate);
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> delteContact(@PathVariable("id") long id){
		
		contactservice.deleteContact(id);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Contact deleted successfully !!!", true),HttpStatus.OK);
		
	}
	//http://localhost:8080/Contact/Api/vikas
	@GetMapping("/{name}")
	public ResponseEntity<List<Contact>> getAllName(@PathVariable("name") String name){
		List<Contact> byName = contactservice.findContactByName(name);
		
		return ResponseEntity.ok(byName);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContactDto> getContactById(@PathVariable("id") long id){
		 ContactDto byId = contactservice.getContactById(id);
		 
		 return ResponseEntity.ok(byId);
	}

}
