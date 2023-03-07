package com.example.lavajato.financeiro.client.payload.request;


import lombok.Data;

import java.util.UUID;

@Data
public class FinanceiroEstoqueRequest {

    private String cnpj;
    private String razaoSocial;

    private UUID id;
}


