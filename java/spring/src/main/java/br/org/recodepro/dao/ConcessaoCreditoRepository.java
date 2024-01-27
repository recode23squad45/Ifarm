package br.org.recodepro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.recodepro.model.ConcessaoCredito;

public interface ConcessaoCreditoRepository extends JpaRepository<ConcessaoCredito, Integer> {
}