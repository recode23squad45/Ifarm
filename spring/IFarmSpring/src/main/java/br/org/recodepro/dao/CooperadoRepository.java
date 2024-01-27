package br.org.recodepro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.recodepro.model.Cooperado;

public interface CooperadoRepository extends JpaRepository<Cooperado, String> {
}