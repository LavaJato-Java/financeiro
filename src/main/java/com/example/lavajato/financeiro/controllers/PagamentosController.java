package com.example.lavajato.financeiro.controllers;

import com.example.lavajato.financeiro.payloads.request.PagamentoFuncionarioRequest;
import com.example.lavajato.financeiro.payloads.request.PagamentoServicoRequest;
import com.example.lavajato.financeiro.payloads.response.RelatorioServicos;
import com.example.lavajato.financeiro.services.SalvarPagamentoService;
import com.example.lavajato.financeiro.services.SomaPedidosPorFornecedorService;
import com.example.lavajato.financeiro.services.SomaPedidosPorServicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.lavajato.financeiro.payloads.request.PagamentoFornecedorRequest;
import com.example.lavajato.financeiro.payloads.response.RelatorioFornecedor;

@RestController
@RequestMapping("/pagamento")
@RequiredArgsConstructor
@Slf4j
public class PagamentosController {

    private final SalvarPagamentoService salvarPagamentoService;
    private final SomaPedidosPorFornecedorService somaPedidosPorFornecedorService;

    private final SomaPedidosPorServicoService somaPedidosPorServicoService;

    @PostMapping(path = "/fornecedor")
    @ResponseStatus(HttpStatus.CREATED)
    public void realizarPagamentoFornecedor(@RequestBody PagamentoFornecedorRequest pagamentoFornecedorRequest){
        log.info("Requisição de pagamento recebido {}",pagamentoFornecedorRequest);
        salvarPagamentoService.execute(pagamentoFornecedorRequest);
    }

    @PostMapping(path = "/funcionario")
    @ResponseStatus(HttpStatus.CREATED)
    public void realizarPagamentoFuncionario(@RequestBody PagamentoFuncionarioRequest pagamentoFuncionarioRequest){
        log.info("Requisição de pagamento recebido {}",pagamentoFuncionarioRequest);
        salvarPagamentoService.executeFuncionario(pagamentoFuncionarioRequest);
    }

    @PostMapping(path = "/servico")
    @ResponseStatus(HttpStatus.CREATED)
    public void realizarPagamentoServico(@RequestBody PagamentoServicoRequest pagamentoServicoRequest){
        log.info("Requisição de pagamento recebido {}",pagamentoServicoRequest);
        salvarPagamentoService.executeServico(pagamentoServicoRequest);
    }


    @GetMapping(path = "/relatorio/{idFornecedor}")
    public RelatorioFornecedor getRelatorioFornecedor(@PathVariable String idFornecedor){
        return somaPedidosPorFornecedorService.execute(idFornecedor);
    }

    @GetMapping(path = "/relatorio/{idServico}")
    public RelatorioServicos getRelatorioServicos(@PathVariable String idServico){
        return somaPedidosPorServicoService.execute(idServico);
    }
}