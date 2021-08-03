package com.geraldo.BD.service;

import com.geraldo.BD.model.Departamento;
import com.geraldo.BD.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public void createDepartamento(Departamento departamento){
        departamentoRepository.save(departamento);
    }

    public List<Departamento> findAllDepartamento() {
       return departamentoRepository.findAll();
    }

    public Optional<Departamento> findByIdDepartamento(Long id){
        return departamentoRepository.findById(id);
    }
    public void deleteDepartamento(Long id){
        departamentoRepository.deleteById(id);
    }
}
