import Cliente.*;
import Conta.*;

public class Main {

	public static void main(String[] args) {

		Conta filerminoC = new ContaCorrente(new Cliente("Filermino Santana"));
		Conta jasonC = new ContaCorrente(new Cliente("Jason Malcon"));
		Conta pauloP = new ContaPoupanca(new Cliente("Paulo Ventura"));
		Conta deilsonC = new ContaCorrente(new Cliente("Deilson Bastos"));

		deilsonC.depositar(2500.99);
		jasonC.depositar(2500.99);
		pauloP.depositar(2500.99);
		filerminoC.depositar(2500.99);
		jasonC.transferir(100, pauloP);

		jasonC.imprimirExtrato();
		filerminoC.imprimirExtrato();
		deilsonC.imprimirExtrato();
		pauloP.imprimirExtrato();
		
		filerminoC.transferir(2430, pauloP);

		filerminoC.imprimirExtrato();

		filerminoC.transferir(2.0, deilsonC);

		jasonC.transferir(2100.09, filerminoC);
		pauloP.transferir(2100.09, filerminoC);
		deilsonC.transferir(2100.09, filerminoC);

		jasonC.imprimirExtrato();
		filerminoC.imprimirExtrato();
	}
}