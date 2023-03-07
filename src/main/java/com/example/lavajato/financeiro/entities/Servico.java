package com.example.lavajato.financeiro.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Data
@Entity
@Table(name = "Servico")
public class Servico {
    @Id
    private UUID id;

    @Column(name = "tipo_servico")
    private String tipoServico;

}
