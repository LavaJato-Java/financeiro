package com.example.lavajato.financeiro.payloads.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ServicoRequest {
    @NotEmpty(message = "O id do serviço é requerido")
    private String id;

    private String tipoServico;
}
