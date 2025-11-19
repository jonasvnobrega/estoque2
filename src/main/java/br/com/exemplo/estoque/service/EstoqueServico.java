package br.com.exemplo.estoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exemplo.estoque.model.ProdutoModelo;
import br.com.exemplo.estoque.repository.ProdutoRepositorio;

@Service
public class EstoqueServico {

@Autowired 
private ProdutoRepositorio pr;

 public Iterable<ProdutoModelo> listar(){

    return pr.findAll();

}

 public ProdutoModelo buscarPorId(Long id) {
        return pr.findById(id).orElse(null);
    }

}
