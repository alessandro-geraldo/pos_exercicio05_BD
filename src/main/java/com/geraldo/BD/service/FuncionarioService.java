package com.geraldo.BD.service;

import com.geraldo.BD.interfaceProjecao.NomeQtdDependentes;
import com.geraldo.BD.interfaceProjecao.NomeSalario;
import com.geraldo.BD.model.Funcionario;
import com.geraldo.BD.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void createFuncionario(Funcionario funcionario){
        funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> findIdFuncionario(Long id){
        return funcionarioRepository.findById(id);
    }

    public void deleteFuncionario(long id){
        funcionarioRepository.deleteById(id);
    }

    public Optional<NomeQtdDependentes> findByNome(String nome){
       return funcionarioRepository.findByNome(nome);
    }

    public List<Funcionario> findAllPorDepartamento(Long id){
        return funcionarioRepository.findAllPorDepartamento(id);
    }

    public Funcionario findBySalario(){
        return funcionarioRepository.findBySalario();
    }
    public List<NomeSalario> findByTresMaioresSalarios(){
        return funcionarioRepository.findByTresMaioresSalarios();
    }
    public List<Funcionario> findBySemDependentes(){
        return funcionarioRepository.findBySemDependentes();
    }
    public List<Funcionario> findBySalariomaiorQue(Double salario){
        return funcionarioRepository.findBySalarioBigger(salario);
    }
    public List<Funcionario> findBySalariomaiorQueQueryNative(Double salario){
        return funcionarioRepository.findBySalarioBiggerQueryNative(salario);
    }
    public List<Funcionario> findByQtdDependentes(Integer qtd){
        return funcionarioRepository.findByQtdDependentes(qtd);
    }
}
