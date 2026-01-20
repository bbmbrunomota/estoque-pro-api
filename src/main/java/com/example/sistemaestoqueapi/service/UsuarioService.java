package com.example.sistemaestoqueapi.service;

import com.example.sistemaestoqueapi.model.Usuario;
import com.example.sistemaestoqueapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }
}