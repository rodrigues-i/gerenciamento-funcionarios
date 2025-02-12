# Gerenciamento de Funcionários
Este problema em java tem as seguintes funcionalidades:
- Lê um arquivo json e cria uma lista de funcionários a partir do conteúdo.
- Remove um funcionário chamado João
- Imprime no console todos os funcionários
- Calcula um aumento de 10% para todos os funcionários
- Agrupa os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
- Imprime os funcionários, agrupados por função.
- Imprime os funcionários que fazem aniversário no mês 10 e 12.
- Imprime o funcionário com a maior idade, exibir os atributos: nome e idade.
- Imprime a lista de funcionários por ordem alfabética.
- Imprime o total dos salários dos funcionários.
- Imprime quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.

## Técnologias Usadas
- Java 17
- IDE Eclipse

## Práticas
Neste projeto são usadas práticas como design pattern (Singleton) e Solid (Single Responsability)

## Exemplo de output do programa
```
Maria	18/10/2000	2.009,44	Operador
Caio	02/05/1961	9.836,14	Coordenador
Miguel	14/10/1988	19.119,88	Diretor
Alice	05/01/1995	2.234,68	Recepcionista
Heitor	19/11/1999	1.582,72	Operador
Arthur	31/03/1993	4.071,84	Contador
Laura	08/07/1994	3.017,45	Gerente
Heloísa	24/05/2003	1.606,85	Eletricista
Helena	02/09/1996	2.799,93	Gerente
------------------------------------------------------------
Agrupamento por Função
------------------------------------------------------------
Operador -> Maria, Heitor
Recepcionista -> Alice
Eletricista -> Heloísa
Diretor -> Miguel
Gerente -> Laura, Helena
Coordenador -> Caio
Contador -> Arthur
------------------------------------------------------------
Aniversariantes de Outubro e Dezembro
------------------------------------------------------------
Aniversariantes de Outubo -> Maria, Miguel.
Aniversariantes de Dezembro -> N/A.
------------------------------------------------------------
Funcionário Mais Velho
------------------------------------------------------------
Funcionario:
Nome: Caio
Idade: 63
------------------------------------------------------------
Funcionários Por Ordem Alfabetica
------------------------------------------------------------
Alice	05/01/1995	2.458,148	Recepcionista
Arthur	31/03/1993	4.479,024	Contador
Caio	02/05/1961	10.819,754	Coordenador
Heitor	19/11/1999	1.740,992	Operador
Helena	02/09/1996	3.079,923	Gerente
Heloísa	24/05/2003	1.767,535	Eletricista
Laura	08/07/1994	3.319,195	Gerente
Maria	18/10/2000	2.210,384	Operador
Miguel	14/10/1988	21.031,868	Diretor
------------------------------------------------------------
Salário Total dos Funcionarios
------------------------------------------------------------
Salário -> 50.906,823
------------------------------------------------------------
Número de Salários Mínimos Ganhos por Cada Funcionário
------------------------------------------------------------
Alice ganha 2,03 salários mínimos.
Arthur ganha 3,7 salários mínimos.
Caio ganha 8,93 salários mínimos.
Heitor ganha 1,44 salários mínimos.
Helena ganha 2,54 salários mínimos.
Heloísa ganha 1,46 salários mínimos.
Laura ganha 2,74 salários mínimos.
Maria ganha 1,82 salários mínimos.
Miguel ganha 17,35 salários mínimos.
```
 
