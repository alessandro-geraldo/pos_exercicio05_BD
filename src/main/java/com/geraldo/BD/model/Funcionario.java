package com.geraldo.BD.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name = "Funcionario")
@NamedQuery(name = "Funcionario.byQtdDependentes",
             query = "from Funcionario f where f.qtdDependentes = ?1")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codFuncionario;
    @Column(name = "Nome",length = 80, nullable = false)
    private String nome;
    @Column(name = "qtdDependentes",length = 10,nullable = false)
    private Integer qtdDependentes;
    @Column(name = "Cargo",length = 30, nullable = false)
    private String cargo;
    @Column(length = 20,nullable = false)
    private Double salario;
    @ManyToOne
    @JoinColumn(name = "Departamento")
    private Departamento departamento;

    public Funcionario() {
    }

//    public Funcionario(Long codFuncionario, String nome, int qtdDependentes, String cargo, Departamento departamento) {
//        this.codFuncionario = codFuncionario;
//        this.nome = nome;
//        this.qtdDependentes = qtdDependentes;
//        this.cargo = cargo;
//        this.departamento = departamento;
//    }


    public Funcionario(Long codFuncionario, String nome, int qtdDependentes, String cargo, Double salario, Departamento departamento) {
        this.codFuncionario = codFuncionario;
        this.nome = nome;
        this.qtdDependentes = qtdDependentes;
        this.cargo = cargo;
        this.salario = salario;
        this.departamento = departamento;
    }

    public Long getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Long codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdDependentes() {
        return qtdDependentes;
    }

    public void setQtdDependentes(int qtdDependentes) {
        this.qtdDependentes = qtdDependentes;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
