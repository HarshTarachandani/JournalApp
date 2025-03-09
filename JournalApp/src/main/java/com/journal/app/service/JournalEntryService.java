package com.journal.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.journal.app.entity.JournalEntry;
import com.journal.app.repository.JournalEntryRepository;
@Component
public class JournalEntryService {

	@Autowired
	JournalEntryRepository journalEntryRepository;
	
	public Optional<JournalEntry> getById(Long id)
	{
		return journalEntryRepository.findById(id);
	}
	
	public void addJournalEntry(JournalEntry journalEntry)
	{
		journalEntryRepository.save(journalEntry);
	}
	
	public void updateJournalEntry(JournalEntry journalEntry)
	{
		journalEntryRepository.save(journalEntry);
	}

	public void deleteJournalEntry(Long id)
	{
		journalEntryRepository.deleteById(id);
	}
	
	public List<JournalEntry> getAll()
	{
		return journalEntryRepository.findAll();
	}
	
	
	
}
