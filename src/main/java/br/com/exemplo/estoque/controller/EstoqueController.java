package br.com.exemplo.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.estoque.model.ProdutoModelo;
import br.com.exemplo.estoque.service.EstoqueServico;

@RestController
@CrossOrigin("*")
public class EstoqueController {

    @Autowired
    private EstoqueServico es;

    // Teste da API
    @GetMapping("/")
    public void testeApi() {
        System.out.println("A API está funcionando!");
    }

    // LISTAR TODOS
    @GetMapping("/produtos")
    public Iterable<ProdutoModelo> listar() {
        return es.listar();
    }

    // LISTAR POR ID
    @GetMapping("/produtos/{id}")
    public ResponseEntity<ProdutoModelo> buscarPorId(@PathVariable Long id) {
        ProdutoModelo produto = es.buscarPorId(id);

        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // CADASTRAR
    @PostMapping("/produtos")
    public ResponseEntity<ProdutoModelo> cadastrar(@RequestBody ProdutoModelo produto) {
        ProdutoModelo novo = es.cadastrar(produto);
        return ResponseEntity.ok(novo);
    }

    // ATUALIZAR
    @PutMapping("/produtos/{id}")
    public ResponseEntity<ProdutoModelo> atualizar(
            @PathVariable Long id,
            @RequestBody ProdutoModelo dados) {

        ProdutoModelo atualizado = es.atualizar(id, dados);

        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETAR
    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean deletou = es.deletar(id);

        if (deletou) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}