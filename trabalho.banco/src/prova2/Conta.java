package prova2;

//Classe base abstrata para representar uma conta bancÃƒÂ¡ria
public abstract class Conta {
 protected String numeroConta; // NÃƒÂºmero da conta
 protected String titular; // Nome do titular da conta
 protected double saldo; // Saldo da conta

 // Construtor da classe base
 public Conta(String numeroConta, String titular) {
     this.numeroConta = numeroConta;
     this.titular = titular;
     this.saldo = 0.0; // Inicializando saldo com 0
 }

 // MÃƒÂ©todo para consultar o saldo da conta
 public double consultarSaldo() {
     return saldo;
 }

 // MÃƒÂ©todo abstrato para depÃƒÂ³sito
 public abstract void depositar(double valor);

 // MÃƒÂ©todo abstrato para saque
 public abstract void sacar(double valor);

 // Getter para o nÃƒÂºmero da conta
 public String getNumeroConta() {
     return numeroConta;
 }

 // Getter para o titular da conta
 public String getTitular() {
     return titular;
 }

 // MÃƒÂ©todo para exibir informaÃƒÂ§ÃƒÂµes gerais da conta
 public void exibirInformacoes() {
     System.out.println("NÃƒÂºmero da conta: " + numeroConta);
     System.out.println("Titular: " + titular);
     System.out.println("Saldo atual: R$ " + saldo);
 }

	protected abstract void transferir(Conta contaDestino, double valorTransferencia);

	public Banco getBanco() {
		// TODO Auto-generated method stub
		return null;
	}
	
    public String gerarNumeroContaUnico() {
        String numeroConta;
        do {
            numeroConta = String.valueOf((int) (Math.random() * 10000)); // Gera um nÃºmero aleatÃ³rio de 4 dÃ­gitos
        } while (buscarContaPorNumero(numeroConta) != null); // Garante que o nÃºmero Ã© Ãºnico
        return numeroConta;
    }

	protected abstract Object buscarContaPorNumero(String numeroConta2);

	
}