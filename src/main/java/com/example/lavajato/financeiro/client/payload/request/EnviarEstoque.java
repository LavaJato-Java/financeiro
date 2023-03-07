package com.example.lavajato.financeiro.client.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class EnviarEstoque {
    @NotNull
    private FinanceiroEstoqueRequest estoque;

    @NotNull
    private List<ItemRequest> items;
}
