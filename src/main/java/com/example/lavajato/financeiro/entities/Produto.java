package com.example.lavajato.financeiro.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Data
@Entity
@Table(name = "Produto")
public class Produto {
    @Id
    private UUID id;

    private String nome;

}