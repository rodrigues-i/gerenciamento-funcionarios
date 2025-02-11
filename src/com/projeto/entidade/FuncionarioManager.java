package com.projeto.entidade;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class FuncionarioManager implements IFuncionario {
	private static FuncionarioManager funcionarioManager;

	private FuncionarioManager() {}

	public static FuncionarioManager getInstance() {
		if(funcionarioManager == null) {
			FuncionarioManager funcionarioManager = new FuncionarioManager();
			FuncionarioManager.funcionarioManager = funcionarioManager;
		}

		return FuncionarioManager.funcionarioManager;
	}

	public List<Funcionario> addFuncionarios() {
		String filePath = Paths.get("src/com/projeto/funcionarios.json").toString();
	        StringBuilder jsonContent = new StringBuilder();

	        // Step 1: Read JSON file content into a String
	        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                jsonContent.append(line);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Step 2: Process JSON content manually
	        String jsonString = jsonContent.toString();
	        List<Funcionario> funcionarios = parseJSON(jsonString);
	        return funcionarios;
	}

	public static List<Funcionario> parseJSON(String json) {
	    List<Funcionario> funcionarios = new ArrayList<>();
	    
	    // Remove the square brackets
	    json = json.substring(1, json.length() - 1).trim(); 
	    
	    // Ensure JSON objects are split correctly
	    String[] objects = json.split("},\\s*\\{"); // Splits objects correctly even with spaces

	    for (String obj : objects) {
	        obj = obj.replace("{", "").replace("}", ""); // Remove braces from individual objects

	        String nome = "";
	        String dataNascimentoString = "";
	        BigDecimal salario = BigDecimal.ZERO;
	        String funcao = "";

	        // Extract key-value pairs
	        String[] fields = obj.split(",");
	        for (String field : fields) {
	            String[] keyValue = field.split(":");

	            // Remove quotes and trim spaces
	            String key = keyValue[0].trim().replace("\"", "");
	            String value = keyValue[1].trim().replace("\"", "");

	            // Assign values based on the key
	            switch (key) {
	                case "Nome":
	                    nome = value;
	                    break;
	                case "DataNascimento":
	                    dataNascimentoString = value;
	                    break;
	                case "Salario":
	                    salario = new BigDecimal(value);
	                    break;
	                case "Funcao":
	                    funcao = value;
	                    break;
	            }
	        }

	        // Convert date string to LocalDate
	        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate dataNascimento = LocalDate.parse(dataNascimentoString, pattern);

	        // Add to list
	        funcionarios.add(new Funcionario(nome, dataNascimento, salario, funcao));
	    }

	    return funcionarios;
	}

   // Extracts the value from a JSON key-value pair
   public static String extractValue(String keyValue) {
       return keyValue.split(":")[1].trim().replace("\"", "");
   }

   public List<Funcionario> removeFuncionario(String nome, List<Funcionario> funcionarios) {
	   List<Funcionario> filteredList = funcionarios.stream().filter(funcionario -> {
		   return !funcionario.getNome().equals(nome);
	   })
	   .collect(Collectors.toList());
	   return filteredList;
	   
   }

   public void printFuncionarios(List<Funcionario> funcionarios) {
	   for(Funcionario f : funcionarios) {
		   String nome = f.getNome();
		   LocalDate dataNascimento = f.getDataNascimento();
		   BigDecimal salario = f.getSalario();
		   String funcao = f.getFuncao();

		   Locale locale = new Locale("pt", "BR");
		   NumberFormat formatter = NumberFormat.getInstance(locale);
		   String formattedSalario = formatter.format(salario);

		   DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		   String formattedDate = dataNascimento.format(dateFormatter);
		   String formattedOutput = "%s\t%s\t%s\t%s".formatted(nome, formattedDate, formattedSalario, funcao);
		   System.out.println(formattedOutput);
	   }
   }

   public List<Funcionario> ganharAumento(int porcentagemAumento, List<Funcionario> funcionarios) {
	   BigDecimal porcentagemValue = BigDecimal.valueOf(porcentagemAumento / 100.0);

	   
	   return funcionarios.stream().map(funcionario -> {
		   BigDecimal porcentagem = funcionario.getSalario().multiply(porcentagemValue);
		   BigDecimal aumento = funcionario.getSalario().add(porcentagem);
		   funcionario.setSalario(aumento);
		   return funcionario;
	   })
		.collect(Collectors.toList());
	   
   }

   public HashMap<String, List<Funcionario>> groupFuncionarios(List<Funcionario> funcionarios) {
	   HashMap<String, List<Funcionario>> agrupamento = new HashMap<>();
	   for(Funcionario f : funcionarios) {
		   String funcao = f.getFuncao();
		   if(!agrupamento.containsKey(funcao)) {
			 agrupamento.put(funcao, new ArrayList<>());  
		   }
		   List<Funcionario> listaExistente = agrupamento.get(funcao);
		   listaExistente.add(f);
		   agrupamento.put(funcao, listaExistente);
	   }

	   return agrupamento;
   }

   public void printAgrupamento(HashMap<String, List<Funcionario>> agrupamento) {
	   for(Map.Entry<String, List<Funcionario>> entry : agrupamento.entrySet()) {
		   StringBuilder strBuilder = new StringBuilder();
		   strBuilder.append(entry.getKey() + " -> ");
		   for(Funcionario f: entry.getValue()) {
			   strBuilder.append(f.getNome() + ", ");
		   }
		   String fileiraAtual = strBuilder.toString();
		   fileiraAtual = fileiraAtual.substring(0, fileiraAtual.length() - 2);
		   System.out.println(fileiraAtual);
	   }
   }

   public void printFuncionarioFazAniversariosMeses(List<Funcionario> funcionarios) {
	   
	   StringBuilder outubroSstrBuilder = new StringBuilder();
	   StringBuilder dezembroSstrBuilder = new StringBuilder();
	   outubroSstrBuilder.append("Aniversariantes de Outubo -> ");
	   dezembroSstrBuilder.append("Aniversariantes de Dezembro -> ");
	   for(Funcionario f : funcionarios) {
		   LocalDate dataNascimento = f.getDataNascimento();
		   int numeroMes = dataNascimento.getMonthValue();
		   String nome = f.getNome();
		   String expressao = nome + ", ";
		   if(numeroMes == 10) {
			   outubroSstrBuilder.append(expressao);
		   } else if(numeroMes == 12) {
			   dezembroSstrBuilder.append(expressao);
		   }
	   }
	   String aniversariantesOutubro = outubroSstrBuilder.toString();
	   String aniversariantesDezembro = dezembroSstrBuilder.toString();

	   if(aniversariantesOutubro.equals("Aniversariantes de Outubo -> ")) {
		   aniversariantesOutubro += "N/A.";
	   } else {
		   aniversariantesOutubro = aniversariantesOutubro.substring(0, aniversariantesOutubro.length() - 2);
		   aniversariantesOutubro += ".";
	   }
	   if(aniversariantesDezembro.equals("Aniversariantes de Dezembro -> ")) {
		   aniversariantesDezembro += "N/A.";
	   } else {
		   aniversariantesDezembro = aniversariantesDezembro.substring(0, aniversariantesDezembro.length() -2);
		   aniversariantesDezembro += ".";
	   }
	   System.out.println(aniversariantesOutubro);
	   System.out.println(aniversariantesDezembro);
   }
}
