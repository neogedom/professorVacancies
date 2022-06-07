package com.neogedom.professorvacancies.resources;

import com.neogedom.professorvacancies.domain.Professor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/professor")
@RequiredArgsConstructor
public class ProfessorResource {

    @Autowired
    @NonNull  ProfessorService professorService;

    @GetMapping
    public String getAll () {
      return "REST funciona";
    }

    @PostMapping
    public ResponseBody<Void> create (@RequestBody Professor professor) {
        professorService.create(professor);

        return ResponseEntity.created(new URI(String.valueOf()));
    }

}
