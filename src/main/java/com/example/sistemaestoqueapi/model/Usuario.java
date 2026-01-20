package com.example.sistemaestoqueapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    private String nome;

    private String cargo;

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCargo() { return cargo; }

    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

}