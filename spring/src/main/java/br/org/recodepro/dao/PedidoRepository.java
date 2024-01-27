package br.org.recodepro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.recodepro.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}