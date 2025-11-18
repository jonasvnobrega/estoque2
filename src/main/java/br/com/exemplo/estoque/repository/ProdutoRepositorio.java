package br.com.exemplo.estoque.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.exemplo.estoque.model.ProdutoModelo;

public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Long> {
    
}
