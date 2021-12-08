package com.neogedom.professorvacancies.domain;

import com.neogedom.professorvacancies.domain.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document @Data @AllArgsConstructor @NoArgsConstructor
public class Orientacao {

    @Id
    private String id;
    @Field
    private Tipo tipo;
    private Periodo periodoInscricao;
    private Professor professor;
}
