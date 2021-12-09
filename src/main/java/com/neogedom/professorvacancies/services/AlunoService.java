package com.neogedom.professorvacancies.services;

import com.neogedom.professorvacancies.domain.Aluno;
import com.neogedom.professorvacancies.dto.AlunoDTO;
import com.neogedom.professorvacancies.repository.AlunoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository repo;

    public AlunoService(AlunoRepository repo) {
        this.repo = repo;
    }

    public Aluno create (Aluno aluno) {
        return repo.save(aluno);
    }

    public Aluno fromDTO (@NotNull AlunoDTO alunoDTO) {
        return new Aluno(alunoDTO.getId(), alunoDTO.getNome(), alunoDTO.getEmail(), alunoDTO.getTelefone());
    }
}
