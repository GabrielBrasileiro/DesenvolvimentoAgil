package Extrato;

public class Extrato {

	private int id;
	private int conta_id;
	private int usuario_id;
	private double valorSacado = 0;
	private double valorDepositado = 0;
	private int tipo_conta;
	
	public int getId() {
		
		return id;
		
	}
	
	public void setId(int id) {
		
		this.id = id;
		
	}
	
	public int getConta_id() {
		
		return conta_id;
		
	}
	
	public void setConta_id(int conta_id) {
		
		this.conta_id = conta_id;
		
	}
	
	public int getUsuario_id() {
		
		return usuario_id;
		
	}
	
	public void setUsuario_id(int usuario_id) {
		
		this.usuario_id = usuario_id;
		
	}
	
	
	public double getValorSacado() {
	
		return valorSacado;
	
	}
	
	public void setValorSacado(double valorSacado) {
	
		this.valorSacado = valorSacado;
	}
	
	
	public double getValorDepositado() {
	
		return valorDepositado;
	}
	
	public void setValorDepositado(double valorDepositado) {
	
		this.valorDepositado = valorDepositado;
	
	}

	public int getTipo_conta() {
		
		return tipo_conta;
		
	}

	public void setTipo_conta(int tipo_conta) {
		
		this.tipo_conta = tipo_conta;
		
	}
	
	public void valorFinalDeposito(double deposito) {
		
		this.valorDepositado = this.valorDepositado + deposito;
		
	}
	
	public void valorFinalSaque(double saque) {
		
		this.valorDepositado = this.valorDepositado + saque;
		
	}
	
	@Override
	public String toString() {
		
		return "Id Conta: " + this.getId() + "\n"
		+ "Id Cliente: " + this.getUsuario_id() + "\n"
		+ "Id Conta: " + this.getConta_id() + "\n"
		+ "Id Conta: " + this.getTipo_conta() + "\n"
		+ "Valor Total sacado: " + this.getValorSacado() + "\n"
		+ "Valor Total depositado: " + this.getValorDepositado() + "\n"
		+ " ";
	
	}

	
}
