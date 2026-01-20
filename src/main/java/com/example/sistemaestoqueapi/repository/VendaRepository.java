package com.example.sistemaestoqueapi.repository;

import com.example.sistemaestoqueapi.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}