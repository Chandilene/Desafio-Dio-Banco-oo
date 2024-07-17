
public abstract class Conta implements iConta {
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {

		if (valor > saldo) {
			System.out.println("SALDO INSUFICIENTE");
		} else {
			saldo -= valor;
		}

	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		double taxa = 0.01 * valor; // 1% de taxa
		double valorComTaxa = valor + taxa;

		if (this.saldo >= valorComTaxa) {
			this.sacar(valorComTaxa);
			contaDestino.depositar(valorComTaxa);
		} else {
			System.out.println("SALDO INSUFICIENTE PARA TRANSFERIR");
		}
	}

	@Override
	public void transferirComPix(double valor, Conta contaDestino) {
		if (this.saldo >= valor) {
			this.sacar(valor);
			contaDestino.depositar(valor);
		} else {
			System.out.println("SALDO INSUFICIENTE PARA TRANSFERIR");
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
		System.out.println(String.format("Titular %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia %d", this.agencia));
		System.out.println(String.format("Numero %d", this.numero));
		System.out.println("Tranferências serão cobradas com 1% do valor");
		System.out.println(String.format("Saldo %.2f", this.saldo));
	}

}
