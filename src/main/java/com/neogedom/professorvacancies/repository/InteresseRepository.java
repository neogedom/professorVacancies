package com.neogedom.professorvacancies.repository;

import com.neogedom.professorvacancies.domain.Interesse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteresseRepository extends MongoRepository<Interesse, String> {
    List<Interesse> findByNome(String nome);
}
