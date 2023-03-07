package com.example.lavajato.financeiro.payloads.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItemRequest {
    @NotNull
    private ProdutoRequest produto;
    @Min(value = 1, message = "Informe um valor válido para o preço do produto")
    private double preco;
    @Min(value = 1, message = "Informe um valor válido para a quantidade do produto")
    private int quantidade;
}