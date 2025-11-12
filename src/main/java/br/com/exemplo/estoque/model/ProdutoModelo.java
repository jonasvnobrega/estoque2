package br.com.exemplo.estoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_produtos")
@Getter
@Setter
public class ProdutoModelo {
    
    @Id
    private Long id;

    private String nome;
    private String descricao;
    private String modelo;
    private Double preco;
}
