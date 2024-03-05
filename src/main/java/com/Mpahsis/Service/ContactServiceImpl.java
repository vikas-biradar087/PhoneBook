package com.Mpahsis.Service;

import java.util.List;

import java.util.stream.Collectors;
//import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.Mpahsis.Entity.Contact;
import com.Mpahsis.Exception.ResourceNotFoundException;
import com.Mpahsis.Payload.ContactDto;
import com.Mpahsis.Repository.ContactRepository;

@Service
public class ContactServiceImpl implements Contactservice {

	private ContactRepository contactRepository;
	public ContactServiceImpl(ContactRepository contactRepository, ModelMapper modMapper) {
		super();
		this.contactRepository = contactRepository;
		this.modMapper = modMapper;
	}

	private ModelMapper modMapper;
	
	@Override
	public ContactDto createContact(ContactDto contactDto) {
		
		
		
		//Convert dto to entity
		
		Contact contact=mapToEntity(contactDto);
		Contact newContact = contactRepository.save(contact);
		
		
		//convert entity to dto 
		ContactDto newResponce = mapToDTO(newContact);
		return newResponce;
		
		//if (contactDto.getId() !=null){
		
			//return "contact Saved"//
		
		//}else{return "contact Failed To save"}
	}
	
	
	//Convert dto to entity
	private Contact mapToEntity(ContactDto contactDto) {
		Contact contact = modMapper.map(contactDto, Contact.class);
		return contact;
		
	}
	
	//convert entity to dto 
	private ContactDto mapToDTO(Contact contact) {
		ContactDto contactDto = modMapper.map(contact, ContactDto.class);
		return contactDto;
	}

	@Override
	public List<ContactDto> fetchAllContact() {
		List<Contact> getAll= contactRepository.findAll();
		List<ContactDto> contactList = getAll.stream().map((x)-> modMapper.map(x, ContactDto.class)).collect(Collectors.toList());
//		List<ContactDto> collect = getAll.stream().map(p->mapToDTO(p)).collect(Collectors.toList());
		return contactList;
		
		
	}


	@Override
	public ContactDto updateContact(long id, ContactDto contactDto) {
	
		Contact ContactUpdate = contactRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact", "id", id));
		
		ContactUpdate.setName(contactDto.getName());
		ContactUpdate.setEmail(contactDto.getEmail());
		ContactUpdate.setNumber(contactDto.getNumber());
		
		Contact saveUpdatedContact = contactRepository.save(ContactUpdate);
		
		return mapToDTO(saveUpdatedContact);
		
		
		/**
		 * if(contactRepository.existsById(contactDto.getContactById())){
		 * contactrepo.save(contact)
		 * return "update success"
		 * }else{
		 * 		return "no record found"
		 * }
		 */
		
	}


	@Override
	public void deleteContact(Long id) {
		Contact ContactDelete = contactRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Contact", "id", id));
		this.contactRepository.delete(ContactDelete);
	}


	@Override
	public List<Contact> findContactByName(String name) {
		
		return contactRepository.findByName(name);
		
//		List<ContactDto> ListName = Name.stream().map((s)-> modMapper.map(s, ContactDto.class)).collect(Collectors.toList());
//
//		retrun ListName;
	}


	@Override
	public ContactDto getContactById(long id) {
		
		Contact contactId = contactRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact", "id", id));
		return mapToDTO(contactId);
		
		
		//if(contactId.isPresent()){
		//return findById.get();//
		//return null//
	}


	

}
