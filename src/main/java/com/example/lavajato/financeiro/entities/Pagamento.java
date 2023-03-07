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
@Table(name = "Pagamento")
@NamedEntityGraph(name = "Pagamento.items", attributeNodes = @NamedAttributeNode("items"))
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;

    @CreatedDate
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "pagamento", cascade = {CascadeType.PERSIST})
    private List<Item> items;

    public void adicionarItems(List<Item> items) {
        items.forEach(item->item.setPagamento(this));
        if(Objects.isNull(this.items)){
            this.items = new ArrayList<>();
        }
        this.items.addAll(items);
    }
}