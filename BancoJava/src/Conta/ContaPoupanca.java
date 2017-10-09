package Conta;
import javax.swing.JOptionPane;

public class ContaPoupanca extends Conta {
	
	public void Saca(double saca) {

		if (this.saldo < saca) {

			JOptionPane.showMessageDialog(null, "O valor que você quer savar é maior que o seu saldo\n");

		} else {

			//Taxa de 10 reais para conta corrente 
			
			this.saldo = (this.saldo - saca) - 5;
			JOptionPane.showMessageDialog(null, "O valor sacado foi de: " + saca + " e 5 de taxa\n");

		}

	}
	
	@Override
	public String toString() {
		
		return "Id Conta: " + this.getId() + "\n"
		+ "Id Cliente: " + this.getUsuario_id() + "\n"
		+ "Saldo: " + this.getSaldo() + "\n"
		+ " ";
	
	}

}
