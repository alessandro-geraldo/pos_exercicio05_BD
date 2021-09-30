# Atividade da Pós Graduação Java UTFPR - Banco de Dados

### Cenário
* Em uma determinada empresa, todo departamento tem um
código numérico e um nome.
* Todos os funcionários da empresa são cadastrados com seu
código, nome, quantidade de dependentes, salário e cargo.
* Cada funcionário está lotado em somente um
departamento.

#### 1. Utilizando o cenário:

* Crie um projeto Java Application (with Maven) a partir dos códigos apresentados nos tópicos:
* Configuração do Spring Data JPA;
* Lidando com Entidades; e
* Repositórios.

#### 2. Acrescentar no projeto Java Application (with Maven) as seguintes consultas:

* Listar um funcionário pelo seu nome e quantidade de dependentes utilizando consulta por palavras-chaves.
* Listar todos os funcionários de um determinado departamento por JPQL via @Query.
* Listar o primeiro departamento cadastrado.
* Listar o primeiro funcionário que tem o maior salário.
* Listar os 3 (três) primeiros funcionários que tem os maiores salários.
* Listar os funcionários que não tem dependentes em ordem crescente de nome por JPQL via @Query.
* Listar os funcionários que tem salário maior que um determinado valor por JPQL sobrescrevendo palavras-chaves @Query.
* Listar os funcionários que tem salário maior que um determinado valor por @Query com native query.
* Alterar a classe Funcionario e criar uma consulta para listar os funcionários com uma determinada quantidade de dependentes por @NamedQuery.
* Alterar a classe Funcionario e criar uma consulta para listar os funcionários que contenham em qualquer parte do seu nome um determinado nome por @NamedNativeQuery.
* Alterar a interface FuncionarioRepository para utilizar a @NamedQuery e @NamedNativeQuery realizadas nas questões 9 e 10 (respectivamente). 

#### 3. Acrescentar no projeto Java Application (with Maven): 

* Uma procedure que aumenta o salário de todos os funcionários em X porcento, onde X é um número inteiro.
* Uma consulta que lista todos os funcionários de um determinado departamento que não possuam dependentes utilizando parâmetros nomeados.
* Uma instrução de update que troca todos os funcionários de um determinado departamento para outro departamento utilizando a anotação @Modifying.
* Uma instrução de delete que exclui todos os funcionários de um determinado departamento utilizando a anotação @Modifying.

## Tecnologias utilizadas

* Springboot
* Banco de dados PostgreSQL
* Postman

