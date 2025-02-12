package com.projeto;

import java.util.HashMap;
import java.util.List;

import com.projeto.entidade.Funcionario;
import com.projeto.entidade.FuncionarioManager;
import com.projeto.entidade.IFuncionario;

public class App {

	public static void main(String[] args) {
		IFuncionario funcionarioManager = FuncionarioManager.getInstance();
		List<Funcionario> funcionarios = funcionarioManager.addFuncionarios();
		funcionarios = funcionarioManager.removeFuncionario("João", funcionarios);
		
		funcionarioManager.printFuncionarios(funcionarios);

		funcionarios = funcionarioManager.ganharAumento(10, funcionarios);

		HashMap<String, List<Funcionario>> agrupamento = funcionarioManager.groupFuncionarios(funcionarios);
		System.out.println("-".repeat(60));
		System.out.println("Agrupamento por Função");
		System.out.println("-".repeat(60));

		funcionarioManager.printAgrupamento(agrupamento);

		System.out.println("-".repeat(60));
		System.out.println("Aniversariantes de Outubro e Dezembro");
		System.out.println("-".repeat(60));
		funcionarioManager.printFuncionarioFazAniversariosMeses(funcionarios);

		System.out.println("-".repeat(60));
		System.out.println("Funcionário Mais Velho");
		System.out.println("-".repeat(60));
		funcionarioManager.printFuncionarioMaisVelho(funcionarios);

		System.out.println("-".repeat(60));
		System.out.println("Funcionários Por Ordem Alfabetica");
		System.out.println("-".repeat(60));
		funcionarioManager.printFuncionariosOrdemAlfabetica(funcionarios);

		System.out.println("-".repeat(60));
		System.out.println("Salário Total dos Funcionarios");
		System.out.println("-".repeat(60));
		funcionarioManager.printTotalSalarioFuncionarios(funcionarios);

		System.out.println("-".repeat(60));
		System.out.println("Número de Salários Mínimos Ganhos por Cada Funcionário");
		System.out.println("-".repeat(60));
		funcionarioManager.printQuantosSalariosMinimosGanha(funcionarios);
	}
}