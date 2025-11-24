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

    // CADASTRAR
    public ProdutoModelo cadastrar(ProdutoModelo produto) {
        return pr.save(produto);
    }

    // ATUALIZAR
    public ProdutoModelo atualizar(Long id, ProdutoModelo dados) {
        ProdutoModelo existente = pr.findById(id).orElse(null);

        if (existente != null) {
            existente.setNome(dados.getNome());
            existente.setDescricao(dados.getDescricao());
            existente.setModelo(dados.getModelo());
            existente.setPreco(dados.getPreco());
            return pr.save(existente);
        }

        return null;
    }

    // DELETAR
    public boolean deletar(Long id) {
        if (pr.existsById(id)) {
            pr.deleteById(id);
            return true;
        }
        return false;
    }
}
