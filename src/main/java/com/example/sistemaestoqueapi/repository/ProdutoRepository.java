package com.example.sistemaestoqueapi.repository;

import com.example.sistemaestoqueapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNomeContainingIgnoreCase(String nome);
}