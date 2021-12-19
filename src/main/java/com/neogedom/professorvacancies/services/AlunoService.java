package com.neogedom.professorvacancies.services;

import com.neogedom.professorvacancies.domain.Aluno;
import com.neogedom.professorvacancies.dto.NewAlunoDTO;
import com.neogedom.professorvacancies.repository.AlunoRepository;
import com.neogedom.professorvacancies.security.UserSS;
import com.neogedom.professorvacancies.services.exceptions.ObjectNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public Aluno getById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                        id + " Tipo: " + Aluno.class.getName()));
    }

    public Aluno authenticated() {
        return fromUserSS((UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    public Aluno fromDTO (NewAlunoDTO alunoDTO) {
        return new Aluno(alunoDTO.getId(), alunoDTO.getNome(), alunoDTO.getTelefone(), alunoDTO.getEmail(), pe.encode(alunoDTO.getSenha()));
    }

    private Aluno fromUserSS (UserSS userSS) {
        return  getById(userSS.getId());
    }

}
