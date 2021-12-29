package com.neogedom.professorvacancies.repository;

import com.neogedom.professorvacancies.domain.Orientacao;
import com.neogedom.professorvacancies.domain.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrientacaoRepository extends MongoRepository<Orientacao, String> {

    @Transactional(readOnly = true)
    List<Orientacao> findAllByProfessor(Professor professor);
}
