package prova2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Banco {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarContaPorNumero(String numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    // Gera um nÃºmero de conta Ãºnico
    public String gerarNumeroContaUnico() {
        Random random = new Random();
        String numeroConta;
        do {
            numeroConta = String.valueOf(100000 + random.nextInt(900000)); // Gera um nÃºmero de 6 dÃ­gitos
        } while (buscarContaPorNumero(numeroConta) != null); // Garante que o nÃºmero nÃ£o existe
        return numeroConta;
    }
    
    public Usuario loginUsuario(String numeroConta, String senha) {
        for (Usuario usuario : usuarios) {
        	if (usuario instanceof Gerente) {
                 Gerente gerente = (Gerente) usuario;
                 if (gerente.getNumeroConta().equals(numeroConta) && gerente.autenticar(senha)) {
                     return gerente;
                 }
        	}
            if (usuario instanceof Correntista) { // Apenas correntistas tÃªm contas vinculadas diretamente
                Correntista correntista = (Correntista) usuario;
                if (correntista.getConta().getNumeroConta().equals(numeroConta) && usuario.validarSenha(senha)) {
                    return usuario;
                }
            }
        }
        
        return null; // Retorna null se nÃ£o encontrar um usuÃ¡rio vÃ¡lido
    }

	public void exibirUsuarios() {
		// TODO Auto-generated method stub
		
	}	

	public void exibirContas() {
		// TODO Auto-generated method stub
		
	}

	public Object getUsuarios() {
		// TODO Auto-generated method stub
		return usuarios;
	}
}
