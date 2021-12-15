package com.neogedom.professorvacancies.services;

import com.neogedom.professorvacancies.repository.UsuarioRepository;
import com.neogedom.professorvacancies.security.UserSS;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UsuarioRepository repo;

    public UserDetailsServiceImpl(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        var user = repo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
        return new UserSS(user.getId(), user.getEmail(), user.getSenha(), user.getPerfis());

    }
}
