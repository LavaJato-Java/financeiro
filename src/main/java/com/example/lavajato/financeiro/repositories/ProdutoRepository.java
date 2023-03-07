package com.example.lavajato.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lavajato.financeiro.entities.Produto;

import java.util.Optional;

public interface ProdutoRepository  extends JpaRepository<Produto, String> {
    Optional<Produto> findById(String id);
}