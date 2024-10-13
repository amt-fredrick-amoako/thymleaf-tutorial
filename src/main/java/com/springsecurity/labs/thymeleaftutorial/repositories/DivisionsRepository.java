package com.springsecurity.labs.thymeleaftutorial.repositories;

import com.springsecurity.labs.thymeleaftutorial.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionsRepository extends JpaRepository<Division, Long> {
}
