package com.neogedom.professorvacancies.services;

import com.neogedom.professorvacancies.domain.Aluno;
import com.neogedom.professorvacancies.domain.Professor;
import com.neogedom.professorvacancies.dto.NewProfessorDTO;
import com.neogedom.professorvacancies.repository.InteresseRepository;
import com.neogedom.professorvacancies.repository.ProfessorRepository;
import com.neogedom.professorvacancies.security.UserSS;
import com.neogedom.professorvacancies.services.exceptions.ObjectNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final InteresseRepository interesseRepository;
    private final BCryptPasswordEncoder pe;

    public ProfessorService(ProfessorRepository professorRepository,
                            InteresseRepository interesseRepository, BCryptPasswordEncoder pe) {
        this.professorRepository = professorRepository;
        this.interesseRepository = interesseRepository;
        this.pe = pe;
    }

    public Professor getById(String id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                        id + " Tipo: " + Professor.class.getName()));
    }

    @Transactional
    public Professor create (@NotNull Professor professor) {
        if (professor.getInteressesDePesquisa().isEmpty()) {
            return professorRepository.save(professor);
        }
        professor.setInteressesDePesquisa(interesseRepository.saveAll(professor.getInteressesDePesquisa()));
        return professorRepository.save(professor);
    }



    public Professor authenticated() {
        return fromUserSS((UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    public Professor fromDTO (@NotNull NewProfessorDTO newProfessorDTO) {
        return new Professor(newProfessorDTO.getId(), newProfessorDTO.getNome(), newProfessorDTO.getInteresseDePesquisa(), newProfessorDTO.getEmail(), pe.encode(newProfessorDTO.getSenha()));
    }

    private Professor fromUserSS (UserSS userSS) {
        return  getById(userSS.getId());
    }
}
