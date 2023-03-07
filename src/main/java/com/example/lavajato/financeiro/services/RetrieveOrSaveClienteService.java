package com.example.lavajato.financeiro.services;

import com.example.lavajato.financeiro.entities.Cliente;
import com.example.lavajato.financeiro.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetrieveOrSaveClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente execute(Cliente cliente){
        return clienteRepository.findById(cliente.getId())
                .orElse(clienteRepository.save(cliente));
    }
}

