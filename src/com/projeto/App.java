package com.projeto;

import java.util.List;

import com.projeto.entidade.Funcionario;
import com.projeto.entidade.FuncionarioManager;

public class App {
	private static List<Funcionario> funcionarios;

	public static void main(String[] args) {
		FuncionarioManager funcionarioManager = FuncionarioManager.getInstance();
		App.funcionarios = funcionarioManager.addFuncionarios();
		List<Funcionario> funcionariosFiltrados = funcionarioManager.removeFuncionario("João", funcionarios);
		
		funcionarioManager.printFuncionarios(funcionariosFiltrados);
	}
}