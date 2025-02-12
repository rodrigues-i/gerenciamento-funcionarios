package com.projeto.entidade;

import java.util.HashMap;
import java.util.List;

public interface IFuncionario {

	public List<Funcionario> addFuncionarios();
	public List<Funcionario> removeFuncionario(String nome, List<Funcionario> funcionarios);
	public void printFuncionarios(List<Funcionario> funcionarios);
	public List<Funcionario> ganharAumento(int porcentagemAumento, List<Funcionario> funcionarios);
	public HashMap<String, List<Funcionario>> groupFuncionarios(List<Funcionario> funcionarios);
	public void printAgrupamento(HashMap<String, List<Funcionario>> agrupamento);
	public void printFuncionarioFazAniversariosMeses(List<Funcionario> funcionarios);
	public void printFuncionarioMaisVelho(List<Funcionario> funcionarios);
	public void printFuncionariosOrdemAlfabetica(List<Funcionario> funcionarios);
	public void printTotalSalarioFuncionarios(List<Funcionario> funcionarios);
	public void printQuantosSalariosMinimosGanha(List<Funcionario> funcionarios);
}