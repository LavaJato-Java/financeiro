package com.example.lavajato.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lavajato.financeiro.entities.Servico;

import java.util.Optional;

public interface ServicoRepository  extends JpaRepository<Servico, String> {
    Optional<Servico> findById(String id);
}