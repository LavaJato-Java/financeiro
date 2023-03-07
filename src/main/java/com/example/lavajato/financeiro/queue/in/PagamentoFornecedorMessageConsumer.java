package com.example.lavajato.financeiro.queue.in;


import com.example.lavajato.financeiro.services.SalvarPagamentoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.example.lavajato.financeiro.payloads.request.PagamentoFornecedorRequest;

@Component
@RequiredArgsConstructor
public class PagamentoFornecedorMessageConsumer {
    private final ObjectMapper objectMapper;
    private final SalvarPagamentoService pagamentoService;
    @RabbitListener(queues = {"${business.message.queue.pagamento_fornecedor}"})
    public void receiveMessage(String message) throws JsonProcessingException {
        PagamentoFornecedorRequest pagamentoFornecedorRequest = objectMapper.readValue(message, PagamentoFornecedorRequest.class);
        pagamentoService.execute(pagamentoFornecedorRequest);
    }
}
