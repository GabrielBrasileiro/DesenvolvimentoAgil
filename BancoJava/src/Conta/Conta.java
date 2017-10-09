package Conta;
import javax.swing.JOptionPane;

public class Conta {
	
	private int id;
	private int usuario_id;
	protected double saldo;

	
	public int getId() {
		
		return id;
		
	}
	
	public void setId(int id) {
		
		this.id = id;
		
	}
	
	public int getUsuario_id() {
		
		return usuario_id;
		
	}
	
	public void setUsuario_id(int usuario_id) {
		
		this.usuario_id = usuario_id;
		
	}
	
	public double getSaldo() {
		
		return saldo;
		
	}
	
	public void setSaldo(double saldo) {
		
		this.saldo = saldo;
		
	}
	
	public void Deposita(double deposita) {
		
		this.saldo = this.saldo + deposita;
		
	}
	
	public void Saca(double saca) {
		
		if(this.saldo < saca) {
			
			JOptionPane.showMessageDialog(null, "O valor que você quer savar é maior que o seu saldo\n");
			
		} else {
			
			this.saldo = this.saldo - saca;
			JOptionPane.showMessageDialog(null, "O valor sacado foi de: " + saca);
			
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
