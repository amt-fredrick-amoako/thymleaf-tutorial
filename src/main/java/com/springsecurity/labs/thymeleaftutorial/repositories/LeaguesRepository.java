package com.springsecurity.labs.thymeleaftutorial.repositories;

import com.springsecurity.labs.thymeleaftutorial.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaguesRepository extends JpaRepository<League, String> {
}
