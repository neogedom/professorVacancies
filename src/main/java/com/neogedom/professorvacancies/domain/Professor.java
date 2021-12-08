package com.neogedom.professorvacancies.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @Document @AllArgsConstructor
public class Professor {
    @Id
    private String id;
    private String nome;
    private String interesseDePesquisa;
}
