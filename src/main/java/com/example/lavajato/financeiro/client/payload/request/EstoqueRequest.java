package com.example.lavajato.financeiro.client.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class EstoqueRequest {
    private String nome;
    private String marca;
    private String unidade;
    @JsonProperty("quantidade_unidade")
    private double quantidadeDaUnidade;

    private UUID id;

    @JsonProperty("quantidade")
    private long quantidadeAdicionada;
}
