package com.example.lavajato.financeiro.client;

import com.example.lavajato.financeiro.client.payload.request.EnviarEstoque;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class EstoqueClient {

    @Value("${business.estoque.url}")
    private String url;
    public void enviarEstoque(EnviarEstoque enviarEstoque ){
        WebClient webClient = WebClient.create();
        webClient.post().uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(enviarEstoque), EnviarEstoque.class)
                .retrieve().bodyToMono(Void.class).block();
    }
}