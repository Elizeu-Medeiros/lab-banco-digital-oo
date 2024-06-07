import java.util.Scanner;

public class Main {
    private static Banco banco;

    public static void main(String[] args) {
        banco = new Banco("Meu Banco");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBem-vindo ao " + banco.getNome());
            System.out.println("1. Criar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Pagar conta");
            System.out.println("6. Solicitar empréstimo");
            System.out.println("7. Imprimir extrato");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    criarConta(scanner);
                    break;
                case 2:
                    realizarDeposito(scanner);
                    break;
                case 3:
                    realizarSaque(scanner);
                    break;
                case 4:
                    realizarTransferencia(scanner);
                    break;
                case 5:
                    pagarConta(scanner);
                    break;
                case 6:
                    solicitarEmprestimo(scanner);
                    break;
                case 7:
                    imprimirExtrato(scanner);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void criarConta(Scanner scanner) {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        Cliente cliente = new Cliente(nome, senha);
        Conta conta = new ContaCorrente(cliente);
        banco.adicionarConta(conta);
        System.out.println("Cliente: " + nome);
		System.out.println("Número da Conta: " + conta.getNumero());
    }

    private static Conta autenticarConta(Scanner scanner) {
        System.out.print("Número da conta: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        for (Conta conta : banco.getContas()) {
            if (conta.getNumero() == numeroConta && conta.getCliente().autenticar(senha)) {
                return conta;
            }
        }
        System.out.println("Conta ou senha inválida.");
        return null;
    }

    private static void realizarDeposito(Scanner scanner) {
        Conta conta = autenticarConta(scanner);
        if (conta == null) return;

        System.out.print("Valor do depósito: ");
        double valor = scanner.nextDouble();
        conta.depositar(valor);
        System.out.println("Depósito realizado.");
    }

    private static void realizarSaque(Scanner scanner) {
        Conta conta = autenticarConta(scanner);
        if (conta == null) return;

        System.out.print("Valor do saque: ");
        double valor = scanner.nextDouble();
        conta.sacar(valor);
        System.out.println("Saque realizado.");
    }

    private static void realizarTransferencia(Scanner scanner) {
        Conta contaOrigem = autenticarConta(scanner);
        if (contaOrigem == null) return;

        System.out.print("Número da conta destino: ");
        int numeroContaDestino = scanner.nextInt();
        scanner.nextLine();  // Consumir nova linha

        Conta contaDestino = null;
        for (Conta conta : banco.getContas()) {
            if (conta.getNumero() == numeroContaDestino) {
                contaDestino = conta;
                break;
            }
        }
        if (contaDestino == null) {
            System.out.println("Conta destino não encontrada.");
            return;
        }

        System.out.print("Valor da transferência: ");
        double valor = scanner.nextDouble();
        contaOrigem.transferir(valor, contaDestino);
        System.out.println("Transferência realizada.");
    }

    private static void pagarConta(Scanner scanner) {
        Conta conta = autenticarConta(scanner);
        if (conta == null) return;

        System.out.print("Valor da conta: ");
        double valor = scanner.nextDouble();
        conta.pagarConta(valor);
    }

    private static void solicitarEmprestimo(Scanner scanner) {
        Conta conta = autenticarConta(scanner);
        if (conta == null) return;

        System.out.print("Valor do empréstimo: ");
        double valor = scanner.nextDouble();
        conta.solicitarEmprestimo(valor);
    }

    private static void imprimirExtrato(Scanner scanner) {
        Conta conta = autenticarConta(scanner);
        if (conta == null) return;

        conta.imprimirExtrato();
    }
}
