package com.journal.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
@Id
private String username;
private String password;

private String role;

@OneToMany
private List<JournalEntry> journalEntries=new ArrayList<>();


public List<JournalEntry> getJournalEntries() {
	return journalEntries;
}
public void setJournalEntries(List<JournalEntry> journalEntries) {
	this.journalEntries = journalEntries;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}


}
