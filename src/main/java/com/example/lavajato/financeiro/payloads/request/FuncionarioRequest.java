package com.example.lavajato.financeiro.payloads.request;

import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
public class FuncionarioRequest {

    private String cpf;
    private String nomeFuncionario;

    private String id;
}


