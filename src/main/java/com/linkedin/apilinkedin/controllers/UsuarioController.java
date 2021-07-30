package com.linkedin.apilinkedin.controllers;

import com.linkedin.apilinkedin.entities.Usuario;
import com.linkedin.apilinkedin.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criarUsuario(@RequestBody Usuario usuario){
        return usuarioService.postUsuario(usuario);
    }


}
