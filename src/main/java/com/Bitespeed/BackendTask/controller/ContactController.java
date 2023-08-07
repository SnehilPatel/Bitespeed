package com.Bitespeed.BackendTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bitespeed.BackendTask.bean.ConsolidatedContactResponse;
import com.Bitespeed.BackendTask.bean.ContactRequest;
import com.Bitespeed.BackendTask.service.ContactService;

@RestController
@RequestMapping("/identify")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<ConsolidatedContactResponse> identifyContact(@RequestBody ContactRequest request) {
        ConsolidatedContactResponse response = contactService.identifyContact(request);
        return ResponseEntity.ok(response);
    }
}
