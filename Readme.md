# LavaJato Application - Microserviço Financeiro

Microserviço que realiza: 

. Pagamento de um Funcionário, adicionando esse funcionário ao Banco de Dados. 

. Pagamento de um Fornecedor, recebendo o Pedido desse fornecedor do microserviço de Fornecimento
e ainda enviando uma request para o microserviço de Estoque para salvar o Produto no Banco de Dados do Estoque.

. Pagamento de um Serviço, e efetuando o pagamento, vinculado a um cliente. Ambos, serviço e cliente são adicionados ao Banco de Dados.

Microserviço usando:

. serviço de mensageria.

. Redis para Cache

. Padrão Saga Coreografado para conexão com os outros microserviços.

## Endpoints

### POST /pagamento/fornecedor

Request 
```java
{
	String id;
	int quantidade;
	Double preco; 
        Produto : { 
              String id;
              String nome;
          };
	Fornecedor : {
		            String razaoSocial;
		            String cnpj;
                  };
}
```

Response : void


### POST /pagamento/funcionario

Request 
```java
{
	Double salario; 
	Funcionario : {
		            String nome;
		            String cpf;
                  };
}
```

Response : void


### POST /pagamento/servico

Request 
```java
{
  Servico : { 
              String id;
              String tipo_servico;
          };
  Cliente : {
            String nome;
            String cpf;
                  };
  List<ItemServico>: [
                  {
                        int quantidade;
                        Double preco;
                        Serviço: {
                          String id;
                          String tipo_servico;
                        }
                  },
    ];
}
```

Response : void

### GET /pagamento/relatorio/{idFornecedor}

Response 
```java
{
	UUID idFornecedor;
	double valorTotalFornecedor;
  }
```


### GET /realizarpedido/relatorio/{idServico}

Response 
```java
{
	UUID idServiço;
	double valorTotalServiço;
  }
```
