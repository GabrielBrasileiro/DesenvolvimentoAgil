package Dados;
import java.util.ArrayList;

import Cliente.Pessoa;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;
import Extrato.Extrato;

public class Dados {

	public ArrayList<Pessoa> arrayRegistroPessoa = new ArrayList<>();
	public ArrayList<ContaCorrente> arrayRegistroContaCorrente = new ArrayList<>();
	public ArrayList<ContaPoupanca> arrayRegistroContaPoupanca = new ArrayList<>();
	public ArrayList<Extrato> arrayRegistroExtrato = new ArrayList<>();
	
	public void registroPessoa(Pessoa pessoa) {

		arrayRegistroPessoa.add(pessoa);

	}

	public String listaPessoas() {

		String lista = "";

		for (int p = 0; p < this.arrayRegistroPessoa.size(); p++) {

			Pessoa ps = this.arrayRegistroPessoa.get(p);
			lista += "Id Cliente: " + ps.getId() + "\n" 
					+ "Nome: " + ps.getNome() + "\n" 
					+ "CPF: " + ps.getCpf() + "\n" 
					+ "RG: " + ps.getRg() + "\n" 
					+ "\n";

		}

		return lista;

	}
	
	public void registroContaCorrente(ContaCorrente contacorrente) {
		
		arrayRegistroContaCorrente.add(contacorrente);
		
	}
	
	public String listaContaCorrente() {

		String lista = "";

		for (int cc = 0; cc < this.arrayRegistroContaCorrente.size(); cc++) {

			ContaCorrente coc = this.arrayRegistroContaCorrente.get(cc);
			lista += "Id da Conta: " + coc.getId() + "\n" 
					+ "Id do Cliente: " + coc.getUsuario_id() + "\n" 
					+ "Saldo: " + coc.getSaldo() + "\n" 
					+ "\n";

		}

		return lista;

	}
	
	public void registroContaPoupanca(ContaPoupanca contapoupanca) {
		
		arrayRegistroContaPoupanca.add(contapoupanca);
		
	}
	
	public String listaContaPoupanca() {

		String lista = "";

		for (int cp = 0; cp < this.arrayRegistroContaPoupanca.size(); cp++) {

			ContaCorrente cop = this.arrayRegistroContaCorrente.get(cp);
			lista += "Id da Conta: " + cop.getId() + "\n" 
					+ "Id do Cliente: " + cop.getUsuario_id() + "\n" 
					+ "Saldo: " + cop.getSaldo() + "\n" 
					+ "\n";

		}

		return lista;

	}
	
	public void registroExtrato(Extrato extrato) {
		
		arrayRegistroExtrato.add(extrato);
		
	}

}
