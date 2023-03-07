package com.example.lavajato.financeiro.queue.in;


import com.example.lavajato.financeiro.services.SalvarPagamentoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.example.lavajato.financeiro.payloads.request.PagamentoFuncionarioRequest;

@Component
@RequiredArgsConstructor
public class PagamentoFuncionarioMessageConsumer {
    private final ObjectMapper objectMapper;
    private final SalvarPagamentoService pagamentoService;
    @RabbitListener(queues = {"${business.message.queue.pagamento_funcionario}"})
    public void receiveMessage(String message) throws JsonProcessingException {
        PagamentoFuncionarioRequest pagamentoFuncionarioRequest = objectMapper.readValue(message, PagamentoFuncionarioRequest.class);
        pagamentoService.executeFuncionario(pagamentoFuncionarioRequest);
    }
}
