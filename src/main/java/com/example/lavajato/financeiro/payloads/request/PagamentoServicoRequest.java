package com.example.lavajato.financeiro.payloads.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PagamentoServicoRequest {
    @NotNull
    private ServicoRequest servico;

    @NotNull
    private ClienteRequest cliente;

    @NotNull
    private List<ItemServicoRequest> itemsServico;

}
