package com.example.lavajato.financeiro.services;


import com.example.lavajato.financeiro.entities.PagamentoServico;
import com.example.lavajato.financeiro.payloads.response.RelatorioServicos;
import com.example.lavajato.financeiro.repositories.PagamentoServicoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.lavajato.financeiro.entities.Pagamento;
import com.example.lavajato.financeiro.payloads.response.RelatorioFornecedor;
import com.example.lavajato.financeiro.repositories.PagamentoRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SomaPedidosPorServicoService {
    private final PagamentoServicoRepository pagamentoServicoRepository;
    @Cacheable(cacheNames = "rlservico", key ="#idServico" )
    public RelatorioServicos execute(String idServico){

        log.info("Relatorio de servicos invocado");
        List<PagamentoServico> pagamentos = pagamentoServicoRepository.findByServicoId(idServico);
        RelatorioServicos relatorioServicos = new RelatorioServicos();
        relatorioServicos.setId(idServico);
        relatorioServicos.setValor(pagamentos.stream().flatMap(pagamento -> pagamento.getItemsServico().stream())
                .map(item -> item.getQuantidade()*item.getPreco()).reduce(0.0, Double::sum));
        return relatorioServicos;
    }
}



