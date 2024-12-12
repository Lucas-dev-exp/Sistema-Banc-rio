package prova2;

public class Bancario extends Usuario {
	private String nome;
	private String numeroConta;
    private String senha;

    public Bancario(String nome, String numeroConta, String senha) {
        super(nome, numeroConta, senha);
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.senha = senha;
    }

    @Override
    public void consultarSaldo(Conta conta) {
        System.out.println("Saldo da conta " + conta.getNumeroConta() + ": R$ " + conta.consultarSaldo());
    }

    // MÃ©todo para realizar transferÃªncia entre contas
    public void realizarTransferencia(Conta origem, Conta destino, double valor) {
        if (origem == null || destino == null) {
            System.out.println("Conta de origem ou destino invÃ¡lida.");
            return;
        }

        if (valor > 0 && origem.consultarSaldo() >= valor) {
            origem.sacar(valor); // Usando o mÃ©todo sacar da classe Conta
            destino.depositar(valor); // Usando o mÃ©todo depositar da classe Conta
            System.out.println("TransferÃªncia de R$ " + valor + " realizada com sucesso da conta " 
                                + origem.getNumeroConta() + " para a conta " + destino.getNumeroConta() + ".");
        } else {
            System.out.println("Saldo insuficiente ou valor de transferÃªncia invÃ¡lido.");
        }
    }
    public String gerarNumeroContaUnico() {
        String numeroConta;
        do {
            numeroConta = String.valueOf((int) (Math.random() * 10000)); // Gera um nÃºmero aleatÃ³rio de 4 dÃ­gitos
        } while (buscarContaPorNumero(numeroConta) != null); // Garante que o nÃºmero Ã© Ãºnico
        return numeroConta;
    }

}