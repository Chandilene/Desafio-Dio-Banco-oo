
public class Main {

	public static void main(String[] args) {
		Cliente Chandilene = new Cliente();
		Chandilene.setNome("Chandilene");
		Conta cc = new ContaCorrente(Chandilene);

		cc.depositar(1000);
		cc.sacar(15);

		Conta poupanca = new ContaPoupanca(Chandilene);

		cc.transferir(900, poupanca);
		// cc.transferirComPix(900, poupanca);

		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

	}

}
