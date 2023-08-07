package com.Bitespeed.BackendTask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bitespeed.BackendTask.bean.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact findByEmailOrPhoneNumber(String email, String phoneNumber);
    
    List<Contact> findByEmailOrPhoneNumberOrderByLinkPrecedenceDesc(String email, String phoneNumber);
}
