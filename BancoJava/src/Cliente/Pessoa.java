package Cliente;
import javax.swing.JOptionPane;

public class Pessoa {
	
	private int id;
	private String nome;
	private int cpf;
	private int rg;
	
	public int getId() {
		
		return id;
		
	}
	
	public void setId(int id) {
		
		this.id = id;
		
	}
	
	public String getNome() {
		
		return nome;
		
	}
	
	public void setNome(String nome) {
		
		this.nome = nome;
		
	}
	
	public long getCpf() {
		
		return cpf;
		
	}
	
	public void setCpf(int cpf) {
		
		this.cpf = cpf;
		
	}
	
	public long getRg() {
		
		return rg;
		
	}
	
	public void setRg(int rg) {
		
		this.rg = rg;
		
	}
	
	public void InformacoesPessoa() {
		
		this.setNome(JOptionPane.showInputDialog("Digite o nome do Cliente: "));

		this.setCpf(Integer.parseInt(JOptionPane.showInputDialog("Digite o seu CPF: ")));

		this.setRg(Integer.parseInt(JOptionPane.showInputDialog("Digite o seu RG: ")));

		
	}
	
	@Override
	public String toString() {
		
		return "Id Cliente: " + this.id + "\n"
		+ "Nome: " + this.getNome() + "\n"
		+ "CPF: " + this.getCpf() + "\n"
		+ "E-mail: " + this.getRg() + "\n"
		+ " ";
	
	}

}
