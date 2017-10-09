package Main;
import javax.swing.JOptionPane;

import Cliente.Pessoa;
import Conta.ContaCorrente;
import Conta.ContaPoupanca;
import Dados.Dados;
import Extrato.Extrato;

public class Main {

	public static void main(String[] args) {

		Dados dados = new Dados();

		int opcao = 0;

		// Saida das caixas de texto
		String menu = "1 - Registrar Pessoa\n" + "2 - Registrar nova Conta Corrente\n"
				+ "3 - Registrar nova Conta Poupanca\n" + "4 - Realizar Deposito\n" + "5 - Realizar Saque\n"
				+ "6 - Extrato\n" + "7 - Lista de Pessoas\n" + "8 - Lista de Contas Corrente\n" + "9 - Lista de Contas Poupança\n"
				+ "10 - Sair\n";

		// Declaração valor final
		double deposito, saca;

		// Comparativos situacinais
		int id_pessoa, id_conta, conta_tipo;

		// Número que é aramazenado no ArrayList como ID
		int contAPessoa = 0, contAContaCorrente = 0, contAContaPoupanca = 0, contAExtrato = 0;

		// Contador da quantidade em si
		int contPessoa = 0, contContaCorrente = 0, contContaPoupanca = 0;

		do {

			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

			if (opcao == 1) {

				// Registro Cliente

				Pessoa p = new Pessoa();
				p.InformacoesPessoa();

				p.setId(contAPessoa++);

				dados.registroPessoa(p);

				JOptionPane.showMessageDialog(null, "Cadastro da pessoa realizado com sucesso\n" + p);
				System.out.println(p);

				contPessoa++; // Contador de Clientes local

			}

			if (opcao == 2) {

				// Registro de uma nova conta corrente

				id_pessoa = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));

				for (int i = 0; i < dados.arrayRegistroPessoa.size(); i++) {

					Pessoa ps = dados.arrayRegistroPessoa.get(i);

					System.out.println("Pessoas Acessadas: " + ps);

					if (ps.getId() == id_pessoa) {

						ContaCorrente cc = new ContaCorrente();
						cc.setUsuario_id(ps.getId());
						cc.setSaldo(0);

						cc.setId(contAContaCorrente++);
						
						dados.registroContaCorrente(cc);

						JOptionPane.showMessageDialog(null,
								"A Conta Corrente do usuário foi cadastrada com sucesso: \n" + cc.toString() + ps.toString());
						
						contContaCorrente++;

					}

				}

			}

