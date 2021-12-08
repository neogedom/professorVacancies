package com.neogedom.professorvacancies.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @Document @RequiredArgsConstructor @AllArgsConstructor @NoArgsConstructor
public class Professor {
    @Id
    @NonNull private String id;
    @NonNull private String nome;
    @NonNull private String interesseDePesquisa;
    private Orientacao orientacao;
}
