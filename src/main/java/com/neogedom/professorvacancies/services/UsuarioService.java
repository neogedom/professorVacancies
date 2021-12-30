package com.neogedom.professorvacancies.services;

import com.neogedom.professorvacancies.domain.Usuario;
import com.neogedom.professorvacancies.repository.UsuarioRepository;
import com.neogedom.professorvacancies.security.UserSS;
import com.neogedom.professorvacancies.services.exceptions.ObjectNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario getById(String id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +
                        id + " Tipo: " + Usuario.class.getName()));
    }


    public Usuario authenticated() {
        return fromUserSS((UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    private Usuario fromUserSS (UserSS userSS) {
        return  getById(userSS.getId());
    }
}
