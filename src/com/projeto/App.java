package com.projeto;

import java.util.List;

import com.projeto.entidade.Funcionario;
import com.projeto.entidade.FuncionarioHandler;

public class App {

	public static void main(String[] args) {
		FuncionarioHandler funcionarioHandler = new FuncionarioHandler();
		List<Funcionario> funcionarios = funcionarioHandler.addFuncionarios();
		for(Funcionario f: funcionarios) {
			System.out.println(f);
		}
	}
}