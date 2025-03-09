package com.journal.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.journal.app.entity.JournalEntry;
@Repository
public interface JournalEntryRepository extends JpaRepository<JournalEntry,Long>{

}