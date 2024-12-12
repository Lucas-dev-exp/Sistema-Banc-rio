package prova2;

public abstract class Usuario {
    protected String nome;
    private String numeroConta;
    private String senha; // Novo atributo

    public Usuario(String nome, String numeroConta, String senha) {
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.senha = senha; // Atribui senha
    }

    public String getNome() {
        return nome;
    }

    public boolean validarSenha(String senha) {
        return this.senha.equals(senha);
    }

    // MÃ©todo abstrato para consultar saldo, implementado nas subclasses
    public abstract void consultarSaldo(Conta conta);
    
    public String gerarNumeroContaUnico() {
        String numeroConta;
        do {
            numeroConta = String.valueOf((int) (Math.random() * 10000)); // Gera um nÃºmero aleatÃ³rio de 4 dÃ­gitos
        } while (buscarContaPorNumero(numeroConta) != null); // Garante que o nÃºmero Ã© Ãºnico
        return numeroConta;
    }

	protected abstract Object buscarContaPorNumero(String numeroConta2);

}
