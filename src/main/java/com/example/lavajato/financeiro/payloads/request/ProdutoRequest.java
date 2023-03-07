package com.example.lavajato.financeiro.payloads.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ProdutoRequest {
    @NotEmpty(message = "O id do produto é requerido")
    private String id;
    private String nome;
}