package com.projeto;

import java.util.HashMap;
import java.util.List;

import com.projeto.entidade.Funcionario;
import com.projeto.entidade.FuncionarioManager;

public class App {

	public static void main(String[] args) {
		FuncionarioManager funcionarioManager = FuncionarioManager.getInstance();
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
	}
}