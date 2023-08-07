package com.Bitespeed.BackendTask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Bitespeed.BackendTask.bean.ConsolidatedContact;
import com.Bitespeed.BackendTask.bean.ConsolidatedContactResponse;
import com.Bitespeed.BackendTask.bean.Contact;
import com.Bitespeed.BackendTask.bean.ContactRequest;
import com.Bitespeed.BackendTask.repository.ContactRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Transactional
	public ConsolidatedContactResponse identifyContact(ContactRequest request) {
		Contact existingContact = contactRepository.findByEmailOrPhoneNumber(request.getEmail(),
				request.getPhoneNumber());

		if (existingContact == null) {
			Contact newContact = new Contact();
			newContact.setEmail(request.getEmail());
			newContact.setPhoneNumber(request.getPhoneNumber());
			newContact.setLinkPrecedence("primary");
			newContact.setLinkedId(null);
			contactRepository.save(newContact);

			return new ConsolidatedContactResponse(
					new ConsolidatedContact(newContact.getId(), new String[] { newContact.getEmail() },
							new String[] { newContact.getPhoneNumber() }, new ArrayList<>()));
		} else {
			List<Contact> matchingContacts = contactRepository.findByEmailOrPhoneNumberOrderByLinkPrecedenceDesc(
					existingContact.getEmail(), existingContact.getPhoneNumber());

			Contact primaryContact = matchingContacts.stream()
					.filter(contact -> "primary".equals(contact.getLinkPrecedence())).findFirst().orElse(null);

			List<Contact> secondaryContacts = matchingContacts.stream()
					.filter(contact -> "secondary".equals(contact.getLinkPrecedence())).collect(Collectors.toList());

			List<Long> secondaryContactIds = secondaryContacts.stream().map(Contact::getId)
					.collect(Collectors.toList());

			if (primaryContact != null) {
				secondaryContacts.forEach(contact -> contact.setLinkedId(primaryContact.getId()));

				return new ConsolidatedContactResponse(new ConsolidatedContact(primaryContact.getId(),
						matchingContacts.stream().map(Contact::getEmail).toArray(String[]::new),
						matchingContacts.stream().map(Contact::getPhoneNumber).toArray(String[]::new),
						secondaryContactIds));
			} else {
				Contact firstSecondaryContact = secondaryContacts.get(0);
				firstSecondaryContact.setLinkPrecedence("primary");

				secondaryContacts.stream().skip(1)
						.forEach(contact -> contact.setLinkedId(firstSecondaryContact.getId()));

				return new ConsolidatedContactResponse(new ConsolidatedContact(firstSecondaryContact.getId(),
						matchingContacts.stream().map(Contact::getEmail).toArray(String[]::new),
						matchingContacts.stream().map(Contact::getPhoneNumber).toArray(String[]::new),
						secondaryContactIds));
			}
		}
	}
}
