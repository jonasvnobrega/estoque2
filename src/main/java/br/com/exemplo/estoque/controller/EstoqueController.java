package br.com.exemplo.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.estoque.model.ProdutoModelo;
import br.com.exemplo.estoque.service.EstoqueServico;

@RestController
@CrossOrigin("*")
public class EstoqueController {

    @Autowired
    private EstoqueServico es;

    @GetMapping("/listar")
    public void testeApi() {
        System.out.println("A API está funcionado!");

      
    }

     @GetMapping("/teste")
    public Iterable<ProdutoModelo> listar() {
    return es.listar();

}
}
