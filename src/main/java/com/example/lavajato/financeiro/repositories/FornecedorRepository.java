package com.example.lavajato.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lavajato.financeiro.entities.Fornecedor;

import java.util.Optional;

public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {
    Optional<Fornecedor> findById(String id);
}
