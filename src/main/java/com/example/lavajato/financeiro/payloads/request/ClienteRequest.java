package com.example.lavajato.financeiro.payloads.request;

import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
public class ClienteRequest {

    private String id;

    private String cpf;
    private String nomeCliente;


}
