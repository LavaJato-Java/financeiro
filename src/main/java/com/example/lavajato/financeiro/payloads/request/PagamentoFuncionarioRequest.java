package com.example.lavajato.financeiro.payloads.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PagamentoFuncionarioRequest {
    @NotNull
    private FuncionarioRequest funcionario;

    @NotNull
    private double salario;

}

