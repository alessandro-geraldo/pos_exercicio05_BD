package com.geraldo.BD.repositories;

import com.geraldo.BD.interfaceProjecao.NomeQtdDependentes;
import com.geraldo.BD.interfaceProjecao.NomeSalario;
import com.geraldo.BD.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
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

   @Query(value = "select * from funcionario where salario > ?1", nativeQuery = true)
   List<Funcionario> findBySalarioBiggerQueryNative(Double salario);

   @Query(name = "Funcionario.ByQtdDependentes")
   List<Funcionario> findByQtdDependentes(Integer qtd);

   @Query(name = "Funcionario.ByNome")
   List<Funcionario> findByNomeFuncionario(String nome);

   @Procedure("funcionario_aumento")
   void funcionarioAumento(Integer aumento);

   @Query(value = "select * from funcionario f "
           + "where f.departamento = :departamento and qtd_dependentes = 0", nativeQuery = true)
   List<Funcionario> findByFuncionarioPorDepartamentoSemDependentes(
           @Param("departamento") Integer departamento);

   @Transactional
   @Modifying
   @Query(value = "update funcionario set departamento = :novoDepartamento " +
           "where departamento = :departamentoAtual"
           ,nativeQuery = true)
   void trocarFuncionariosDeDepartamento(@Param("departamentoAtual") Integer departamentoAtual,
                                         @Param("novoDepartamento") Integer novoDepartamento);

   @Transactional
   @Modifying
   @Query(value = "delete from funcionario f where f.departamento = :departamento",nativeQuery = true)
   void deleteTodosFuncionariosDoDepartamento(@Param("departamento")Integer departamento);
}

