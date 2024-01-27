package br.org.recodepro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.recodepro.model.ProdutoPedido;

public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido, Integer> {
}