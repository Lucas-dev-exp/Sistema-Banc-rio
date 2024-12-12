package prova2;

public class Correntista extends Usuario {
	public Conta conta;
	private String nome;
	private String numeroConta;
    private String senha;

    public Correntista(String nome, String numeroConta, String senha) {
        super(nome, numeroConta, senha);
        this.nome = nome;
        this.senha = senha;
    }

    @Override
    public void consultarSaldo(Conta conta) {
        if (this.conta == conta) {
            System.out.println("Saldo da sua conta: R$ " + conta.consultarSaldo());
        } else {
            System.out.println("Acesso negado. VocÃª sÃ³ pode consultar o saldo da sua prÃ³pria conta.");
        }
    }

    public void realizarTransferencia(Conta destino, double valor) {
        conta.transferir(destino, valor);
    }

    public Conta getConta() {
        return this.conta;
    }
    
    public String gerarNumeroContaUnico() {
        String numeroConta;
        do {
            numeroConta = String.valueOf((int) (Math.random() * 10000)); // Gera um nÃºmero aleatÃ³rio de 4 dÃ­gitos
        } while (buscarContaPorNumero(numeroConta) != null); // Garante que o nÃºmero Ã© Ãºnico
        return numeroConta;
    }

}
