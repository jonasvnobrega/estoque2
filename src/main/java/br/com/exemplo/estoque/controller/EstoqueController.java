package br.com.exemplo.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.estoque.model.ProdutoModelo;
import br.com.exemplo.estoque.service.EstoqueServico;

@RestController
@CrossOrigin("*")
public class EstoqueController {

    @Autowired
    private EstoqueServico es;

    @GetMapping("/")
    public void testeApi() {
        System.out.println("A API está funcionado!");

      
    }

     @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar() {
    return es.listar();

}
@GetMapping("/listar/{id}")
public ResponseEntity<ProdutoModelo> buscarPorId(@PathVariable Long id) {
    ProdutoModelo produto = es.buscarPorId(id);

    if (produto != null) {
        return ResponseEntity.ok(produto);
    } else {
        return ResponseEntity.notFound().build();
    }
}
}
