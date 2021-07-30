package com.linkedin.apilinkedin.services;

import com.linkedin.apilinkedin.entities.Usuario;
import com.linkedin.apilinkedin.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    IUsuarioRepository iUsuarioRepository;

    @Autowired
    public UsuarioService(IUsuarioRepository iUsuarioRepository) {
        this.iUsuarioRepository = iUsuarioRepository;
    }

    public Usuario postUsuario(Usuario usuario) {
        return iUsuarioRepository.save(usuario);
    }
}
