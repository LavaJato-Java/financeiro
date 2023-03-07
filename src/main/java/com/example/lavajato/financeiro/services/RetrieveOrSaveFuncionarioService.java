package com.example.lavajato.financeiro.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.lavajato.financeiro.entities.Funcionario;
import com.example.lavajato.financeiro.repositories.FuncionarioRepository;

@Service
@RequiredArgsConstructor
public class RetrieveOrSaveFuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public Funcionario execute(Funcionario funcionario){
        return funcionarioRepository.findById(funcionario.getId())
                .orElse(funcionarioRepository.save(funcionario));
    }
}


