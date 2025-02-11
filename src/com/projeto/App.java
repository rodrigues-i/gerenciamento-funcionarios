package com.projeto;

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
	}
}