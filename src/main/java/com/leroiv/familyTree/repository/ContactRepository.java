package com.leroiv.familyTree.repository;

import com.leroiv.familyTree.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository  extends JpaRepository<Contact, Long> {
}
