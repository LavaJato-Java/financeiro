package com.example.lavajato.financeiro.services;

import com.example.lavajato.financeiro.entities.*;
import com.example.lavajato.financeiro.payloads.request.*;
import com.example.lavajato.financeiro.repositories.PagamentoFuncionarioRepository;
import com.example.lavajato.financeiro.repositories.PagamentoServicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import com.example.lavajato.financeiro.repositories.PagamentoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalvarPagamentoService {

    private final RetrieveOrCreateProdutoService retrieveOrCreateProdutoService;

    private final RetrieveOrCreateServicoService retrieveOrCreateServicoService;
    private final RetrieveOrSaveFornecedorService retrieveOrSaveFornecedorService;

    private final RetrieveOrSaveFuncionarioService retrieveOrSaveFuncionarioService;

    private final RetrieveOrSaveClienteService retrieveOrSaveClienteService;

    private final PagamentoRepository pagamentoRepository;
    private final PagamentoFuncionarioRepository pagamentoFuncionarioRepository;
    private final PagamentoServicoRepository pagamentoServicoRepository;

    @CacheEvict(cacheNames = "rlfornecedor", allEntries = true)
    public void execute(PagamentoFornecedorRequest pagamentoFornecedorRequest){
        Fornecedor fornecedor = new Fornecedor();
        BeanUtils.copyProperties(pagamentoFornecedorRequest.getFornecedor(),fornecedor);
        List<Item> items = pagamentoFornecedorRequest.getItems().stream().map(this::getItems)
                .collect(Collectors.toList());

        Fornecedor fornecedorSaved = retrieveOrSaveFornecedorService.execute(fornecedor);

        Pagamento pagamento = new Pagamento();
        pagamento.setFornecedor(fornecedorSaved);
        pagamento.adicionarItems(items);
        pagamentoRepository.save(pagamento);
    }

    private Item getItems(ItemRequest itemRequest) {
        Item item = new Item();
        BeanUtils.copyProperties(itemRequest, item);
        Produto produto = new Produto();
        BeanUtils.copyProperties(itemRequest.getProduto(), produto);
        item.setProduto(retrieveOrCreateProdutoService.execute(produto));
        return item;
    }

    @CacheEvict(cacheNames = "rlfuncionario", allEntries = true)
    public void executeFuncionario(PagamentoFuncionarioRequest pagamentoFuncionarioRequest){
        Funcionario funcionario = new Funcionario();
        BeanUtils.copyProperties(pagamentoFuncionarioRequest.getFuncionario(),funcionario);
        Double salario = pagamentoFuncionarioRequest.getSalario();

        Funcionario funcionarioSaved = retrieveOrSaveFuncionarioService.execute(funcionario);

        PagamentoFuncionario pagamentoFuncionario = new PagamentoFuncionario();
        pagamentoFuncionario.setFuncionario(funcionarioSaved);
        pagamentoFuncionarioRepository.save(pagamentoFuncionario);
    }

    @CacheEvict(cacheNames = "rlservico", allEntries = true)
    public void executeServico(PagamentoServicoRequest pagamentoServicoRequest){
        Servico servico = new Servico();
        BeanUtils.copyProperties(pagamentoServicoRequest.getServico(),servico);

        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(pagamentoServicoRequest.getCliente(),cliente);

        List<ItemServico> itemsServico = pagamentoServicoRequest.getItemsServico().stream().map(this::getItemsServico)
                .collect(Collectors.toList());

        Cliente clienteSaved = retrieveOrSaveClienteService.execute(cliente);
        Servico servicoSaved = retrieveOrCreateServicoService.execute(servico);

        PagamentoServico pagamentoServico = new PagamentoServico();
        pagamentoServico.setServico(servicoSaved);
        pagamentoServico.setCliente(clienteSaved);
        pagamentoServico.adicionarItemsServico(itemsServico);
        pagamentoServicoRepository.save(pagamentoServico);
    }

    private ItemServico getItemsServico(ItemServicoRequest itemServicoRequest) {
        ItemServico itemServico = new ItemServico();
        BeanUtils.copyProperties(itemServicoRequest, itemServico);
        Servico servico = new Servico();
        BeanUtils.copyProperties(itemServicoRequest.getServico(), servico);
        itemServico.setServico(retrieveOrCreateServicoService.execute(servico));
        return itemServico;
    }
}