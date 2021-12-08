package com.neogedom.professorvacancies.repository;

import com.neogedom.professorvacancies.domain.Orientacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrientacaoRepository extends MongoRepository<Orientacao, String> {
}
