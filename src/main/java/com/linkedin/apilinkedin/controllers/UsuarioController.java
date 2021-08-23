package com.linkedin.apiexemplo.controllers;

import com.linkedin.apiexemplo.entities.Usuario;
import com.linkedin.apiexemplo.exceptions.UsuarioNotFoundedException;
import com.linkedin.apiexemplo.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/usuario")
public class UsuarioController {
    @Autowired
    DbService dbService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criarUsuario(@RequestBody @Validated Usuario usuario){
        return dbService.postUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> getUsuario(){
        return dbService.getUsuario();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(dbService.getUsuarioById(id).orElseThrow(() ->
                new UsuarioNotFoundedException("Usuario com ID: " + id + "Não foi Encontrado!!!!")));
    }

    @PutMapping("/{id}")
    public Object putUsuario(@PathVariable Long id, @RequestBody Usuario usuario) throws UsuarioNotFoundedException {
        try {
            return dbService.putUsario(usuario);
        }catch (Exception ex){
            return ("Usuario com ID: " + id + "Não foi Encontrado!!!!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id) throws UsuarioNotFoundedException{
        try {
            dbService.deleteUsuario(id);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return ResponseEntity.ok().build();
    }

}
