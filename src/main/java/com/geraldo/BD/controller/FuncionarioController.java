package com.geraldo.BD.controller;

import com.geraldo.BD.interfaceProjecao.NomeQtdDependentes;
import com.geraldo.BD.interfaceProjecao.NomeSalario;
import com.geraldo.BD.model.Funcionario;
import com.geraldo.BD.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public void createFuncinario(@RequestBody Funcionario funcionario){
        funcionarioService.createFuncionario(funcionario);
    }

    @GetMapping
    public List<Funcionario> findAll(){
       return funcionarioService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Funcionario> findIdFuncionario(@PathVariable Long id){
        return funcionarioService.findIdFuncionario(id);
    }
    @DeleteMapping("/{id}")
    public void deleteFuncionario(@PathVariable Long id){
        funcionarioService.deleteFuncionario(id);
    }

    @GetMapping("/nome:{nome}")
    public Optional<NomeQtdDependentes> findByNome(@PathVariable String nome){
        return funcionarioService.findByNome(nome);
    }
    @GetMapping("/numero_departamento:{id}")
    public List<Funcionario> findAllPorDepartamento(@PathVariable Long id){
        return funcionarioService.findAllPorDepartamento(id);
    }
    @GetMapping("/maior_salario")
    public Funcionario findBySalario(){
        return funcionarioService.findBySalario();
    }
    @GetMapping("/tres_maiores_salarios")
    public List<NomeSalario> findByTresMaioresSalarios(){
        return funcionarioService.findByTresMaioresSalarios();
    }
    @GetMapping("/sem_dependentes")
    public List<Funcionario> findBySemDependentes(){
        return funcionarioService.findBySemDependentes();
    }
    @GetMapping("/maior_que:{salario}")
    public List<Funcionario> findBySalarioMaiorQue(@PathVariable Double salario){
        return funcionarioService.findBySalariomaiorQue(salario);
    }

}
