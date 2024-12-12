package prova2;

//Classe ContaPoupanca, que herda de Conta
public class ContaPoupanca extends Conta {
	private double taxaRendimento; // Taxa de rendimento da poupanÃƒÂ§a

	// Construtor da classe ContaPoupanca
	public ContaPoupanca(String numeroConta, String titular, double taxaRendimento) {
		super(numeroConta, titular); // Chamando o construtor da classe Conta
		this.taxaRendimento = taxaRendimento;
	}

	// MÃƒÂ©todo para depositar dinheiro na poupanÃƒÂ§a
	@Override
	public void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
			System.out.println("DepÃƒÂ³sito de R$ " + valor + " realizado com sucesso na conta poupanÃƒÂ§a.");
		} else {
			System.out.println("Valor de depÃƒÂ³sito invÃƒÂ¡lido.");
		}
	}

	// MÃƒÂ©todo para sacar dinheiro da poupanÃƒÂ§a
	@Override
	public void sacar(double valor) {
		if (valor > 0 && saldo >= valor) {
			saldo -= valor;
			System.out.println("Saque de R$ " + valor + " realizado com sucesso na conta poupanÃƒÂ§a.");
		} else {
			System.out.println("Saldo insuficiente ou valor de saque invÃƒÂ¡lido.");
		}
	}

	// MÃƒÂ©todo para aplicar o rendimento da poupanÃƒÂ§a
	public void aplicarRendimento() {
		saldo += saldo * taxaRendimento;
		System.out.println("Rendimento aplicado. Novo saldo: R$ " + saldo);
	}

	// Getter para a taxa de rendimento
	public double getTaxaRendimento() {
		return taxaRendimento;
	}

	// Setter para a taxa de rendimento
	public void setTaxaRendimento(double taxaRendimento) {
		if (taxaRendimento >= 0) {
			this.taxaRendimento = taxaRendimento;
		} else {
			System.out.println("Taxa de rendimento invÃƒÂ¡lida.");
		}
	}

	@Override
	protected void transferir(Conta contaDestino, double valorTransferencia) {
		// TODO Auto-generated method stub
		
	}
}
