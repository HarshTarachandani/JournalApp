package com.journal.app.entity;


import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Component
@Data
@Entity
public class JournalEntry {
@Id
@Column(name="journal_id")
private long id;
private String title;
private String content;

@ManyToOne
@JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
private User user;


public JournalEntry() {
	super();
}

public JournalEntry(long id, String title, String content) {
	super();
	this.id = id;
	this.title = title;
	this.content = content;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}

public void setUser(User user)
{
	this.user=user;
}
public User getUser()
{
	return this.user;
}
}
