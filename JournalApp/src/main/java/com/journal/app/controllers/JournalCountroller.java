package com.journal.app.controllers;

import java.util.List;
 import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journal.app.entity.JournalEntry;
import com.journal.app.service.JournalEntryService;


@RestController
@RequestMapping("/journal")
public class JournalCountroller {

	@Autowired
	JournalEntryService journalEntryService;	
	
	@GetMapping
	public ResponseEntity<?> getAllJournalEntry()
	{
		List<JournalEntry> list=journalEntryService.getAll();
		return new ResponseEntity<>(list,HttpStatus.OK);		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getJournalEntryById(@PathVariable Long id)
	{
		Optional<JournalEntry> optional=journalEntryService.getById(id);
		if(!optional.isEmpty()) return new ResponseEntity<>(optional.get(),HttpStatus.OK);
		return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping
	public ResponseEntity<?> addJournalEntryById(@RequestBody JournalEntry journalEntry)
	{
		Long id=journalEntry.getId();
		Optional<JournalEntry> optional=journalEntryService.getById(id);
		if(optional.isPresent())
			return new ResponseEntity<>(optional.get(),HttpStatus.BAD_REQUEST);
			
		journalEntryService.addJournalEntry(journalEntry);

		return new ResponseEntity<>(journalEntry,HttpStatus.CREATED);
		
	}
	
	@PutMapping
	public ResponseEntity<?> updateJournalEntry(@RequestBody JournalEntry journalEntry)
	{
		Long id=journalEntry.getId();
		Optional<JournalEntry> optional=journalEntryService.getById(id);
		if(!optional.isPresent())
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
			
		journalEntryService.updateJournalEntry(journalEntry);

		return new ResponseEntity<>(journalEntry,HttpStatus.OK);
		
	}
	
	
}
