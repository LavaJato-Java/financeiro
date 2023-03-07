package com.example.lavajato.financeiro.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.lavajato.financeiro.entities.PagamentoFuncionario;

import java.util.List;

public interface PagamentoFuncionarioRepository extends JpaRepository<PagamentoFuncionario, String> {
    //@EntityGraph(value = "PagamentoFuncionario.items")
        //@Query("Select p from Pagamento p join p.fornecedor f join p.items i where f.identificador = :identificador ")

    List<PagamentoFuncionario> findByFuncionarioId(String idFuncionario);
}