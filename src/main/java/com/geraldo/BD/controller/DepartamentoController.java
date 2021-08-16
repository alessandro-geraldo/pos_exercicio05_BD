package com.geraldo.BD.controller;

import com.geraldo.BD.model.Departamento;
import com.geraldo.BD.repositories.DepartamentoRepository;
import com.geraldo.BD.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoController {

    @Autowired
    public DepartamentoService departamentoService;

    @PostMapping
    public void createDepartamento(@RequestBody Departamento departamento){
        departamentoService.createDepartamento(departamento);
    }

    @GetMapping
    public List<Departamento> selectAll(){
       return departamentoService.findAllDepartamento();
    }
    @GetMapping("/{id}")
    public Optional<Departamento> findIdDepartamento(@PathVariable Long id){
        return departamentoService.findByIdDepartamento(id);
    }
    @DeleteMapping("/{id}")
    public void deleteDepartamento(@PathVariable Long id){
        departamentoService.deleteDepartamento(id);
    }

    @GetMapping("/first_departamento")
    public Departamento findFirstDepartamento(){
       return departamentoService.findFirstDepartamento();
    }
}
