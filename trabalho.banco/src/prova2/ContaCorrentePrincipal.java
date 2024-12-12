package prova2;

//Classe ContaCorrentePrincipal, que herda de Conta
public class ContaCorrentePrincipal extends Conta {

 // Construtor da classe ContaCorrentePrincipal
 public ContaCorrentePrincipal(String numeroConta, String titular) {
     super(numeroConta, titular); // Chamando o construtor da classe base
 }

 // MÃƒÂ©todo para depositar dinheiro na conta corrente principal
 @Override
 public void depositar(double valor) {
     if (valor > 0) {
         saldo += valor;
         System.out.println("DepÃƒÂ³sito de R$ " + valor + " realizado com sucesso na conta corrente principal.");
     } else {
         System.out.println("Valor de depÃƒÂ³sito invÃƒÂ¡lido.");
     }
 }

 // MÃƒÂ©todo para sacar dinheiro da conta corrente principal
 @Override
 public void sacar(double valor) {
     if (valor > 0 && saldo >= valor) {
         saldo -= valor;
         System.out.println("Saque de R$ " + valor + " realizado com sucesso na conta corrente principal.");
     } else {
         System.out.println("Saldo insuficiente ou valor de saque invÃƒÂ¡lido.");
     }
 }

 // MÃƒÂ©todo para transferir dinheiro para outra conta
 public void transferir(Conta destino, double valor) {
     if (valor > 0 && saldo >= valor) {
         saldo -= valor;
         destino.depositar(valor); // Chamando o mÃƒÂ©todo depositar na conta de destino
         System.out.println("TransferÃƒÂªncia de R$ " + valor + " realizada com sucesso para a conta " + destino.getNumeroConta() + ".");
     } else {
         System.out.println("Saldo insuficiente ou valor de transferÃƒÂªncia invÃƒÂ¡lido.");
     }
 }
}
