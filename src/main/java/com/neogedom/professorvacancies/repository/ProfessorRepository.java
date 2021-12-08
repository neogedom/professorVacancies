package com.neogedom.professorvacancies.repository;

import com.neogedom.professorvacancies.domain.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends MongoRepository<Professor, String> {
}
