package com.example.lavajato.financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lavajato.financeiro.entities.Cliente;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
    Optional<Cliente> findById(String id);
}


