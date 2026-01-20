package com.example.sistemaestoqueapi.controller;

import com.example.sistemaestoqueapi.model.Venda;
import com.example.sistemaestoqueapi.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vendas")
@CrossOrigin("*")
public class VendaController {

    @Autowired
    private VendaService service;

    @PostMapping
    public Venda realizarVenda(@RequestBody Map<String, Object> payload) {
        Long produtoId = Long.valueOf(payload.get("produtoId").toString());
        Integer quantidade = (Integer) payload.get("quantidade");

        // Pegamos o vendedor do payload (que enviamos no React como 'vendedor')
        String vendedor = (String) payload.get("vendedor");

        // Passamos o vendedor para o service
        return service.registrarVenda(produtoId, quantidade, vendedor);
    }
    @GetMapping
    public List<Venda> listarHistorico() {
        return service.listarTodas();
    }
}