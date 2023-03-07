package com.example.lavajato.financeiro.services;

import com.example.lavajato.financeiro.entities.Servico;
import com.example.lavajato.financeiro.repositories.ServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetrieveOrCreateServicoService {
    private final ServicoRepository servicoRepository;
    public Servico execute(Servico servico){
        return servicoRepository.findById(servico.getId())
                .orElse(servicoRepository.save(servico));
    }
}


