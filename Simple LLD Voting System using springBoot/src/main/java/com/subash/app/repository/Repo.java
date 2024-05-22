package com.subash.app.repository;

import com.subash.app.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Person, Long> {

}
