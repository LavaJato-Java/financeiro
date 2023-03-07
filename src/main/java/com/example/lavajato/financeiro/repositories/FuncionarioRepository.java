package com.example.lavajato.financeiro.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lavajato.financeiro.entities.Funcionario;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {
    Optional<Funcionario> findById(String id);
}

