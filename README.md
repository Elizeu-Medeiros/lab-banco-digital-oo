# Banco Digital em Java

## Descrição do Projeto

Este projeto implementa um banco digital simples utilizando Java e os princípios de Programação Orientada a Objetos (POO). A aplicação permite a criação de contas bancárias, depósitos, saques, transferências, pagamento de contas, solicitação de empréstimos e impressão de extratos. Toda a interação é realizada via console.

## Funcionalidades Implementadas

1. **Criação de Contas** : Permite criar contas correntes para clientes.
2. **Depósito** : Possibilita realizar depósitos em contas existentes.
3. **Saque** : Permite efetuar saques em contas existentes.
4. **Transferência** : Permite transferir valores entre contas.
5. **Pagamento de Contas** : Possibilita pagar contas diretamente da conta do cliente.
6. **Empréstimos** : Permite solicitar empréstimos.
7. **Impressão de Extratos** : Permite imprimir extratos com informações da conta.
8. **Persistência de Dados** : Permite salvar e carregar dados das contas em arquivos.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes:

* **Cliente** : Representa um cliente do banco com nome e senha.
* **Conta** : Classe abstrata que representa uma conta bancária.
* **ContaCorrente** : Implementação de conta corrente.
* **ContaPoupanca** : Implementação de conta poupança.
* **Banco** : Gerencia um conjunto de contas e oferece métodos para adicionar contas e salvar/carregar dados.
* **Main** : Classe principal que fornece uma interface baseada em console para interagir com o banco digital.

## Como Executar

1. Clone o repositório.
2. Compile os arquivos `.java`.
3. Execute o arquivo `Main.java`.

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para enviar sugestões ou melhorias através de pull requests.

## Licença

Este projeto está licenciado sob a [MIT License]().
