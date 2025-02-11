package com.projeto;

import java.util.List;

import com.projeto.entidade.Funcionario;
import com.projeto.entidade.FuncionarioManager;

public class App {
	private static List<Funcionario> funcionarios;

	public static void main(String[] args) {
		FuncionarioManager funcionarioHandler = FuncionarioManager.getInstance();
		funcionarios = funcionarioHandler.addFuncionarios();
		for(Funcionario f: funcionarios) {
			System.out.println(f);
		}
	}
}