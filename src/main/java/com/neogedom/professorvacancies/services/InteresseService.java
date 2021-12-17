package com.neogedom.professorvacancies.services;

import com.neogedom.professorvacancies.domain.Interesse;
import com.neogedom.professorvacancies.repository.InteresseRepository;
import com.neogedom.professorvacancies.services.exceptions.ObjectNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class InteresseService {

    private final InteresseRepository interesseRepository;

    public InteresseService(InteresseRepository interesseRepository) {
        this.interesseRepository = interesseRepository;
    }

    public Interesse getById(@NotNull String id) {
        return interesseRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                        id + " Tipo: " + Interesse.class.getName()));
    }

    public Interesse create (@NotNull Interesse interesse) {
        return interesseRepository.save(interesse);
    }



}
