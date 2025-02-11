package com.projeto.entidade;

import java.util.List;

public interface IFuncionario {

	public List<Funcionario> addFuncionarios();
	public List<Funcionario> removeFuncionario(String nome, List<Funcionario> funcionarios);
}