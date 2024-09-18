import Cliente.*;
import Conta.*;

public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");

		Cliente dagoberto = new Cliente("dagoberto");

		Cliente deconhecido = new Cliente();
		Conta cc = new ContaCorrente(venilton);
		Conta dagobertoCorrente = new ContaCorrente(dagoberto);
		Conta poupanca = new ContaPoupanca(venilton);
		Conta desconhecidoPoupanca = new ContaPoupanca(deconhecido);

		cc.depositar(100);
		cc.transferir(100, poupanca);

		dagobertoCorrente.imprimirExtrato();
		desconhecidoPoupanca.imprimirExtrato();
		
		cc.transferir(150, desconhecidoPoupanca);

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
