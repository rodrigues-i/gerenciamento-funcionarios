package com.projeto.entidade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioHandler implements IFuncionario {

	public List<Funcionario> addFuncionarios() {
		String filePath = Paths.get("src/com/projeto/funcionarios.json").toString();
	        StringBuilder jsonContent = new StringBuilder();

	        // Step 1: Read JSON file content into a String
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
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
}
