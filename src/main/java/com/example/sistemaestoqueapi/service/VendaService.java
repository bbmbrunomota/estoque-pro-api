package com.example.sistemaestoqueapi.service;

import com.example.sistemaestoqueapi.model.Produto;
import com.example.sistemaestoqueapi.model.Venda;
import com.example.sistemaestoqueapi.repository.ProdutoRepository;
import com.example.sistemaestoqueapi.repository.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Venda registrarVenda(Long produtoId, int qtd, String vendedor) { // Adicione String vendedor aqui
        Produto p = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (p.getQuantidade() < qtd) throw new RuntimeException("Estoque insuficiente");

        p.setQuantidade(p.getQuantidade() - qtd);
        produtoRepository.save(p);

        Venda v = new Venda(p.getNome(), qtd, p.getPreco() * qtd);
        v.setVendedor(vendedor);

        return vendaRepository.save(v);
    }

    public List<Venda> listarTodas() {
        return vendaRepository.findAll();
    }
}