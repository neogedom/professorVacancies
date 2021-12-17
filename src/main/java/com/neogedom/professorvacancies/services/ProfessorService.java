package com.neogedom.professorvacancies.services;

import com.neogedom.professorvacancies.domain.Professor;
import com.neogedom.professorvacancies.dto.NewProfessorDTO;
import com.neogedom.professorvacancies.repository.InteresseRepository;
import com.neogedom.professorvacancies.repository.ProfessorRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

    public Professor create (@NotNull Professor professor) {
        if (professor.getInteressesDePesquisa().isEmpty()) {
            return professorRepository.save(professor);
        }
        professor.setInteressesDePesquisa(interesseRepository.saveAll(professor.getInteressesDePesquisa()));
        return professorRepository.save(professor);

    }

    public Professor fromDTO (@NotNull NewProfessorDTO newProfessorDTO) {
        return new Professor(newProfessorDTO.getId(), newProfessorDTO.getNome(), newProfessorDTO.getInteresseDePesquisa(), newProfessorDTO.getEmail(), pe.encode(newProfessorDTO.getSenha()));
    }
}
