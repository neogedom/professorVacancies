package com.neogedom.professorvacancies.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Data
public class Interesse {
    @Id
    public String id;
    public String nome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interesse interesse = (Interesse) o;
        return nome.equals(interesse.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
