package com.example.lavajato.financeiro.repositories;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.lavajato.financeiro.entities.PagamentoServico;

import java.util.List;

public interface PagamentoServicoRepository extends JpaRepository<PagamentoServico, String> {
    @EntityGraph(value = "PagamentoServico.items")
        //@Query("Select p from Pagamento p join p.fornecedor f join p.items i where f.identificador = :identificador ")

    List<PagamentoServico> findByServicoId(String idServico);
}

