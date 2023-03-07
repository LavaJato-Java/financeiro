package com.example.lavajato.financeiro.payloads.request;

import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
public class FornecedorRequest {

    private String cnpj;
    private String nomeFornecedor;

    private String id;
}