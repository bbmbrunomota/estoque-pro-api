package com.example.sistemaestoqueapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidade;


    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
}