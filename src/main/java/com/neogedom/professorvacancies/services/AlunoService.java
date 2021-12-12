package com.neogedom.professorvacancies.services;

import com.neogedom.professorvacancies.domain.Aluno;
import com.neogedom.professorvacancies.dto.NewAlunoDTO;
import com.neogedom.professorvacancies.repository.AlunoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository repo;
    private final BCryptPasswordEncoder pe;

    public AlunoService(AlunoRepository repo, BCryptPasswordEncoder pe) {
        this.repo = repo;
        this.pe = pe;
    }

    public Aluno create (Aluno aluno) {
        return repo.save(aluno);
    }

    public Aluno fromDTO (@NotNull NewAlunoDTO alunoDTO) {
        return new Aluno(alunoDTO.getId(), alunoDTO.getNome(), alunoDTO.getTelefone(), alunoDTO.getEmail(), pe.encode(alunoDTO.getSenha()));
    }
}
