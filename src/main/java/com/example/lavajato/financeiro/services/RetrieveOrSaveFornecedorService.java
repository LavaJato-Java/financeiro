package com.example.lavajato.financeiro.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.lavajato.financeiro.entities.Fornecedor;
import com.example.lavajato.financeiro.repositories.FornecedorRepository;

@Service
@RequiredArgsConstructor
public class RetrieveOrSaveFornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public Fornecedor execute(Fornecedor fornecedor){
        return fornecedorRepository.findById(fornecedor.getId())
                .orElse(fornecedorRepository.save(fornecedor));
    }
}

