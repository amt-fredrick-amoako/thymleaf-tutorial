package com.springsecurity.labs.thymeleaftutorial.repositories;

import com.springsecurity.labs.thymeleaftutorial.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
}
