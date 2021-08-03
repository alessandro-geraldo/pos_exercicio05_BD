package com.geraldo.BD.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codDepartamento;
    @Column(name = "Nome",length = 60,nullable = false)
    private String nome;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "departamento")
    private List<Funcionario> funcionario;

    public Departamento() {
    }

    public Departamento(Long codDepartamento, String nome, List<Funcionario> funcionario) {
        this.codDepartamento = codDepartamento;
        this.nome = nome;
        this.funcionario = funcionario;
    }

    public Long getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Long codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }
}
