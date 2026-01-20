package com.example.sistemaestoqueapi.controller;

import com.example.sistemaestoqueapi.model.Usuario;
import com.example.sistemaestoqueapi.repository.UsuarioRepository;
import com.example.sistemaestoqueapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }
}