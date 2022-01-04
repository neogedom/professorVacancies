package com.neogedom.professorvacancies.repository;

import com.neogedom.professorvacancies.domain.Professor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends MongoRepository<Professor, String> {
    @Query(value="{ '_class' : 'com.neogedom.professorvacancies.domain.Professor'," +
            "'orientacoes' : {'$exists': true, $type: array, $not: {$size: 0}}}")
    Page<Professor> findAllProfessors(PageRequest pageRequest);
}
