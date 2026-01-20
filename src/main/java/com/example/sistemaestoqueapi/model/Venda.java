package com.example.sistemaestoqueapi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "historico_vendas")
@Data
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProduto;
    private Integer quantidade;
    private Double valorTotal;
    private LocalDateTime dataVenda;
    private String vendedor;

    public Venda() {}

    public String getVendedor() { return vendedor; }
    public void setVendedor(String vendedor) { this.vendedor = vendedor; }

    public Venda(String nomeProduto, Integer quantidade, Double valorTotal) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.dataVenda = LocalDateTime.now();
    }
}