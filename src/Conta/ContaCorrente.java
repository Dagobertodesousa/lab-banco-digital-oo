package Conta;
import Cliente.Cliente;
import Modelo.IConta;

public class ContaCorrente extends Conta {
	protected final double TETO = 8000.0;
	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	public double getTETO() {
		return TETO;
	}

	@Override
	public boolean limiteSaque(double valor) {
		// TODO Auto-generated method stub
		return super.limiteSaque(valor);
	}

	@Override
	public boolean tetoConta(double valor) {
		// TODO Auto-generated method stub
		return super.tetoConta(valor);
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		// TODO Auto-generated method stub
		super.transferir(valor, contaDestino);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
		System.out.println("=========================");
	}
	
}
