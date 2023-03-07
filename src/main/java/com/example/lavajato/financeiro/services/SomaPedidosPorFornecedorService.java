package com.example.lavajato.financeiro.services;

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
public class SomaPedidosPorFornecedorService {
    private final PagamentoRepository pagamentoRepository;
    @Cacheable(cacheNames = "rlfornecedor", key ="#idFornecedor" )
    public RelatorioFornecedor execute(String idFornecedor){

        log.info("Relatorio do fornecedor invocado");
        List<Pagamento> pagamentos = pagamentoRepository.findByFornecedorId(idFornecedor);
        RelatorioFornecedor relatorioFornecedor = new RelatorioFornecedor();
        relatorioFornecedor.setId(idFornecedor);
        relatorioFornecedor.setValor(pagamentos.stream().flatMap(pagamento -> pagamento.getItems().stream())
                .map(item -> item.getQuantidade()*item.getPreco()).reduce(0.0, Double::sum));
        return relatorioFornecedor;
    }
}
