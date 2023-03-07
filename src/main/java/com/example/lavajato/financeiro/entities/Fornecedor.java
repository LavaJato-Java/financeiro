package com.example.lavajato.financeiro.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "Fornecedor")
public class Fornecedor {

    @Id
    private UUID id;

    private String cnpj;

    @Column(name = "nome_fornecedor")
    private String nomeFornecedor;

}