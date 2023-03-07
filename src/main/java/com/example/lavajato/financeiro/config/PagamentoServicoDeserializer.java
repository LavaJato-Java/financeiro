package com.example.lavajato.financeiro.config;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.context.annotation.Configuration;
import com.example.lavajato.financeiro.payloads.request.PagamentoServicoRequest;

import java.nio.charset.StandardCharsets;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class PagamentoServicoDeserializer implements Deserializer<PagamentoServicoRequest> {

    private final ObjectMapper objectMapper;

    @Override
    public PagamentoServicoRequest deserialize(String s, byte[] bytes) {
        log.info("Deserializando um objeto no tópico {}", s);
        String message = new String(bytes, StandardCharsets.UTF_8);
        try {
            return objectMapper.readValue(message, PagamentoServicoRequest.class);
        } catch (JsonProcessingException e) {
            log.error("Não foi possível converter a mensagem no objeto desejado");
            return null;
        }

    }

    public PagamentoServicoDeserializer(){
        this.objectMapper = new ObjectMapper();
    }
}


