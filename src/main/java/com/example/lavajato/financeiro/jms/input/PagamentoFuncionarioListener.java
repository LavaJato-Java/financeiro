package com.example.lavajato.financeiro.jms.input;


import com.example.lavajato.financeiro.services.SalvarPagamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.lavajato.financeiro.payloads.request.PagamentoFuncionarioRequest;

@Service
@RequiredArgsConstructor
@Slf4j
public class PagamentoFuncionarioListener {

    private final SalvarPagamentoService salvarPagamentoService;

    @KafkaListener(topics = "${business.mensagem.entrada.pagamento_funcionario}", groupId = "${spring.kafka.consumer.group-id}")
    public void receive(PagamentoFuncionarioRequest request){
        log.info("Recebendo uma nova requisição para pagamento do funcionario {}", request);
        salvarPagamentoService.executeFuncionario(request);
    }
}