			if (opcao == 3) {

				// Registro de uma nova conta poupanca

				id_pessoa = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));

				for (int i = 0; i < dados.arrayRegistroPessoa.size(); i++) {

					Pessoa ps = dados.arrayRegistroPessoa.get(i);

					System.out.println("Pessoas Acessadas: " + ps);

					if (ps.getId() == id_pessoa) {

						ContaPoupanca cp = new ContaPoupanca();
						cp.setUsuario_id(ps.getId());
						cp.setSaldo(0);

						cp.setId(contAContaPoupanca++);
						
						dados.registroContaPoupanca(cp);

						JOptionPane.showMessageDialog(null,
								"A Conta do Corrente do usuário foi cadastrada com sucesso: \n" + cp.toString() + ps.toString());

						contContaPoupanca++;
						
					}

				}

			}

			if (opcao == 4) {

				id_pessoa = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));
				
				for (int i = 0; i < dados.arrayRegistroPessoa.size(); i++) {

					Pessoa ps = dados.arrayRegistroPessoa.get(i);

					System.out.println("Pessoas Acessadas: " + ps);

					if (ps.getId() == id_pessoa) {

						conta_tipo = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo de conta que gostaria de depositar: \n" + "1 - Conta Corrente\n" + "2 - Conta Poupança"));
						
						if(conta_tipo == 1) {
							
							//Conta Corrente
							
							id_conta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da conta que quer depositar: "));
							
							for(int cc = 0; cc < dados.arrayRegistroContaCorrente.size(); cc++) {
								
								ContaCorrente coc = dados.arrayRegistroContaCorrente.get(cc);
								
								System.out.println("Contas acessadas: " + coc);
								
								// Condição que só permite ao usuário sacar caso o id do registro da conta seja igual ao dele
								if((coc.getId() == id_conta) && (coc.getUsuario_id() == id_pessoa)) {
									
									deposito = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de depósito: "));
									
									coc.Deposita(deposito);
									
									System.out.println(coc.getSaldo());
									
									Extrato ex = new Extrato();
									ex.setId(contAExtrato++);
									ex.setConta_id(id_conta);
									ex.setUsuario_id(id_pessoa);
									ex.setTipo_conta(1);
									ex.setValorDepositado(deposito);
									dados.registroExtrato(ex);
									
									JOptionPane.showMessageDialog(null, "Valor Depósito:\n" + deposito + "\n\nInformações do Cliente:\n" + dados.arrayRegistroPessoa.get(i).toString() + "\nInformações da roupa:\n" + dados.arrayRegistroContaCorrente.get(cc).toString());
									
								} 
								
							}
							
						}
						
						if(conta_tipo == 2) {
							
							//Conta Poupanca
							
							id_conta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da conta que quer depositar: "));
							
							for(int cp = 0; cp < dados.arrayRegistroContaPoupanca.size(); cp++) {
								
								ContaPoupanca cop = dados.arrayRegistroContaPoupanca.get(cp);
								
								System.out.println("Contas acessadas: " + cop);
								
								if((cop.getId() == id_conta) && (cop.getUsuario_id() == id_pessoa)) {
									
									deposito = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de depósito: "));
									
									cop.Deposita(deposito);
									
									System.out.println(cop.getSaldo());
									
									Extrato ex = new Extrato();
									ex.setId(contAExtrato++);
									ex.setConta_id(id_conta);
									ex.setUsuario_id(id_pessoa);
									ex.setTipo_conta(2);
									ex.setValorDepositado(deposito);
									dados.registroExtrato(ex);
									
									JOptionPane.showMessageDialog(null, "Valor Depósito:\n" + deposito + "\n\nInformações do Cliente:\n" + dados.arrayRegistroPessoa.get(i).toString() + "\nInformações da roupa:\n" + dados.arrayRegistroContaPoupanca.get(cp).toString());
									
								} 
								
							}							
							
						}

					}

				}

			}

			if (opcao == 5) {

				id_pessoa = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do Cliente: "));
				
				for (int i = 0; i < dados.arrayRegistroPessoa.size(); i++) {

					Pessoa ps = dados.arrayRegistroPessoa.get(i);

					System.out.println("Pessoas Acessadas: " + ps);

					if (ps.getId() == id_pessoa) {

						conta_tipo = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo de conta que gostaria de sacar: \n" + "1 - Conta Corrente\n" + "2 - Conta Poupança"));
						
						if(conta_tipo == 1) {
							
							//Conta Corrente
							
							id_conta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da conta que quer sacar: "));
							
							for(int cc = 0; cc < dados.arrayRegistroContaCorrente.size(); cc++) {
								
								ContaCorrente coc = dados.arrayRegistroContaCorrente.get(cc);
								
								System.out.println("Contas acessadas: " + coc);
								
								// Condição que só permite ao usuário sacar caso o id do registro da conta seja igual ao dele
								if((coc.getId() == id_conta) && (coc.getUsuario_id() == id_pessoa)) {
									
									saca = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que gostaria de sacar: "));
									
									coc.Saca(saca);
									
									Extrato ex = new Extrato();
									ex.setId(contAExtrato++);
									ex.setConta_id(id_conta);
									ex.setUsuario_id(id_pessoa);
									ex.setTipo_conta(1);
									ex.setValorSacado(saca);
									dados.registroExtrato(ex);
									
									System.out.println(coc.getSaldo());
									
									JOptionPane.showMessageDialog(null, "Valor do saque:\n" + saca + "\n\nInformações do Cliente:\n" + dados.arrayRegistroPessoa.get(i).toString() + "\nInformações da Conta:\n" + dados.arrayRegistroContaCorrente.get(cc).toString());
									
								} 
								
							}
							
						}
						
						if(conta_tipo == 2) {
							
							//Conta Poupanca
							
							id_conta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da conta que quer sacar: "));
							
							for(int cp = 0; cp < dados.arrayRegistroContaPoupanca.size(); cp++) {
								
								ContaPoupanca cop = dados.arrayRegistroContaPoupanca.get(cp);
								
								System.out.println("Contas acessadas: " + cop);
								
								if((cop.getId() == id_conta) && (cop.getUsuario_id() == id_pessoa)) {
									
									saca = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que gostaria de sacar: "));
									
									cop.Saca(saca);
									
									System.out.println(cop.getSaldo());
									
									JOptionPane.showMessageDialog(null, "Valor do saque:\n" + saca + "\n\nInformações do Cliente:\n" + dados.arrayRegistroPessoa.get(i).toString() + "\nInformações da roupa:\n" + dados.arrayRegistroContaPoupanca.get(cp).toString());
									
									Extrato ex = new Extrato();
									ex.setId(contAExtrato++);
									ex.setConta_id(id_conta);
									ex.setUsuario_id(id_pessoa);
									ex.setTipo_conta(2);
									ex.setValorSacado(saca);
									dados.registroExtrato(ex);
									
								}
								
							}							
							
						}

					}

				}

			}

			if (opcao == 6) {
				
				// Extrato com histórico total de saques
				// Vai mostrar os 3 saques existente com o id
				
				id_pessoa = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do Cliente que quer tirar o extrato: "));
				conta_tipo = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo da conta que gostaria:\n1 - Conta Corrente\n2 - Conta Poupança"));
				id_conta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da conta: "));
				
				for(int ext = 0; ext < dados.arrayRegistroExtrato.size(); ext++) {
					
					Extrato ex = dados.arrayRegistroExtrato.get(ext);
					
					System.out.println("Extratos acessadas: \n" + ex);
					
					if((id_pessoa == ex.getUsuario_id()) && (conta_tipo == ex.getTipo_conta()) && (id_conta == ex.getConta_id())) {
						
						JOptionPane.showMessageDialog(null, "Extrato:\n" + "\nExtrato ID: " + ex.getId() + "\nUsuário ID: " + ex.getUsuario_id() + "\nConta ID: " + ex.getConta_id() + "\nConta Tipo: " + ex.getTipo_conta() + "\nValor total sacado: " + ex.getValorSacado() + "\nValor total depositado: " + ex.getValorDepositado());
						
						System.out.println(ex.getConta_id());
						System.out.println(ex.getValorDepositado());
						System.out.println(ex.getValorSacado());
						
					}
									
				}						

			}
			
			if (opcao == 7) {

				// Listagem das Pessoas

				JOptionPane.showMessageDialog(null, "Número de Pessoas Cadastradas: " + contPessoa + "\n\nPessoas Cadastradas: \n" + dados.listaPessoas());

			}

			if (opcao == 8) {

				// Listagem das Contas Correntes

				JOptionPane.showMessageDialog(null, "Número de Contas Correntes Cadastradas: " + contContaCorrente + "\n\nClientes Cadastrados: \n" + dados.listaContaCorrente());

			}

			if (opcao == 9) {

				// Listagem das Contas Correntes

				JOptionPane.showMessageDialog(null, "Número de Contas Poupança Cadastradas: " + contContaPoupanca + "\n\nClientes Cadastrados: \n" + dados.listaContaPoupanca());

			}

		} while (opcao != 10);

	}

}

// Gabriel Brasileiro