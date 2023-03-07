package com.example.lavajato.financeiro.payloads.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PagamentoFornecedorRequest {
    @NotNull
    private FornecedorRequest fornecedor;

    @NotNull
    private List<ItemRequest> items;

}