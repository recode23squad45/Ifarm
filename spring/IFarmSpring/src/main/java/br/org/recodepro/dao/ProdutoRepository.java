package br.org.recodepro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.recodepro.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}