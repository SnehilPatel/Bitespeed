package com.Bitespeed.BackendTask.bean;

public class ConsolidatedContactResponse {
    private ConsolidatedContact contact;

    public ConsolidatedContactResponse(ConsolidatedContact contact) {
        this.contact = contact;
    }

    public ConsolidatedContact getContact() {
        return contact;
    }

    public void setContact(ConsolidatedContact contact) {
        this.contact = contact;
    }
}
