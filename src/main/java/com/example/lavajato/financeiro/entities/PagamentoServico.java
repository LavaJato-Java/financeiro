package com.example.lavajato.financeiro.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@Entity
@Table(name = "PagamentoServico")
@NamedEntityGraph(name = "PagamentoServico.itemsServico", attributeNodes = @NamedAttributeNode("itemsServico"))
public class PagamentoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;

    @CreatedDate
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "pagamentoServico", cascade = {CascadeType.PERSIST})
    private List<ItemServico> itemsServico;

    public void adicionarItemsServico(List<ItemServico> itemsServico) {
        itemsServico.forEach(item->item.setPagamentoServico(this));
        if(Objects.isNull(this.itemsServico)){
            this.itemsServico = new ArrayList<>();
        }
        this.itemsServico.addAll(itemsServico);
    }
}
