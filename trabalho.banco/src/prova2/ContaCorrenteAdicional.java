package prova2;

// Classe ContaCorrenteAdicional, que herda de Conta
public class ContaCorrenteAdicional extends Conta {
    private ContaCorrentePrincipal contaVinculada; // Conta principal vinculada
    private double limiteGasto; // Limite de gasto para a conta adicional

    // Construtor da classe ContaCorrenteAdicional
    public ContaCorrenteAdicional(String numeroConta, String titular, ContaCorrentePrincipal contaVinculada, double limiteGasto) {
        super(numeroConta, titular); // Chamando o construtor da classe base
        this.contaVinculada = contaVinculada;
        this.limiteGasto = limiteGasto;
    }

    // MÃ©todo para depositar dinheiro na conta adicional
    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("DepÃ³sito de R$ " + valor + " realizado com sucesso na conta corrente adicional.");
        } else {
            System.out.println("Valor de depÃ³sito invÃ¡lido.");
        }
    }

    // MÃ©todo para sacar dinheiro da conta adicional
    @Override
    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor && valor <= limiteGasto) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso na conta corrente adicional.");
        } else {
            System.out.println("Saldo insuficiente, valor de saque invÃ¡lido ou acima do limite de gasto.");
        }
    }

    // Getter para a conta vinculada
    public ContaCorrentePrincipal getContaVinculada() {
        return contaVinculada;
    }

    // Getter para o limite de gasto
    public double getLimiteGasto() {
        return limiteGasto;
    }

    // Setter para o limite de gasto
    public void setLimiteGasto(double limiteGasto) {
        if (limiteGasto >= 0) {
            this.limiteGasto = limiteGasto;
            System.out.println("Novo limite de gasto definido: R$ " + limiteGasto);
        } else {
            System.out.println("Limite de gasto invÃ¡lido.");
        }
    }

	@Override
	protected void transferir(Conta contaDestino, double valorTransferencia) {
		// TODO Auto-generated method stub
		
	}
}
