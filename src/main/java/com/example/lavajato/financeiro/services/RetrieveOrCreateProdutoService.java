package com.example.lavajato.financeiro.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.lavajato.financeiro.entities.Produto;
import com.example.lavajato.financeiro.repositories.ProdutoRepository;

@Service
@RequiredArgsConstructor
public class RetrieveOrCreateProdutoService {
    private final ProdutoRepository produtoRepository;
    public Produto execute(Produto produto){
        return produtoRepository.findById(produto.getId())
                .orElse(produtoRepository.save(produto));
    }
}


