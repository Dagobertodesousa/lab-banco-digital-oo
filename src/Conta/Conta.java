package Conta;
import Cliente.Cliente;
import Modelo.IConta;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected final Double TETO;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.TETO = 0.0;
	}
	
	public double getTETO() {
		return TETO;
	}

	public boolean tetoConta(double valor){
		if (this.getTETO() >= (this.getSaldo() + valor)){
			return true;
		}
		return false;
	}

	public boolean limiteSaque(double valor){
		if (getSaldo() >= valor){
			return true;
		}
		return false;
	}

	public boolean limiteDeposito(double valor){
		if (valor <= this.getTETO()){
			return true;
		}
		return false;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
		System.out.println("--------------------------------------------\n"
							+ this.cliente.getNome() + " realizou um saque de R$ " + valor
							+ "\n--------------------------------------------");
	}

	@Override
	public void depositar(double valor) {
		if (this.limiteDeposito(valor)) {
			saldo += valor;
			System.out.println("--------------------------------------------\n"
								+ this.cliente.getNome() + " recebeu um deposito de R$ " + valor
								+ "\n--------------------------------------------");
		} else {
			System.out.println("--------------------------------------------\n"
								+ "Valor fornecido superior ao teto para a conta"
								+ "\n--------------------------------------------");
		}
		
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (this.limiteSaque(valor)) {
			if (contaDestino.tetoConta(valor)){
				System.out.println("============================================");
				this.sacar(valor);
				contaDestino.depositar(valor);
				System.out.println("============================================");
			} else {
				System.out.println("--------------------------------------------"
									+ "\nImpossibilidade de transferencia por"
									+ "\nmotivo de conta de terceiro."
									+ "\n--------------------------------------------");
			}
		} else {
			System.out.println("--------------------------------------------\n"
								+ "valor superior ao limite para saque"
								+ "\n--------------------------------------------");
		}
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
