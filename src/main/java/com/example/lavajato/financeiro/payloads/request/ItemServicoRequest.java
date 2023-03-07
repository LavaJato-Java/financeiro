package com.example.lavajato.financeiro.payloads.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItemServicoRequest {
    @NotNull
    private ServicoRequest servico;
    @Min(value = 1, message = "Informe um valor válido para o preço do servico")
    private double preco;
    @Min(value = 1, message = "Informe um valor válido para a quantidade do servico")
    private int quantidade;
}