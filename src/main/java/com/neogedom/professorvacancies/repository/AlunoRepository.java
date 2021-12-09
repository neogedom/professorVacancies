package com.neogedom.professorvacancies.repository;

import com.neogedom.professorvacancies.domain.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String> {
}
