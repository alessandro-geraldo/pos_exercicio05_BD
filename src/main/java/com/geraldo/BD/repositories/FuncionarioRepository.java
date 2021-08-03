package com.geraldo.BD.repositories;

import com.geraldo.BD.interfaceProjecao.NomeQtdDependentes;
import com.geraldo.BD.interfaceProjecao.NomeSalario;
import com.geraldo.BD.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {


   Optional<NomeQtdDependentes> findByNome(String nome);

   @Query("select f from Funcionario f join f.departamento d where d.codDepartamento = ?1")
   List<Funcionario> findAllPorDepartamento(Long id);

   @Query(value = "select * from funcionario where salario =\n" +
           "(select max(salario) from funcionario)", nativeQuery = true)
   Funcionario findBySalario();

   @Query(value = "select nome, max(salario) from funcionario group by nome limit 3", nativeQuery = true)
   List<NomeSalario> findByTresMaioresSalarios();

   @Query("select f from Funcionario f where f.qtdDependentes = 0")
   List<Funcionario> findBySemDependentes();

   @Query("select f from Funcionario f where f.salario > ?1")
   List<Funcionario> findBySalarioBigger(Double salario);
}
