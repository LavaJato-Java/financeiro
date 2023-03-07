package com.example.lavajato.financeiro.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.lavajato.financeiro.entities.*;
import com.example.lavajato.financeiro.repositories.*;

@Service
@RequiredArgsConstructor
public class SavePagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final PagamentoFuncionarioRepository pagamentoFuncionarioRepository;
    private final PagamentoServicoRepository pagamentoServicoRepository;

    public Pagamento executar(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }

    public PagamentoFuncionario executarFuncionario(PagamentoFuncionario pagamentoFuncionario){
        return pagamentoFuncionarioRepository.save(pagamentoFuncionario);
    }

    public PagamentoServico executarServico(PagamentoServico pagamentoServico){
        return pagamentoServicoRepository.save(pagamentoServico);
    }
}