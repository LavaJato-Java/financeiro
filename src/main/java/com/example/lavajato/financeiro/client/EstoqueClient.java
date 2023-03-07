package com.example.lavajato.financeiro.client;

import com.example.lavajato.financeiro.client.payload.request.EnviarEstoque;
import com.example.lavajato.financeiro.client.payload.request.EstoqueRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
@Slf4j
public class EstoqueClient {

    @Value("${business.estoque.url}")
    private String url;

    @Async
    public void solicitarCadastroEstoque(EstoqueRequest estoqueRequest){
        WebClient webClient = WebClient.create();
        Mono<EstoqueRequest> estoqueRequestMono =  webClient.post().uri(url)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(estoqueRequest), EstoqueRequest.class)
                .retrieve().bodyToMono(EstoqueRequest.class);
        estoqueRequestMono.subscribe(respostaEstoque -> log.info("retorno do estoque {}", respostaEstoque));

    }
}