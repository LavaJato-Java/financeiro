package com.example.lavajato.financeiro.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "Funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String cpf;

    @Column(name = "nome_funcionario")
    private String nomeFuncionario;

    private double salario;

}


