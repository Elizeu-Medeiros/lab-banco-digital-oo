import java.io.Serializable;

public abstract class Conta implements Serializable {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        if (saldo < valor) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
    }

    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public void pagarConta(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Conta paga com sucesso. Valor: " + valor);
        } else {
            System.out.println("Saldo insuficiente para pagar a conta.");
        }
    }

    public void solicitarEmprestimo(double valor) {
        saldo += valor;
        System.out.println("Empréstimo de " + valor + " concedido.");
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public abstract void imprimirExtrato();
}
