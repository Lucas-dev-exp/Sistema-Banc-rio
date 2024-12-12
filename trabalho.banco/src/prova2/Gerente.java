package prova2;

public class Gerente extends Usuario {
	private String nome;
    private String numeroConta;
    private String senha;

    public Gerente(String nome,String numeroConta, String senha) {
        super(nome, numeroConta, senha);
        this.nome = nome;
        this.numeroConta = numeroConta;
        this.senha = senha;
    }

    @Override
    public void consultarSaldo(Conta conta) {
        System.out.println("Saldo da conta " + conta.getNumeroConta() + ": R$" + conta.consultarSaldo());
    }

    public void cadastrarUsuario(Usuario usuario) {
        System.out.println("UsuÃ¡rio " + usuario.getNome() + " cadastrado com sucesso.");
    }

    // MÃ©todos de login
    public String getNumeroConta() {
        return numeroConta;
    }

    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}
