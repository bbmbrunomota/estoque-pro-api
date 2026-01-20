package com.example.sistemaestoqueapi.controller;

import com.example.sistemaestoqueapi.exception.RecursoNaoEncontradoException;
import com.example.sistemaestoqueapi.model.Produto;
import com.example.sistemaestoqueapi.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Produto> listar(@RequestParam(required = false) String nome) {
        List<Produto> resultado;
        if (nome != null && !nome.isEmpty()) {
            resultado = repository.findByNomeContainingIgnoreCase(nome);
        } else {
            resultado = repository.findAll();
        }
        return resultado;
    }

    @PatchMapping("/{id}/venda")
    public ResponseEntity<?> venderProduto(@PathVariable Long id, @RequestBody Map<String, Integer> payload) {
        int quantidadeVendida = payload.get("quantidade");

        return repository.findById(id).map(produto -> {
            if (produto.getQuantidade() < quantidadeVendida) {
                return ResponseEntity.badRequest().body("Estoque insuficiente!");
            }
            produto.setQuantidade(produto.getQuantidade() - quantidadeVendida);
            repository.save(produto);
            return ResponseEntity.ok(produto);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Produto produto) {

        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("O nome do produto é obrigatório!");
        }
        if (produto.getPreco() <= 0) {
            return ResponseEntity.badRequest().body("O preço deve ser maior que zero!");
        }

        Produto salvo = repository.save(produto);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> editar(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        return repository.findById(id)
                .map(produto -> {
                    produto.setNome(produtoAtualizado.getNome());
                    produto.setPreco(produtoAtualizado.getPreco());
                    produto.setQuantidade(produtoAtualizado.getQuantidade());
                    return ResponseEntity.ok(repository.save(produto));
                })
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado para edição."));
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Não foi possível excluir. Produto com ID " + id + " não existe.");
        }
        repository.deleteById(id);
    }
}