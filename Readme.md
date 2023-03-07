#LavaJata Application - Microservice Financeiro

Microserviço que realiza: 

. Pagamento de um Funcionário, adicionando esse funcionário ao Banco de Dados. 

. Pagamento de um Fornecedor, recebendo o Pedido desse fornecedor do microserviço de Fornecimento
e ainda enviando uma request para o microserviço de Estoque para salvar o Produto no Banco de Dados do Estoque.

. Pagamento de um Serviço, recebendo a solicitação do microserviço de Serviços do Lavajato, e efetuando o pagamento,
vinculado a um cliente, que é tbm é adicionado ao Banco de Dados.