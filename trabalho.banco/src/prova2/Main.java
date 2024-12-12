package prova2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        
        // Gerente padrÃ£o cadastrado no sistema
        Gerente gerentePadrao = new Gerente("Admin", "1000", "123123");
        banco.adicionarUsuario(gerentePadrao);

        System.out.println("Bem-vindo ao Sistema BancÃ¡rio!");
        
        Usuario usuarioLogado = null;
        while (usuarioLogado == null) { // Continua pedindo login atÃ© ser vÃ¡lido
            usuarioLogado = realizarLogin(banco, scanner);
        }

        // Menu principal com base no tipo de usuÃ¡rio logado
        if (usuarioLogado instanceof Gerente) {
            exibirMenuGerente((Gerente) usuarioLogado, banco, scanner);
        } else if (usuarioLogado instanceof Bancario) {
            exibirMenuBancario((Bancario) usuarioLogado, banco, scanner);
        } else if (usuarioLogado instanceof Correntista) {
            exibirMenuCorrentista((Correntista) usuarioLogado, scanner);
        }

        scanner.close();
    }

    // MÃ©todo para realizar login
    private static Usuario realizarLogin(Banco banco, Scanner scanner) {
        System.out.println("\n--- Login do UsuÃ¡rio ---");
        System.out.print("Digite o nÃºmero da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        Usuario usuario = banco.loginUsuario(numeroConta, senha);
        if (usuario == null) {
            System.out.println("NÃºmero da conta ou senha invÃ¡lidos. Tente novamente.");
            return null;
        }

        System.out.println("Login realizado com sucesso! Bem-vindo(a), " + usuario.getNome() + ".");
        return usuario;
    }

    // Menu para Gerente
    private static void exibirMenuGerente(Gerente gerente, Banco banco, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Menu Gerente ---");
            System.out.println("1. Consultar saldo de uma conta");
            System.out.println("2. Cadastrar novo usuÃ¡rio");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opÃ§Ã£o: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nÃºmero da conta: ");
                    String numeroConta = scanner.nextLine();
                    Conta conta = banco.buscarContaPorNumero(numeroConta);
                    if (conta != null) {
                        gerente.consultarSaldo(conta);
                    } else {
                        System.out.println("Conta nÃ£o encontrada.");
                    }
                    break;
                case 2:
                    cadastrarUsuario(banco, scanner);
                    break;
                case 3:
                    System.out.println("Saindo do menu do Gerente...");
                    return;
                default:
                    System.out.println("OpÃ§Ã£o invÃ¡lida!");
            }
        } while (opcao != 3);
    }

    // Menu para BancÃ¡rio
    private static void exibirMenuBancario(Bancario bancario, Banco banco, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Menu BancÃ¡rio ---");
            System.out.println("1. Consultar saldo de uma conta");
            System.out.println("2. Realizar transferÃªncia entre contas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opÃ§Ã£o: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nÃºmero da conta: ");
                    String numeroConta = scanner.nextLine();
                    Conta conta = banco.buscarContaPorNumero(numeroConta);
                    if (conta != null) {
                        bancario.consultarSaldo(conta);
                    } else {
                        System.out.println("Conta nÃ£o encontrada.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o nÃºmero da conta de origem: ");
                    String origem = scanner.nextLine();
                    System.out.print("Digite o nÃºmero da conta de destino: ");
                    String destino = scanner.nextLine();
                    System.out.print("Digite o valor da transferÃªncia: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a nova linha
                    Conta contaOrigem = banco.buscarContaPorNumero(origem);
                    Conta contaDestino = banco.buscarContaPorNumero(destino);
                    if (contaOrigem != null && contaDestino != null) {
                        bancario.realizarTransferencia(contaOrigem, contaDestino, valor);
                    } else {
                        System.out.println("Conta(s) nÃ£o encontrada(s).");
                    }
                    break;
                case 3:
                    System.out.println("Saindo do menu do BancÃ¡rio...");
                    break;
                default:
                    System.out.println("OpÃ§Ã£o invÃ¡lida!");
            }
        } while (opcao != 3);
    }

    // Menu para Correntista
    private static void exibirMenuCorrentista(Correntista correntista, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Menu Correntista ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Realizar transferÃªncia");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opÃ§Ã£o: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    correntista.consultarSaldo(correntista.getConta());
                    break;
                case 2:
                    System.out.print("Digite o nÃºmero da conta de destino: ");
                    String destino = scanner.nextLine();
                    System.out.print("Digite o valor da transferÃªncia: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a nova linha
                    Conta contaDestino = correntista.getConta().getBanco().buscarContaPorNumero(destino);
                    if (contaDestino != null) {
                        correntista.realizarTransferencia(contaDestino, valor);
                    } else {
                        System.out.println("Conta de destino nÃ£o encontrada.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo do menu do Correntista...");
                    break;
                default:
                    System.out.println("OpÃ§Ã£o invÃ¡lida!");
            }
        } while (opcao != 3);
    }

    // MÃ©todo para cadastrar usuÃ¡rio
    private static void cadastrarUsuario(Banco banco, Scanner scanner) {
        System.out.println("\n--- Cadastro de UsuÃ¡rio ---");
        System.out.print("Digite o nome do usuÃ¡rio: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a senha para o usuÃ¡rio: ");
        String senha = scanner.nextLine();

        System.out.println("Escolha o tipo de usuÃ¡rio:");
        System.out.println("1. Gerente");
        System.out.println("2. BancÃ¡rio");
        System.out.println("3. Correntista");
        System.out.print("OpÃ§Ã£o: ");
        int tipoUsuario = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Usuario usuario = null;
        if (tipoUsuario == 3) { // Correntista
        	String numeroConta = banco.gerarNumeroContaUnico();
            System.out.println("NÃºmero da conta gerado: " + numeroConta);
            usuario = new Correntista(nome, numeroConta, senha);
        } else if (tipoUsuario == 1) {
        	String numeroConta = banco.gerarNumeroContaUnico();
            System.out.println("NÃºmero da conta gerado: " + numeroConta);
			usuario = new Gerente(nome, numeroConta, senha);
        } else if (tipoUsuario == 2) {
        	String numeroConta = banco.gerarNumeroContaUnico();
            System.out.println("NÃºmero da conta gerado: " + numeroConta);
            usuario = new Bancario(nome, numeroConta, senha); 
        } else {
            System.out.println("Tipo de usuÃ¡rio invÃ¡lido.");
            return;
        }

        banco.adicionarUsuario(usuario);
        System.out.println("UsuÃ¡rio cadastrado com sucesso!");
    }
}
