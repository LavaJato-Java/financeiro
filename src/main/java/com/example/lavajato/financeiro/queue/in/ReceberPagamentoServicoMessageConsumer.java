package com.example.lavajato.financeiro.queue.in;


import com.example.lavajato.financeiro.payloads.request.PagamentoServicoRequest;
import com.example.lavajato.financeiro.services.SalvarPagamentoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReceberPagamentoServicoMessageConsumer {
    private final ObjectMapper objectMapper;
    private final SalvarPagamentoService pagamentoService;
    @RabbitListener(queues = {"${business.message.queue.pagamento_servico}"})
    public void receiveMessage(String message) throws JsonProcessingException {
        PagamentoServicoRequest pagamentoServicoRequest = objectMapper.readValue(message, PagamentoServicoRequest.class);
        pagamentoService.executeServico(pagamentoServicoRequest);
    }
}

