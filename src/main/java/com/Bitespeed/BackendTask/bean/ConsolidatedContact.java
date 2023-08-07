package com.Bitespeed.BackendTask.bean;

import java.util.List;

public class ConsolidatedContact {
	private Long primaryContactId;
	private String[] emails;
	private String[] phoneNumbers;
	private List<Long> secondaryContactIds;

	public Long getPrimaryContactId() {
		return primaryContactId;
	}

	public void setPrimaryContactId(Long primaryContactId) {
		this.primaryContactId = primaryContactId;
	}

	public String[] getEmails() {
		return emails;
	}

	public void setEmails(String[] emails) {
		this.emails = emails;
	}

	public String[] getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(String[] phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<Long> getSecondaryContactIds() {
		return secondaryContactIds;
	}

	public void setSecondaryContactIds(List<Long> secondaryContactIds) {
		this.secondaryContactIds = secondaryContactIds;
	}

	public ConsolidatedContact(Long primaryContactId, String[] emails, String[] phoneNumbers, List<Long> secondaryContactIds) {
        this.primaryContactId = primaryContactId;
        this.emails = emails;
        this.phoneNumbers = phoneNumbers;
        this.secondaryContactIds = secondaryContactIds;
    }
}